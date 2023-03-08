package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.github.javafaker.Faker;

public class RegisterPage {

    private WebDriver driver;
    private Faker faker;


    @FindBy(id = "gender-male")
    private WebElement genderMaleRadioButton;

    @FindBy(id = "gender-female")
    private WebElement genderFemaleRadioButton;

    @FindBy(id = "FirstName")
    public WebElement firstNameInput;

    @FindBy(id = "LastName")
    public WebElement lastNameInput;

    @FindBy(id = "Email")
    public WebElement emailInput;

    @FindBy(id = "Password")
    public WebElement passwordInput;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPasswordInput;

    @FindBy(id = "register-button")
    public WebElement registerButton;

    @FindBy(xpath = "//h1[normalize-space()='Register']")
    public WebElement registerCompleted;

    @FindBy(className = "register-continue-button")
    public WebElement continueBtn;



    public RegisterPage(WebDriver driver) {
        super();
        this.faker = new Faker();
        PageFactory.initElements(driver,this);
    }


    public void selectMaleGender() {

        genderMaleRadioButton.click();
    }

    public void selectFemaleGender() {

        genderFemaleRadioButton.click();
    }

    public void fillingTheRegisterFields() {
        firstNameInput.sendKeys(faker.name().firstName());
        lastNameInput.sendKeys(faker.name().lastName());
        emailInput.sendKeys(faker.internet().emailAddress());
        String password = faker.internet().password();
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
    }


    public void clickRegisterButton() {

        registerButton.click();
    }

    public void ContinueBtn() {

        continueBtn.click();
    }

    public String AssertRegistration() {

        return registerCompleted.getText();
    }



}
