package PageObjects;

import Page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PlaceOrderPage extends Page {

    WebDriver driver;
    public PlaceOrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='wrapperTwo']//div//select")
    WebElement selectCountryDropDown;

    @FindBy(className = "chkAgree")
    WebElement agreeCheckbox;

    @FindBy(xpath = "//button[normalize-space()='Proceed']")
    WebElement proceedForOrderButton;

    public void selectCountry(String country){
        Select select = switchToSelectDropDown(selectCountryDropDown);
        select.selectByValue(country);
        String selectedCountry = select.getFirstSelectedOption().getText();
        waitTillTextAppears(selectCountryDropDown,selectedCountry);
    }

    public String getSelectedCountry(){
        Select select = switchToSelectDropDown(selectCountryDropDown);
        return  select.getFirstSelectedOption().getText();
    }

    public void checkAgreeCheckbox(){
        agreeCheckbox.click();
    }

    public void clickOnProceed(){
        proceedForOrderButton.click();
    }
}
