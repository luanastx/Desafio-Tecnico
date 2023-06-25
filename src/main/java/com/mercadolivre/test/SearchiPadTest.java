package com.mercadolivre.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchiPadTest {

    private WebDriver driver;
    private static final String CHROME_DRIVER_PATH = "C:\\Users\\luana\\OneDrive\\Área de Trabalho\\chromedriver_win32\\chromedriver.exe";

    @Before
    public void setting() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchiPad() {
        // Cenário: Pesquisar iPad no site do Mercado livre e verificar se o produto é exibido nos resultados

        // Abrir o site do Mercado livre
        driver.get("https://www.mercadolivre.com.br");

        // Localizar o campo de pesquisa e inserir a palavra-chave "iPad"
        WebElement search = driver.findElement(By.id("cb1-edit"));
        search.clear();
        search.sendKeys("iPad");
        search.submit();

        try {
            // Localizar o elemento que contém o texto "iPad" nos resultados da pesquisa
            WebElement result = driver.findElement(By.xpath("//h2[contains(text(), 'iPad')]"));
            String product = result.getText();

            // Verificar se o produto encontrado é realmente um iPad
            Assert.assertTrue("The product found is not an iPad.", product.contains("iPad"));
        } catch (NoSuchElementException e) {
            // Caso nenhum resultado seja encontrado, o teste falha
            Assert.fail("No results found for iPad.");
        }

        System.out.println("The iPad search was successfully validated.");
    }

    @After

    // Fechar o navegador após a execução do teste
    public void close() {
        driver.quit();
    }
}







