package com.periplus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addToCart() {
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add to Cart')]")));
        addToCartBtn.click();

        try {
            WebElement closePopupBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.popup-close")));
            closePopupBtn.click();
        } catch (Exception e) {
            
        }
    }
}
