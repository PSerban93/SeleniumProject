import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.lang3.RandomStringUtils;


public class RegisterTest {
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
    public void openBrowser() {
        wait(3);
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    @Test
    public void registernewwithoutpass() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Serban");
        driver.findElement(By.name("lastname")).sendKeys("Perseca");
        String email = RandomStringUtils.randomAlphanumeric(6)+"@mailinator.com";
        driver.findElement(By.id("email_address")).sendKeys("ion.dintufe" + email);
        driver.findElement(By.className("checkbox")).click();
        driver.findElement(By.cssSelector(".buttons-set .button")).click();
        WebElement TextElement = driver.findElement(By.id("advice-required-entry-password"));
        String Text = TextElement.getText();
//        if (welcomeText.equals("* Required Fields"))
//            System.out.println("Register Test Succeeded !");
//        else
//            System.err.println("Test Failed");
        Assert.assertTrue(TextElement.isDisplayed());
        Assert.assertEquals("This is a required field.", Text);
    }
    @Test
    public void registernewwithoutmail() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Serban");
        driver.findElement(By.name("lastname")).sendKeys("Perseca");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.className("checkbox")).click();
        driver.findElement(By.cssSelector(".buttons-set .button")).click();
        WebElement TextElement = driver.findElement(By.id("advice-required-entry-email_address"));
        String Text = TextElement.getText();
        Assert.assertTrue(TextElement.isDisplayed());
        Assert.assertEquals("This is a required field.", Text);
    }
    @Test
    public void registernewwithoutlastname() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Serban");
        String email = RandomStringUtils.randomAlphanumeric(6)+"@mailinator.com";
        driver.findElement(By.id("email_address")).sendKeys("ion.dintufe" + email);
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.className("checkbox")).click();
        driver.findElement(By.cssSelector(".buttons-set .button")).click();
        WebElement TextElement = driver.findElement(By.id("advice-required-entry-lastname"));
        String Text = TextElement.getText();
        Assert.assertTrue(TextElement.isDisplayed());
        Assert.assertEquals("This is a required field.", Text);
    }
    @Test
    public void registernewwithoutname() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.name("lastname")).sendKeys("Perseca");
        String email = RandomStringUtils.randomAlphanumeric(6)+"@mailinator.com";
        driver.findElement(By.id("email_address")).sendKeys("ion.dintufe" + email);
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.className("checkbox")).click();
        driver.findElement(By.cssSelector(".buttons-set .button")).click();
        WebElement TextElement = driver.findElement(By.id("advice-required-entry-firstname"));
        String Text = TextElement.getText();
        Assert.assertTrue(TextElement.isDisplayed());
        Assert.assertEquals("This is a required field.", Text);
    }
    @Test
    public void registernew(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Serban");
        driver.findElement(By.name("lastname")).sendKeys("Perseca");
        String email = RandomStringUtils.randomAlphanumeric(6)+"@mailinator.com";
        driver.findElement(By.id("email_address")).sendKeys("ion.dintufe" + email);
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.className("checkbox")).click();
        driver.findElement(By.cssSelector(".buttons-set .button")).click();
        WebElement successTextElement = driver.findElement(By.cssSelector(".success-msg span"));
        String successText = successTextElement.getText();
        Assert.assertTrue(successTextElement.isDisplayed());
        Assert.assertEquals("Thank you for registering with Madison Island.", successText);

    }
    @After
    public void close() {
        waittoclose(3);
        driver.quit();
    }
}
