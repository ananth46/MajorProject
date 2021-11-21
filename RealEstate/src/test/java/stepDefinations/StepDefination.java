package stepDefinations;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Resources.Base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SigninPage;
import pageObjects.media;


public class StepDefination extends Base {

	public WebDriver driver;

	//Initializing the browser with chrome
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();

	}

	//Navigating to link 
	@And("^Navigate to  \"([^\"]*)\" site$")
	public void navigate_to_something_site(String url) throws Throwable {
		//getting url
		driver.get(url); 
		//Scrolling down Page with the help of java script executor by importing required files
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");


	}
	//method for clicking on Login link in home page to land on Secure sign in Page
	@And("^Click on Login link in home page to land on Secure sign in Page$")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
		//creating object for SiginPage class
		SigninPage l= new SigninPage(driver);
		//using object,calling method from SigninPage and clicking on Login button
		l.getLoginbtn().click();



	}
	//creating method for entering valid credentials
	@When("^I entered valid (.+) and valid (.+) logs in$")
	public void i_entered_valid_and_valid_logs_in(String username, String password) throws Throwable {
		//creating object for SiginPage class
		SigninPage lp=new SigninPage(driver);
		//using object,calling method from SigninPage and sending the required credentials
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		//now clicking on SignIn button
		lp.getSignin().click();
	}


	@Then("^Click on signin button$")
	public void click_on_signin_button() throws Throwable {
		//creating object for SiginPage class
		SigninPage lp=new SigninPage(driver);
		//now clicking on SignIn button
		lp.getSignin().click();
		System.out.println("Signin click successfull");

	}
	//Media Section
	@Given("^click on mediasectionA$")
	public void click_on_mediasection() throws Throwable {
		//creating object for Media class
		media m = new media(driver);
		//Using object clicking on getMediaOpt present in media class and clicking on media option
		m.getMediaOpt().click();
	}


	@And("^User is on media sectionA$")
	public void user_is_on_media_section() throws Throwable 
	{
		System.out.println("Sucessfully navigated to media section");  //Printing acknowledgement that user is on media section

	}

	//method for library option
	@When("^click on Library optionA$")
	public void click_on_library_option() throws Throwable {
		media md = new media(driver);  //creating object for Media class
		md.getLibraryopt().click(); //Using object calling getLibraryopt present in media class and clicking on library option
	}

	//method for add new button
	@And("^click on Add New buttonA$")
	public void click_on_add_new_button() throws Throwable {
		media m = new media(driver); //creating object for Media class
		m.getAddnewbtn().click(); //Using object clicking on getAddnewbtn present in media class clicking on add new button
	}

	//method for select files option
	@And("^click on select filesA$")
	public void click_on_select_files() throws Throwable {
		
		media md = new media(driver); //creating object for media class
		
		md.getSelectBtn().click(); //clicking on select files button by calling the getSelectBtn method

	}

	//method for File uploading functionality
	@Then("^check file uploading functinalityA$")
	public void check_file_uploading_functinality() throws Throwable {
		
		Robot rb = new Robot(); //Creating object for robot class

		// pressing keys with the help of keyPress and keyRelease events
		rb.keyPress(KeyEvent.VK_D);
		rb.keyRelease(KeyEvent.VK_D);

		rb.keyPress(KeyEvent.VK_SHIFT);
		rb.keyPress(KeyEvent.VK_SEMICOLON);
		rb.keyRelease(KeyEvent.VK_SEMICOLON);
		rb.keyRelease(KeyEvent.VK_SHIFT);

		rb.keyPress(KeyEvent.VK_BACK_SLASH);
		rb.keyRelease(KeyEvent.VK_BACK_SLASH);

		rb.keyPress(KeyEvent.VK_I);
		rb.keyRelease(KeyEvent.VK_I);

		rb.keyPress(KeyEvent.VK_M);
		rb.keyRelease(KeyEvent.VK_M);

		rb.keyPress(KeyEvent.VK_G);
		rb.keyRelease(KeyEvent.VK_G);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //using implicitly wait to wait until file uploading is completed
		
		System.out.println("File uploading is completed."); //printing acknowledgement for file uploading completion
	}
	//method for closing the browser
	@And("^close the browserA$")
	public void close_the_browser() throws Throwable {
		driver.close();
	}

	//method for dropdown
	@Given("^click on dropdownA$")
	public void click_on_dropdown() throws Throwable {
		
		media dpdwn = new media(driver); //creating object for media class
		
		dpdwn.getdropdownopt().click(); //clicking doropdown using method call
	}

	//method for choosing option fron dropdown
	@When("^User choose any option from dropdownA$")
	public void i_choose_any_option_from_dropdown() throws Throwable { 
		Select dropdown = new Select(driver.findElement(By.id("media-attachment-filters"))); //finding the element using id
		
		for(int i=0;i<=4;i++) //using for loop for selecting option from dropdown
		{
			dropdown.selectByIndex(i);
			if(i==4) {
				
				dropdown.selectByIndex(0); //when loop reached the last option of dropdown again navigating to the first option
			}
		}
		//Acknowledge for dropdown functionality completion 
		System.out.println("DropDown action is completed \nNavigating again to option which has index value '0' ");

	}
	//
	@Then("^Appropriate result should be displayedA$")
	public void appropriate_result_should_be_displayed() throws Throwable {
		System.out.println("Result is displayed");
	}

	@Given("^User is in first dropdownA$")
	public void user_is_in_first_dropdown() throws Throwable {
		System.out.println("Now User clicks on second dropdown");
	}

	//method for choosing option fron dropdown
	@Then("^Choose any option from dropdownA$")
	public void choose_any_option_from_dropdown() throws Throwable {
		//finding the element using id 
		Select dropdown = new Select(driver.findElement(By.id("media-attachment-date-filters"))); 
		//using for loop for selecting option from dropdown
		for(int i=0;i<=4;i++) {
			dropdown.selectByIndex(i);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(i==4) {
				//Acknowledge for dropdown functionality completion 
				System.out.println("DropDown action is completed \nNavigating again to option which has index value '0' ");
			}
		}
		//when loop reached the last option of dropdown again navigating to the first option
		dropdown.selectByIndex(0);
	}

	//method for search box 
	@Given("^click on search boxA$")
	public void click_on_search_box() throws Throwable {
		media search= new media(driver);
		//calling method from media class using object
		search.searchboxopt().click();
	}

	@When("^user enters any text inside the search boxA$")
	public void user_enters_any_text_inside_the_search_box() throws Throwable {
		media search= new media(driver);
		//sending text to searchbox 
		search.searchboxopt().sendKeys("capgemini");

	}

	@Then("^result should be displayedA$")
	public void result_should_be_displayed() throws Throwable {
		//Acknowledgement for search box result
		System.out.println("Result displayed");

	}
}


















