package com.cucumber.CucumberProject;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;



import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTesting {

	WebDriver driver;
	
	
	
	@Given("^Open CARD login page$")
	public void open_CARD_login_page() throws Throwable {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("http://172.16.18.10:8123");
		driver.manage().window().maximize();  
	}

	@When("^Submit username and password$")
	public void submit_username_and_password() throws Throwable {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='Username']")).clear();
		driver.findElement(By.xpath("//*[@id='Username']")).sendKeys("wmelendez");
		driver.findElement(By.xpath("//*[@id='Password']")).clear();
		// Enter password
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("himalaya");
		
	}

	@Then("^Gets logged in$")
	public void gets_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[contains(@value,'Login')]")).click();
	}   
	
	@Given("^Select child name$")
	public void select_child_name() throws Throwable {
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='txtSearchChild']")).sendKeys("child t2");
		Thread.sleep(5000);
		//Explict wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shared-learner-block']/div/div/div/div[2]/h4[1]")));
		boolean status = element.isDisplayed();
		 // if else condition
		if (status) {
			System.out.println("===== WebDriver is visible======");
			String name = driver.findElement(By.xpath("//*[@id='shared-learner-block']/div/div/div/div[2]/h4[1]")).getText();
			
			if (name.contains("Child"))
			{
				driver.findElement(By.xpath("//div[contains(@class,'col-xs-12 padding-zero m-b m-t')]")).click();
			}
		} else {
			System.out.println("===== WebDriver is not visible======");
		}
		
	}

	@When("^Curriculum Language$")
	public void curriculum_Language() throws Throwable {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(@data-tour-title,'Treatment Plan')]")).click();
		
	}

	@When("^Lesson Manding Fluency$")
	public void lesson_Manding_Fluency() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String lesson=driver.findElement(By.xpath("//a[contains(@onclick,'lesson.openLesson(5, 503,1)')]")).getText();
	    if (lesson.contains("Manding"))
	    	{
	    	driver.findElement(By.xpath("//a[contains(@onclick,'lesson.openLesson(5, 503,1)')]")).click();	
	    	}
	    driver.findElement(By.xpath("//a[contains(@onclick,'setTpIdsession(1918917)')]")).click();
	    driver.findElement(By.xpath("//a[@onclick='GetExemplar();']")).click();
	  
	 }

	@Then("^Mands buttons should visible\\.$")
	public void mands_buttons_should_visible() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(By.xpath("//*[@class='exemplarTR e1588728']/td/div/a[3]")).click();
	   driver.findElement(By.xpath("//*[@id='c_1091']//tr[9]/td/a[4]")).click();
	   //handle alert
	  String s1=driver.findElement(By.xpath("//*[@class='modal-title']")).getText();
	  System.out.print(s1);
	  
	   driver.findElement(By.xpath("//*[@id='txtMandsGoal']")).clear();
	   driver.findElement(By.xpath("//*[@id='txtMandsGoal']")).sendKeys("10");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//button[text()='Submit'][2]")).click();
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("//*[@class='exemplarTR e1588728']/td/div/a[3]")).click();
	}
	
		   
	}

