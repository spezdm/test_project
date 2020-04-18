 package ua.com.prestaShopAutomationQatestlab.testFirstv2;
import org.openqa.selenium.support.PageFactory;
import ua.com.prestaShopAutomationQatestlab.WebDriverSettings;

public class Test extends WebDriverSettings {
    @org.junit.Test
    public void TestProject() {
        TestPage testPage = PageFactory.initElements(driver, TestPage.class);
    //Сценарий:
        testPage.open();                   //  1
        testPage.getPrice();               //  2
        testPage.clickUSD();
        testPage.showPrice();              //  3
    /*
        testFirstPage.search();            //  4
        testFirstPage.validatorSearch();   //  5,6
        testFirstPage.sort();              //  7
        testFirstPage.validatorSort();     //  8
        testFirstPage.validatorPrice();    //  9
   */
    }
}