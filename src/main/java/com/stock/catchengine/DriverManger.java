package com.stock.catchengine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * driver manger
 */
public class DriverManger {

    private static volatile WebDriver driver;
    private static final String driverPath = "C:\\Users\\Administrator.CH-202203040207\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe";

    private DriverManger() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (DriverManger.class) {
                if (driver == null) {
                    //参数配置
                    System.setProperty("webdriver.chrome.driver",
                            driverPath);

                    ChromeOptions option = new ChromeOptions();
                    option.addArguments("no-sandbox");
                    option.addArguments("headless");

                    driver = new ChromeDriver(option);
                }
            }
        }
        return driver;
    }

    public static void close(){
        synchronized (DriverManger.class) {
            if(driver != null ){
                driver.close();
            }
        }
    }
}
