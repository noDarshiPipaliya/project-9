package TestSuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
//        WebElement usernameField = driver.findElement(By.id("user-name"));
//        usernameField.sendKeys("user-name");
//        WebElement passwordField = driver.findElement(By.name("password"));
//        passwordField.sendKeys("secret_sauce");
        sendTextToElement(By.id("user-name"),"user-name");
        sendTextToElement(By.id("password"),"secret_sauce");

//        WebElement loginbutton = driver.findElement(By.xpath("//input[@id='login-button']"));
//        loginbutton.click();
        clickOnElement(By.xpath("//input[@id='login-button']"));

        String expectedMessage = "PRODUCTS";
        WebElement actualMessageelement = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to secure area ", expectedMessage, actualMessage);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
//        WebElement usernameField = driver.findElement(By.id("user-name"));
//        usernameField.sendKeys("standard_user");
//        WebElement passwordField = driver.findElement(By.name("password"));
//        passwordField.sendKeys("secret_sauce");
        sendTextToElement(By.id("user-name"),"standard_user");
        sendTextToElement(By.id("password"),"secret_sauce");

//        WebElement loginbutton = driver.findElement(By.xpath("//input[@id='login-button']"));
//        loginbutton.click();
        clickOnElement(By.xpath("//input[@id='login-button']"));

        List<WebElement> value = (List<WebElement>) driver.findElement(By.className("inventory_items_name"));
        int size = value.size();
        System.out.println(size);

        int expectedvalue=6;
        int actualvalue =size;
        Assert.assertEquals(expectedvalue,actualvalue);

    }
}
