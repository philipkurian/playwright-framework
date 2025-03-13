package bluecurrent;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
        features = "src/main/resources/features",
        tags = "@BC_DEMO",
        glue = {"nz.co.vector.bluecurrent.acceptance.steps"})
public class ITCucumber {
}
