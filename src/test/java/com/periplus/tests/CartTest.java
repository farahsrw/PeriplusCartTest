package com.periplus.tests;

import com.periplus.pages.CartPage;
import com.periplus.pages.HomePage;
import com.periplus.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends TestBase {

    @Test
    public void testAddHarryPotterToCart() {
        driver.get("https://www.periplus.com");

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.searchForProduct("Harry Potter");
        productPage.addToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCartPage();

        int itemCount = cartPage.getNumberOfProductsInCart();
        Assert.assertEquals(itemCount, 1, "Jumlah item di keranjang tidak sesuai.");
    }
}
