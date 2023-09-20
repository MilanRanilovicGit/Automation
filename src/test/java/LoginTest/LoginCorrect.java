package LoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginCorrect {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.webdriver", "G:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // Page Load

        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");

        //Username
        WebElement user = driver.findElement(By.name("username"));
        user.isDisplayed();
        user.isEnabled();
        user.sendKeys("MikiRanilovic");

        //Password
        WebElement pass = driver.findElement(By.name("password"));
        pass.isDisplayed();
        pass.isEnabled();
        pass.sendKeys("passwordtest1");

        //Button
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input"));
        button.isDisplayed();
        button.isEnabled();
        button.click();

        //Confirmation
        WebElement homePage = driver.findElement(By.id("accountTable"));
        String welcome = homePage.getText();

        if (welcome != null && welcome.contains("Account Balance"))
        {
            System.out.println("Logged in successfully");
        } else
            System.out.println("Positive test Failed");

    }
}
