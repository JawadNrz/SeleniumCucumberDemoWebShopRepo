package pageobject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductReviewsPage{

    private WebDriver driver;


    @FindBy(id = "AddProductReview_Title")
    private WebElement reviewTittle;

    @FindBy(id = "AddProductReview_ReviewText")
    private WebElement reviewText;

    @FindBy(xpath = "//input[@type='radio']")
    public List<WebElement> ratingRadioBtns;

    @FindBy(xpath = "//input[@name='add-review']")
    private WebElement submitReviewBtn;

    @FindBy(css = "div[class='product-review-list'] div[class='title'] strong")
    private WebElement ratingSuccessful;

    public ProductReviewsPage(WebDriver driver) {

        super();
        PageFactory.initElements(driver, this);
    }

    public void ReviewTittleInput(String reviewtittle) {

        reviewTittle.sendKeys(reviewtittle);
    }

    public void ReviewTextInput(String reviewtext) {

        reviewText.sendKeys(reviewtext);
    }

    public void SubmitReviewBtn( ) {
        submitReviewBtn.click();
    }

    public void selectRatingRadioOption(int index) {
        ratingRadioBtns.get(index).click();
    }

    public void selectAllRadioOptions() {
        int radioButtonCount = ratingRadioBtns.size();
        for (int i = 0; i < radioButtonCount; i++) {
            selectRatingRadioOption(i);
        }
    }

    public String AssertRating() {
        return ratingSuccessful.getText();
    }


}
