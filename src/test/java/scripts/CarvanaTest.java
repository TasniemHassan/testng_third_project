package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class CarvanaTest extends Base {

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateCarvanaTitle(){
        driver.get("https://www.carvana.com/");
        Assert.assertEquals(driver.getTitle(),"Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    @Test(priority = 2, description = "Validate the Carvana logo")
    public void validateCarvanaLogo(){
        driver.get("https://www.carvana.com/");
        Assert.assertTrue(carvanaHomePage.carvanaLogo.isDisplayed());
    }

    @Test(priority = 3, description = "Validate the main navigation section items")
    public void validateMainNavItems(){
        driver.get("https://www.carvana.com/");
        String[] mainNaviSecItems = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};
        for(int i = 0; i <3; i++){
            Assert.assertEquals(carvanaHomePage.mainNaviSectionItems.get(i).getText(), mainNaviSecItems[i]);
            Assert.assertTrue(carvanaHomePage.mainNaviSectionItems.get(i).isDisplayed());
        }
    }

    @Test(priority = 4, description = "Validate the sign in error message")
    public void validateSignIn(){
        driver.get("https://www.carvana.com/");
        carvanaHomePage.signInButton.click();
        carvanaHomePage.emailField.sendKeys("johndoe@gmail.com");
        carvanaHomePage.passwordField.sendKeys("abcd1234");
        carvanaHomePage.modalSignInButton.click();
        Assert.assertEquals(carvanaHomePage.signInModalErrorMessage.getText(), "Email address and/or password combination is incorrect\n" +
                "Please try again or reset your password.");
    }

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void validateSearchFilterOptionsAndSearchButton(){
        driver.get("https://www.carvana.com/");
        Waiter.pause(3);
        carvanaHomePage.searchCarsLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        String[] filterOptionsText = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
        for(int i = 0; i<6; i++){
            Assert.assertEquals(carvanaSearchCarsPage.carFilterOptions.get(i).getText(), filterOptionsText[i]);
        }
    }

    @Test(priority=6, description="Validate the search result tiles")
    public void validateResultTiles(){
        driver.get("https://www.carvana.com/");
        Waiter.pause(3);
        carvanaHomePage.searchCarsLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        carvanaSearchCarsPage.searchInputBox.sendKeys("mercedes-benz");
        carvanaSearchCarsPage.goButton.click();
        Waiter.pause(3);
        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));
        for(int i =0; i< carvanaSearchCarsPage.resultTiles.size(); i++){
            Assert.assertTrue(carvanaSearchCarsPage.resultTiles.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.resultTileImage.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.addToFavoritesTag.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.inventoryType.get(i).isDisplayed() && carvanaSearchCarsPage.inventoryType.get(i).getText() != null);
            Assert.assertTrue(carvanaSearchCarsPage.yearMakeModel.get(i).isDisplayed() && carvanaSearchCarsPage.yearMakeModel.get(i).getText() != null);
            Assert.assertTrue(carvanaSearchCarsPage.trimMileageInfo.get(i).isDisplayed() && carvanaSearchCarsPage.trimMileageInfo.get(i).getText() != null);
            Assert.assertTrue(carvanaSearchCarsPage.price.get(i).isDisplayed());
            Assert.assertTrue(Integer.parseInt(carvanaSearchCarsPage.price.get(i).getText().replaceAll("[^0-9]", "")) > 0);
            Assert.assertTrue(carvanaSearchCarsPage.monthlyPayment.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.monthlyPayment.get(i).getText() != null);
            Assert.assertTrue(carvanaSearchCarsPage.downPayment.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarsPage.downPayment.get(i).getText() != null);
            Waiter.pause(3);
            Assert.assertTrue(carvanaSearchCarsPage.deliveryChip.get(i).getText() != null);
           // Assert.assertEquals(carvanaSearchCarsPage.deliveryChip.get(i).getText(), "Free Shipping");
        }
    }
}
