package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) 
@CucumberOptions(

        features= {".//Features//"},
        glue={"stepsDefinition1","stepsDefinition2"}, 
        		 tags = "@module1 or @module2",
        plugin= {  		
        		
        		"pretty", "html:reports/myreport.html", 
        		"json:reports/myreport.json"
        		}    //To capture failures
          	
      )


public class TestRunner 
{
	
}

