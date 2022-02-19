package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
  
	//data driven (framework)+ page object model is pattern or approach - framework
	
	WebDriver driver;
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();

  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  lp.openBrowser();
	  lp.openLoginPage();
  }

  @AfterMethod
  public void afterMethod() {
	 lp.closeBrowser();
  }
  
  @Test (priority=1)
  public void loginWithWrongEmailPasswordTest() throws InterruptedException {
	  //enter wrong email
	  //wrong password
	  // click on login button
	  lp.login(df.wrongEmail, df.wrongPassword);
	  Assert.assertEquals(df.globalErr, lp.readGlobalErr());
	  
  }
  
 @Test (priority=2)
  public void loginWithEmptyEmailTest() throws InterruptedException {
	  //wrong password
	  // click on login button
      lp.login("", df.wrongPassword);  
	  Assert.assertEquals(df.emptyEmailErr, lp.readErr());
	  
  }

  @Test (priority=3)
  public void loginWithEmptyPasswordTest() throws InterruptedException {
	  //enter wrong email
	  // click on login button
	  lp.login(df.wrongEmail, "");
	  Assert.assertEquals(df.emptyPasswordErr, lp.readErr() );
	  
  }
  
  @Test (priority=4)
  public void loginWithSpecialCharEmailTest() throws InterruptedException {
	  //enter wrong email with special char
	  //wrong password
	  // click on login button
	  lp.login(df.emailWithSpecialChar, df.wrongPassword);
	  Assert.assertEquals(df.emailWithSpecCharErr, lp.readErr());
	  
  }
  
}
