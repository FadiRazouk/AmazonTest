package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void proceedToCheckout() {
        WebElement checkoutButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("nav-cart")));
        checkoutButton.click();
    }

    // Method to verify that the cart contains the expected items
    public void verifyItemsInCart() {
        WebElement cartTotal = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart-count")));
        assertTrue(cartTotal.isDisplayed(), "Cart total is not displayed.");
        assertTrue(Integer.parseInt(cartTotal.getText()) > 0, "Cart total is not greater than 0.");
    }

    // Method to retrieve the total amount
    public double getTotalAmount() {
        WebElement totalAmountElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-subtotal-amount-activecart")));
        String totalAmountText = totalAmountElement.getText().replaceAll("[^0-9.]", "");
        return Double.parseDouble(totalAmountText);
    }
}
