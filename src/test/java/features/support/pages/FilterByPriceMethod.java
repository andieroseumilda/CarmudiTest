package features.support.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class FilterByPriceMethod {
	private Actions actions;
	private WebDriverWait wait;
	private WebDriver driver;
	private FilterByPriceLocator filter_price_locator;
	
	
	public FilterByPriceMethod(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 500);
		actions = new Actions(driver);
		this.driver= driver;
		filter_price_locator = new FilterByPriceLocator(driver);
	}
	
	// Methods
	public static String get_special_char_alpha;
	public void scrollToElement() throws InterruptedException {		
		actions.moveToElement(filter_price_locator.getBuildLabel());
		actions.perform();
	}
	public void reloadPage(){
		if(!filter_price_locator.getVehicleLabel().isDisplayed()){
			driver.navigate().refresh();
			}
	}
	public void inputPrice(int input_price, String textbox_label) throws InterruptedException{
		reloadPage();
		filter_price_locator.getPriceLabel().click();
		scrollToElement();	
		if(textbox_label.equals("From:")){
			filter_price_locator.getTextboxFrom().sendKeys(String.valueOf(input_price)); 
		} else {
			filter_price_locator.getTextboxTo().sendKeys(String.valueOf(input_price));
		}
	}
	public void inputSpecialCharAlpha(String input_special_char_alpha, String textbox_label) throws InterruptedException{
		filter_price_locator.getPriceLabel().click();
		scrollToElement();
		if(textbox_label.equals("From:")){
			filter_price_locator.getTextboxFrom().sendKeys(String.valueOf(input_special_char_alpha));
			get_special_char_alpha = filter_price_locator.getTextboxFrom().getText();
		}else{
			filter_price_locator.getTextboxTo().sendKeys(String.valueOf(input_special_char_alpha));
		}
	}
	public void displayListOfCars() throws InterruptedException{
		Thread.sleep(2000);
		filter_price_locator.getSortByLabel().isDisplayed();
		filter_price_locator.getApplyFilters().click();
	}

	public void sortBy(String price_sort_by) throws Exception{
		Thread.sleep(3000);
		reloadPage();
		filter_price_locator.getSortByLabel().isDisplayed();
		filter_price_locator.getSortByLabel().click();
		actions.moveToElement(filter_price_locator.getSortByLowestPrice()).build().perform();
		System.out.println(price_sort_by);
		if(price_sort_by.equals("lowest to highest")){
			filter_price_locator.getSortByLowestPrice().click();
		} else {
			filter_price_locator.getSortByHighestPrice().click();
		}
	}
	public void listOfCars() throws Exception{
		Thread.sleep(3000);
		reloadPage();
		filter_price_locator.getSortByLabel().isDisplayed();
		 List<WebElement> myList=filter_price_locator.getListOfPriceVehicle();	 
		 for(int i=0; i<myList.size(); i++){
			 	String car_price = myList.get(i).getText();
			 	System.out.println(car_price);
		    }
		driver.close();
	}
	public void textBoxValidation(){
		if((filter_price_locator.getTextboxFrom().getText()).isEmpty() || ((filter_price_locator.getTextboxFrom().getText()).isEmpty())){
			System.out.println("Test Passed!");
		}else {
			System.out.println("Test Failed!");
		}
		driver.close();
	}
	public void tickCheckBoxNew(){
		filter_price_locator.getCheckboxNew().click();
	}
	public void checkCurrentPage(){
		if(driver.getCurrentUrl().equalsIgnoreCase("https://www.carmudi.com.ph")){
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Failed!");
		}
		driver.close();
	}
}
