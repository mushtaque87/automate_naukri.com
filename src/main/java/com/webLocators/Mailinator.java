package com.webLocators;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public class Mailinator {

	private WebDriver driver;

	public Mailinator() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "inboxfield")
	private WebElement emailTextBox;

	@FindBy(xpath = "//button[@class='btn btn-dark']")
	private WebElement goButton;

	@FindBy(css = "#mailcontainer li a")
	private WebElement emailLink;

	@FindBy(name = "rendermail")
	private WebElement emailFrame;

	@FindBy(partialLinkText = "Verify and activate")
	private WebElement actionLink;
	
	@FindBy(partialLinkText = "Reset my password")
	private WebElement actionLinkForResetPassword;

	@FindBy(id = "capture_resetPassword_newPassword")
	private WebElement newPasswordTextBox;

	@FindBy(id = "capture_resetPassword_newPasswordConfirm")
	private WebElement newPasswordConfirmTextBox;

	//@FindBy(id = "capture_resetPassword_capture_submit")
	@FindBy(id = "capture_resetPassword_submitButton")
	private WebElement submitButton;
	
	@FindBy(xpath=".//*[@id='resetPasswordSuccess']/div[2]/a")
    private WebElement donebutton;
	
	@FindBy(id = "resetPasswordSuccess")
	private WebElement resetPasswordSuccess;

	@FindBy(xpath = ".//*[@id='verifyEmailSuccess']/div/h1")
	private WebElement verifyText;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div/div/div[1]/div[2]/div[1]/div/div[5]/ul/li/a/div[1]")
	private WebElement verifyEmailFromLink;
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div/div/div[1]/div[2]/div[1]/div/div[5]/ul/li/a/div[2]")
	private WebElement verifyEmailSubjectLink;

//	@FindBy(xpath="//*[@type='submit']")
	

	
	@FindBy(xpath = "//font/a[@class='copymobile']/font")
	private WebElement verifyEmailCopy;
	
	
	@FindBy(xpath = "//font/a[@class='copymobiletitle']/font")
	private WebElement verifyEmailTitle;
	
	@FindBy(name = "button")
	private WebElement acceptZScalarSecurity;

	/////////////////////////////////////////
	
	

	@FindBy(id = "Sug_keywords")
	private WebElement naukriSug_keywords;
	
	@FindBy(id = "name")
	private WebElement naukriname;
	
	
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
	//skills_action
	
	@FindBy(xpath = "//*[@value='Save']")
	private WebElement monstersaveButton;
	
	
	
	
	//skills_action
	
	
	

	//public void checkInbox(String emailId)throws Exception {

	public boolean VerifyEmailSubject()
	{
	   if(verifyEmailFromLink.getText().contains("Philips") && verifyEmailSubjectLink.getText().contains("Philips email verification"))
	   {
		   System.out.println("Email Subject verified");
		   return true;
	   }
	   else
	   {
		   return false;
	   }
	}
	
	
	public boolean VerifyEmailTitleVerification(String FirstName , String LastName)
	{
	   if(verifyEmailTitle.getText().contains(FirstName) && verifyEmailTitle.getText().contains(LastName))
	   {
		   System.out.println("Title verified");
		   return true;
	   }
	   else
	   {
		   return false;
	   }
	   
	}
	
	public boolean VerifyEmailContentVerification(String content)
	{
	   if(verifyEmailCopy.getText().contains(content))
	   {
		   System.out.println("Verified email content");
		   return true;
	   }
	   else
	   {
		   return false;
	   }
	   
	}
	
	public void OpenEmailAddressInMailinator(String emailId)throws Exception {
		boolean isTrue=true;
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.mailinator.com");
		Thread.sleep(10000);

		emailTextBox.sendKeys(emailId);
		goButton.click();
		Thread.sleep(10000);
	}
	
	
	public void OpenEmail() throws InterruptedException
	{	
	emailLink.click();
	Thread.sleep(8000);
	}
	
	
	public void ClickEmailAndActivateAccount() throws InterruptedException
	{
	driver.switchTo().frame(emailFrame);
	Thread.sleep(2000);
	actionLink.click();
	Thread.sleep(9000);
	}
	
	
	public boolean checkInbox(String emailId)throws Exception {
		boolean isTrue=true;
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.mailinator.com");
		Thread.sleep(10000);

		emailTextBox.sendKeys(emailId);
		goButton.click();
		Thread.sleep(10000);
		
		emailLink.click();
		Thread.sleep(8000);

		driver.switchTo().frame(emailFrame);
		Thread.sleep(2000);
		actionLink.click();
		Thread.sleep(9000);
		
		return isTrue;
	}
	
	
	
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
		
		naukriphonenumber.clear();
		naukriname.sendKeys("Mushtaque Ahmed");
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
		for(int i = 0 ; i < 100 ; i++ )
		{
		driver.navigate().to("http://my.monsterindia.com/view_resume.html");
		Thread.sleep(10000);

		
		monstereditButton.click();
		Thread.sleep(10000);
		
		monstersaveButton.click();
		System.out.println("Monster ProfileUpdated : " + i);
		}
		return isTrue;
	}

	public boolean checkInboxForResetPassword(String emailId)throws Exception {
		boolean isTrue=true;
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.mailinator.com");
		Thread.sleep(10000);

		emailTextBox.sendKeys(emailId);
		goButton.click();
		Thread.sleep(10000);
		
		emailLink.click();
		Thread.sleep(8000);

		driver.switchTo().frame(emailFrame);
		Thread.sleep(2000);
		actionLinkForResetPassword.click();
		Thread.sleep(9000);
		
		return isTrue;
	}

	
	public void quit() {
		driver.quit();
	}

	
	public void verifyEmail() throws Exception {
		String verificationText = "Thank you for verifying your email address"; //Need to put Verification Success Message as it is.
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		if(isElementPresent(verifyText)){
			if((verifyText.getText()).equals(verificationText)){
				CustomReporter.log("Email Verification Successfull.");
			} else CustomReporter.errorLog("Email Verification Text Not matched. We have recieved message "+verifyText.getText());
		} else CustomReporter.errorLog("verifyText element is not present.");

	}
	
	
	public void changePassword(String newPassword) throws InterruptedException{
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
//		if(isElementPresent(acceptZScalarSecurity)){
//			acceptZScalarSecurity.click();
//			CustomReporter.log("Zscalar Security Check passed.");
//		}

		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(newPasswordTextBox));
		newPasswordTextBox.click();
		newPasswordTextBox.clear();
		newPasswordTextBox.sendKeys(newPassword);

		wait.until(ExpectedConditions.visibilityOf(newPasswordConfirmTextBox));
		newPasswordConfirmTextBox.click();
		newPasswordConfirmTextBox.clear();
		newPasswordConfirmTextBox.sendKeys(newPassword);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		submitButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(resetPasswordSuccess));
		donebutton.click();
		CustomReporter.log("Password Reset Successfully", true);
	}


	private boolean isElementPresent(WebElement element) {
		try {
			WebDriverWait wait;
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
