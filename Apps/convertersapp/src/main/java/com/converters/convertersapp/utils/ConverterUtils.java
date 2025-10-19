package com.converters.convertersapp.utils;

import com.converters.convertersapp.constants.FormatsEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;


@Component
@Slf4j
public class ConverterUtils {

    public File convertMultiPartToFile(MultipartFile multipartFile) {
        File convertedFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));

        try (FileOutputStream fileOutputStream = new FileOutputStream(convertedFile)) {
            boolean fileCreated = convertedFile.createNewFile();
            log.info("New File created::{}", fileCreated);
            fileOutputStream.write(multipartFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return convertedFile;
    }

    public File convertBytesToFile(String fileName, byte[] bytes) {
        File file = new File(fileName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    public String checkFormat(String format) {
        return switch (FormatsEnum.valueOf(format)) {
            case FormatsEnum.JPEG -> "jpeg";
            case FormatsEnum.PNG -> "png";
            case FormatsEnum.BMP -> "bmp";
            case FormatsEnum.TIFF -> "tiff";
            case FormatsEnum.TEXT -> "text";
            case FormatsEnum.PDF -> "pdf";
            case FormatsEnum.EXCEL -> "excel";
            default -> throw new RuntimeException("Unsupported format: " + format);
        };
    }

    public MediaType getMediaType(String format) {
        return switch (FormatsEnum.valueOf(format)) {
            case FormatsEnum.JPEG -> MediaType.IMAGE_JPEG;
            case FormatsEnum.PNG -> MediaType.IMAGE_PNG;
            case FormatsEnum.BMP -> MediaType.valueOf("image/bmp");
            case FormatsEnum.TIFF -> MediaType.valueOf("image/tiff");
            case FormatsEnum.PDF -> MediaType.APPLICATION_PDF;
            case FormatsEnum.EXCEL -> MediaType.valueOf("application/vnd.ms-excel");
            case FormatsEnum.TEXT -> MediaType.TEXT_PLAIN;
            default -> MediaType.APPLICATION_OCTET_STREAM;
        };
    }
}
