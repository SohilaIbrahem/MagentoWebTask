package testRunner;

import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/Features", glue = {"stepDefinition"}, monochrome = true, plugin = {
        "pretty", "html:target/HtmlReports/report.html", "json:target/JsonReport/report.json",
        "junit:target/JunitReport/report.xml"}, tags = "@SmokeTest"

)
public class Runner {

}