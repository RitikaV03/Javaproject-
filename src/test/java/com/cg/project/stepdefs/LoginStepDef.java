package com.cg.project.stepdefs;
import org.junit.Assert;
import org.openqa.selenium.By;import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.cg.project.factory.DriverFactory;
import com.cg.project.pagebeans.LoginPageBean;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Scenario;
public class LoginStepDef {

	private WebDriver driver;
	private LoginPageBean pageBean;
	
	@Before
	public void setupScenarioEnv() {
		driver = DriverFactory.getDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts.implicitlywait(20,TIMEUNIT.Seconds);
                Thread.sleep(20,TIMEUNIT.Seconds);
		pageBean = PageFactory.initElements(driver, LoginPageBean.class);
	}

	@Given("User is on GitHub login Page")
	public void user_is_on_GitHub_login_Page() {
		driver.get("https://github.com/login");
	}

	@When("user enter Invalid credential and click submit button")
	public void user_enter_Invalid_credential_and_click_submit_button() {
		pageBean.setUsername("wrong username");
		pageBean.setPassword("Wrong Password");
		pageBean.signIn();
	}
	@Then("{string} Message should display")
	public void message_should_display(String string) {
		String expectedErrorMsg = string;
		String actualErrorMeg = pageBean.getErrorMsg();
		Assert.assertEquals(expectedErrorMsg, actualErrorMeg);
	}
	
	@When("user enter valid credential and click submit button")
	public void user_enter_valid_credential_and_click_submit_button() {
		pageBean.setUsername("Correct username");
		pageBean.setPassword("Correct Password");
		pageBean.signIn();
	}

	@Then("user should successfully Sigin on his Github Account")
	public void user_should_successfully_Sigin_on_his_Github_Account() {
			Assert.fail();
	}
	@After
	public void tearDownScenarioEnv(Scenario scenario) {
		
		if(scenario.isFailed()) {
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			byte [] screenShotData = screenshot.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenShotData, "image/png" ,"");
		}
		driver.quit();
		driver=null;
	}
}
