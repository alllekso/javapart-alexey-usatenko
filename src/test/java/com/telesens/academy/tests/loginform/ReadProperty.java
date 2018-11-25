package com.telesens.academy.tests.loginform;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ReadProperty {
    public String readProperty(String fileProp, String key) {
        Properties prop = new Properties();
        InputStream is = ReadProperty.class.getClassLoader().getResourceAsStream(fileProp);
        try (InputStreamReader isr = new InputStreamReader(is, "UTF-8")) {
            prop.load(isr);
            return prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


