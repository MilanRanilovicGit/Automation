package LoginTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


public class Registration {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.webdriver", "G:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // Page Load

        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");

        //Register Button
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        //Form
        //Obrisati sendKeys podatak da bi polje palo check
        //Svaki error se print'a na kraju
        //FirstName
        WebElement firstName = driver.findElement(By.id("customer.firstName"));
        firstName.isDisplayed();
        firstName.isEnabled();
        firstName.sendKeys("Milan");
        //Lastname
        WebElement lastName = driver.findElement(By.id("customer.lastName"));
        lastName.isDisplayed();
        lastName.isEnabled();
        lastName.sendKeys("Ranilovic");
        //Address
        WebElement address = driver.findElement(By.id("customer.address.street"));
        address.isDisplayed();
        address.isEnabled();
        address.sendKeys("Tosin Bunar 3");
        //City
        WebElement city = driver.findElement(By.id("customer.address.city"));
        city.isDisplayed();
        city.isEnabled();
        city.sendKeys("Belgrade");
        //State
        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.isDisplayed();
        state.isEnabled();
        state.sendKeys("Serbia");
        //ZipCode
        WebElement zip = driver.findElement(By.id("customer.address.zipCode"));
        zip.isDisplayed();
        zip.isEnabled();
        zip.sendKeys("11000");
        //SSN
        WebElement ssn = driver.findElement(By.id("customer.ssn"));
        ssn.isDisplayed();
        ssn.isEnabled();
        ssn.sendKeys("1234567");
        //Username
        WebElement userName = driver.findElement(By.id("customer.username"));
        userName.isDisplayed();
        userName.isEnabled();
        //Koristiti 2 puta isti username da bi pao registraciju
        userName.sendKeys("MikiUserTest2");
        //Password
        WebElement password = driver.findElement(By.id("customer.password"));
        password.isDisplayed();
        password.isEnabled();
        password.sendKeys("password1");
        //ConfirmPassword
        WebElement confirmPassword = driver.findElement(By.id("repeatedPassword"));
        confirmPassword.isDisplayed();
        confirmPassword.isEnabled();
        //Promeniti password u nesto drugo da bi fialovao potvrdu
        confirmPassword.sendKeys("password1");

        //Button
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[13]/td[2]/input"));
        button.isDisplayed();
        button.isEnabled();
        button.click();

        //Test
        WebElement registered = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/p"));
        String welcomeText = registered.getText();

        List<String> errorsIds = Arrays.asList("customer.firstName.errors", "customer.lastName.errors", "customer.address.street.errors", "customer.address.city.errors", "customer.address.state.errors", "customer.address.zipCode.errors", "customer.ssn.errors", "customer.username.errors", "customer.password.errors", "repeatedPassword.errors");
        List<WebElement> errors = new ArrayList<>();

        for (String id : errorsIds) {
            List<WebElement> elements = driver.findElements(By.id(id));
            errors.addAll(elements);
        }
        if (welcomeText != null && welcomeText.contains("successfully")) {
            System.out.println(welcomeText);
        } else {
            System.out.println("Registration Failed");
            for (WebElement error : errors) {
                System.out.println(error.getText());
            }
        }
    }
}