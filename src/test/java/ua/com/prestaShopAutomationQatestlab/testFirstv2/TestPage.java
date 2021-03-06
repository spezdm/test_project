package ua.com.prestaShopAutomationQatestlab.testFirstv2;
import org.apache.commons.math3.util.Precision;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPage {

    private WebDriver driver;
    private WebDriverWait wait;
    public TestPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }
    @FindBy(id = "header")
    private WebElement header;
    private WebElement dropButton;
    private By desktop_currency_selector = By.xpath("//*[@id='_desktop_currency_selector']//i");
    private By currency = By.xpath(("//a[@title='Доллар США']"));
    private By UAH = By.xpath("//span[contains(text(), 'UAH ₴')]");
    private By USD = By.xpath("//span[contains(text(), 'USD $')]");

    public void clickUSD () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(desktop_currency_selector)).click();
        dropButton = driver.findElement(currency);
        dropButton.click();
    }

    public void open() {
    System.out.println("Открыть главную страницу сайта:\n");
    driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
    }

    public void getPrice() {
        System.out.println("\"Выполнить проверку, что цена продуктов в секции" +
                "\"Популярные товары\" указана в соответствии с" +
                " установленной валютой в шапке сайта (USD, EUR, UAH): ");
         wait.until(ExpectedConditions.visibilityOfElementLocated(desktop_currency_selector));
        WebElement current = driver.findElement(UAH);
        String currentStr = current.getText();
        if (currentStr.equals("UAH ₴")) {
            System.out.println("Популярные товары указаны в валюте: " + currentStr);
        }
    }

    public void showPrice() {
        System.out.println("Установить показ цены в USD используя" +
                "выпадающий список в шапке сайта.\n");
        WebElement current = driver.findElement(USD);
        String currentStr = current.getText();
        System.out.println("Выбрана валюта: " + currentStr);
    }
/*
    public void search() {
        System.out.println("Выполнить поиск в каталоге по слову “dress.”");
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
        WebElement inputSearch = driver.findElement(By.cssSelector("input.ui-autocomplete-input"));
        inputSearch.sendKeys("dress");
        inputSearch.click();
    }

    public void validatorSearch() {
        System.out.println("Выполнить проверку, что страница \"Результаты поиска\"" +
                "содержит надпись \"Товаров: x\", где x -" +
                " количество действительно найденных товаров.\n");
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
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

    public void sort () {
        System.out.println("Установить сортировку \"от высокой к низкой.\"\n");
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
        WebElement inputSearch = driver.findElement(By.cssSelector("input.ui-autocomplete-input"));
        inputSearch.sendKeys("dress");
        inputSearch.click();
        WebElement button = driver.findElement(By.cssSelector("button"));
        button.click();
        WebElement element = driver.findElement(By.xpath("//div[@class ='row sort-by-row']"));
        element.findElement(By.xpath("//a[@class ='select-title']")).click();
        WebElement current = driver.findElement(By.xpath("//div[@class ='dropdown-menu']"));
        current.findElement(By.linkText("Цене: от высокой к низкой")).click();
    }

    public void validatorSort () {
        System.out.println("Проверить, что товары отсортированы по цене, " +
                "при этом некоторые товары могут быть со скидкой," +
                "и при сортировке используется цена без скидки.");
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
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
        WebElement validatorSort = driver.findElement(By.xpath("//a[contains(text(), '????:')]"));
        String currentStr = validatorSort.getText();
        if (currentStr.equals("Цене: от высокой к низкой" +"\n" + "\uE5C5")) {
            System.out.println("Товары отсортированы по цене.");
        }
    }

    public void validatorPrice() {
        System.out.println("Для товаров со скидкой указана скидка в процентах вместе с ценой до и после скидки." +
                " Необходимо проверить, что цена до и после скидки совпадает с указанным размером скидки.\n");
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
        WebElement inputSearch = driver.findElement(By.cssSelector("input.ui-autocomplete-input"));
        inputSearch.sendKeys("dress");
        inputSearch.click();
        WebElement button = driver.findElement(By.cssSelector("button"));
        button.click();
        WebElement element = driver.findElement(By.xpath("//div[@class ='row sort-by-row']"));
        element.findElement(By.xpath("//a[@class ='select-title']")).click();
        WebElement current = driver.findElement(By.xpath("//div[@class ='dropdown-menu']"));
        current.findElement(By.linkText("????: ?? ??????? ? ??????")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='products row']")));
        WebElement elementCurrent = driver.findElement(By.xpath("//article[@data-id-product='5']"));
        elementCurrent.findElement(By.xpath("div[@class = 'thumbnail-container']")).click();

        System.out.print("Цена без скидки: ");
        WebElement price = driver.findElement(By.cssSelector(".regular-price"));
        price.findElement(By.xpath("//span[contains(text(), '1,14')]"));
        String priceStr = price.getText();
        priceStr = priceStr.replaceAll("\\$"," ");
        priceStr = priceStr.replace(",",".");
        Float priceNum = Float.valueOf(priceStr);
        System.out.println(priceNum);

        System.out.print("Цена со скидкой: ");
        WebElement new_price = driver.findElement(By.cssSelector(".current-price"));
        new_price.findElement(By.xpath("//span[@itemprop ='price']"));
        new_price.findElement(By.xpath("//span[contains(text(), '1,08')]"));
        String new_priceStr = new_price.getText();
        new_priceStr = new_priceStr.replaceAll("\\$ СОХРАНИТЬ 5\\%"," ");
        new_priceStr = new_priceStr.replace(",",".");
        Double new_priceNum = Double.valueOf(new_priceStr);
        System.out.println(new_priceNum);

        double discount_percent = 5;
        System.out.println("Проверочный процент скидки: " + discount_percent);
        double discount_value = priceNum * discount_percent / 100;
        double discount_price = priceNum - discount_value;
        double discount_price_round = Precision.round(discount_price, 2);

        if(new_priceNum.equals(discount_price_round)) {
            System.out.println("Цена до и после скидки совпадает с указанным размером скидки.\n");
        }else {
            System.out.println("Цена до и после скидки не совпадает с указанным размером скидки.\nэ
            ");
        }
    }

 */
}
