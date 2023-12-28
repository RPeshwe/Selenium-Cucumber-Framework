package Utlis;

import PageObjects.Pages.Cart;
import PageObjects.Component.CartComponent;
import PageObjects.Pages.GreenCartPage;
import PageObjects.Pages.PlaceOrderPage;
import org.openqa.selenium.WebDriver;

public class TestContextSetup {

    public WebDriver driver;
    public String homePageProductName;
    public GreenCartPage greenCartPage;
    public CartComponent cartComponent;

    public PlaceOrderPage placeOrderPage;

    public Cart cart;
}
