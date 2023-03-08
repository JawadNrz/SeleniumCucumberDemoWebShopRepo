package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodPage {
    private WebDriver driver;

    // Shipping RadioButtons
    // Shipping time button Ground
    @FindBy(id = "shippingoption_0")
    private WebElement shippingOptionGround;
    // Shipping time button NextDay
    @FindBy(id = "shippingoption_1")
    private WebElement shippingOptionNextDay;
    // Shipping time button 2Day
    @FindBy(id = "shippingoption_2")
    private WebElement shippingOption2ndDay;
    // Continue Button ShippingMethodePage
    @FindBy(className = "shipping-method-next-step-button")
    private WebElement shippingMethodContinueBtn;
    // Payment method "Cash"
    @FindBy(id = "paymentmethod_0")
    private WebElement paymentMethodCash;
    // Continue Button PaymentMthod Continue Button
    @FindBy(className = "payment-method-next-step-button")
    private WebElement paymentMethodContinueBtn;
    // Continue Button PaymentInfo Continue Button
    @FindBy(className = "payment-info-next-step-button")
    private WebElement paymentMethodInfoContinueBtn;
    // Confirm Button
    @FindBy(className = "confirm-order-next-step-button")
    public WebElement confirmBtn;
    // Order Completed Button
    @FindBy(className = "order-completed-continue-button")
    private WebElement completedBtn;



    public PaymentMethodPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver,this);
    }


    public void ShippingOptionGround() {

        shippingOptionGround.click();
    }

    public void ShippingOptionNextDay() {

        shippingOptionNextDay.click();
    }

    public void ShippingOption2ndDay() {

        shippingOption2ndDay.click();
    }

    public void ShippingMethodContinueBtn() {

        shippingMethodContinueBtn.click();
    }

    public void PaymentMethodCash() {

        paymentMethodCash.click();
    }

    public void PaymentMethodContinueBtn() {

        paymentMethodContinueBtn.click();
    }

    public void PaymentMethodInfoContinueBtn() {

        paymentMethodInfoContinueBtn.click();
    }

    public void ConfirmBtn() {

        confirmBtn.click();
    }

    public void CompletedBtn() {

        completedBtn.click();
    }
}
