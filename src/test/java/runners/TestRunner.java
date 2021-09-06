package runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources",
		glue = {"stepDefinitions"},
		monochrome = true,
		strict = true,
		plugin={"pretty", "html:target/cucumber-reports"}
		//,tags= {"@NegativeFlows"}
		)
public class TestRunner {

}
