package com.test.ui.playwright.site;

import com.microsoft.playwright.*;

import java.util.Random;

public class Site {

    private Playwright playwright;
    private BrowserType browserType;
    private Browser browser;
    private BrowserContext browserContext;
    private Page page;

    private Browser.NewContextOptions contextOptions;
    private BrowserType.LaunchOptions options;

    public void playwright(){
        Random r = new Random();
        int i = r.nextInt(999999 - 99999) + 345;
        System.out.println("Object id is: " + i);
        playwright = Playwright.create();
    }

    public BrowserType browserType(){
        if(playwright == null) {
            playwright();
        }
        browserType = playwright.chromium();
        return browserType;
    }


    public Browser browser(){
        if(browserType == null){
            browserType();
        }

        if(options == null) {
            options = new BrowserType.LaunchOptions();
        }

        browser = browserType.launch(options);
        return browser;
    }

    public BrowserContext browserContext(){
        if(browser == null){
            browser();
        }

        if(contextOptions == null) {
            browserContext = browser.newContext();
        }

        browserContext = browser.newContext(contextOptions);
        return browserContext;
    }

    public BrowserContext newBrowserContext(){
        browserContext = browser.newContext();
        return browserContext;
    }

    private void defaultPage(){
        page = browserContext().newPage();
    }

    public Site newContextPage(){
        page = browserContext().newPage();
        return this;
    }

    public Page page(){
       if(page == null) {
           defaultPage();
       }
        return page;
    }

    public Site options(BrowserType.LaunchOptions options){
        this.options = options;
        return this;
    }

    public Site contextOptions(Browser.NewContextOptions contextOptions){
        this.contextOptions = contextOptions;
        return this;
    }

    public void navigate(String url){
        page().navigate(url);
    }

    public void closeContext(){
        if(browserContext != null) {
            browserContext.close();
        }
    }

    public void close(){
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }

}
