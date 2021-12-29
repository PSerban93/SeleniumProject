import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class CartTest {

    public void wait(int seconds) {
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
    public void addToCartTest() {
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
        // TODO Implement add to cart steps
        driver.findElement(By.cssSelector("li.level0.nav-5.parent")).click();
        driver.findElement(By.cssSelector(".actions .button")).click();
        WebElement reqTextElement = driver.findElement(By.cssSelector(".required:nth-child(6)"));
        String reqText = reqTextElement.getText();
        Assert.assertTrue(reqTextElement.isDisplayed());
        Assert.assertEquals("* Required Fields", reqText);
        driver.findElement(By.id("option27")).click();
        driver.findElement(By.id("option81")).click();
        driver.findElement(By.cssSelector(".add-to-cart button")).click();
        WebElement textElement = driver.findElement(By.cssSelector(".success-msg span"));
        String text = textElement.getText();
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("Slim fit Dobby Oxford Shirt was added to your shopping cart.", text);
    }
    @Test
    public void addToCartwithoutrequirefields() {
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
        driver.findElement(By.cssSelector(".actions .button")).click();
        driver.findElement(By.cssSelector(".add-to-cart button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement reqTextElement = driver.findElement(By.cssSelector(".validation-advice"));
        String reqText = reqTextElement.getText();
        Assert.assertTrue(reqTextElement.isDisplayed());
        Assert.assertEquals("This is a required field.", reqText);
    }
    @Test
    public void addToCartfromWishlist(){
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
        driver.findElement(By.cssSelector(".first.odd .cart-cell [title='Add to Cart']")).click();
        WebElement reqTextElement = driver.findElement(By.cssSelector(".notice-msg span"));
        String reqText = reqTextElement.getText();
        Assert.assertTrue(reqTextElement.isDisplayed());
        Assert.assertEquals("Please specify the product's option(s).", reqText);
        driver.findElement(By.id("option27")).click();
        driver.findElement(By.id("option81")).click();
        driver.findElement(By.cssSelector(".add-to-cart button")).click();
        WebElement textElement = driver.findElement(By.cssSelector(".success-msg span"));
        String text = textElement.getText();
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("Slim fit Dobby Oxford Shirt was added to your shopping cart.", text);
    }
    @Test
    public void removefromCart(){
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
        driver.findElement(By.cssSelector(".header-minicart .label")).click();
        driver.findElement(By.cssSelector(".cart-link")).click();
        driver.findElement(By.cssSelector(".first.odd .a-center [title='Remove Item']")).click();
    }
    @After
    public void close() {
        waittoclose(3);
        driver.quit();
    }
}

