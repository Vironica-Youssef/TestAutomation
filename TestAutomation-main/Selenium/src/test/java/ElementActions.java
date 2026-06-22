import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import java.io.File;

public class ElementActions {
    WebDriver driver;
    By username = By.id("inputUsername");
    By password = By.cssSelector("[type=\"password\"]");
    By LoginButton = RelativeLocator.with(By.tagName("button")).below(password);
    By UploadLink = By.xpath("/html/body/main/div[2]/div[9]/div/ul/li/a");
    By UpleadFile = By.id("fileInput");

    //actions on elements
    public void clicking(By by) {
        driver.findElement(by).click();
    }

    public void type(By by, String text) {
        clear(by);
        driver.findElement(by).sendKeys(text);
    }

    public void UploadFile(By by, String filePath) {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
        driver.findElement(by).sendKeys(userDir + File.separator + filePath);
        driver.findElement(by).sendKeys(filePath);
    }

    public void clear(By by) {
        driver.findElement(by).clear();
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void navigateTo(String URL) {
        driver.navigate().to(URL);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    @Test
    public void LogInTest() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("https://aa-practice-test-automation.vercel.app/");

        type(username, "admin");
        type(password, "admin");
        clicking(LoginButton);

    }

    @Test
    public void UploadFileTC() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("https://aa-practice-test-automation.vercel.app/");

        type(username, "admin");
        type(password, "admin");
        clicking(LoginButton);

        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        clicking(UploadLink);
        UploadFile(UpleadFile, "C:\\Users\\GOGO\\Desktop\\Personal\\CV\\SW testing\\Real CV\\Vironica Youssef – Software Tester Resume.pdf");


    }


}


