package com.titan.managers;

import com.titan.fileReaders.ConfigReader;

public class ReaderManager {

    private static ReaderManager readerManager = new ReaderManager();
    private static ConfigReader configReader;

    private ReaderManager() {
    }

    public static ReaderManager getInstance() {
        return readerManager;

    }

    public ConfigReader getConfigReader() {

        return (configReader == null) ? new ConfigReader() : configReader;


    }
}
