package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import login.LoginPage;

public class SeleniumUtilities extends BaseSeleniumTest {

	private String LOGIN_USER = "andresm96@gmail.com";
	private String PASSWORD = "123456";

	/**
	 * Method to login.
	 * 
	 * @param webDriver
	 */
	public void login(WebDriver webDriver) {
		driver = webDriver;
		LoginPage loginPage = new LoginPage(webDriver);
		navigateTo(URL_BASE);
		loginPage.login(LOGIN_USER, PASSWORD);
		loginPage.clickLogin();

	}

	
	/**
	 * Method to Login with user and password.
	 */
	public void login(WebDriver webDriver, String user, String pass) {
		driver = webDriver;
		LoginPage loginPage = new LoginPage(webDriver);
		navigateTo(URL_BASE);
		loginPage.login(user, pass);
		loginPage.clickLogin();
	}

	/**
	 * Method that sleep a specific time.
	 */
	public static void waitTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to click on the browser back button
	 * 
	 * @return void
	 */
	public void clickToBack() {
		driver.navigate().back();
		SeleniumUtilities.waitTime(2000);
	}

	/**
	 * Method to down scroll page.
	 * 
	 * @return void
	 */
	public void downScrollPage(WebDriver webDriver) {
		driver = webDriver;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 450)");
	}
	
	/**
	 * Method to check if an element is visible on the screen.
	 * 
	 * @param locator
	 * @return boolean
	 */
	public boolean existElement(By locator, WebDriver webDriver) {
		driver = webDriver;
		try {
			driver.findElement(locator);
		} catch (Exception e) {
			return false;
		}
		return true;
	}


}