package features.step_definitions;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.annotation.en.Then;

public class FilterByThePriceSteps {
	private features.support.pages.Browser browser;
	private features.support.pages.FilterByPriceMethod price;
	private WebDriver driver;
		
	@Given("I am on the Carmudi Search Page$")
		public void goToCarmudiPage() throws MalformedURLException {
			browser = new features.support.pages.Browser();
			this.driver = browser.open();
		}
	
	@When("^i input (\\d+) on the \"(.*)\" textbox$")
		public void enterAmount(int input_price, String textbox_label) throws InterruptedException{
			price = new features.support.pages.FilterByPriceMethod(driver);
			price.inputPrice(input_price, textbox_label);
	}
	@When("^i input \"(.*)\" on the \"([^\"]*)\" textbox$")
		public void enterSpecialChar(String enter_specialchar_alpha, String textbox_label) throws InterruptedException {
			price = new features.support.pages.FilterByPriceMethod(driver);
			price.inputSpecialCharAlpha(enter_specialchar_alpha, textbox_label);
	}	
	@When("^i click the New checkbox on the Condition tab$")
		public void tikCheckboxNew(){
			price = new features.support.pages.FilterByPriceMethod(driver);
			price.tickCheckBoxNew();
	}	
	@Then("^i should see the list of available vehicle with the amount entered$")
		public void displayList() throws Exception{
			price = new features.support.pages.FilterByPriceMethod(driver);
			price.displayListOfCars();
	}
	@Then("^the vehicle rates are sort from the \"(.*)\"$")
		public void sortBy(String price_sort_by) throws Exception{
		price = new features.support.pages.FilterByPriceMethod(driver);
		price.sortBy(price_sort_by);
		price.listOfCars();
	}	
	@Then("^the system will validated the input text$")
		public void validatedTheTextbox() throws Exception{
			price = new features.support.pages.FilterByPriceMethod(driver);
			price.textBoxValidation();		
	}
	@Then("^i should see to search home page of the Carmudi website$")
	public void checkHomePage() {
		price = new features.support.pages.FilterByPriceMethod(driver);
		price.checkCurrentPage();
	}	
}