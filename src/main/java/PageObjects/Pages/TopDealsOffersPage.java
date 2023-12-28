package PageObjects.Pages;

import Page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopDealsOffersPage extends Page {
    WebDriver driver;
    public TopDealsOffersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search-field")
    WebElement searchBarTopDeals;

    @FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr/td[1]")
    WebElement searchedProductFromTable;

    public String getSearchedProductName(String productName) throws InterruptedException {
        searchBarTopDeals.sendKeys(productName);
        Thread.sleep(1000);
        return searchedProductFromTable.getText();
    }
}
