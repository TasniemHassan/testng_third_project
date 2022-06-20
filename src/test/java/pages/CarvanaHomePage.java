package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaHomePage {
    public CarvanaHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".Logo__LogoWrapper-sc-14r2405-0 ")
    public WebElement carvanaLogo;

    @FindBy(xpath="//div[@data-qa='navigation-wrapper']/div/a")
    public List<WebElement> mainNaviSectionItems;

    @FindBy(xpath="//div[@data-qa='sign-in-wrapper']/div/a")
    public WebElement signInButton;

    @FindBy(id="usernameField")
    public WebElement emailField;

    @FindBy(id="passwordField")
    public WebElement passwordField;

    @FindBy(css="button[data-cv='sign-in-submit']")
    public WebElement modalSignInButton;

    @FindBy(css="div[data-qa='error-message-container']")
    public WebElement signInModalErrorMessage;

    @FindBy(xpath="//div[@data-qa='header-items']/a[1]")
    public WebElement searchCarsLink;



}
