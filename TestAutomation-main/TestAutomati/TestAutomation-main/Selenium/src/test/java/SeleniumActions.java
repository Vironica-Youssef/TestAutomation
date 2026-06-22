import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumActions {
    WebDriver driver;

    //Locators
    By username = By.id("inputUsername");
    By password = By.cssSelector("[type=\"password\"]");
    By LoginButton = RelativeLocator.with(By.tagName("button")).below(password);
    By MouseActionsLink = By.xpath("/html/body/main/div[2]/div[4]/div/ul/li[1]");
    By DragAndDropLink = By.xpath("/html/body/main/div[2]/div[4]/div/ul/li[2]/a");
    //By ScrollLink = By.xpath("/html/body/main/div[2]/div[4]/div/ul/li[4]/a");
    By ScrollLink = By.cssSelector("onclick=\"window.location.href=getRelativePath('mouse-keyboard/scrolling.html')\"");
    By RightClickButton = By.id("riClickBtn");
    By DoubleClickButton=By.id("dblClickBtn");
    //By DoubleClickButton=By.xpath("/html/body/main/section[1]/div/div[2]/button");
    By DragImage=By.id("dragImage");
    By DropImage=By.id("dropZone");

    public void click(By by) {
        driver.findElement(by).click();
    }
    public void type(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    @Test
    public void RightClick(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://aa-practice-test-automation.vercel.app/");

        type(username, "admin");
        type(password, "admin");
        click(LoginButton);
        click(MouseActionsLink);

        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(RightClickButton)).perform();
    }

    @Test
    public void Hover(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://aa-practice-test-automation.vercel.app/");

        type(username, "admin");
        type(password, "admin");
        click(LoginButton);
        click(MouseActionsLink);

        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(DoubleClickButton)).perform();

    }
    @Test
    public void DoubleClick(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://aa-practice-test-automation.vercel.app/");

        type(username, "admin");
        type(password, "admin");
        click(LoginButton);
        click(MouseActionsLink);

        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(DoubleClickButton)).doubleClick().perform();
    }

    @Test
    public void DragAndDrop(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://aa-practice-test-automation.vercel.app/");

        type(username, "admin");
        type(password, "admin");
        click(LoginButton);
        click(DragAndDropLink);

        Actions actions=new Actions(driver);
        actions.dragAndDrop(driver.findElement(DragImage),driver.findElement(DropImage)).perform();


    }

    @Test
    public void ClickAndRelease(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://aa-practice-test-automation.vercel.app/");

        type(username, "admin");
        type(password, "admin");
        click(LoginButton);
        click(DragAndDropLink);

        Actions actions=new Actions(driver);
        actions.clickAndHold(driver.findElement(DragImage)).moveToElement(driver.findElement(DropImage)).release().perform();
    }

    @Test
    public void Keys(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/key_presses");


        Actions actions=new Actions(driver);
        actions.keyDown(Keys.CANCEL).perform();
    }

    @Test
    public void SendKeys(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/key_presses");


        Actions actions=new Actions(driver);
        actions.sendKeys(driver.findElement(By.id("target")),"Viro").perform();
    }

    @Test
    public void Scroll(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://aa-practice-test-automation.vercel.app/");

        type(username, "admin");
        type(password, "admin");
        click(LoginButton);
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        click(ScrollLink);

        Actions actions=new Actions(driver);
        actions.scrollToElement(driver.findElement(By.id("scroll_text"))).sendKeys(driver.findElement(By.id("scroll_text")),"hi").perform();
    }
    }
