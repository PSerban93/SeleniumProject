import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void addtoWishlist(){
        wait(3);
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        ((WebElement) accountLink).click();
        driver.findElement((By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li > div > div.actions > ul > li:nth-child(1) > a"))).click();
        String welcomeText = driver.findElement(By.cssSelector("#login-form > div > div.col-2.registered-users > div.content.fieldset > p.required")).getText();
        if (welcomeText.equals("* Required Fields"))
            System.out.println("Add to WishList Test Succeeded !");
        else
            System.err.println("Test Failed");
        driver.quit();
    }
}
