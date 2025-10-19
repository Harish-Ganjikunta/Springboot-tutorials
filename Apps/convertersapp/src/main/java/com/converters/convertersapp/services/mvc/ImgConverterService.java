package com.converters.convertersapp.services.mvc;

import com.converters.convertersapp.services.ImageToTextService;
import com.converters.convertersapp.utils.ConverterUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;


@Service
@Slf4j
public class ImgConverterService {

    @Autowired
    private ImageToTextService imageToTextService;

    @Autowired
    private ConverterUtils converterUtils;


    public String convert(MultipartFile file, String format, RedirectAttributes redirectAttributes) {
       log.info("Entered into the ImageConverterService...");
        if (file.isEmpty()) {
            log.info("File is empty...");
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
            // throw new RuntimeException("Please select a file to upload.");
        }

        if (format.equalsIgnoreCase("text")) {
            log.info("Converting image to text...");
            return convertImageToText(file);
        } else {
            log.info("Converting image to format: " + format);
            return convertImage(file, format, redirectAttributes);
        }

    }


    public String convertImageToText(MultipartFile imageFile) {
       log.info("Entered into the convertImageToText method...");
        File file = converterUtils.convertMultiPartToFile(imageFile);
        log.info("Converted MultipartFile to File...{}",file.getName());
        return imageToTextService.convertImageToPlainText(file, "", "");

    }

    public String convertImage(MultipartFile file,String format, RedirectAttributes redirectAttributes){
        log.info("Entered into the convertImage method...");
        String base64Image = "";
        try{
            // Read the image from the uploaded file
            BufferedImage originalImage = ImageIO.read(file.getInputStream());
            // Write the image to a ByteArrayOutputStream in the desired format
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, format.toLowerCase(), baos);
            byte[] convertedImageBytes = baos.toByteArray();
            // Encode the converted image to a Base64 string for display
            base64Image = Base64.getEncoder().encodeToString(convertedImageBytes);
        }catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "Error converting image.");
            return "redirect:/";
           // throw new RuntimeException(e);
        }
        return base64Image;
    }




    /*private Tesseract tesseract;
    private Path tessdataPath;
    public static final String datapath = "D:\\java-workspace\\Springboot-tutorials\\Apps\\tessdata";


    @PostConstruct
    public void init() throws IOException {
        this.tesseract = new Tesseract();
        // Set the path to the tessdata directory inside resources

        //instance.setDatapath (new File(datapath).getPath());
        this.tessdataPath = Files.createTempDirectory("tessdata");
        this.tesseract.setDatapath(this.tessdataPath.toString());
        this.tesseract.setDatapath(new File(datapath).getPath());

        // Copy traineddata files from resources to a temporary directory
        // Tesseract native libraries may have issues reading from a packaged JAR.
        try (var inputStream = ImageToTextService.class.getClassLoader().getResourceAsStream(
                //ImageToTextConstants.DEFAULT_LANGUAGE_RESOURCE_PATH.getValue())){

               "tessdata/eng.traineddata")) {
            if (inputStream == null) {
                throw new IOException("Traineddata file not found.");
            }
           // Path destination = this.tessdataPath.resolve("eng.traineddata");
            Path destination = this.tessdataPath.resolve("eng.traineddata");
                    //ImageToTextConstants.DEFAULT_LANGUAGE_RESOURCE_PATH.getValue());
            Files.copy(inputStream, destination);
        }
    }

    public String doOcr(File imageFile) throws TesseractException {
        // Optionally set language
        tesseract.setLanguage(ImageToTextConstants.DEFAULT_LANGUAGE.getValue());
        return tesseract.doOCR(imageFile);
    }*/


  /*  public static void main(String[] args) {

        ITesseract tesseract = new Tesseract();

        try {

            // the path of your tess data folder inside the extracted file
            tesseract.setDatapath("D:\\Tesseract-OCR\\tessdata");

            // path of your image file
            String text = tesseract.doOCR(new File("D:\\java-workspace\\Springboot-tutorials\\Apps\\test.png"));
            System.out.print(text);

            // Create a FileWriter with the specified file path
            FileWriter fileWriter = new FileWriter("D:\\Tess4j\\Spring_Cloud_Annotations.txt");

            // Wrap FileWriter in BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the text to the file
            bufferedWriter.write(text);

            // Close the BufferedWriter to flush and release resources
            bufferedWriter.close();
            System.out.println("Text has been written to the file successfully.");

        } catch (TesseractException | IOException e) {
            e.printStackTrace();
        }
    }*/
}
