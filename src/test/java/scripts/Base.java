package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CarvanaHomePage;
import pages.CarvanaSearchCarsPage;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {
    WebDriver driver;
    WebDriverWait explicitWait;
    Wait fluentWait;
    CarvanaHomePage carvanaHomePage;
    CarvanaSearchCarsPage carvanaSearchCarsPage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 30);
        fluentWait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).
                pollingEvery(2, TimeUnit.SECONDS).ignoring(Exception.class);
        carvanaHomePage = new CarvanaHomePage(driver);
        carvanaSearchCarsPage = new CarvanaSearchCarsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        Driver.quitDriver();
    }
}
