package com.WebAuto.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Baidu1 {
    public static void main(String[] args) throws InterruptedException {
        String pwd = System.getProperties().getProperty("APP_HOME", System.getProperty("user.dir"));
        System.out.println(pwd);
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.driver", pwd + "\\driver\\chromedriver2.38.exe");
        System.err.println(System.getProperty("webdriver.chrome.driver"));
        WebDriver dirver =new ChromeDriver(opt);
        dirver.get("http://www.baidu.com");
        dirver.manage().window().maximize();
       //百度搜索框的尺寸大小
        WebElement size =dirver.findElement(By.id("kw"));
        System.out.println("百度的搜索框的大小————————"+size.getSize());
        //返回百度底部文案的内容
        WebElement test =dirver.findElement(By.id("cp"));
        System.out.println("百度所搜框底部的文案信息——————"+test.getText());
        //返回元素的属性值
        WebElement ty =dirver.findElement(By.id("kw"));
        System.out.println("百度搜索框的name属性——————"+ty.getTagName());
        //返回元素是否可见返回结果为true或者false
        WebElement display =dirver.findElement(By.id("kw"));
        System.out.println("返回元素是否可见——————"+display.isDisplayed());
        //等待时间的处理方式 两种
        //1.throws关键字
        Thread.sleep(3000);

        //try catch关键字的时间等待
//        try{
//            Thread.sleep(3000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }



        dirver.quit();
        System.out.println("end selenium");
    }
}
