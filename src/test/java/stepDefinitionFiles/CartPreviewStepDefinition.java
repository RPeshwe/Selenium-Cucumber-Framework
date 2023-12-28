package stepDefinitionFiles;

import PageObjects.Component.CartComponent;
import Utlis.TestContextSetup;
import Utlis.UiBaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;

public class CartPreviewStepDefinition extends UiBaseTest {
    TestContextSetup testContextSetup;

    public CartPreviewStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("click on cart and validate item name and quantity")
    public void clickOnCartAndValidateItemNameAndQuantity() {
        SoftAssertions softAssertions = new SoftAssertions();
        testContextSetup.cartComponent = testContextSetup.greenCartPage.clickOnCartButton();
        String itemName = testContextSetup.cartComponent.getItemNameAddedToCart().split("-")[0].trim();
        String itemQuantity = testContextSetup.cartComponent.getItemQuantityAddedToCart();
        softAssertions.assertThat(itemName)
                .as("Validate item name is correctly displayed")
                .isEqualTo(testContextSetup.homePageProductName);
        softAssertions.assertThat(itemQuantity)
                .as("Validate item quantity is displayed correctly")
                .isEqualTo("4 Nos.");
        softAssertions.assertAll();
    }
}
