package menu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SeleniumUtilities;

public class MenuPage {

	private WebDriver driver;
	private By iniciarSesionButtonLocator;

	private WebDriverWait wait;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		iniciarSesionButtonLocator = By.id("btn_inicio");


		wait = new WebDriverWait(driver, 60);
	}


	/**
	 * Method to find the employer name container
	 * 
	 * @return WebElement
	 */
	public void clickIniciarSesion() {
		wait.until(ExpectedConditions.elementToBeClickable(iniciarSesionButtonLocator));
		driver.findElement(iniciarSesionButtonLocator).click();
		
	}

}
