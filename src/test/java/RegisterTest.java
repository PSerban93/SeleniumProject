import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class RegisterTest {
    public void wait ( int seconds){
        System.out.print("\n Next Test start in: \n");
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
    public void registernew() {
        wait(3);
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Serban");
        driver.findElement(By.name("lastname")).sendKeys("Perseca");
        driver.findElement(By.id("email_address")).sendKeys("iondintufe@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.className("checkbox")).click();
        String welcomeText = driver.findElement(By.cssSelector("#form-validate > div.fieldset > p.required")).getText();
        if (welcomeText.equals("* Required Fields"))
            System.out.println("Register Test Succeeded !");
        else
            System.err.println("Test Failed");

        driver.quit();
    }
}
