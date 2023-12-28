package stepDefinitionFiles;

import PageObjects.Pages.Cart;
import Utlis.TestContextSetup;
import Utlis.UiBaseTest;
import io.cucumber.java.en.And;
import org.assertj.core.api.SoftAssertions;

public class CartStepDefinition extends UiBaseTest {
    TestContextSetup testContextSetup;

    public CartStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @And("click on proceed to checkout validate item name and quantity")
    public void clickOnProceedToCheckoutValidateItemNameAndQuantity() throws InterruptedException {
        SoftAssertions softAssertions = new SoftAssertions();
        Cart cart = testContextSetup.cartComponent.clickOnCheckoutButton();
        String itemName = cart.getProductNameFromCart().split("-")[0].trim();
        String itemQuantity = cart.getQuantityFromCart();
        softAssertions.assertThat(itemName)
                .as("Validate item name is correctly displayed in cart")
                .isEqualTo(testContextSetup.homePageProductName);
        softAssertions.assertThat(itemQuantity)
                .as("Validate item quantity is displayed correctly in cart")
                .isEqualTo("4");
        softAssertions.assertAll();
    }
}
