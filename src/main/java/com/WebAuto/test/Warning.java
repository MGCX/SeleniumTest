package com.WebAuto.test;
/**
 * 对界面的截图
 */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Warning {
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
        Actions actions=new Actions(dirver);
        actions.clickAndHold(dirver.findElement(By.linkText("设置"))).perform();
        dirver.findElement(By.linkText("搜索设置")).click();
        dirver.findElement(By.linkText("保存设置")).click();
        Thread.sleep(3000);
        Alert alert=dirver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

    }
}
