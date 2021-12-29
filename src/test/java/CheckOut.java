import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CheckOut {
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
    public void waittoclose(int seconds) {
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
    public void proceedtoCheckoutfromCart() {
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
        driver.findElement(By.cssSelector(".bottom button")).click();
        WebElement textElement = driver.findElement(By.cssSelector(".page-title"));
        String text = textElement.getText();
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("CHECKOUT", text);
    }
    @Test
    public void proceedtoCheckoutfromminiCartdropdown() {
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
        driver.findElement(By.cssSelector(".checkout-button")).click();
        WebElement textElement = driver.findElement(By.cssSelector(".page-title"));
        String text = textElement.getText();
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("CHECKOUT", text);
    }
    @Test
    public void proceedtoCheckout() {
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
        driver.findElement(By.cssSelector(".links:nth-child(1) .top-link-checkout")).click();
        WebElement textElement = driver.findElement(By.cssSelector(".page-title"));
        String text = textElement.getText();
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("CHECKOUT", text);
    }
    @Test
    public void completeCheckout(){
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
        driver.findElement(By.cssSelector(".links:nth-child(1) .top-link-checkout")).click();
        WebElement textElement = driver.findElement(By.cssSelector(".page-title"));
        String text = textElement.getText();
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("CHECKOUT", text);
        WebElement billingDropdown = driver.findElement(By.id("billing-address-select"));
        Select billingselect = new Select(billingDropdown);
        billingselect.selectByValue("219");
        driver.findElement(By.id("billing:use_for_shipping_no")).click();
        driver.findElement(By.cssSelector(".buttons-set [title='Continue']:first-child")).click();
        WebElement shippingType = driver.findElement(By.id("co-shipping-form"));
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(shippingType));
        WebElement shippingDropdown = driver.findElement(By.id("shipping-address-select"));
        Select shipselect = new Select(shippingDropdown);
        shipselect.selectByVisibleText("New Address");
        WebElement requiredTextElement = driver.findElement(By.cssSelector(".required:nth-last-child(3)"));
        String requiredText = requiredTextElement.getText();
        Assert.assertTrue(requiredTextElement.isDisplayed());
        Assert.assertEquals("* Required Fields", requiredText);
        driver.findElement(By.id("shipping:firstname")).clear();
        driver.findElement(By.id("shipping:lastname")).clear();
        driver.findElement(By.id("shipping:street1")).clear();
        driver.findElement(By.id("shipping:street2")).clear();
        driver.findElement(By.id("shipping:city")).clear();
        driver.findElement(By.id("shipping:region")).clear();
        driver.findElement(By.id("shipping:postcode")).clear();
        driver.findElement(By.cssSelector(".active .fields [title=Telephone]")).clear();
        driver.findElement(By.id("shipping:fax")).clear();
        driver.findElement(By.id("shipping:firstname")).sendKeys("Serban");
        driver.findElement(By.id("shipping:lastname")).sendKeys("Perseca");
        driver.findElement(By.id("shipping:street1")).sendKeys("Str. Sucevei");
        driver.findElement(By.id("shipping:city")).sendKeys("Bistrita");
       // driver.findElement(By.id("shipping:region")).sendKeys("Bistrita-Nasaud");
        driver.findElement(By.id("shipping:postcode")).sendKeys("325854");
        WebElement countryDropdown = driver.findElement(By.id("shipping:country_id"));
        Select countryselect = new Select(countryDropdown);
        countryselect.selectByValue("RO");
        WebElement regionDropdown = driver.findElement(By.id("shipping:region_id"));
        Select regionselect = new Select(regionDropdown);
        regionselect.selectByValue("283");
        driver.findElement(By.cssSelector(".active .fields [title=Telephone]")).sendKeys("0754321597");
        driver.findElement(By.id("shipping:fax")).sendKeys("0263888999");
        driver.findElement(By.cssSelector(".buttons-set [title='Continue']:nth-child(2)")).click();
        WebElement shippingMethod = driver.findElement(By.id("checkout-shipping-method-load"));
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(shippingMethod));
        driver.findElement(By.id("s_method_freeshipping_freeshipping")).click();
        driver.findElement(By.cssSelector(".active .button")).click();
        WebElement paymentMethod = driver.findElement(By.id("co-payment-form"));
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(paymentMethod));
        driver.findElement(By.cssSelector(".active .button")).click();
        WebElement orderReview = driver.findElement(By.id("checkout-step-review"));
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(orderReview));
        WebElement totalTextElement = driver.findElement(By.cssSelector(".last>.a-right:nth-of-type(1) strong"));
        String totalText = totalTextElement.getText();
        Assert.assertTrue(totalTextElement.isDisplayed());
        Assert.assertEquals("Grand Total", totalText);
        driver.findElement(By.cssSelector(".btn-checkout")).click();
        new WebDriverWait(driver, 35).until(ExpectedConditions.urlToBe("http://testfasttrackit.info/selenium-test/checkout/onepage/success/"));
        WebElement msgTextElement = driver.findElement(By.cssSelector(".col-main .page-title h1"));
        String msgText = msgTextElement.getText();
        Assert.assertTrue(msgTextElement.isDisplayed());
        Assert.assertEquals("YOUR ORDER HAS BEEN RECEIVED.", msgText);
    }
    @After
    public void close() {
        waittoclose(3);
        driver.quit();
    }
}
//      pentru dropdown
//    WebElement stateDropdown = driver.findElement(By.id("billing:region_id"));
//        Select select = new Select(stateDropdown);
//        select.selectByValue("1");


//      pentru timeout
//    new WebDriverWait(driver, 15).until(ExpectedConditions.