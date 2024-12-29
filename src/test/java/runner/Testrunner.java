
package runner;



import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",plugin = {"pretty","json:target/cucumber-report/cucumber.json","html:target/cucumber-report/cucumber1.html"},glue={"stepdefinition","base"},tags="@SMOKE")
public class Testrunner {
	
	
	    
	
	

}