package ua.com.prestaShopAutomationQatestlab;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSettings {
    public ChromeDriver driver;
    public WebDriverWait wait;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        //System.out.println("test start");
    }
    @After
    public void close () {
        //System.out.println("Test close");
        //driver.quit();
    }

}
