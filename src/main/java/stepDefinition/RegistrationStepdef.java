package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.RegisterPage;
import java.time.Duration;
import static fixures.Utilities.driver;

@RunWith(Cucumber.class)
public class RegistrationStepdef {

    @When("I fill in all the required fields with valid user details")
    public void iFillAllTheRegistrationFields() {

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.selectMaleGender();
        registerPage.fillingTheRegisterFields();
    }

    @And("I select the {string} radio button")
    public void iSelectTheRadioButton(String radioButtonLabel) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement radioButton = driver.findElement(By.xpath("//label[normalize-space()='" + radioButtonLabel + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(radioButton));
        radioButton.click();
    }
}
