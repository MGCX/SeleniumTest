package com.WebAuto.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zhengdaoseshi {
    public static void main(String[] args) {
        String pwd = System.getProperties().getProperty("APP_HOME", System.getProperty("user.dir"));
        System.out.println(pwd);
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.driver", pwd + "\\driver\\chromedriver2.38.exe");
        System.err.println(System.getProperty("webdriver.chrome.driver"));
        WebDriver dirver =new ChromeDriver(opt);
        dirver.get("http://www.jander.cn");
        dirver.manage().window().maximize();
        dirver.findElement(By.xpath("//*[@id=\"icon-login\"]")).click();
        dirver.findElement(By.id("username")).sendKeys("17693292429");
        dirver.findElement(By.id("password")).sendKeys("wpmllai11440");

//        dirver.findElement(By.xpath("//*[@id=\"login\"]")).click();


    }
}
