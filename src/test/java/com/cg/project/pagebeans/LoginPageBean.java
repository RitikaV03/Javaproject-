package com.cg.project.pagebeans;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class LoginPageBean {

	@FindBy(how = How.NAME, name="login")
	private WebElement username;
	
	@FindBy(how = How.NAME,name = "password")
	private WebElement password;
	
	@FindBy(how= How.NAME, name="commit")
	private WebElement submit;
	
	@FindBy(how = How.XPATH,xpath = "/html/body/div[3]/main/div/div[2]/div/div")
	private WebElement errorMsg;
	
	public String getUsername() {
		return username.getText();
	}

	public void setUsername(String username) {
		this.username.sendKeys(username);
	}

	public String getPassword() {
		return password.getText();
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public String getErrorMsg() {
		return errorMsg.getText();
	}
	
	public void signIn() {
		submit.submit();
	}
	
}