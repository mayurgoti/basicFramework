package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
 
	WebDriver driver;
	
	/*
	  public WebElement emailAdd = driver.findElement(By.id("usernameInput-input")); 
	  public WebElement password = driver.findElement(By.id("password-input"));
	  public WebElement signIn = driver.findElement(By.id("signIn")); 
	  public WebElement globalErr = driver.findElement(By.id("globalError")); 
	  public WebElement generalErr = driver.findElement(By.className("Error__text"));  
	 */
	 
	
	@FindBy(id = "usernameInput-input")
    public WebElement emailAdd;
	
	@FindBy(name = "password")
    public WebElement password;
	
	@FindBy(id = "signIn")
    public WebElement signIn;
	
	@FindBy(id = "globalError")
    public WebElement globalErr;
	
	@FindBy(className = "Error__text")
    public WebElement generalErr;
	
	
	public void openBrowser() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Selenium_WorkSpace\\BasicframeWork\\src\\data\\BrowserData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			driver = new SafariDriver();
		}
		PageFactory.initElements(driver, this);
		
	}
	
	public void openLoginPage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=Q-grOdRO03c&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiUS1nck9kUk8wM2MiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTYzOTMyODMxOCwiaWF0IjoxNjM5MzI3MTE4LCJqdGkiOiI1ZGRkNWNlOC1mZmMzLTQzY2ItYmM5NC0xYzNlNzUwYWZhZjkiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.At2Cmu7pFegCPq26F8iYyY8yCwYlnWbGC0jh3i1nAE1UyJ7jN6vg_YCBkrUD-4_9RF8XXTEqN-0xo1dGRMJMoL1Gpwe-9TQ7LA2Aab_unJGnPXb1eiIV2W1aefung7WY9p5il_0doiDNSuPTAEi_hD7iCrgLzpwkwkpR05nvoiCDldpfEijfuNzDBmN6NHZU0rYaBxCohkliRTaC6qC0XmxWY3b8aqS2Hlvqfgw62Bc3_m7h4RREqhE6GCIETjlHtVif6Wi05W8aYd4wcr6urBZH2Y4Z91i7oHmmrqgSA4eAvk75nXGwnfYJ3rD1ZGvi7Tw1ssz4BDyc3Z0kswJw3A&preferred_environment=");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void login(String email, String pass) throws InterruptedException {
		emailAdd.sendKeys(email);
	    password.sendKeys(pass);
	    signIn.click();
	    Thread.sleep(1000);
	}
	
	public  String readGlobalErr() {
		String actualErr = globalErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readErr() {
		String actualErr = generalErr.getText();
		System.out.println(actualErr);
		return actualErr;	
	}
	
	
}
