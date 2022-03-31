package registration;

import pages.admin_area.DashBoardPage;
import pages.admin_area.HomePage;
import baseTest.BaseTest;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @Test
    public void successfulRegistration() {
        HomePage.goToLink();
        HomePage.myAccount();
        HomePage.register();
        HomePage.populateData();
        HomePage.continueButton();
        DashBoardPage.verifyUserInfoText("Your Account Has Been Created!");
    }
}
