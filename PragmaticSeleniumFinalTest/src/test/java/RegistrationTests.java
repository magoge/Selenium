import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Browsers Drivers\\chromedriver.exe");
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 3);
        driver.get("http://shop.pragmatic.bg/");
    }

    @Test
    public void successfulRegistration() {
        WebElement myAccount = driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccount.click();

        WebElement register = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
        register.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        String randomFirstName = RandomStringUtils.randomAlphabetic(8);
        firstName.sendKeys(randomFirstName);

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        String randomLastName = RandomStringUtils.randomAlphabetic(10);
        lastName.sendKeys(randomLastName);

        WebElement email = driver.findElement(By.id("input-email"));
        String emailRandom = RandomStringUtils.randomAlphabetic(8);
        String emailReal = emailRandom + "@abv.bg";
        email.sendKeys(emailReal);

        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("+3598889992");

        WebElement passwordOfTheUser = driver.findElement(By.id("input-password"));
        passwordOfTheUser.sendKeys("parola123456789");

        WebElement passwordConfirm = driver.findElement(By.id("input-confirm"));
        passwordConfirm.sendKeys("parola123456789");

        WebElement agreeCheckBox = driver.findElement(By.name("agree"));
        agreeCheckBox.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        continueButton.click();

        WebElement confirmMessage = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(confirmMessage.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
