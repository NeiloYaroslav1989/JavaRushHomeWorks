package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) {
        ImageReader imageReader = null;

        if (imageTypes == null) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

        if (imageTypes == ImageTypes.JPG) {
            imageReader = new JpgReader();
        } else if (imageTypes == ImageTypes.PNG) {
            imageReader = new PngReader();
        } else if (imageTypes == ImageTypes.BMP) {
            imageReader = new BmpReader();
        }
        return imageReader;
    }
}
