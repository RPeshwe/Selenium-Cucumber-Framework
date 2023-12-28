package PageObjects;

import Page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends Page {

    WebDriver driver;

    public Cart(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//p[@class='product-name']")
    WebElement productNameOnTable;

    @FindBy(xpath = "//p[@class='quantity']")
    WebElement quantityOnTable;

    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    WebElement placeOrderButton;

    @FindBy(xpath = "//label[normalize-space()='Choose Country']")
    WebElement chooseCountryLabelPlaceOrderPage;

    public String getProductNameFromCart() {
        return productNameOnTable.getText();
    }

    public String getQuantityFromCart() {
        return quantityOnTable.getText();
    }

    public PlaceOrderPage clickOnPlaceOrderButton() {
        placeOrderButton.click();
        waitTillVisibilityOfElement(chooseCountryLabelPlaceOrderPage);
        return  new PlaceOrderPage(driver);
    }
}
