package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SeleniumUtilities;

public class LoginPage {

	private WebDriver driver;

	private By textFieldLocator;

	private By loginButtonLocator;
	private By formLoginLocator;
	private By inputLocator;

	private WebDriverWait wait;

	/**
	 * Constructor.
	 * 
	 * @param driver
	 */

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		textFieldLocator = By.className("farma-content-input-modal-full-width");

		loginButtonLocator = By.id("btnLogin");
		formLoginLocator = By.name("formLogin");
		inputLocator = By.tagName("input");

		wait = new WebDriverWait(driver, 60);

	}
	
	/**
	 * Method that return form login.
	 *
	 * @param username
	 */

	public WebElement formLogin() {
		return driver.findElement(formLoginLocator);

	}
	
	/**
	 * Method to assign the username.
	 *
	 * @param username
	 */

	public void setUsername(String username) {
		WebElement usernameTextBox = formLogin().findElements(textFieldLocator).get(0).findElement(inputLocator);
		usernameTextBox.clear();
		usernameTextBox.sendKeys(username);
	}

	/**
	 * Method to assign the password
	 *
	 * @para pasword
	 */
	public void setPassword(String password) {
		WebElement passwordTextBox = formLogin().findElements(textFieldLocator).get(1).findElement(inputLocator);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
	}

	/**
	 * Method that do click in login button.
	 */
	public void clickLogin() {
		WebElement loginButton = driver.findElement(loginButtonLocator);
		loginButton.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(formLoginLocator));
	}

	/**
	 * Method that set userName and password with the parameters.
	 * 
	 * @param username
	 * @param password
	 */
	public void login(String username, String password) {
		setUsername(username);
		setPassword(password);
	}

	

}
