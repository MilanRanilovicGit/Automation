package LoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginIncorrect {
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
        //Mogu da koristim pogresan password i sistem ce mi i dalje ulaziti tako da prazno je jedino sto mi garantuje login failed
        pass.sendKeys("");


        //Button
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input"));
        button.isDisplayed();
        button.isEnabled();
        button.click();

        //Confirmation

        WebElement error = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]"));
        String errorText = error.getText();

        if (errorText != null && errorText.contains("Error"))
        {
            System.out.println(errorText);
        } else
            System.out.print("Negative test failed");
    }
}
