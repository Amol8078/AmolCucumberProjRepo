package com.titan.fileReaders;

import com.titan.enumerator.SelectDriver;
import com.titan.enumerator.SelectEnv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    private final String filePath = System.getProperty("user.dir")+"/configFile/config.properties";

    public ConfigReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public SelectDriver getDriver() {
        String driverName = properties.getProperty("browser");
        if (driverName == null || driverName.equalsIgnoreCase("chrome")) return SelectDriver.CHROME;
        else if (driverName == null || driverName.equalsIgnoreCase("firefox")) return SelectDriver.FIREFOX;
        else throw new RuntimeException("driver not found");
    }

    public SelectEnv getEnv() {
        String envName = properties.getProperty("environment");
        System.out.println(envName);
        if (envName == null || envName.equalsIgnoreCase("local")) return SelectEnv.LOCAL;
        else if (envName == null || envName.equalsIgnoreCase("remote")) return SelectEnv.REMOTE;
        else throw new RuntimeException("environment not found");
    }

    public String getApplicationUrl() {
        String urlName = properties.getProperty("url");
        System.out.println(urlName);
        if (urlName != null) return urlName;
        else throw new RuntimeException(" url not found");
    }

    public String getUserName(){
        String userName = properties.getProperty("username");
        if (userName != null) return userName;
        else throw new RuntimeException(" username not found");


    }
    public String getPassword(){
        String password = properties.getProperty("password");
        if (password != null) return password;
        else throw new RuntimeException(" password not found");


    }
    public String getOtp(){
        String otp = properties.getProperty("otp");
        if (otp != null) return otp;
        else throw new RuntimeException(" otp not found");


    }

}
