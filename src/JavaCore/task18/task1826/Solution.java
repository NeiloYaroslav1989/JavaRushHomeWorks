package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);
        byte[] buffer = new byte[inputStream.available()];
        byte[] encryptedBuffer = new byte[inputStream.available()];

        if (args[0].equals("-e")) {
            inputStream.read(buffer);
            int bufferLength = buffer.length-1;

            for (int i = 0; i < buffer.length; i++) {
                encryptedBuffer[bufferLength--] = buffer[i];
            }
            outputStream.write(encryptedBuffer);
        } else if (args[0].equals("-d")) {
            inputStream.read(buffer);
            int bufferLength = buffer.length-1;

            for (int i = 0; i < buffer.length; i++) {
                encryptedBuffer[bufferLength--] = buffer[i];
            }
            outputStream.write(encryptedBuffer);
        }

        inputStream.close();
        outputStream.close();
    }

}
