package com.webLocators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobPortals {

	private WebDriver driver;

	public JobPortals() {
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		// driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	/////////////////////////////////////////
	
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement naukrisaveButton;
	
	@FindBy(xpath = "//*[@class='w60']")
	private WebElement naukriphonenumber;
	
	@FindBy(id = "emailTxt")
	private WebElement naukriEmailID;
	
	@FindBy(id = "pwd1")
	private WebElement naukriPassword;
	
	@FindBy(xpath = "//*[@class='logSBtn  logSBtn  ga-bind']")
	private WebElement naukriloginButton;
	
	@FindBy(xpath = "//button[@class='action-btn exp']")
	private WebElement iamexpButton;
	
	@FindBy(xpath = "//*[@class='btn btn_purple']")
	private WebElement monsterUpdateButton;
	
	@FindBy(xpath = "//*[@class='rbtn_edit pf_editaction']")
	private WebElement monstereditButton;
	
	
	@FindBy(id = "button")
	private WebElement monsterloginbutton;
	
	@FindBy(id = "username_login")
	private WebElement username_login;
	
	@FindBy(name = "passwd")
	private WebElement passwd_temp;
	
	
	//skills_action
	
	@FindBy(xpath = "//*[@value='Save']")
	private WebElement monstersaveButton;
	
	public boolean updateNaukriProfile()throws Exception {
		boolean isTrue=true;
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		driver.navigate().to("https://my.naukri.com/Profile/edit?id=&altresid");
		
		naukriEmailID.sendKeys("mushtaque87@gmail.com");
		naukriPassword.sendKeys("ahmed1987");
		Thread.sleep(1000);
		naukriloginButton.click();
		Thread.sleep(5000);
		System.out.println("Login Successfull");
		for(int i = 0 ; i < 100 ; i++ )
		{
		driver.navigate().to("https://my.naukri.com/Profile/edit?id=&altresid");
		Thread.sleep(10000);

		naukriphonenumber.clear();
		naukriphonenumber.sendKeys("9886820824");
		//naukriphonenumber.sendKeys("9886352591");
		naukrisaveButton.click();
		Thread.sleep(10000);
		
		
		System.out.println("Naukri ProfileUpdated : " + i);
		}
		return isTrue;
	}
	
	public boolean updateMonsterProfile()throws Exception {
		boolean isTrue=true;
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		driver.navigate().to("https://my.monsterindia.com/login.html?r=1501243810&src=http%3A%2F%2Fmy.monsterindia.com%2Fview_resume.html");
		Thread.sleep(5000);
		username_login.clear();
		username_login.sendKeys("mushtaque87@gmail.com");
		Thread.sleep(5000);
		passwd_temp.clear();
		passwd_temp.sendKeys("ahmed1987");
		Thread.sleep(5000);
		monsterloginbutton.click();
		Thread.sleep(10000);
		
		for(int i = 0 ; i < 100 ; i++ )
		{
		//driver.navigate().to("http://my.monsterindia.com/view_resume.html");
		//Thread.sleep(10000);
		
	
		
		monstereditButton.click();
		
		
		monstersaveButton.click();
		Thread.sleep(5000);

		System.out.println("Monster ProfileUpdated : " + i);
		}
		return isTrue;
	}
	
	public void quit() {
		driver.quit();
	}

}
