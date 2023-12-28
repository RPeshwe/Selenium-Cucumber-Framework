package stepDefinitionFiles;

import PageObjects.Pages.TopDealsOffersPage;
import Utlis.TestContextSetup;
import Utlis.UiBaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.Set;

public class GreenCartOffersPageStepDefinition extends UiBaseTest {

    TestContextSetup testContextSetup;

    public String offerPageText;

    TopDealsOffersPage topDealsOffersPage;

    public GreenCartOffersPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @When("^User searched for same shot name (.+) in offers page to check if product exist$")
    public void user_searched_for_same_shot_name_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
        offerPageText = landOnOffersPageAndGetSearchedProductName(shortName);
    }

    @Then("Validate both names are same")
    public void validate_both_names_are_same() {
        Assertions.assertThat(offerPageText.trim())
                .as("Validate both pages shortnames searches are correct")
                .isEqualTo(testContextSetup.homePageProductName.trim());
    }


    private String landOnOffersPageAndGetSearchedProductName(String productName) throws InterruptedException {
        String mainWindow = testContextSetup.driver.getWindowHandle();
        topDealsOffersPage = testContextSetup.greenCartPage.clickOnTopDeals();
        Set<String> multiWindows = testContextSetup.driver.getWindowHandles();
        for (String childWindow : multiWindows) {
            if (!childWindow.equals(mainWindow)) {
                testContextSetup.driver.switchTo().window(childWindow);
                offerPageText = topDealsOffersPage.getSearchedProductName(productName);
                testContextSetup.driver.close();
                testContextSetup.driver.switchTo().window(mainWindow);
            }
        }
        return offerPageText;
    }
}
