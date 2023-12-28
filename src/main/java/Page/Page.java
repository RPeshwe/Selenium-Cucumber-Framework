package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Page {
    private WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void click(WebElement element){
        element.click();
    }

    public void sendKey(String textToSend, WebElement element){
        element.sendKeys(textToSend);
    }

    public void pressKeys(String keyToPress, WebElement element){
        if (keyToPress.contains("Enter")){
            element.sendKeys(Keys.ENTER);
        }else if(keyToPress.contains("Tab")){
            element.sendKeys(Keys.TAB);
        }
    }

    public void clickAnywhereInPage(){
        Actions act =  new Actions(driver);
        act.moveByOffset(0,0)
                .click()
                .build()
                .perform();

    }

    public void waitTillVisibilityOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitTillInvisibilityOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitTillTextAppears(WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public WebDriverWait getWaitObject(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }

    public void waitTillAlertAppears(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public Alert switchToAlert(){
        return driver.switchTo().alert();
    }

    public Select switchToSelectDropDown(WebElement element){
        return new Select(element);
    }

    public JavascriptExecutor getJavaScripExecutor(){
        return  (JavascriptExecutor) driver;
    }

    public Actions perfromActions(){
        return new Actions(driver);
    }

    public void switchToFrame(WebElement element){
        driver.switchTo().frame(element);
    }

    public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }

    public WebDriver switchToWindow(String windowName){
        return driver.switchTo().window(windowName);
    }

    public String getMainWindowHandle(){
        return driver.getWindowHandle();
    }

    public String getChildWindowHandle(String mainWindow){
        Set<String> windowHandles = getWindowHandles();
        for (String childWindow: windowHandles){
            if(!childWindow.equals(mainWindow)){
                return childWindow;
            }
        }
        return null;
    }
    public void closeWindow(){
        driver.close();
    }
}
