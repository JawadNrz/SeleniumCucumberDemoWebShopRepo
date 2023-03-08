package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@name='removefromcart']")
    private WebElement productCheckBox;

    @FindBy(xpath = "//a[normalize-space()='Edit']")
    private WebElement editBtn;

    @FindBy(xpath = "//input[@name='updatecart']")
    private WebElement updateShoppingCartBtn;

    @FindBy(xpath = "//input[@name='continueshopping']")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "(//input[@name='itemquantity3014555'])[1]")
    private WebElement qtyArticleNbr;

    @FindBy(id = "CountryId")
    private WebElement countryDropDown;

    @FindBy(id = "StateProvinceId")
    private WebElement stateProvinceDropDown;

    @FindBy(id = "ZipPostalCode")
    private WebElement postalCodeField;

    @FindBy(css = "input[value='Estimate shipping']")
    private WebElement estimateShippingBtn;

    @FindBy(id = "termsofservice")
    private WebElement agreeCheckBox;

    @FindBy(id = "checkout")
    private WebElement checkOutBtn;



    public ShoppingCartPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver,this);
    }


    public void ProductCheckBox() {

        productCheckBox.click();
    }

    public void EditProductBtn() {

        editBtn.click();
    }

    public void UpdateShoppingCartBtn() {

        updateShoppingCartBtn.click();
    }

    public void ContinueShoppingBtn() {

        continueShoppingBtn.click();
    }

    public void QtyArticleNbr(String number) {

        qtyArticleNbr.clear();
        qtyArticleNbr.sendKeys(number);
    }

    public void SelectProvinceDropDown(String visibleText) {
        Select selectProvinceDropDown = new Select(stateProvinceDropDown);
        selectProvinceDropDown.selectByVisibleText(visibleText);
    }

    public void SelectCountryDropDown(String visibleText) {
        Select selectCountryDropDown = new Select(countryDropDown);
        selectCountryDropDown.selectByVisibleText(visibleText);
    }

    public void PostalCodeField(String postalcode) {
        postalCodeField.sendKeys(postalcode);
    }

    public void AgreeCheckBox() {

        agreeCheckBox.click();
    }

    public void EstimateShippingBtn() {

        estimateShippingBtn.click();
    }

    public void CheckOutBtn() {

        checkOutBtn.click();
    }
}
