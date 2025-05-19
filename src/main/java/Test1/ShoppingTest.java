package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShoppingTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException{
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.periplus.com/");
        Thread.sleep(1000);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void ShoppingCartTest() throws InterruptedException {
        driver.findElement(By.id("nav-signin-text")).click();
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));

        //Enter email and password
        email.sendKeys("kennethtanbenyamin02@gmail.com");
        password.sendKeys("96P!w&K&hK");

        //Click Login
        driver.findElement(By.id("button-login")).click();
        Thread.sleep(4000);

        //Find Book
        driver.findElement(By.linkText("New Releases")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("When the Mountains Roared")).click();
        Thread.sleep(4000);

        //Add book to cart
        driver.findElement(By.className("btn-add-to-cart")).click();
        Thread.sleep(3000);

        //Checks for success message
//        String resultMessage = driver.findElement(By.className("modal-text")).getText();
//        String expected = "Success add to cart";
//        Assert.assertEquals(resultMessage, expected);
//        Thread.sleep(2000);

        //Checks in cart
        driver.findElement(By.id("show-your-cart")).click();
        Thread.sleep(3000);
        boolean resultBool = driver.findElement(By.linkText("When the Mountains Roared")).isDisplayed();
        Assert.assertTrue(resultBool);

    }
}
