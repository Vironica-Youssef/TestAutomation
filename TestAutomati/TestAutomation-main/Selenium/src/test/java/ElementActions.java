import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class ElementActions {
    WebDriver driver;
    By username = By.id("inputUsername");
    By password = By.cssSelector("[type=\"password\"]");
    By LoginButton = RelativeLocator.with(By.tagName("button")).below(password);
    By UploadLink = By.xpath("/html/body/main/div[2]/div[9]/div/ul/li/a");
    By UpleadFile = By.id("fileInput");

    //actions on elements
    public void click(By by) {
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

    public void implicitWait() {driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));}

    public void explicitWait(By msg) {

        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(msg));
    }

    public void fluentWait(By msg){
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(30L))
                .withMessage("Element is not visible")
                .ignoring(NoSuchElementException.class)
                .until(driver1 -> driver.findElement(msg).isDisplayed());
    }

    @Test
    public void LogInTest() {
//        EdgeOptions edgeOptions = new EdgeOptions();
//        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new EdgeDriver();
        maximize();
        navigateTo("https://aa-practice-test-automation.vercel.app/");

        type(username, "admin");
        type(password, "admin");
        click(LoginButton);

    }

//    @Test
//    public void UploadFileTC() {
//        driver = new EdgeDriver();
//        maximize();
//        navigateTo("https://aa-practice-test-automation.vercel.app/");
//
//        type(username, "admin");
//        type(password, "admin");
//        click(LoginButton);
//
//        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//
//        click(UploadLink);
//        UploadFile(UpleadFile, "C:\\Users\\GOGO\\Desktop\\Personal\\CV\\SW testing\\Real CV\\Vironica Youssef – Software Tester Resume.pdf");



    }




