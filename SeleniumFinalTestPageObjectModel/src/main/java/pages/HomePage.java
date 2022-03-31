package pages.admin_area;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class HomePage {
    static {
        PageFactory.initElements(Browser.driver, HomePage.class);
    }

    public static void goToLink() {
        Browser.driver.get("http://shop.pragmatic.bg/");
    }

    public static void myAccount() {
        WebElement myAccount = Browser.driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccount.click();
    }

    public static void register() {
        WebElement register = Browser.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
        register.click();
    }

    public static void populateData() {
        WebElement firstName = Browser.driver.findElement(By.id("input-firstname"));
        String randomFirstName = RandomStringUtils.randomAlphabetic(8);
        firstName.sendKeys(randomFirstName);

        WebElement lastName = Browser.driver.findElement(By.id("input-lastname"));
        String randomLastName = RandomStringUtils.randomAlphabetic(10);
        lastName.sendKeys(randomLastName);

        WebElement email = Browser.driver.findElement(By.id("input-email"));
        String emailRandom = RandomStringUtils.randomAlphabetic(8);
        String emailReal = emailRandom + "@abv.bg";
        email.sendKeys(emailReal);

        WebElement telephone = Browser.driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("+3598889992");

        WebElement passwordOfTheUser = Browser.driver.findElement(By.id("input-password"));
        passwordOfTheUser.sendKeys("parola123456789");

        WebElement passwordConfirm = Browser.driver.findElement(By.id("input-confirm"));
        passwordConfirm.sendKeys("parola123456789");

        WebElement agreeCheckBox = Browser.driver.findElement(By.name("agree"));
        agreeCheckBox.click();
    }

    public static void continueButton() {
        WebElement continueButton = Browser.driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        continueButton.click();
    }
}
