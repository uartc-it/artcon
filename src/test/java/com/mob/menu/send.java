package com.mob.menu;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class send {

    public WebDriver driver;

    @Test
    public void sends() {
        driver = new FirefoxDriver();
        driver.get("http://artc-it.net/");
        driver.findElement(By.linkText("Contact us")).click();
        driver.findElement(By.xpath("//section[@id='contacts']/div[2]/form/div/label")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Test");
        driver.findElement(By.id("tel")).clear();
        driver.findElement(By.id("tel")).sendKeys("0685555555");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("vvv@ua.fm");
        driver.findElement(By.id("msg")).clear();
        driver.findElement(By.id("msg")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='Send']")).click();
        driver.quit();
    }

}

