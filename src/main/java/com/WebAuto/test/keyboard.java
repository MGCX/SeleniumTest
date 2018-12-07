package com.WebAuto.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//存在问题 sendkeys后不能用keys.bacaspace、、、、待解决    ·
public class keyboard {
    public static void main(String[] args) throws InterruptedException {
        String pwd = System.getProperties().getProperty("APP_HOME", System.getProperty("user.dir"));
        System.out.println(pwd);
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.driver", pwd + "\\driver\\chromedriver2.38.exe");
        System.err.println(System.getProperty("webdriver.chrome.driver"));
        WebDriver dirver =new ChromeDriver(opt);
        dirver.get("http://www.baidu.com");
        //输入框内输入内容
        WebElement input =dirver.findElement(By.xpath("//*[@id=\"s_form_wrapper\"]/form[1]/span[2]/input[1]"));
        input.sendKeys("你好");
        input.click();
        Thread.sleep(2000);
        //删除多余的一个m

    }
}
