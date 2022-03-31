package pages.admin_area;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Browser;

public class DashBoardPage {

    @FindBy(xpath = "//h1")
    private static WebElement userInfo;

    static {
        PageFactory.initElements(Browser.driver, DashBoardPage.class);
    }

    public static void verifyUserInfoText(String expectedFirstNameAndLastNameOfTheUser) {
        Assert.assertEquals(userInfo.getText(), expectedFirstNameAndLastNameOfTheUser);
    }
}
