import org.openqa.selenium.By;
import org.testng.annotations.Test;
import parent.BaseTest;

import static org.testng.Assert.assertTrue;

public class HerokkuTest extends BaseTest {
    @Test
    public void incorrectLogin() {
        browser.get("https://the-internet.herokuapp.com/login");
        browser.findElement(By.cssSelector("#username")).sendKeys("user1");
        browser.findElement(By.cssSelector("#password")).sendKeys("12345678");
        browser.findElement(By.xpath("//button[@type='submit']")).click();
        String actualErrorMsg = browser.findElement(By.cssSelector("#flash-messages [class=\"flash error\"]")).getText().trim();
        String expectedErrorMsg = "Your username is invalid!";
        assertTrue(actualErrorMsg.contains(expectedErrorMsg));

    }
}
