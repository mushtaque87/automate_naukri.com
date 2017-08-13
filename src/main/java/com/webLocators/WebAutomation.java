package com.webLocators;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webLocators.JobPortals;

public class WebAutomation {

	@Test(testName = "Web", description = "Test")
	public void Web() throws InterruptedException, IOException{
		System.out.println("start");
	//Mailinator mailinator = new Mailinator();
		JobPortals jobportal = new JobPortals();
	try {
		jobportal.updateNaukriProfile();
		//jobportal.updateMonsterProfile();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		jobportal.quit();
	}
	}
}
