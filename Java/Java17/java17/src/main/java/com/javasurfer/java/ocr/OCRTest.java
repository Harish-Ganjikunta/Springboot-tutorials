package com.javasurfer.java.ocr;

import com.asprise.ocr.Ocr;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class OCRTest {

    public static void main(String[] args) {
      //  File file = new File("D:\\java-workspace\\Springboot-tutorials\\Apps\\test.png");
        File file = new File("D:\\java-workspace\\Springboot-tutorials\\Apps\\te.jpeg");
        Ocr.setUp();
        try{
            Ocr ocr = new Ocr();
            ocr.startEngine("eng",Ocr.SPEED_FAST);
            URL imgUrl = file.toURI().toURL();
            String result = ocr.recognize(new URL[]{imgUrl},Ocr.RECOGNIZE_TYPE_TEXT,Ocr.OUTPUT_FORMAT_PLAINTEXT);
            ocr.stopEngine();
            System.out.println("Result:"+result);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
