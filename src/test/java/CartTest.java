import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {

        public void addToCartTest(){
            System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("http://testfasttrackit.info/selenium-test/");
            WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
            accountLink.click();
            driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
            driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
            driver.findElement(By.id("pass")).sendKeys("123456");
            driver.findElement(By.id("send2")).click();
            String welcomeText = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong")).getText();
            if (welcomeText.equals("Hello, Cosmin Fast!"))
                System.out.println("Success");
            else
                System.err.println("Fail");

            // TODO Implement add to cart steps

        }

    }

