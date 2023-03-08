import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "/Users/jawadnrz/IntelliJ/WebShopTest/WebShop/src/main/java/features",
            glue = {"stepDefinition"}

    )

    public class TestRunner {

    }


