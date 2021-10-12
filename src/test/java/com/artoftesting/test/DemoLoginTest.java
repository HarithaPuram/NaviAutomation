package com.artoftesting.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.artoftesting.base.TestBase;
import com.artoftesting.pages.DemoInventoryPage;
import com.artoftesting.pages.DemoLoginPage;
//import com.artoftesting.pages.SauceDemoInventoryPage;
import com.artoftesting.pages.DemoLoginPage;
import com.artoftesting.util.ExcelUtil;

public class DemoLoginTest extends TestBase {

	//DemoLoginPage loginPage;
	DemoLoginPage bookHotel;

	// Log4j configuration
	private static final Logger log = LogManager.getLogger(DemoLoginTest.class);
	//private static final WebDriver WebDriver = null;

	@Test(priority = 1)
	public void loginTest() throws Exception {

		log.info("Verifying successful login.");

		bookHotel = new DemoLoginPage(driver);

		// Should fetch the username and password from external test data files
		DemoInventoryPage inventoryPage = bookHotel.login("testervedantu@gmail.com", "Tester12!@");

	}

	/*
	 * @Test(priority=2) public void bookHotelTest() throws Exception{
	 * 
	 * log.info("Booking Hotel"); bookHotel = new SauceDemoLoginPage(driver);
	 * bookHotel.bookHotel(); }
	 */
	 
	/*
	 * @DataProvider(name = "tempTestData") public Object[][] tempTestData() throws
	 * Exception {
	 * 
	 * String[][] testData =
	 * ExcelUtil.getExcelDataIn2DArray("testData//loginTestData.xlsx",
	 * "loginSheet"); return testData; }
	 * 
	 * //Test to demo data provider functionality
	 * 
	 * @Test(dataProvider = "tempTestData") public void tempTest(String userId,
	 * String pwd) { System.out.println(userId + " - " + pwd); }
	 */

}
