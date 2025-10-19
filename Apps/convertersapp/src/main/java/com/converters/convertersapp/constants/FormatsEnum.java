package com.converters.convertersapp.constants;

public enum FormatsEnum {

    JPEG("jpeg"),
    PNG("png"),
    BMP("bmp"),
    TIFF("tiff"),
    PDF("pdf"),
    EXCEL("excel"),
    TEXT("text");

    private final String format;

    FormatsEnum(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
