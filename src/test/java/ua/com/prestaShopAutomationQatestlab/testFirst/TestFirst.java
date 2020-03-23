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
        //Сценарий:
        testFirstPage.open();             //  1
        testFirstPage.getPrice();         //  2
        testFirstPage.getStarted();
        testFirstPage.showPrice();        //  3
        testFirstPage.search();           //  4
        testFirstPage.validatorSearch();  //  5,6
        testFirstPage.sort();             //  7
        testFirstPage.validatorSort();    //  8
        testFirstPage.validatorPrice();   //  9

    }


}