import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"stepDefinitions"}, //mendefinisikan step definition nya itu sebelah mana
        plugin = {"pretty"},
        tags = "@Positive"
)
public class runnerDetail {
}
