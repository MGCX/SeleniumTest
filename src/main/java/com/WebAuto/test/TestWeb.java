package com.WebAuto.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestWeb {
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
//加别名 好辨别
//        WebElement denglu= dirver.findElement(By.xpath("//*[@id=\"u1\"]/a[7]"));
//        denglu.click();
//        Thread.sleep(3000);
//WebElement shuru =dirver.findElement(By.id("TANGRAM__PSP_10__footerULoginBtn"));
//        shuru.click();
//        WebElement shuru1 =dirver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_10__userName\"]"));
//        shuru1.sendKeys("17693292429");
//        WebElement shuru2 =dirver.findElement(By.id("TANGRAM__PSP_10__password"));
//
//        shuru2.sendKeys("wpmllai11440");
//        dirver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_10__submit\"]")).click();
dirver.findElement(By.id("kw")).sendKeys("政道搜索");
dirver.findElement(By.id("su")).click();


        WebElement zhengdao =dirver.findElement(By.xpath("//*[@id=\"1\"]/h3/a"));
zhengdao.click();
//
//         dirver.findElement(By.xpath("//*[@id=\"u1\"]/a[7]")).click();
////不用起别名 不好识别
//        Thread.sleep(3000);
//        dirver.findElement(By.id("TANGRAM__PSP_10__footerULoginBtn")).click();
//        dirver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_10__userName\"]")).sendKeys("17693292429");
//        dirver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys("wpmllai11440");
//        dirver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_10__submit\"]")).click();
    }

}
