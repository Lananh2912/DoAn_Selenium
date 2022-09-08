package Runner;

import java.sql.Driver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//@RunWith(Cucumber.class);
@RunWith(Cucumber.class)
@CucumberOptions(
   //path of feature file
   features = "src/test/resources",
   //path of step definition file
		   glue={"helpers","classpath/stepDefinitions", "classpath/stepDefinitions.LogIn","classpath/stepDefinitions.Publish"},
 //  glue = "stepDefinitions",
   plugin = {"pretty",
		   "html:target/cucumber",
		   "json:target/cucumber.json,",
		   "com.cucumber.listener.extentcucumberformatter:target/report.html"})
public class Mainrunner {
	@AfterClass
    public static void  closeBrowser(){
       
    }
}
