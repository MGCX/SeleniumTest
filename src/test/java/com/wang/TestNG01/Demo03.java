package com.wang.TestNG01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Demo03 {
      WebDriver driver ;

    @BeforeClass
    public  void OpenChrome () {
        String pwd = System.getProperties().getProperty("APP_HOME", System.getProperty("user.dir"));
        System.out.println(pwd);
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.driver", pwd + "\\driver\\chromedriver2.38.exe");
        System.err.println(System.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver(opt);
        driver=new ChromeDriver();
    }

    @Test
    public void list() {
        driver.get("E:\\idea-workspace\\Demo\\selenium_html\\index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(2)).keyUp(Keys.SHIFT).perform();
    }


    @Test
    public void savehtml(){
        driver.get("http://www.baidu.com");
    }


}
