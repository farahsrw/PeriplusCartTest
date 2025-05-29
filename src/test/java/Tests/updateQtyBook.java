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

public class updateQtyBook {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.periplus.com/p/9781526672605/harry-potter?filter_name=harry%20potter");
    }

    @AfterClass
    public void tearDown() {
        WebElement qtyInput = driver.findElement(By.id("qty_68254711"));
        java.lang.@Nullable String actualResult = qtyInput.getDomProperty("value");
        Assert.assertEquals(actualResult, "2", "Quantity did not update correctly.");
        driver.quit();
    }

    @Test
    public void updateQuantityBook() throws InterruptedException {
        Thread.sleep(2000);
        WebElement cart = driver.findElement(By.className("btn-add-to-cart"));
        cart.click();
        Thread.sleep(2000);
        driver.get("https://www.periplus.com/checkout/cart");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));

        WebElement addBook = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[data-type='plus'][data-field='quantity[68254711]']")
        ));

        if (addBook.isDisplayed() && addBook.isEnabled()) {
            addBook.click();
        } else {
            Assert.fail("Plus button is not clickable.");
        }

        wait.until(ExpectedConditions.textToBePresentInElementValue(
                driver.findElement(By.id("qty_68254711")), "2"
        ));
    }
}