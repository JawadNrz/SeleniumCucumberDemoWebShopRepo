package pageobject;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;

public class BillingAdressPage{

    private WebDriver driver;
    private Faker faker;



    //here the elements of the checkout page of the area Billing address are identified
    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement firstNameInput;

    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement lastNameInput;

    @FindBy(id = "BillingNewAddress_Email")
    private WebElement emailInput;

    @FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
    public WebElement countryDropDownBilling;

    @FindBy(id = "BillingNewAddress_City")
    public WebElement cityInput;

    @FindBy(id = "BillingNewAddress_Address1")
    public WebElement adress1Input;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement postalCodeInput;

    @FindBy(id = "BillingNewAddress_FaxNumber")
    public WebElement FaxNumberInput;

    @FindBy(xpath = "//input[@onclick='Billing.save()']")
    public WebElement continueBtnBilling;

    @FindBy(id = "billing-address-select")
    public WebElement billingSelectAdress;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement phoneNumber;


    public BillingAdressPage(WebDriver driver) {
        super();
        this.faker = new Faker();
        PageFactory.initElements(driver,this);
    }

    public void fillBillingAddressForm() {
		 /* firstNameInput.sendKeys(faker.name().firstName());
		  lastNameInput.sendKeys(faker.name().lastName());
		  emailInput.sendKeys(faker.internet().emailAddress()); */

        countryDropDownBilling.sendKeys("Germany");
        cityInput.sendKeys(faker.address().city());
        adress1Input.sendKeys(faker.address().streetAddress());
        postalCodeInput.sendKeys(faker.address().zipCode());
        phoneNumber.sendKeys(faker.phoneNumber().phoneNumber());
    }

    public void BillingAdressCountinueBtn() {

        continueBtnBilling.click();
    }

    public void SelectBillingAdress(String visibleText) {

        Select selectbillingadress = new Select(billingSelectAdress);
        selectbillingadress.selectByVisibleText(visibleText);

    }

    public void SelectCountryFromBillingPage(String visibleText) {

        Select selectCountry = new Select(countryDropDownBilling);
        selectCountry.selectByVisibleText(visibleText);
    }
}
