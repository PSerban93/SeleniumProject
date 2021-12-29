import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class WishListTest {
    public void wait ( int seconds) {
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
    public void openBrowser() {
        wait(3);
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    @Test
    public void addtoWishlistwithoutLogin(){
        WebElement accountLink = driver.findElement(By.cssSelector("li.level0.nav-5.parent"));
        accountLink.click();
        driver.findElement((By.cssSelector(".link-wishlist"))).click();
        WebElement requiredTextElement = driver.findElement(By.cssSelector(".required"));
        String requiredText = requiredTextElement.getText();
        Assert.assertTrue(requiredTextElement.isDisplayed());
        Assert.assertEquals("* Required Fields", requiredText);

    }
    @Test
    public void addtoWishlist(){
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
        driver.findElement(By.cssSelector("li.level0.nav-5.parent")).click();
        driver.findElement((By.cssSelector(".link-wishlist"))).click();
        WebElement msgElement = driver.findElement(By.cssSelector(".success-msg span"));
        String msgText = msgElement.getText();
        Assert.assertTrue(msgElement.isDisplayed());
        Assert.assertEquals("Slim fit Dobby Oxford Shirt has been added to your wishlist. Click here to continue shopping.", msgText);
    }
    @Test
    public void removefromWishlist(){
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
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".links:nth-child(1) :nth-child(2)")).click();
        driver.findElement(By.cssSelector(".first.odd [title='Remove Item']")).click();
        driver.switchTo().alert().accept();
        WebElement textElement = driver.findElement(By.cssSelector(".page-title"));
        String Text = textElement.getText();
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("MY WISHLIST", Text);
    }
    @After
    public void close() {
        waittoclose(3);
        driver.quit();
    }
}
