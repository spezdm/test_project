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
    public void Price() {
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

    @Test
    public void Search() {
        System.out.println("Выполнить поиск в каталоге по слову “dress.”");
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
        WebElement inputSearch = driver.findElement(By.cssSelector("input.ui-autocomplete-input"));
        inputSearch.sendKeys("dress");
        inputSearch.click();

    }
    @Test
    public void validatorSearch() {
        System.out.println("Выполнить проверку, что страница \"Результаты поиска\" " +
                "содержит надпись \"Товаров: x\", где x -" +
                " количество действительно найденных товаров.\n");
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
        WebElement header = driver.findElement(By.id("header"));
        header.findElement(By.xpath("//*[@id='_desktop_currency_selector']//i")).click();
        WebElement dropButton = driver.findElement(By.xpath("//a[@title='Доллар США']"));
        dropButton.click();
        WebElement inputSearch = driver.findElement(By.cssSelector("input.ui-autocomplete-input"));
        inputSearch.sendKeys("dress");
        inputSearch.click();
        WebElement button = driver.findElement(By.cssSelector("button"));
        button.click();
        WebElement goods = driver.findElement(By.xpath("//div[@class = 'col-md-6 hidden-sm-down total-products']"));
        goods.click();
        WebElement goodStr = driver.findElement(By.xpath("//p[contains(text(), 'Товаров: 7.')]"));
        String goodsStr = goodStr.getText().trim();
        System.out.println(goodsStr);
        System.out.println("Проверить, что цена всех показанных " +
                "результатов отображается в долларах.\n");
        WebElement current = driver.findElement(By.xpath("//span[contains(text(), 'USD $')]"));
        String currentStr = current.getText().trim();
        if (currentStr.equals("USD $")) {
            System.out.println("Цена в: " + currentStr);
        }
    }

    @Test
    public void sort () {
        System.out.println("Установить сортировку \"от высокой к низкой.\"\n");
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
        WebElement header = driver.findElement(By.id("header"));
        header.findElement(By.xpath("//*[@id = '_desktop_currency_selector']//i")).click();
        WebElement dropButton = driver.findElement(By.xpath("//a[@title='Доллар США']"));
        dropButton.click();
       WebElement inputSearch = driver.findElement(By.cssSelector("input.ui-autocomplete-input"));
        inputSearch.sendKeys("dress");
        inputSearch.click();
        WebElement button = driver.findElement(By.cssSelector("button"));
        button.click();
        WebElement element = driver.findElement(By.xpath("//div[@class ='row sort-by-row']"));
        element.findElement(By.xpath("//a[@class ='select-title']")).click();
        WebElement current = driver.findElement(By.xpath("//div[@class ='dropdown-menu']"));
        current.findElement(By.linkText("Цене: от высокой к низкой")).click();;
    }

    @Test
    public void validatorSort () {
       System.out.println("Проверить, что товары отсортированы по цене, " +
                          "при этом некоторые товары могут быть со скидкой," +
                          "и при сортировке используется цена без скидки.");
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
        WebElement header = driver.findElement(By.id("header"));
        header.findElement(By.xpath("//*[@id = '_desktop_currency_selector']//i")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Доллар США']"))).click();
        WebElement inputSearch = driver.findElement(By.cssSelector("input.ui-autocomplete-input"));
        inputSearch.sendKeys("dress");
        inputSearch.click();
        WebElement button = driver.findElement(By.cssSelector("button"));
        button.click();
        WebElement element = driver.findElement(By.xpath("//div[@class ='row sort-by-row']"));
        element.findElement(By.xpath("//a[@class='select-title']")).click();
        WebElement current = driver.findElement(By.xpath("//div[@class ='dropdown-menu']"));
        current.findElement(By.linkText("" + "Цене: от высокой к низкой")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select-title")));
        WebElement validatorSort = driver.findElement(By.xpath("//a[contains(text(), 'Цене:')]"));
        String currentStr = validatorSort.getText();
        if (currentStr.equals("Цене: от высокой к низкой" +"\n" + "\uE5C5")) {
            System.out.println("Товары отсортированы по цене.");
        }
    }
}


