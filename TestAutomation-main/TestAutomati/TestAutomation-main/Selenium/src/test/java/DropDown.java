import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;



public class DropDown {
    WebDriver driver;

    //Locators
    By username = By.id("inputUsername");
    By password = By.cssSelector("[type=\"password\"]");
    By LoginButton = RelativeLocator.with(By.tagName("button")).below(password);
    By DropDownLink = By.xpath("/html/body/main/div[2]/div[3]/div/ul/li[1]/a");
    By DropDown = By.id("experience-dropdown");

    //actions
    public void click(By by) {
        driver.findElement(by).click();
    }

    public void type(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }


    @Test
    public void TestDropDown(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://aa-practice-test-automation.vercel.app/");

        type(username, "admin");
        type(password, "admin");
        click(LoginButton);
        click(DropDownLink);

        Select select = new Select(driver.findElement(DropDown));
        select.selectByValue("2-4");


    }
}
