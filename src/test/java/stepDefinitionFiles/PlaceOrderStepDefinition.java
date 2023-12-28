package stepDefinitionFiles;

import PageObjects.Cart;
import PageObjects.PlaceOrderPage;
import Utlis.TestContextSetup;
import Utlis.UiBaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.ja.且つ;
import org.assertj.core.api.Assertions;

public class PlaceOrderStepDefinition extends UiBaseTest {
    TestContextSetup testContextSetup;
    PlaceOrderPage placeOrderPage;
    Cart cart;

    public PlaceOrderStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @And("click on place order")
    public void clickOnPlaceOrder() {
        cart = new Cart(testContextSetup.driver);
        placeOrderPage = cart.clickOnPlaceOrderButton();
    }

    @And("^choose country (.+) with clicking on checkbox$")
    public void chooseCountryWithClickingOnCheckbox(String arg0) {
        placeOrderPage.selectCountry("India");
        placeOrderPage.checkAgreeCheckbox();
        String getSelectedCountry = placeOrderPage.getSelectedCountry();
        Assertions.assertThat(getSelectedCountry)
                .as("Validate country is correctly selected from drop-down")
                .isEqualTo("India");
    }
}
