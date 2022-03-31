import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;

    public static void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Browsers Drivers\\chromedriver.exe");
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void quit() {
        driver.close();
    }
}
