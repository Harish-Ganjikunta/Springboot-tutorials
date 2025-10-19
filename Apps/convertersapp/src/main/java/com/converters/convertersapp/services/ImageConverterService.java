package com.converters.convertersapp.services;

import com.converters.convertersapp.constants.FormatsEnum;
import com.converters.convertersapp.utils.ConverterUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfBody;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.Objects;

@Service
@Slf4j
public class ImageConverterService {

    @Autowired
    private ImageToTextService imageToTextService;

    @Autowired
    private ConverterUtils converterUtils;


    public ResponseEntity<byte[]> convertImageToImage(MultipartFile file, String format) {
        log.info("Entered into the convertImageToImage method...");
        try{
            // Read the PNG image
            BufferedImage pngImage = ImageIO.read(new ByteArrayInputStream(file.getBytes()));

            // Create a new BufferedImage with TYPE_INT_RGB to remove alpha channel
            // This is crucial for JPEG as it doesn't support transparency
            BufferedImage jpegImage = new BufferedImage(
                    pngImage.getWidth(), pngImage.getHeight(), BufferedImage.TYPE_INT_RGB);

            // Draw the PNG image onto the new JPEG-compatible image
            jpegImage.createGraphics().drawImage(pngImage, 0, 0, null);

            // Write the BufferedImage to a ByteArrayOutputStream as JPEG
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(jpegImage, converterUtils.checkFormat(format.toUpperCase()), byteArrayOutputStream);
            byte[] jpegBytes = byteArrayOutputStream.toByteArray();
            // Set headers for the response
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(converterUtils.getMediaType(format.toUpperCase()));
            headers.setContentLength(jpegBytes.length);
            return new ResponseEntity<>(jpegBytes, headers, HttpStatus.OK);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ByteArrayOutputStream convertImageTextToPDF(MultipartFile imageFile){
        log.info("Entered into the convertImageToPDF method...{}",imageFile.getOriginalFilename());
        /*StringBuilder fileName = new StringBuilder(Objects.requireNonNull(imageFile.getOriginalFilename()));
        fileName.append(".").append(FormatsEnum.PDF.getFormat());*/
        Document document = new Document();
        PdfWriter pdfWriter = null;
                String imageData =  convertImageToText(imageFile);
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
           // FileOutputStream fos = new FileOutputStream(fileName.toString())
        ){
            pdfWriter = PdfWriter.getInstance(document,byteArrayOutputStream);
            pdfWriter.open();
            document.open();
            //Element ele =  new
            document.add(new Paragraph(imageData));
            /*HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.set(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename="+converterUtils.extractFileName(imageFile)+".pdf");
            headers.setContentLength(byteArrayOutputStream.size());*/
            return  byteArrayOutputStream;
            /*document.close();
            pdfWriter.close();*/
        } catch (IOException | DocumentException e) {
            throw new RuntimeException(e);
        }finally {
            if (document.isOpen()) {
                document.close();
            }
            assert pdfWriter != null;
            pdfWriter.close();
        }
    }

    public String convert(MultipartFile file, String format) {
        log.info("Entered into the ImageConverterService...");
        if (file.isEmpty()) {
            log.info("File is empty...");
             throw new RuntimeException("Please select a file to upload.");
        }

        if (format.equalsIgnoreCase("text")) {
            log.info("Converting image to text...");
            return convertImageToText(file);
        } else {
            log.info("Converting image to format:{}", format);
            return convertImage(file, format);
        }

    }


    public String convertImageToText(MultipartFile imageFile) {
        log.info("Entered into the convertImageToText method...");
        File file = converterUtils.convertMultiPartToFile(imageFile);
        log.info("Converted MultipartFile to File...{}",file.getName());
        return imageToTextService.convertImageToPlainText(file, "", "");

    }

    private String convertImage(MultipartFile file,String format){
        log.info("Entered into the convertImage method...");
        String base64Image = "";
        try{
            // Read the image from the uploaded file
            BufferedImage originalImage = ImageIO.read(file.getInputStream());
            // Write the image to a ByteArrayOutputStream in the desired format
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, converterUtils.checkFormat(format.toUpperCase()), baos);
            byte[] convertedImageBytes = baos.toByteArray();
            // Encode the converted image to a Base64 string for display
            base64Image = Base64.getEncoder().encodeToString(convertedImageBytes);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return base64Image;
    }


}
