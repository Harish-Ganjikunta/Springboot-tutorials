package com.converters.convertersapp.services;

import com.asprise.ocr.Ocr;
import com.converters.convertersapp.utils.ConverterUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class ImageToTextService {

    @Autowired
    private ConverterUtils converterUtils;


    public String convertImageToPlainText(File imageFile, String language, String outPutFormat) {
        log.info("Entered into the convertImageToPlainText method...");
        return doOcr("","","","",imageFile);
    }



    public File convertImageToTextFile(File imageFile) {

        String result = "";
        try {
            Ocr ocr = new Ocr();
            ocr.startEngine(Ocr.LANGUAGE_ENG, Ocr.SPEED_FAST);
            URL imgUrl = imageFile.toURI().toURL();
            result = ocr.recognize(new URL[]{imgUrl}, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
            ocr.stopEngine();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        return converterUtils.convertBytesToFile(imageFile.getName(), result.getBytes(StandardCharsets.UTF_8));
    }


    private static String doOcr(String language, String speed, String recognizeType, String outPutFormat, File imageFile) {
        log.info("Entered into the doOcr method...");
        String result = "";
        try {
            Ocr.setUp();
            Ocr ocr = new Ocr();
            if (!ObjectUtils.isEmpty(language) || !ObjectUtils.isEmpty(speed)) {
                ocr.startEngine(language, speed);
            } else {
                ocr.startEngine(Ocr.LANGUAGE_ENG, Ocr.SPEED_FAST);
            }
            URL imgUrl = imageFile.toURI().toURL();
            if (!ObjectUtils.isEmpty(recognizeType) || !ObjectUtils.isEmpty(outPutFormat)) {
                result = ocr.recognize(new URL[]{imgUrl}, recognizeType, outPutFormat);
            } else {
                result = ocr.recognize(new URL[]{imgUrl}, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
            }
            ocr.stopEngine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

