package com.amazon.tests;

import com.amazon.pages.AllVideoGamesPage;
import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertTrue;

public class AmazonTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAmazonVideoGamesFlow() throws InterruptedException {
        // Step 1: Open Amazon homepage
        HomePage homePage = new HomePage(driver);
        homePage.openAmazon();

        // Step 2: Open "All" menu
        homePage.openAllMenu();

        // Step 3: Click on "Video Games" and choose "All Video Games"
        homePage.clickVideoGames();

        // Step 4: Add filter "Free Shipping" and "New"
        AllVideoGamesPage videoGamesPage = new AllVideoGamesPage(driver);
        videoGamesPage.applyFilter("All customers get FREE Shipping on orders shipped by Amazon");
        Thread.sleep(1000);

        videoGamesPage.applyFilter("New");
        Thread.sleep(1000);
        // Step 5: Sort by price high to low
        videoGamesPage.sortBy("Price: High to Low");
        Thread.sleep(1000);

        // Step 6: Add products below 15,000 EGP to the cart
        double totalPrice = videoGamesPage.addProductsToCartBelowPrice(15000);
        Thread.sleep(3000);

        // Step 7: Open Cart and verify items
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
        cartPage.verifyItemsInCart();

        // Step 9: Verify total amount
        double productFound = cartPage.getTotalAmount();;
        assertTrue(Math.abs(productFound - totalPrice) < 1e-3, "The values are not equal!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
