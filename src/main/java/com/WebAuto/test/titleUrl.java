package com.WebAuto.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class titleUrl {
    public static void main(String[] args) throws InterruptedException {
        String pwd = System.getProperties().getProperty("APP_HOME", System.getProperty("user.dir"));
        System.out.println(pwd);
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.driver", pwd + "\\driver\\chromedriver2.38.exe");
        System.err.println(System.getProperty("webdriver.chrome.driver"));
        WebDriver dirver =new ChromeDriver(opt);
        dirver.get("https://mail.qq.com/");
        dirver.manage().window().maximize();
        System.out.println("————————登陆之前的title和url————————");
        //获得当前页面的title
        System.out.println("title of current page is %\n"+dirver.getTitle());
        System.out.println("url of current page is %\n"+dirver.getCurrentUrl());
        //登陆qq邮箱
        dirver.switchTo().frame("login_frame");

        dirver.findElement(By.id("u")).sendKeys("995953864");

        dirver.findElement(By.id("p")).sendKeys("wpmllai11220");
        dirver.findElement(By.xpath("//*[@id=\"login_button\"]")).click();
        System.out.println("------登陆后的title和url--------");
        //获得登陆后的title和url
        System.out.println("title of current of %\n"+dirver.getTitle());
        System.out.println("url of current page is %\n"+dirver.getCurrentUrl());

//        //获得登陆用户名
//        String text =dirver.findElement(By.id("useraddr")).getText();
//        System.out.println(text) ;
    }
}
