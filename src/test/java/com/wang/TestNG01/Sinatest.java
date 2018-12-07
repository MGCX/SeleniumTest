package com.wang.TestNG01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sinatest {
    public static WebDriver driver;
    @BeforeMethod
    public void test01(){
        String pwd=System.getProperties().getProperty("APP_HOME",System.getProperty("user.dir"));
        System.out.println(pwd);
        ChromeOptions opt=new ChromeOptions();
        opt.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.driver",pwd+"\\driver\\chromedriver2.38.exe");
        System.err.println(System.getProperty("webdriver.chrome.driver"));
        driver=new ChromeDriver(opt);
    }

    public static void login(String username,String password){
        driver.get("https://mail.sina.com.cn/");
        driver.findElement(By.id("freename")).sendKeys(username);
        driver.findElement(By.id("freepassword")).sendKeys(password);
        driver.findElement(By.cssSelector("body > div.mailLoginBox > div > div.mainBox.bg1.activity > div > div > div:nth-child(5) > div.loginBox > div.freeMailbox > div.loginOrRegister.clearfix > div.loginRegisterSubmit > a.loginBtn")).click();


    }
    @Test
    public static void loginTest(){
        Sinatest.login("18793371880","");
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div.mailLoginBox > div > div.mainBox.bg1.activity > div > div > div:nth-child(5) > div.loginBox > div.freeMailbox > div.freeError > span.loginError.tip13")));
        String a= driver.findElement(By.cssSelector("body > div.mailLoginBox > div > div.mainBox.bg1.activity > div > div > div:nth-child(5) > div.loginBox > div.freeMailbox > div.freeError > span.loginError.tip13")).getText();
        Assert.assertEquals(a,"请输入密码");
    }
    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
