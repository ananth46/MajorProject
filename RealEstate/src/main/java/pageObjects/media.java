package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class media {
	
	public WebDriver driver;
	
	By mediaopt  = By.xpath("//*[text()='Media']");
	By Libraryopt = By.xpath("//*[text()='Library']");
	By addnewbtn = By.xpath("//*[@role='button']");
	By selectfilebtn = By.cssSelector("[id='__wp-uploader-id-1']");
	By dropdownopt = By.cssSelector("[id=media-attachment-filters]");
	By dropdown = By.cssSelector("[class='attachment-filters']");
	By searchbox = By.cssSelector("[id='media-search-input']") ;

	public media(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public WebElement getMediaOpt() {
		return driver.findElement(mediaopt);			
	}
	
	public WebElement getLibraryopt() {
		return driver.findElement(Libraryopt );			
	}
	
	public WebElement getAddnewbtn() {
		return driver.findElement(addnewbtn);
	}
	
	public WebElement getSelectBtn() {
		return driver.findElement(selectfilebtn);
	}
	
	public WebElement getdropdownopt(){
		return driver.findElement(dropdownopt);
	}
	
	public WebElement getdropdown(){
		return driver.findElement(dropdown);
	}
	
	public WebElement searchboxopt(){
		return driver.findElement(searchbox);
	}

}
