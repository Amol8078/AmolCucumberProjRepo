package com.titan.contextManager;


import com.titan.managers.DriverManager;
import com.titan.managers.PageManager;

public class ContextText {
    private DriverManager driverManager;
    private PageManager pageManager;


    public ContextText() {
        driverManager = new DriverManager();
        pageManager = new PageManager(driverManager.getDriverForLaunch());
    }
    public DriverManager getDriverManager(){

       return driverManager;
    }
    public PageManager getPageManager(){

        return pageManager;
    }
}
