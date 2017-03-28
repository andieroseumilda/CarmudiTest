package features.support.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class FilterByPriceLocator {
	private Actions actions;
	private WebDriverWait wait;
	private WebDriver driver;
	
	
	public FilterByPriceLocator(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 500);
		actions = new Actions(driver);
		this.driver= driver;
	}
	
	// Element Locations
	@FindBy(xpath = "//div[@class='search-filters']//div[@id='facet_price']")
	private WebElement set_price_label;
	
	@FindBy(xpath = "//div[@class='search-filters']//div[@id='facet_price']//div//label//input[@placeholder='From:']")
	private WebElement set_textbox_from;
	
	
	@FindBy(xpath = "//div[@class='search-filters']//div[@id='facet_price']//div//label//input[@placeholder='To:']")
	private WebElement set_textbox_to;
	
	@FindBy(xpath = "//div[@class='search-filters']//div[@id='facet_year']")
	private WebElement set_build_label;
	
	@FindBy(xpath="//div[@id='refine-search-modal']/div[@class='catalog-filters']//div/a[contains(.,'Apply filters')]")
	private WebElement set_apply_filters;

	@FindBy(xpath = "//div[@class='sort']//a[@data-dropdown='sort-dropdown']")
	private WebElement set_sort_by_label;

	@FindBy(xpath = "//div[@class='sort']//ul[@id='sort-dropdown']/li[contains(.,'Price: lowest first')]")
	private WebElement set_sort_by_lowest_price;
	
	@FindBy(xpath = "//div[@class='sort']//ul[@id='sort-dropdown']/li[contains(.,'Price: highest first')]")
	private WebElement set_sort_by_highest_price;
	
	@FindBy(xpath = "//div[@data-layer-category='listing_box']//h4[@data-layer-action='price']/a")
	private List<WebElement> set_list_of_price_vehicle;
	
	@FindBy(xpath = "//div[@id='facet_brand']/div[contains(.,'Vehicles')]")
	private WebElement set_vehicle_label;
	
	@FindBy(xpath = "//div[@class='facet-checkbox checkbox-row facet-new']")
	private WebElement set_checkbox_new;
	
	
	// Get Element Locations
	public WebElement getPriceLabel() {
		return wait.until(visibilityOf(set_price_label)); 
	}
	public WebElement getTextboxFrom() {
		return wait.until(visibilityOf(set_textbox_from)); 
	}
	public WebElement getTextboxTo() {
		return wait.until(visibilityOf(set_textbox_to)); 
	}
	public WebElement getBuildLabel() {
		return wait.until(visibilityOf(set_build_label)); 
	}
	public WebElement getApplyFilters() {
		return wait.until(visibilityOf(set_apply_filters)); 
	}
	public WebElement getSortByLabel() {
		return wait.until(elementToBeClickable(set_sort_by_label)); 
	}
	public WebElement getSortByLowestPrice() {
		return wait.until(visibilityOf(set_sort_by_lowest_price)); 
	}
	public WebElement getSortByHighestPrice() {
		return wait.until(visibilityOf(set_sort_by_highest_price)); 
	}
	public List<WebElement> getListOfPriceVehicle() {
		return set_list_of_price_vehicle; 
	}
	public WebElement getVehicleLabel() {
		return wait.until(visibilityOf(set_vehicle_label)); 
	}
	public WebElement getCheckboxNew() {
		return wait.until(visibilityOf(set_checkbox_new));
		
	}
}
