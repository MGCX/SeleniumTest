package com.WebAuto.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

/**
 * @author  wangpengming
 * 关于多个窗口之间的转换
 * 使用到for循环 对于不同页面的句柄和全部页面的句柄进行比较
 * 1.首先得到当前页面的句柄 String 别名 = driver.getWindowHandle();
 * 2.打开要打开的页面
 * 3.获得所有句柄 Set<String>handles=driver.getWindowHandles  <s的关键性>();
 *4.判断是不是要打开的窗口的句柄，并操作窗口的元素for（String handle:handles）{
 *     if(hanle.equls(别名)==false){
 *         切换到要打开的窗口,并操作
 *         driver.swtichto().window(hanle);
 *         操作
 *     }
 *     切换到刚开始打开的页面
 *     for(String handle:handles){
 *         if(hanle.equlse(别名)){
 *            driver.SwitchTo().Window(handle);
 *            操作
 *         }
 *     }
 *}
 */

public class DuoChuangKou {
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
        //获得当前句柄
        String sreach_handle=dirver.getWindowHandle();
            dirver.findElement(By.xpath("//*[@id=\"u1\"]/a[7]")).click();
            Thread.sleep(3000);
            dirver.findElement(By.xpath("//*[@id=\"passport-login-pop-dialog\"]/div/div/div/div[4]/a")).click();
            //获得所有的句柄
        Set<String> hanles=dirver.getWindowHandles();
        //判断是不是注册页的句柄，并操作注册页上的元素
        for (String hanle:hanles){
            if (hanle.equals(sreach_handle)==false){
                //切换到注册页
                dirver.switchTo().window(hanle);
                System.out.println("now register window!");
                Thread.sleep(2000);
                dirver.findElement(By.name("userName")).sendKeys("wo");
                dirver.findElement(By.name("phone")).sendKeys("123456");
                Thread.sleep(3000);
            }
        }
        //判断是不是百度首页的句柄
        for (String handle:hanles)if (handle.equals(sreach_handle)){
            dirver.switchTo().window(handle);
            Thread.sleep(2000);
            dirver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_4__closeBtn\"]")).click();
            dirver.findElement(By.id("kw")).sendKeys("你好");
            dirver.findElement(By.id("su")).click();
        }
    }
}
