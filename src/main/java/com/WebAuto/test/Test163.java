package com.WebAuto.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test163{
    WebDriver driver;
    String time1= String.valueOf(System.currentTimeMillis());
    @BeforeMethod
    public void test01(){
        String pwd=System.getProperties().getProperty("APP_HOME",System.getProperty("user.dir"));
        System.out.println(pwd);
        ChromeOptions opt=new ChromeOptions();
        opt.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.driver",pwd+"\\driver\\chromedriver2.38.exe");
        System.err.println(System.getProperty("webdriver.chrome.driver"));
        driver=new ChromeDriver(opt);
        driver.get("http://mail.163.com");

        }



        @Test
       // 测试失败 由于mail.163.com 中的点击注册按钮 有添加不知道什么类型的时间戳
        //所以无法转交给ifarm中操作ifarm中的元素

        public void test02(){
            WebDriverWait wait=new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"loginDiv\"]/iframe")));

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"loginDiv\"]/iframe")));
        driver.findElement(By.id("changepage")).click();
        String handle=driver.getWindowHandle();
        for (String handles:driver.getWindowHandles()){
            if (handles.equals(handle)){
                continue;
                }
            driver.switchTo().window(handles);
        }

            driver.findElement(By.xpath("//*[@id=\"tabsUl\"]/li[1]/a")).click();
            driver.findElement(By.id("nameIpt")).sendKeys("wang"+time1);
            driver.findElement(By.id("mainPwdIpt")).sendKeys("wp45687897894");
            driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("wp45687897894");
            driver.findElement(By.id("mainMobileIpt")).sendKeys("17693292429");
            driver.findElement(By.id("vcodeIpt")).sendKeys("155131");
            driver.findElement(By.id("mainAcodeIpt")).sendKeys("1564131");
            driver.findElement(By.id("mainRegA")).click();
           //显示等待
            WebDriverWait wait1=new WebDriverWait(driver,10);
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_mainAcode\"]/span")));
            String yanzhengma =driver.findElement(By.xpath("//*[@id=\"m_mainAcode\"]/span")).getText();
            Assert.assertEquals(yanzhengma," 手机验证码不正确，请重新填写");
    }
//
//        @AfterMethod
//    public void test00() throws InterruptedException {
//        Thread.sleep(5000);
//        driver.quit();
//        }

}
