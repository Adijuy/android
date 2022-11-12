package com.wh.android.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

@Component
public class Images {

    @Value("${image.path}")
    private String path;
    public byte[] getImage() throws Exception {
        try {

            Random random = new Random();

            File file = new File(path);
            String[] list = file.list();
            File file1 = new File(path + list[random.nextInt(list.length)]);

            String[] list1 = file1.list();

            FileInputStream fileInputStream =
                    new FileInputStream(new File(file1,list1[random.nextInt(list1.length)]));
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            fileInputStream.close();
            return bytes;
        }catch (Exception e){

        }
        return null;
    }
}
