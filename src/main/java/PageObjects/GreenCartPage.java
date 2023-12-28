package PageObjects;

import Page.Page;
import PageObjects.Component.CartComponent;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GreenCartPage extends Page {
    WebDriver driver;

    public GreenCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Top Deals")
    WebElement topDealsLink;

    @FindBy(className = "search-keyword")
    WebElement searchBarHomePage;

    @FindBy(css = "h4.product-name")
    WebElement searchedProductTextValue;

    @FindBy(className = "increment")
    WebElement incrementCountPlusIcon;

    @FindBy(className = "quantity")
    WebElement quantityTab;

    @FindBy(xpath = "//button[normalize-space()='ADD TO CART']")
    WebElement addToCartButton;

    @FindBy(className = "cart-icon")
    WebElement cartIcon;

    @FindBy(xpath = "//div[@class='cart-preview active']")
    WebElement cartPreview;

    @FindBy(xpath = "//span[@class='cart-count']")
    WebElement numberShownOnCartIcon;

    public void searchProduct(String productName) throws InterruptedException {
        searchBarHomePage.sendKeys(productName);
        Thread.sleep(1000);
    }

    public String getSearchedProductName() {
        return searchedProductTextValue.getText();
    }

    public TopDealsOffersPage clickOnTopDeals() {
        topDealsLink.click();
        return new TopDealsOffersPage(driver);
    }

    public void increaseItemsQuantity() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            incrementCountPlusIcon.click();
            Thread.sleep(100);
        }
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public String getNumberShowedOnCartIcon() {
        return numberShownOnCartIcon.getText();
    }

    public CartComponent clickOnCartButton() {
        cartIcon.click();
        waitTillVisibilityOfElement(cartPreview);
        return new CartComponent(driver);
    }
}
