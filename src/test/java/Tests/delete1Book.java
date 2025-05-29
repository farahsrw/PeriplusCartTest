package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class delete1Book {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.periplus.com/p/9781526672605/harry-potter?filter_name=harry%20potter");
    }

    @Test
    public void removeBookFromCart() throws InterruptedException {
        Thread.sleep(2000);
        WebElement cart = driver.findElement(By.className("btn-add-to-cart"));
        cart.click();
        Thread.sleep(2000);
        driver.get("https://www.periplus.com/checkout/cart");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));

        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a.btn-cart-remove[href*='remove=68254711']")
        ));
        if (removeButton.isDisplayed() && removeButton.isEnabled()) {
            removeButton.click();
        } else {
            Assert.fail("Remove button is not clickable.");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.get("https://www.periplus.com/checkout/cart");

        List<WebElement> qtyInputs = driver.findElements(By.id("qty_68254711"));
        Assert.assertTrue(qtyInputs.isEmpty(), "After removal, there should be no quantity input for that book.");

        driver.quit();
    }
}
