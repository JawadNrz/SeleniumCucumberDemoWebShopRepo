package stepDefinition;

import fixures.Utilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static fixures.Utilities.driver;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.xpath;


@RunWith(Cucumber.class)
public class LoginStepDef {

    // Navigate to any Website
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String pageName) {

        String url = "https://demowebshop.tricentis.com/";
        switch (pageName.toLowerCase()) {
            case "home":
                url += "";
                break;
            case "register":
                url += "register";
                break;
            case "login":
                url += "login";
                break;
            case "cart":
                url += "cart";
                break;
            default:
                throw new IllegalArgumentException("Invalid page name: " + pageName);
        }
        Utilities.openUrl(url);
    }

    // Click on any Page
    @And("I click on the {string} {string}")
    public void iClickOnThePage(String elementName, String elementType) throws InterruptedException {
        WebElement element = null;
        switch (elementType) {
         case "page" :
            element = driver.findElement(xpath("//a[normalize-space()='" + elementName + "']"));
            element.click();
            Thread.sleep(1000);
            break;
         case "product" :
            element = driver.findElement(xpath("//h2[@class='product-title']//a[normalize-space()='" + elementName + "']"));
            element.click();
             break;

            default:
                throw new IllegalStateException("Unexpected value: " + elementType);
        }
    }


    // filling in InputBoxes
    @When("I pass a {string} to {string} inputBox")
    public void iPassAToInputBox(String inputText, String inputBox) throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        LogInPage logInPage = new LogInPage(driver);
        GenerelPage generelPage = new GenerelPage(driver);
        ProductPage productPage = new ProductPage(driver);
        BillingAdressPage billingAdressPage = new BillingAdressPage(driver);
        ProductReviewsPage productReviewsPage = new ProductReviewsPage(driver);

        switch (inputBox) {
            case "FirstName":
                registerPage.firstNameInput.sendKeys(inputText);
                break;
            case "LastName":
                registerPage.lastNameInput.sendKeys(inputText);
                break;
            case "Email":
                registerPage.emailInput.sendKeys(inputText);
                if (inputText.equals("email")) {
                    logInPage.InputEmailLogin(inputText);
                }
                break;
            case "RandomEmail":
                registerPage.emailInput.sendKeys(Utilities.generateRandomEmail());
                break;
            case "Password":
                registerPage.passwordInput.sendKeys(inputText);
                //if (inputBox.equals("Password")) {
                  //  logInPage.InputPasswordLogin(inputText);
               // }
                break;
            case "ConfirmPassword":
                registerPage.confirmPasswordInput.sendKeys(inputText);
                break;
            case "Search store":
                generelPage.searchStore.sendKeys(inputText);
                break;
            case "Address1" :
                billingAdressPage.adress1Input.sendKeys(inputText);
                break;
            case "City" :
                billingAdressPage.cityInput.sendKeys(inputText);
                break;
            case  "Postal code" :
                billingAdressPage.postalCodeInput.sendKeys(inputText);
                break;
            case  "Phone number" :
                billingAdressPage.phoneNumber.sendKeys(inputText);
                break;
            case "Length in cm" :
                productPage.LenghtInCmField(inputText);
                break;
            case "Review title" :
                productReviewsPage.ReviewTittleInput(inputText);
                break;
            case "Review text" :
                productReviewsPage.ReviewTextInput(inputText);
                break;

            default:
                System.out.println("Input Box does not exist");
        }
    }

    // Click on any button
    @And("I click the {string} button on the {string} page")
    public void iClickTheButton(String buttonName, String buttonPage) {


        String css = "input[onclick='" + buttonName + "']";

        ArrayList<WebElement> buttons = new ArrayList<>();
        buttons.addAll(driver.findElements(By.xpath("//input[@value='"+ buttonName +"']")));
        buttons.addAll(driver.findElements(By.xpath("//input[@id='"+ buttonName +"']")));
        buttons.addAll(driver.findElements(By.xpath("//button[@id='" + buttonName + "']")));
        for (WebElement button : buttons) {
            button.click();
        }
    }


    // Click on any Checkbox
    @And("I click the {string} checkbox")
    public void iClickTheCheckbox (String checkBoxName) throws InterruptedException {
        WishListPage wishListPage = new WishListPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        ShippingAdressPage shippingAdressPage = new ShippingAdressPage(driver);
        switch (checkBoxName) {
            case "Remove":
                wishListPage.RemoveCheckbox();
                break;
            case "Add to cart":
                wishListPage.AddToCartCheckBox();
                break;
            case "":
                shoppingCartPage.ProductCheckBox();
                break;
            case "Agree":
                shoppingCartPage.AgreeCheckBox();
                break;
            case "In-Store Pickup" :
                shippingAdressPage.PickUpInStoreCheckBox.click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + checkBoxName);
        }

    }


    // Assertion
    @Then("I should see {string} {string}")
    public void i_should_see(String elementType, String elementText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = null;

        switch (elementType) {
            case "the button":
                element = driver.findElement(xpath("//input[@value='" + elementText + "']"));
                break;
            case "error message":
                element =  driver.findElement(xpath("//span[contains(text(),'" + elementText + "')]"));
                break;
            case "element":
                element = driver.findElement(xpath("//a[normalize-space()='" + elementText + "']"));
                break;
            case "error":
                element = driver.findElement(xpath("//li[normalize-space()='" + elementText + "']"));
                break;
            case "the product" :
                element = driver.findElement(xpath("//a[@class='" + elementText + "']"));
                break;
            case "the message":
                element = driver.findElement(xpath("(//h2[normalize-space()='" + elementText + "'])[1]"));
                break;
            case " the Information":
                  element = driver.findElement(xpath("div[class='title'" + elementText + "'] strong)"));
               break;
            case "the Message":
                element = driver.findElement(xpath("//li[normalize-space()='" + elementText + "'])"));
                break;
            case "the logo":
                element = driver.findElement(xpath("//img[@alt='" + elementText + "']"));
                break;
            case "information" :
                element = driver.findElement(xpath("//div[@class='" + elementText + "'])"));
                break;
            default:
                throw new IllegalArgumentException("Unsupported element type: " + elementType);
        }
        assertEquals("Element not found: " + elementText, true, element.isDisplayed());
        }

    // Dropdowns
    @And("I select {string} option from {string} dropdown")
    public void i_select_option_from_dropdown(String option, String dropdownName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        BillingAdressPage billingAdressPage = new BillingAdressPage(driver);

        switch (dropdownName) {
            case "Display per Page":
                productPage.selectDisplayPerPage(option);
                break;
            case "Sort by":
                productPage.selectSortBy(option);
                break;
            case "View as":
                productPage.selectViewAs(option);
                Thread.sleep(2000);
                break;
            case "Material":
                productPage.selectMaterialOwnJewelry(option);
                Thread.sleep(1000);
                break;
            case "Size":
                productPage.selectShoeSize(option);
                break;
            case "Country":
                try {
                    shoppingCartPage.SelectCountryDropDown(option);
                } catch (Exception e) {
                    billingAdressPage.SelectCountryFromBillingPage(option);
                }
                break;
            case "Province":
                shoppingCartPage.SelectProvinceDropDown(option);
                break;
            case "Select a billing Address" :
                billingAdressPage.SelectBillingAdress(option);
        }
            
        }

        @When("the website is closed")
        public void theWebsiteIsClosed() {
        driver.close();
        }

    }



















