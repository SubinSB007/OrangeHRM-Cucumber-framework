package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="", features= {"F:\\Selenium\\CucumberOrangehrmdemo\\src\\test\\resources\\features"},
glue= {"stepDefinitions"},
plugin= {"pretty","html:target/orangeReport.html"})
public class CucumberTestRunner extends AbstractTestNGCucumberTests{

}
