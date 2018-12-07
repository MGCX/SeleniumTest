package com.wang.TestNG01;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo02 {
    WebDriver driver;
    @BeforeClass
    public void demo02(){

        String pwd = System.getProperties().getProperty("APP_HOME", System.getProperty("user.dir"));
        System.out.println(pwd);
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.driver", pwd + "\\driver\\chromedriver2.38.exe");
        System.err.println(System.getProperty("webdriver.chrome.driver"));
        WebDriver dirver =new ChromeDriver(opt);
//        dirver.get("file:///E:/idea-workspace/Demo/selenium_html/demo1.html");
//        dirver.findElement(By.className("alert")).click();
//        Thread.sleep(3000);
//        Alert aleat=dirver.switchTo().alert();
//        aleat.accept();
        }
        @Test
   public void test01 () throws InterruptedException {

            driver.get("http://www.baidu.com");
//        driver.findElement(By.className("alert")).click();
//        Thread.sleep(3000);
//        Alert aleat=driver.switchTo().alert();
//        aleat.accept();
        }


}
