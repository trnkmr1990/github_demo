package Stepdefinationcom;

import org.junit.runner.RunWith;
//import org.testng.annotations.Test;



import cucumber.api.CucumberOptions;
//import cucumber.api.CucumberOptions;
//import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.*;



@RunWith(Cucumber.class)
@CucumberOptions(features={"E:\\Automation\\Mands_CucumberProject\\ src\\test\\resources"}, 
glue={"classpath:com.cucumber.CucumberProject"})

public class TestRunner {

}
