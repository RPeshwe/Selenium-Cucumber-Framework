package stepDefinitionFiles;

import PageObjects.GreenCartPage;
import Utlis.TestContextSetup;
import Utlis.UiBaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.io.IOException;

public class GreenCartHomePageDefinition extends UiBaseTest {
    TestContextSetup testContextSetup;

    public GreenCartHomePageDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCart landing page")
    public void user_is_on_green_cart_landing_page() throws IOException {
        testContextSetup.greenCartPage = launchGreenCart(testContextSetup.driver);
    }

    @When("^User searched with short name (.+) and extracted actual name of product$")
    public void user_searched_with_short_name_and_extracted_actual_name_of_product(String productShortName)
            throws InterruptedException {
        testContextSetup.greenCartPage.searchProduct(productShortName);
        testContextSetup.homePageProductName = testContextSetup.greenCartPage.getSearchedProductName().split("-")[0].trim();
    }

    @And("User increases quantity as four and added to cart")
    public void userIncreasesQuantityAsFourAndAddedToCart() throws InterruptedException {
        testContextSetup.greenCartPage.increaseItemsQuantity();
        testContextSetup.greenCartPage.clickOnAddToCartButton();
    }

    @Then("Validate cart has hypertext shown as one")
    public void validateCartHasHypertextShownAsOne() {
        String hyperTextOnCart = testContextSetup.greenCartPage.getNumberShowedOnCartIcon();
        Assertions.assertThat(hyperTextOnCart)
                .as("Validate number is correctly displayed on cart icon")
                .isEqualTo("1");
    }
}
