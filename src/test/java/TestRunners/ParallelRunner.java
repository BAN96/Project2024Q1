package TestRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/AppFeatures"},
		glue= {"StepDefinations","AppHooks"},
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:test-output/CucumberReporting/cucumber.html"
		}
		
		)
public class ParallelRunner extends AbstractTestNGCucumberTests{

	@DataProvider(parallel=true)
    public Object[][] scenarios() {
        return super.scenarios();
    } 
}
