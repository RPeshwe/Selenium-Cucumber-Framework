package stepDefinitionFiles;

import PageObjects.PlaceOrderPage;
import Utlis.TestContextSetup;
import Utlis.UiBaseTest;
import io.cucumber.java.en.And;

public class PlaceOrderStepDefinition extends UiBaseTest {
    TestContextSetup testContextSetup;

    public PlaceOrderStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @And("click on place order")
    public void clickOnPlaceOrder() {
        PlaceOrderPage placeOrderPage = testContextSetup.cart.clickOnPlaceOrderButton();
        placeOrderPage.selectCountry("India");
        placeOrderPage.checkAgreeCheckbox();
    }

    @And("choose country <{string}> with clicking on checkbox")
    public void chooseCountryWithClickingOnCheckbox(String arg0) {
    }
}
