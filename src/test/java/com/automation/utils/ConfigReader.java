package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;

    public static void initConfig(){
        try {
            properties=new Properties();
            properties.load(new FileInputStream("src/test/resources/config/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getConfigValue(String key){
        return properties.getProperty(key);
    }

    public static void setConfigValue(String key, String value){
        properties.setProperty(key,value);
    }

    public static Object getObject(String key) {
        return properties.get(key);
    }

    public static void setObject(String key, Object value) {
        properties.put(key, value);
    }
}
