import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import java.time.Duration;

public class Checkbox_RadioButton {
    WebDriver driver;

    //Locators
    By username = By.id("inputUsername");
    By password = By.cssSelector("[type=\"password\"]");
    By LoginButton = RelativeLocator.with(By.tagName("button")).below(password);
    By CheckBoxRadioLink = By.xpath("/html/body/main/div[2]/div[2]/div/ul/li[3]/a");
    By CheckBox = By.id("nofan-checkbox");
    By GradRadioButton = By.xpath("//*[@id=\"checkbox-main\"]/section/div/div[5]/div[1]/label");


    //actions
    public void click(By by) {
        driver.findElement(by).click();
    }
    public void type(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    @Test
    public void CheckBoxTest(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://aa-practice-test-automation.vercel.app/");

        type(username, "admin");
        type(password, "admin");
        click(LoginButton);
        click(CheckBoxRadioLink);
        click(CheckBox);
        System.out.println("Checked: "+driver.findElement(CheckBox).isSelected());
    }

    @Test
    public void RadioButton(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://aa-practice-test-automation.vercel.app/");

        type(username, "admin");
        type(password, "admin");
        click(LoginButton);
        click(CheckBoxRadioLink);
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(GradRadioButton));
        //click(GradRadioButton);
        System.out.println("Checked: "+driver.findElement(GradRadioButton).isSelected());
    }
}
