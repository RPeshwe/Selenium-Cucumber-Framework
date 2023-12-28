package stepDefinitionFiles;

import Utlis.TestContextSetup;
import Utlis.UiBaseTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Hooks extends UiBaseTest {

    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Before
    public void setUp() throws IOException {
        testContextSetup.driver = setup();
    }

    @AfterStep
    public void getScreenShotOnFailure(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File file = getScreenshot(testContextSetup.driver);
            byte[] byteArrayOfScreenshotFile = FileUtils.readFileToByteArray(file);
            scenario.attach(byteArrayOfScreenshotFile, "image/png", scenario.getName());
        }
    }

    @After
    public void tearDown() {
        testContextSetup.driver.quit();
    }
}
