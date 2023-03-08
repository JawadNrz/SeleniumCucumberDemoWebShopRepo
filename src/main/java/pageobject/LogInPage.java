package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

        private WebDriver driver;

        // Navigate to the LoginPage
        @FindBy(xpath = "//a[contains(text(),'Log in')]")
        private WebElement logIn;

        // Input Box Username
        @FindBy(id = "Email")
        private WebElement inputUserName;

        // Input Box Password
        @FindBy(id = "Password")
        private WebElement inputPassword;

        // Click on RememberME Checkbox
        @FindBy(id = "RememberMe")
        private WebElement rememberMeBox;

        // Click on Log IN button
        @FindBy(css = ".login-button")
        private WebElement logInBtn;

        // Assertion Login
        @FindBy(className = "account")
        private WebElement logInSuccessful;

        // Forgot Password
        @FindBy(className = "forgot-password")
        private WebElement forgotPassword;

        // Password recovery / Enter your Password
        @FindBy(id = "Email")
        private WebElement emailAdress;

        @FindBy(className = "validation-summary-errors")
        private WebElement unsuccassfulLogin;

        // Recover Button
        @FindBy(css = "input[value='Recover']")
        private WebElement recoverBtn;

        // Status Message (Email with instructions has been sent to you.)
        @FindBy(linkText = "Email with instructions has been sent to you.")
        private WebElement statusMessagePwRecovery;

        public LogInPage(WebDriver driver) {
            super();
            PageFactory.initElements(driver, this);

        }

        public void InputEmailLogin(String email ) {
                inputUserName.clear();
            inputUserName.sendKeys(email);
        }
        public void InputPasswordLogin(String password) {
                inputPassword.sendKeys(password);
        }

        public void ClickRememberCheckBox() {
            rememberMeBox.click();
        }

        public void ClickLogInBtn() {
            logInBtn.click();
        }


        public void ForgotPasswordBtn() {
            forgotPassword.click();
        }

        public void EmailAdressForRecovery(String emailadress) {
            emailAdress.sendKeys(emailadress);
        }

        public void RecoverButton() {
            recoverBtn.click();
        }

        public String StatusMessage() {
            return statusMessagePwRecovery.getText();

        }

        public String AssertLogIn1() {
            return logInSuccessful.getText();
        }

        public String UnsuccessfulLogin() {
            return unsuccassfulLogin.getText();
        }
    }


