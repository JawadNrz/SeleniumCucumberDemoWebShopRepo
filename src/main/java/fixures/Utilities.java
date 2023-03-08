package fixures;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;


public class Utilities {

    public static WebDriver driver;



    public Utilities(WebDriver driver) {
        this.driver = driver;

    }

    public static String generateRandomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static void openUrl(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void clickOnCheckBox(String checkBoxName) {
        WebElement checkBox = driver.findElement(By.xpath("//input[@name='" + checkBoxName + "']"));
        if(!checkBox.isSelected()){
            checkBox.click();
        }
    }


}






