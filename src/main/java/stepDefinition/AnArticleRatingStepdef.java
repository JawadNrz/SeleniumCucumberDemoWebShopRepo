package stepDefinition;

import io.cucumber.java.en.And;
import pageobject.ProductReviewsPage;
import static fixures.Utilities.driver;

public class AnArticleRatingStepdef {

    @And("I click {int} stars as rating")
    public void RatingRadioButton (int rating) {
        ProductReviewsPage productReviewsPage = new ProductReviewsPage(driver);

        switch (rating) {
            case 1 :
                productReviewsPage.selectRatingRadioOption(0);
                break;
            case 2 :
                productReviewsPage.selectRatingRadioOption(1);
                break;
            case 3 :
                productReviewsPage.selectRatingRadioOption(2);
                break;
            case 4 :
                productReviewsPage.selectRatingRadioOption(3);
                break;
            case 5 :
                productReviewsPage.selectRatingRadioOption(4);
                break;
            default:
                throw new IllegalStateException("Unexpected index: " + rating);
        }
        }


    }

