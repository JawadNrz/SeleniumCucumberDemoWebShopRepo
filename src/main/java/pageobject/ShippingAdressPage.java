package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAdressPage{
    private WebDriver driver;

    // PickUpStore CheckBox
    @FindBy(id = "PickUpInStore")
    public WebElement PickUpInStoreCheckBox;
    // Shipping Continue Button
    @FindBy(xpath = "//input[@onclick='Shipping.save()']")
    public WebElement continueBtnShipping;


    public ShippingAdressPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver,this);
    }

    public void ShippingContinueBtn() {

        continueBtnShipping.click();
    }

}
