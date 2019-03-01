package utilities;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


@Tag("integration")
public class BaseSeleniumTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    public static String URL_BASE = "https://dev4-dot-web-farmatodo.appspot.com";
    
    @BeforeEach
    public void init() throws MalformedURLException {
    	//Utilizar la propiedar segun el sistema operativo.
        //System.setProperty("webdriver.chrome.driver", "chromedriverMAC");
        System.setProperty("webdriver.chrome.driver", "chromedriverWIN.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        wait = new WebDriverWait(driver, 60);
    }

    @AfterEach
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    public void navigateTo(String url){
        driver.get(url);
    }
}
