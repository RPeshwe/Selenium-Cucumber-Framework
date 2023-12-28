package PageObjects.Component;

import PageObjects.Pages.Cart;
import PageObjects.Pages.GreenCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartComponent extends GreenCartPage {
    WebDriver driver;

    public CartComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='quantity']")
    WebElement itemsQuantityLabel;

    @FindBy(xpath = "//p[@class='product-name']")
    WebElement itemsNameLabel;

    @FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
    WebElement proceedToCheckoutButton;

    @FindBy(className = "products")
    WebElement cartPageLoad;

    public String getItemNameAddedToCart() {
        return itemsNameLabel.getText();
    }

    public String getItemQuantityAddedToCart() {
        return itemsQuantityLabel.getText();
    }

    public Cart clickOnCheckoutButton() throws InterruptedException {
        proceedToCheckoutButton.click();
        Thread.sleep(2500);
        //waitTillVisibilityOfElement(cartPageLoad);
        return new Cart(driver);
    }
}
