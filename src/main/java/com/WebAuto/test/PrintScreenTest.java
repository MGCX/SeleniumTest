package com.WebAuto.test;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class PrintScreenTest {
    public static void main(String[] args) throws InterruptedException {
        String pwd = System.getProperties().getProperty("APP_HOME", System.getProperty("user.dir"));
        System.out.println(pwd);
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.driver", pwd + "\\driver\\chromedriver2.38.exe");
        System.err.println(System.getProperty("webdriver.chrome.driver"));
        WebDriver dirver =new ChromeDriver(opt);
        dirver.get("http://www.baidu.com");
        File file=((TakesScreenshot)dirver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("E:\\test01.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
