package com.wang.TestNG01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo04 {
    WebDriver driver;
    @BeforeMethod
    public void RegisterTest(){

        driver.get("http://www.jander.cn");
    }
    @Test
    public void regist()  {
       String time= String.valueOf(System.currentTimeMillis()/100);
        WebDriverWait wait =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#icon-register > span")));
        driver.findElement(By.cssSelector("#icon-register > span")).click();
       driver.findElement(By.xpath("//*[@id=\"scroll\"]/div[1]/div/div/div[1]/div[3]/div[1]/div/div[2]/div[2]/form[1]/div/div/div/input")).sendKeys(time);
       driver.findElement(By.xpath("//*[@id=\"scroll\"]/div[1]/div/div/div[1]/div[3]/div[1]/div/div[2]/div[2]/form[2]/div[1]/div/div[1]/input")).sendKeys(time);
       driver.findElement(By.id("next")).click();
        //显示等待
        WebDriverWait wait1 =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"scroll\"]/div[1]/div/div/div[1]/div[3]/div[1]/div/div[2]/div[2]/form[2]/div[1]/div/div[2]")));
        String error =driver.findElement(By.xpath("//*[@id=\"scroll\"]/div[1]/div/div/div[1]/div[3]/div[1]/div/div[2]/div[2]/form[2]/div[1]/div/div[2]")).getText();
        Assert.assertEquals(error,"验证码输入错误");

    }
}
