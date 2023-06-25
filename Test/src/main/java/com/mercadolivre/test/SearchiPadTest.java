package com.mercadolivre.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchiPadTest {

    private WebDriver driver;

    @Before
    public void setting() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\luana\\OneDrive\\Área de Trabalho\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchiPad() {
        driver.get("https://www.mercadolivre.com.br");

        WebElement search = driver.findElement(By.id("cb1-edit"));
        search.sendKeys("iPad");
        search.submit();

        WebElement result = driver.findElement(By.xpath("//h2[contains(text(), 'iPad')]"));
        Assert.assertTrue("No results found.", result.isDisplayed());

        String product = result.getText();
        Assert.assertTrue("The product found is not an iPad.", product.contains("iPad"));

        System.out.println("The iPad search was successfully validated.");
    }

    @After
    public void close() {
        driver.quit();
    }
}







