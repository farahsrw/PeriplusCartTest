package com.periplus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCartPage() {
        driver.findElement(By.cssSelector("a.cart-icon")).click();
    }

    public int getNumberOfProductsInCart() {
        List<WebElement> cartItems = driver.findElements(By.cssSelector("div.cart-item"));
        return cartItems.size();
    }
}
