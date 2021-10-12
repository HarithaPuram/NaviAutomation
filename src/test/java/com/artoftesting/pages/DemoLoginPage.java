package com.artoftesting.pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class DemoLoginPage {

	WebDriver driver;
	
	private static final Logger log = LogManager.getLogger(DemoLoginPage.class);
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(xpath="//*[contains(@id,'password')]")
	WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	WebElement loginButton;
	
	@FindBy(xpath="//label[normalize-space()='Login with Phone/Email']")
	WebElement loginCreateAccount;
	
	@FindBy(xpath="//span[contains(text(),'Continue')]")
	WebElement clickContinue;
	
	@FindBy(xpath="//span[text()='Hotels'][1]")
	WebElement clickOnHotel;
	
	@FindBy(xpath="//span[text()='City / Hotel / Area / Building']")
	WebElement clickCity;
	
	@FindBy(xpath="//input[@placeholder='Enter city/ Hotel/ Area/ Building']")
	WebElement enterCity;
	
	@FindBy(xpath="//p[text()='Mysore, Karnataka, India']")
	WebElement selectCity;
	
	
	/*
	 * @FindBy(xpath="//input[@placeholder='From']") WebElement enterCity;
	 * 
	 * @FindBy(xpath="//p[text()='Mysore, India']") WebElement selectCity;
	 */
	@FindBy(xpath="//span[@data-cy='selectCheckInDate']")
	WebElement clickOnDatePicker;
	@FindBy(xpath="//div[@class='DayPicker-Day' and text()='14'][1]")
	WebElement selectCheckInDate;
	@FindBy(xpath="//div[@class='DayPicker-Day' and text()='17']")
	WebElement selectCheckOutDate;
	@FindBy(xpath="//input[@id='guest']")
	WebElement clickOnGuest;
	
	
	@FindBy(xpath="//li[@data-cy='adults-2']")
	WebElement clickOnNumberOfAdults;
	@FindBy(xpath="//li[@data-cy='children-1']")
	WebElement clickOnNumberOfChildern;
	@FindBy(className="ageSelectBox")
	WebElement selectChildAge;
	@FindBy(xpath="//button[@class='primaryBtn btnApply']")
	WebElement clickApplyButton;
	@FindBy(xpath="//button[@id='hsw_search_button']")
	WebElement clickonSearch;
	
	@FindBy(xpath="//div[@class='input-range__slider']")
	WebElement costFilter;
	
	@FindBy(xpath="//div[@class='flexOne makeFlex']")
	WebElement flexOne;
	
	@FindBy(xpath="//a[contains(text(),'Hotels In Mysore')]")
	WebElement childPage;
	
	@FindBy(xpath="(//li)[14]")
	WebElement getHotelName;
	
	
	
	
	public DemoLoginPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	
	public void setUsername(String uname) {
		username.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void LoginCreateAccount() {
		loginCreateAccount.click();
	}
	
	public void clickContinueButton() {
		clickContinue.click();
	}
	
	public void clickonHotels() throws InterruptedException {
		WebElement clickHotels=driver.findElement(By.xpath("//span[text()='Hotels']"));
		 JavascriptExecutor js = (JavascriptExecutor)driver;	
		 js.executeScript("arguments[0].click();", clickHotels);
	//	 clickOnHotel.click();
		
		Thread.sleep(2000);
	}
	public void clickOnCity() {
		clickCity.click();
	}
	
	public void enterCity() {
		enterCity.sendKeys("Mysore");
	}
	public void selectCity() {
		selectCity.click();
	}
	public void clickOnDatePicker() {
		 JavascriptExecutor js = (JavascriptExecutor)driver;	
		 js.executeScript("arguments[0].click();", clickOnDatePicker);
		
	}
	public void selectCheckInDate() {
		 JavascriptExecutor js = (JavascriptExecutor)driver;	
		 js.executeScript("arguments[0].click();", selectCheckInDate);
		
	}
	public void selectCheckOutDate() {
		 JavascriptExecutor js = (JavascriptExecutor)driver;	
		 js.executeScript("arguments[0].click();", selectCheckOutDate);

	}
	public void clickOnGuest() {
		clickOnGuest.click();
	}
	public void clickOnNumberOfAdults() {
		clickOnNumberOfAdults.click();
	}
	public void clickOnNumberOfChildern() {
		clickOnNumberOfChildern.click();
	}
	public void selectChildAge() {
		selectChildAge.click();
		Select select=new Select(selectChildAge);
		select.selectByIndex(11);
			
	}
	public void clickApplyButton() {
		clickApplyButton.click();
	}
	public void clickonSearch() {
		clickonSearch.click();
		
	}
	
	
	public void slider() {

		Actions move = new Actions(driver);
	//	move.dragAndDropBy(costFilter, 30, 0).build().perform();
	//	move.dragAndDropBy(costFilter, 10, 20).build().perform();
		move.dragAndDropBy(costFilter, 30, 10).build().perform();
		
	}
	
	public void flexOne() {
		flexOne.click();
		
	}
	
	public void childPage() {
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		// Here we will check if child window has other child windows and will fetch the heading of the child window
		while (iterator.hasNext()) {
		    String ChildWindow = iterator.next();
		        if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
		        driver.switchTo().window(ChildWindow);
		    
		        System.out.println("Heading of child window is " + childPage.getText());
		     //   driver.close();
		       
		    }
		}
	//	driver.switchTo().window(mainWindowHandle);
		
		
	}
	public void getHotelName() {
		getHotelName.getText();
		log.info("HOtel Name"+getHotelName.getText());
		
	}
	/*
	 * public void mainwindowhandle() { String mainWindowHandle =
	 * driver.getWindowHandle(); Set<String> allWindowHandles =
	 * driver.getWindowHandles(); Iterator<String> iterator =
	 * allWindowHandles.iterator(); while (iterator.hasNext()) { String ChildWindow
	 * = iterator.next(); if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	 * driver.switchTo().window(ChildWindow); // WebElement text =
	 * driver.findElement(By.xpath("//a[contains(text(),'Hotels In Bengaluru')]"));
	 * System.out.println("Heading of child window is " +
	 * mainwindowhandle.getText()); driver.close();
	 * 
	 * } } driver.switchTo().window(mainWindowHandle);
	 * 
	 * }
	 */
	

	 
	

	
	public DemoInventoryPage login(String username, String password) throws InterruptedException {
		log.info("Logging with username - " + username + "  and password - " + password);
		LoginCreateAccount();
		setUsername(username);
		clickContinueButton();
		setPassword(password);
		Thread.sleep(3000);
		clickLoginButton();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(5000);
			
		clickonHotels();
		 Thread.sleep(2000);
		clickOnCity();
		enterCity();
		selectCity();
		clickOnDatePicker();
		selectCheckInDate();
		 Thread.sleep(2000);
		 selectCheckOutDate();
		 Thread.sleep(2000);
		 clickonSearch();
		 Thread.sleep(2000);
		 slider();
		 Thread.sleep(3000);
		 flexOne();
		 Thread.sleep(2000);
		 childPage();
		 Thread.sleep(3000);
		 getHotelName();
		return new DemoInventoryPage(driver);
	}
	
	/*
	 * public SauceDemoInventoryPage bookHotel() throws Exception {
	 * Thread.sleep(2000); clickonHotels(); Thread.sleep(2000); clickOnCity();
	 * enterCity(); selectCity(); clickOnDatePicker(); selectCheckInDate();
	 * Thread.sleep(2000); selectCheckOutDate(); Thread.sleep(2000); clickOnGuest();
	 * clickOnNumberOfAdults(); clickOnNumberOfChildern(); Thread.sleep(2000);
	 * selectChildAge(); clickApplyButton(); clickonSearch(); Thread.sleep(2000);
	 * 
	 * 
	 * return new SauceDemoInventoryPage(driver); }
	 */
	
	public String getTitle() {
		return driver.getTitle();
	}
	
}
