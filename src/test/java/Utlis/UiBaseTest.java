package Utlis;

import PageObjects.Pages.GreenCartPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class UiBaseTest {

    public WebDriver driver;

    private Properties loadGlobalPropertyFile() throws IOException {
        Properties properties = new Properties();
        FileInputStream propertyFile = new FileInputStream(
                System.getProperty("user.dir") +
                        "//src//test//resources//globalProperties.properties"
        );
        properties.load(propertyFile);
        return properties;
    }

    //driver setup
    public WebDriver setup() throws IOException {
        String browserName_properties = loadGlobalPropertyFile().getProperty("browser");
        String browserName_maven = System.getProperty("browser");
        String browserName = browserName_maven != null ? browserName_maven : browserName_properties;
        if (driver == null) {
            if (browserName.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                if (browserName_maven != null) {
                    options.addArguments("headless");
                }
                driver = new ChromeDriver(options);
            } else if (browserName.equalsIgnoreCase("firefox")) {
                if (browserName_maven != null) {
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    driver = new FirefoxDriver(firefoxOptions);
                } else {
                    driver = new FirefoxDriver();
                }
            } else if (browserName.equalsIgnoreCase("edge")) {
                if (browserName_maven != null) {
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("headless");
                    driver = new EdgeDriver(edgeOptions);
                } else {
                    driver = new EdgeDriver();
                }
            }
            assert driver != null;
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            return driver;
        }
        return driver;
    }

    public GreenCartPage launchGreenCart(WebDriver driver) throws IOException {
        String url = loadGlobalPropertyFile().getProperty("url");
        driver.get(url);
        return new GreenCartPage(driver);
    }

    public void launchApplication(String url, WebDriver driver) {
        driver.get(url);
    }

    public File getScreenshot(WebDriver driver) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        return source;
    }
}
