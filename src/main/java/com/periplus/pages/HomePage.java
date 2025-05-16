package com.periplus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public ProductPage searchForProduct(String productName) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchBox.submit();

        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.product-listing a.product-title")));
        firstResult.click();

        return new ProductPage(driver);
    }
}
