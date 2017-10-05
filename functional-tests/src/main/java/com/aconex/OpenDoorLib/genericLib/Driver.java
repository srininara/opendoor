package com.aconex.OpenDoorLib.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    //The below code is for fire fox driver
    //public static WebDriver DRIVER=new FirefoxDriver();
//	public static WebDriver DRIVER=DRIVER();
    public static WebDriver DRIVER=DRIVER();

    //The below code block is for chrome driver as well as can be used for firefox
    public static void systemPropeties(){
//        System.setProperty("webdriver.chrome.driver","/Users/akumarn/Documents/chromedriver/chromedriver");
        //System.setProperty("webdriver.ie.driver","C:\\IEDriverForSelenium\\IEDriverServer.exe");
        
    }

    public static WebDriver DRIVER(){
        systemPropeties();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        return new ChromeDriver(chromeOptions);
        //return new FirefoxDriver();
        //return new InternetExplorerDriver();


    }

}


	/*public static WebDriver getDriver(String browser){
		if(browser.equals("firefox"))
		driver =new FirefoxDriver();
		*//*else if(browser.equals("ie")){

			driver =new InternetExplorerDriver();
		}else{
			driver =new ChromeDriver();
		}*/
//return driver;

/*public static WebDriver driver;

    public  Driver(WebDriver driver){
        Driver.driver = driver;
    }*/

