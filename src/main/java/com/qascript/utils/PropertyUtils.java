package com.qascript.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {


    public static Properties loadProperties(String file){

        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                properties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       return properties;

    }
}
