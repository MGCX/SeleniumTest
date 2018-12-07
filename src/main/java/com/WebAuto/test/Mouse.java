package com.WebAuto.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouse {
    public static void main(String[] args) {
        String pwd = System.getProperties().getProperty("APP_HOME", System.getProperty("user.dir"));
        System.out.println(pwd);
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.driver", pwd + "\\driver\\chromedriver2.38.exe");
        System.err.println(System.getProperty("webdriver.chrome.driver"));
        WebDriver dirver =new ChromeDriver(opt);
        dirver.get("http://www.baidu.com" );
        //鼠标右击
        Actions actions= new Actions(dirver);
        actions.contextClick(dirver.findElement(By.id("kw"))).perform();
        //鼠标悬停

        actions.clickAndHold(dirver.findElement(By.linkText("设置"))).perform();
    }

}
