import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {

    public void wait ( int seconds){
        System.out.print("\n Test start in: \n");
        do {
            System.out.println(seconds + " Sec.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seconds--;
        } while (seconds > 0);
    }
    public void waittoclose ( int seconds) {
        System.out.print("\n Test end in: \n");
        do {
            System.out.println(seconds + " Sec.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seconds--;
        } while (seconds > 0);
    }

    private WebDriver driver;

    @Before
    public void openBrowser(){
        wait(3);
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    @Test
    public void loginWithValidCredentials(){
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement welcomeTextElement = driver.findElement(By.cssSelector(".hello strong"));
        String welcomeText = welcomeTextElement.getText();
        Assert.assertTrue(welcomeTextElement.isDisplayed());
        Assert.assertEquals("Hello, Cosmin Fast!", welcomeText);
    }
    @Test
   public void loginWithInvalidCredentials(){
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fsttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement textElement = driver.findElement(By.cssSelector(".error-msg span"));
        String text = textElement.getText();
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("Invalid login or password.", text);
//        WebElement stateDropdown = driver.findElement(By.id("billing:region_id"));
//        Select select = new Select(stateDropdown);
//        select.selectByValue("1");
    }
    @Test
    public void loginWithoutemail() {
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement textElement = driver.findElement(By.id("advice-required-entry-email"));
        String text = textElement.getText();
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("This is a required field.", text);
    }
    @Test
    public void loginWithoutpass() {
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fsttrackit.org");
        driver.findElement(By.id("send2")).click();
        WebElement textElement = driver.findElement(By.id("advice-required-entry-pass"));
        String text = textElement.getText();
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("This is a required field.", text);
    }
    @After
    public void close(){
        waittoclose(3);
        driver.quit();
    }
}


