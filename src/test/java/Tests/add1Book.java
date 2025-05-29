package Tests;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class add1Book {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.periplus.com/p/9781526672605/harry-potter?filter_name=harry%20potter");
    }

    @AfterClass
    public void tearDown() {
        driver.get("https://www.periplus.com/checkout/cart");
        WebElement qtyInput = driver.findElement(By.id("qty_68254711"));
        java.lang.@Nullable String actualResult = qtyInput.getDomProperty("value");
        Assert.assertEquals(actualResult, "1", "Quantity did not match expected value.");
        driver.quit();
    }

    @Test
    public void testOneAddBook() throws InterruptedException {
        Thread.sleep(2000);
        WebElement cart = driver.findElement(By.className("btn-add-to-cart"));
        cart.click();
        Thread.sleep(2000);
    }
}