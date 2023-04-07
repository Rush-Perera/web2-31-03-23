package com.jiat.web.db.util;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {
    public static ApplicationProperties applicationProperties;

    private Properties properties;

    private ApplicationProperties() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/application.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Another way to load the properties file from the classpath (done by sir)

//        InputStream is = getClass().getClassLoader().getResourceAsStream("/application.properties");
//        try {
//            properties.load(is);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    public static ApplicationProperties getInstance(){
        if (applicationProperties == null){
            applicationProperties = new ApplicationProperties();
        }
        return applicationProperties;
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
