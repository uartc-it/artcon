package com.mob.menu;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class gor_menu {
    public WebDriver driver;


    @Test
    public void MenuTop() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://artc-it.net/");
        driver.findElement(By.linkText("About")).click();
        driver.findElement(By.linkText("Solutions")).click();
        driver.findElement(By.linkText("Customers")).click();
        driver.findElement(By.linkText("Career")).click();
        driver.findElement(By.linkText("Contact us")).click();
        driver.quit();
    }

}

