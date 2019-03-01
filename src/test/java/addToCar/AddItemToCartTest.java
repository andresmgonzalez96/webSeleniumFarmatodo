package addToCar;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.DecimalFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import login.LoginPage;
import menu.MenuPage;
import utilities.BaseSeleniumTest;

public class AddItemToCartTest extends BaseSeleniumTest {

	private String LOGIN_USER = "andresm96@gmail.com";
	private String PASSWORD = "123456";
	private String PRODUCT_AGUA = "Agua MANANTIAL Natural";
	

	private LoginPage loginPage;
	private MenuPage menuPage;
	private AddItemToCartPage addItemToCartPage;

	
	@Test
	/**
	 * Method that add item to cart
	 */
	public void addItemToCart() {
		addItemToCartPage = new AddItemToCartPage(driver);
		addItemToCartPage.setProduct(PRODUCT_AGUA);
		addItemToCartPage.clickAddCart();
		
		assertTrue(addItemToCartPage.isVisibilityCart());
		addItemToCartPage.deleteAllItemsAdd();
		
	}
	


	@BeforeEach
	public void arrange() {
		navigateTo(URL_BASE);
		menuPage = new MenuPage(driver);
		menuPage.clickIniciarSesion();
		loginPage = new LoginPage(driver);
		loginPage.login(LOGIN_USER, PASSWORD);
		long totalSum = 0;
		long startTime = System.currentTimeMillis();
		loginPage.clickLogin();
		totalSum += (System.currentTimeMillis() - startTime);
		DecimalFormat formateador = new DecimalFormat("###,###");
		System.out.println("Login = " + formateador.format(totalSum) + " Segundos");

	}

}
