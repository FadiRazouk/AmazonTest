# **Amazon Checkout Automation**

## **Project Overview**
This project automates the testing of Amazon's product search, filtering, and checkout flow. The tests focus on the following scenarios:

1. Navigating to the "All Video Games" category.
2. Applying filters (free shipping and condition: new).
3. Sorting products by price (high to low).
4. Adding products below 15,000 EGP to the cart.
5. Completing the checkout process using a cash payment method.

The project is built using Selenium WebDriver with Java and follows the **Page Object Model (POM)** design pattern for code maintainability and scalability.

## **Project Structure**
```
/src
  ├── /main/java/com/amazon/pages
      ├── HomePage.java
      ├── VideoGamesPage.java
      └── CartPage.java
  └── /test/java/com/amazon/tests
      └── AmazonTest.java
```

- **HomePage.java**: Handles interactions with the main Amazon homepage.
- **VideoGamesPage.java**: Manages actions on the video games section.
- **CartPage.java**: Manages cart interactions.

## **Prerequisites**

To set up and run this project, ensure you have the following installed:

- Java Development Kit (JDK) (Version 8 or higher)
- Apache Maven
- Google Chrome (Version 114 or compatible)
- ChromeDriver (managed by WebDriverManager)

## **Setup and Installation**

### 1. Clone the repository
```bash
git clone git@github.com:FadiRazouk/Amazon-Checkout-Automation.git
```

### 2. Install dependencies
Make sure Maven is installed, then run the following command to install the required dependencies:
```bash
mvn clean install
```

### 3. Update ChromeDriver version (if needed)
The project uses WebDriverManager to automatically manage the ChromeDriver version. If a specific Chrome version is required, adjust it in the `pom.xml` or in your local environment settings.

### 4. Running the Tests
To run the tests, use the following Maven command:
```bash
mvn test
```

Alternatively, you can run the `AmazonCheckoutTest` class from your IDE.

## **Key Test Scenarios**

- **Navigate to All Video Games**: Opens the Amazon homepage and navigates through the left-side "All" menu to reach the "All Video Games" section.
- **Apply Filters**: Applies the "Free Shipping" and "New Condition" filters from the left menu.
- **Sort Products**: Sorts the products by "Price: High to Low".
- **Add Products to Cart**: Adds all products priced below 15,000 EGP to the cart.
- **Checkout Process**: Completes the checkout process using a cash payment method.
