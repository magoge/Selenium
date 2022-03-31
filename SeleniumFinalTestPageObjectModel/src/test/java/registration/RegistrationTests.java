package registration;

import org.apache.commons.lang3.RandomStringUtils;
import pages.admin_area.DashBoardPage;
import pages.admin_area.HomePage;
import baseTest.BaseTest;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {
    String randomFirstName = RandomStringUtils.randomAlphabetic(8);

    @Test
    public void successfulRegistration() {
        HomePage.goToLink();
        HomePage.myAccount();
        HomePage.register();
        HomePage.populateData(randomFirstName);
        HomePage.continueButton();
        DashBoardPage.verifyUserInfoText("Your Account Has Been Created!");
    }
}
