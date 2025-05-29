package Tests;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class checkoutBook {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.periplus.com/account/Login");
    }
    @AfterClass
    public void tearDown() {
        String expectedUrl = "https://www.periplus.com/checkout/Review-Your-Order";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "The browser did not navigate to the expected URL after checkout.");
        driver.quit();
    }
    @Test
    public void checkout() throws InterruptedException {
        Thread.sleep(2000);
        WebElement mail = driver.findElement(By.name("email"));
        mail.sendKeys("x@gmail.com");
        WebElement password = driver.findElement(By.id("ps"));
        password.sendKeys("xxxxx");
        WebElement login = driver.findElement(By.id("button-login"));
        login.click();
        Thread.sleep(2000);
        driver.get("https://www.periplus.com/p/9781526672605/harry-potter?filter_name=harry%20potter");
        Thread.sleep(2000);
        WebElement cart = driver.findElement(By.className("btn-add-to-cart"));
        cart.click();
        Thread.sleep(2000);
        driver.get("https://www.periplus.com/checkout/cart");
        Thread.sleep(8000);
        WebElement checkout = driver.findElement(By.cssSelector("a.btn.d-flex.align-items-center.justify-content-center"));
        if (checkout.isDisplayed() && checkout.isEnabled()) {
            checkout.click();
        } else {
            Assert.fail("Checkout button is not clickable.");
        }
        Thread.sleep(5000);
        WebElement fName = driver.findElement(By.name("firstname"));
        fName.sendKeys("Test");
        WebElement adr = driver.findElement(By.name("address_1"));
        adr.sendKeys("TestTestTestTestTestTestTestTestTestTestTestTestTest");
        WebElement country = driver.findElement(By.id("zone_id"));
        Select selectCountry = new Select(country);
        selectCountry.selectByValue("3");

        Thread.sleep(2000);
        WebElement city = driver.findElement(By.id("city_id"));
        Select selectCity = new Select(city);
        selectCity.selectByValue("24");

        Thread.sleep(2000);
        WebElement district = driver.findElement(By.id("district"));
        Select selectDistrict = new Select(district);
        selectDistrict.selectByValue("249");

        Thread.sleep(2000);
        WebElement village = driver.findElement(By.id("village"));
        Select selectVillage = new Select(village);
        selectVillage.selectByValue("2545");
        WebElement poscode = driver.findElement(By.id("postcode"));
        poscode.sendKeys("15321");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("08xxx");
        WebElement submit = driver.findElement(By.id("button-address-new"));
        submit.click();
        Thread.sleep(5000);
    }
}
