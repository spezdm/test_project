package ua.com.prestaShopAutomationQatestlab.testFirst;
import org.apache.commons.math3.util.Precision;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.prestaShopAutomationQatestlab.WebDriverSettings;

public class TestFirst extends WebDriverSettings {
    @Test
    public void TestProject() {
        TestFirstPage testFirstPage = PageFactory.initElements(driver, TestFirstPage.class);
        testFirstPage.open();
        testFirstPage.price();
        testFirstPage.getStarted();
        testFirstPage.showPrice();
        testFirstPage.search();
        testFirstPage.validatorSearch();
        testFirstPage.sort();
        testFirstPage.validatorSort();
        testFirstPage.validatorPrice();
    }
}