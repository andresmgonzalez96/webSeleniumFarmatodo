package addToCar;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SeleniumUtilities;

public class AddItemToCartPage {

	private WebDriver driver;

	private By searchFieldLocator;
	private By addItemToCartLocator;
	private By cartLocator;
	private By deleteAllItemsModalLocator;

	private WebDriverWait wait;

	/**
	 * Constructor.
	 * 
	 * @param driver
	 */

	public AddItemToCartPage(WebDriver driver) {
		this.driver = driver;
		searchFieldLocator = By.className("farma-input-header");
		addItemToCartLocator = By.className("farma-item-outstanding-icon");
		cartLocator = By.className("number-prod-cart");
		deleteAllItemsModalLocator = By.id("modalDeleteAllProductos");

		wait = new WebDriverWait(driver, 60);

	}
	
	/**
	 * Method type product in search field.
	 *
	 * @param product
	 */
	public void setProduct(String product) {
		long totalSum = 0;
		long startTime = System.currentTimeMillis();
		
		WebElement searchField = driver.findElement(searchFieldLocator);
		searchField.clear();
		searchField.sendKeys(product);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addItemToCartLocator));
		
		totalSum += (System.currentTimeMillis() - startTime);
		DecimalFormat formateador = new DecimalFormat("###,###");
		System.out.println("Search = " + formateador.format(totalSum) + " Segundos");
	}

	/**
	 * Method that add first product to cart.
	 */
	public void clickAddCart() {
		long totalSum = 0;
		long startTime = System.currentTimeMillis();
		
		WebElement addCartButton = driver.findElements(addItemToCartLocator).get(1);
		addCartButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartLocator));
		
		totalSum += (System.currentTimeMillis() - startTime);
		DecimalFormat formateador = new DecimalFormat("###,###");
		System.out.println("Add To Cart = " + formateador.format(totalSum) + " Segundos");
		
	}
	
	/**
	 * Method that return if cart is visible.
	 */
	public boolean isVisibilityCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartLocator));
		SeleniumUtilities utilities = new SeleniumUtilities();
		return utilities.existElement(cartLocator, driver);
		
	}
	
	/**
	 * Method that delete all items add to cart.
	 */
	public void deleteAllItemsAdd() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartLocator));
		WebElement cart = driver.findElement(cartLocator);
		cart.click();
		wait.until(ExpectedConditions.urlContains("cart"));
		driver.findElement(By.className("farma-img-circle-garbage-option")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(deleteAllItemsModalLocator));
		WebElement deleteModal = driver.findElement(deleteAllItemsModalLocator);
		deleteModal.findElement(By.className("btn")).click();
		SeleniumUtilities.waitTime(2000); //Time for delete items
		
	}
	

}
