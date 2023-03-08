package stepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BillingAdressPage;
import pageobject.PaymentMethodPage;
import pageobject.ProductPage;
import pageobject.ShippingAdressPage;
import static fixures.Utilities.driver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.xpath;


public class E2EStepdef {

    @And("I click on the {string} button on the {string} page")
    public void IClickTheButtonOnThePage(String buttonName, String pageName) throws InterruptedException {
        ShippingAdressPage shippingAdressPage = new ShippingAdressPage(driver);
        PaymentMethodPage paymentMethodPage = new PaymentMethodPage(driver);
        BillingAdressPage billingAdressPage = new BillingAdressPage(driver);


        switch (pageName) {
            case "Billing Address":
                billingAdressPage.continueBtnBilling.click();
                Thread.sleep(2000);
                break;
            case "Shipping Address":
                shippingAdressPage.continueBtnShipping.click();
                Thread.sleep(2000);
                break;
            case "Shipping Method":
                paymentMethodPage.ShippingMethodContinueBtn();
                Thread.sleep(2000);
                break;
            case "Payment Method":
                paymentMethodPage.PaymentMethodContinueBtn();
                Thread.sleep(2000);
                break;
            case "Payment Information":
                paymentMethodPage.PaymentMethodInfoContinueBtn();
                Thread.sleep(5000);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + pageName);
        }
    }

    @Then("I should see the product {string} with price {string}")
    public void i_should_see_product_details(String productName, String productPrice) {
        ProductPage productPage = new ProductPage(driver);
        productPage.assertProductDetails(productName, productPrice);
    }

    @And("I click the Add to cart button on the {string} page")
    public void IClickAddToCartButton(String pageName) {
        ProductPage productPage = new ProductPage(driver);
        productPage.ClickAddToCartBtn();
    }

    @And("I click the Confirm button")
    public void ICLickTheConfirmButton() throws InterruptedException {
        PaymentMethodPage paymentMethodPage = new PaymentMethodPage(driver);
        paymentMethodPage.confirmBtn.click();
        Thread.sleep(2000);

    }

    @Then("I should see the Message {string}")
    public void IShouldSeeTheMessage(String elementText) {

        // Find the element containing the success message
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='section order-completed']/div[@class='title']/strong"));

        // Get the text of the success message
        String actualMessage = successMessage.getText();

        // Define the expected message
        String expectedMessage = "Your order has been successfully processed!";

        // Assert that the actual message matches the expected message
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
