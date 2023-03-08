package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class ProductPage{

    private WebDriver driver;

    // We can use this options for every Class on our Projects
    // ViewAs DropDown For All Products
    @FindBy(id = "products-viewmode")
    private WebElement viewAs;
    // OrderBy DropDown for All Products
    @FindBy(id = "products-orderby")
    private WebElement sortBy;
    // PageSize DropDown for All Products
    @FindBy(id = "products-pagesize")
    private WebElement displayPerPage;

    @FindBy(id = "product_attribute_28_7_10" )
    private WebElement shoeSize;

    // from here on everything belongs to a certain product
    // ProductName: Create Your Own Jewelry
    @FindBy(xpath = "//div[@class='product-item']//img[@title='Show details for Create Your Own Jewelry']")
    private WebElement createYourJewelryProduct;

    // Material DropDown on Create Your Own Jewelry Page
    @FindBy(id = "product_attribute_71_9_15")
    private WebElement materialDropDown;

    @FindBy(xpath = "//input[@id='product_attribute_71_10_16']")
    private WebElement lengthInCmField;

    // Pendant RadioButtons
    @FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> radioButtons;

    //
    @FindBy(id = "addtocart_71_EnteredQuantity")
    private WebElement qtyNumberJewelry;

    @FindBy(id = "add-to-wishlist-button-71")
    private WebElement addToWishlistBtn;

    // Add your review Button
    @FindBy(xpath = "//a[normalize-space()='Add your review']")
    private WebElement addYourReviewBtn;

    // Add to Cart Button
    @FindBy(className = "add-to-cart-button")
    private WebElement addToCartBtn;
    // up to here



    public ProductPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }


    public void selectSortBy(String visibleText) {

        Select sortBySelect = new Select(sortBy);
        sortBySelect.selectByVisibleText(visibleText);
    }

    public void selectDisplayPerPage(String visibleText) {

        Select displayPerPageSelect = new Select(displayPerPage);
        displayPerPageSelect.selectByVisibleText(visibleText);
    }

    public void selectShoeSize(String visibleText) {

        Select displayPerPageSelect = new Select(shoeSize);
        displayPerPageSelect.selectByVisibleText(visibleText);
    }

    public void selectViewAs(String visibleText) {

        Select viewAsSelect = new Select(viewAs);
        viewAsSelect.selectByVisibleText(visibleText);
    }

    public void CreateYourOwnJewelryProduct() {

        createYourJewelryProduct.click();
    }

    public void selectMaterialOwnJewelry(String visibleText) {

        Select materialSelect = new Select(materialDropDown);
        materialSelect.selectByVisibleText(visibleText);
    }

    public void LenghtInCmField(String cm) {

        lengthInCmField.sendKeys(cm);
    }

    public void selectRadioOption(int index){
        radioButtons.get(index).click();
    }

    public void selectAllRadioOptions() {
        int radioButtonCount = radioButtons.size();
        for (int i = 0; i < radioButtonCount; i++) {
            selectRadioOption(i);
        }
    }

    public void SelectQtyField(String number) {

        qtyNumberJewelry.clear();
        qtyNumberJewelry.sendKeys(number);
    }

    public void ClickOnAddToWishListBtn() {

        addToWishlistBtn.click();

    }

    public void ClickOnAddYourReview() {

        addYourReviewBtn.click();
    }

    public void ClickAddToCartBtn() {

        addToCartBtn.click();

    }
    public void assertProductDetails(String productName, String productPrice) {
        String actualProductName = driver.findElement(By.xpath("//div[@class='order-summary-content']/div[@class='product-name']/a"))
                .getText().trim();
        String actualProductPrice = driver.findElement(By.xpath("//div[@class='order-summary-content']/div[@class='product-unit-price']/span"))
                .getText().trim();


        // Assertions
        assertEquals(productName, actualProductName, "Product name is incorrect");
        assertEquals(productPrice, actualProductPrice, "Product price is incorrect");
    }
}
