package pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GenerelPage {

    private WebDriver driver;


    // DemoWebShop Logo on the HomePage
    @FindBy(css = "img[alt='Tricentis Demo Web Shop']")
    private WebElement homePageBtn;

    // Wishlist
    @FindBy(xpath = "//span[normalize-space()='Wishlist']")
    public WebElement wishList;

    // Shopping Cart Button on HomePage
    @FindBy(css = ".Shopping cart")
    private WebElement shoppingCart;

    // LogOut Button on the HomePage
    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement logOutBtn;

    // RegisterBtn
    @FindBy(className = "ico-register")
    public WebElement reigsterBtn;

    // My account - Customer info - Email Button on HomePage
    @FindBy(css = ".account")
    private WebElement customerInfoBtn;

    // Click on Log IN button
    @FindBy(css = ".login-button")
    public WebElement logInBtn;

    // Navigate to the LoginPage
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    public WebElement logIn;



    // Search Store / Search Box
    @FindBy(id = "small-searchterms")
    public WebElement searchStore;

    // Search Button on the HomePage
    @FindBy(css = ".search-box-button")
    private WebElement searchBtn;

    //Menu Bar
    @FindBy(css = "ul.top-menu li a")
    public List<WebElement> menuBarObjects;

    //Menu Bar
    @FindBy(css = "div.header-links ul li a")
    public List<WebElement> headerLink;

    @FindBy(xpath = "//ul[@class='top-menu']//a[normalize-space()='Jewelry']")
    public WebElement jewelryBtn;

    //@FindBy(xpath = "//ul[@class='top-menu']/li/a")
    //private WebElement menuBarObjects;


    public GenerelPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);

    }

    public void HomePageLogo() {
        homePageBtn.click();
    }

    public void SearchBtn() {
        searchBtn.click();
    }

    public void SearchStore(String name) {
        searchStore.sendKeys(name);
    }
    public void selectMenuItem(String visibleText) {
        for (WebElement item : menuBarObjects) {
            if (item.getText().equals(visibleText)) {
                item.click();
                break;
            }
        }
    }
    public void selectHeaderLink(int index) {
        headerLink.get(index).click();
    }
    public void selectHeaderLinks() {
        int menuButtonCount = headerLink.size();
        for (int i = 0; i < menuButtonCount; i++) {
            selectHeaderLink(i);
        }

    }
    public void clickHeaderLink(String linkName) {
        WebElement headerLink = driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a[text()='" + linkName + "']"));
        headerLink.click();
    }


    public void LogInClick() {
        logIn.click();
    }

    public void RegisterClick() {
        reigsterBtn.click();
    }

    public void WishlistClick() {
        wishList.click();
    }

    public void LogoutClick() {
        logOutBtn.click();
    }

    public void AccountClick() {
        customerInfoBtn.click();
    }

    public void ShoppingCartClick() {
        shoppingCart.click();
    }
    public void JewelryClick() {
        jewelryBtn.click();
    }
}



