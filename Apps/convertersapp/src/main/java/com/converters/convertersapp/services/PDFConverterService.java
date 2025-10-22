package com.converters.convertersapp.services;

import com.converters.convertersapp.utils.ConverterUtils;
import org.apache.pdfbox.debugger.ui.ImageUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.apache.poi.ss.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
public class PDFConverterService {

    @Autowired
    private ConverterUtils converterUtils;


    public ResponseEntity<byte[]> generateImageFromPDF(MultipartFile file, String format,Character download) {
         String fileName = converterUtils.extractFileName(file);
        String extension =converterUtils.checkFormat(format.toUpperCase());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            PDDocument pdDocument = PDDocument.load(file.getInputStream());
            PDFRenderer pdfRenderer = new PDFRenderer(pdDocument);
            for(int page = 0; page < pdDocument.getNumberOfPages(); ++page) {
                // Render each page as an image
              BufferedImage bufferedImage =  pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                //byte[] jpegBytes = byteArrayOutputStream.toByteArray();
                // Set headers for the response
                headers.setContentType(converterUtils.getMediaType(format.toUpperCase()));
                if(Objects.nonNull(download) && download=='Y') {
                    ImageIOUtil.writeImage(bufferedImage,String.format("C:\\Users\\hp\\Downloads\\%s-%d.%s",fileName, page + 1, format), 300);
                }else {
                    //ImageIOUtil.writeImage(bufferedImage,format, 300);
                     ImageIO.write(bufferedImage,extension, byteArrayOutputStream);
                     headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName + "." + extension);
                }
                headers.setContentLength(byteArrayOutputStream.size());
                //headers.setContentLength(jpegBytes.length);
            }
            pdDocument.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
    }
}
