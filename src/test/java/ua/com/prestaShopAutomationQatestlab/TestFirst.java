package ua.com.prestaShopAutomationQatestlab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFirst extends WebDriverSettings {
    @Test
    public void OpenSite() {
    System.out.println("Открыть главную страницу сайта:\n");
    //driver.manage().window().setSize(new Dimension(100,100));
    driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");

    }
    @Test
    public void Price () {
    System.out.println("Выполнить проверку, что цена продуктов в секции " +
                        "\"Популярные товары\" указана в соответствии с" +
                       " установленной валютой в шапке сайта (USD, EUR, UAH): ");
    driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
   // WebElement header = driver.findElement(By.id("header"));
   // header.findElement(By.xpath("//*[@id='_desktop_currency_selector']//i"));
    WebElement current = driver.findElement(By.xpath("//span[contains(text(), 'UAH ₴')]"));
    String currentStr = current.getText().trim();
    if (currentStr.equals("UAH ₴")) {
        System.out.println("Популярные товары указаны в валюте: " + currentStr);
        }
    }

    @Test
    public void showPrice() {
     System.out.println("Установить показ цены в USD используя" +
                        "выпадающий список в шапке сайта.\n");
     driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
     WebElement header = driver.findElement(By.id("header"));
     header.findElement(By.xpath("//*[@id='_desktop_currency_selector']//i")).click();
     WebElement dropButton = driver.findElement(By.xpath("//a[@title='Доллар США']"));
     dropButton.click();
     WebElement current = driver.findElement(By.xpath("//span[contains(text(), 'USD $')]"));
     String currentStr = current.getText().trim();
     System.out.println("Выбрана валюта: " + currentStr);
    }

    public void Search() {

    }

}


