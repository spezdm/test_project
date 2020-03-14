package ua.com.prestaShopAutomationQatestlab;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFirst {
    @Test
    public void firstTest() {
        System.getProperty("webdriver.chrome.driver","");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
    }
}
