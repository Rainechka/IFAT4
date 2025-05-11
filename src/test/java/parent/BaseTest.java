package parent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class BaseTest {
    public WebDriver browser;

    @BeforeMethod
    public void setup() {
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        browser.manage().window().maximize();
    }

    @AfterMethod
    public void close() {
        browser.quit();
    }
}