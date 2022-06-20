package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaSearchCarsPage {
    public CarvanaSearchCarsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css= "span[data-qa='label-text']")
    public List<WebElement> carFilterOptions;

    @FindBy(css="input[data-qa='search-bar-input']")
    public WebElement searchInputBox;

    @FindBy(css="button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(css="div[data-test='ResultTile']")
    public List<WebElement> resultTiles;

    @FindBy(css=".vehicle-image")
    public List<WebElement> resultTileImage;

    @FindBy(css="div[data-qa='base-favorite-vehicle']")
    public List<WebElement> addToFavoritesTag;

    @FindBy(css="div[data-qa='inventory-type-experiment']")
    public List<WebElement> inventoryType;

    @FindBy(css="div[data-qa='make-model']")
    public List<WebElement> yearMakeModel;

    @FindBy(css="div[data-qa='trim-mileage']")
    public List<WebElement> trimMileageInfo;

    @FindBy(css=".price")
    public List<WebElement> price;

    @FindBy(css="div[data-qa='monthly-payment']")
    public List<WebElement> monthlyPayment;

    @FindBy(css=".down-payment")
    public List<WebElement> downPayment;

    @FindBy(css="div[data-qa='delivery-chip'] span")
    public List<WebElement> deliveryChip;




}
