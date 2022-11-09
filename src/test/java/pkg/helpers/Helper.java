package pkg.helpers;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class Helper {
    //Logger Setup
    public static Logger log = LoggerFactory.getLogger("Logger");
    public static WebDriver driver;

    //Setup properties file
    public static Properties property() {
        try {
            Properties properties = new Properties();

            FileInputStream fileInputStream = new FileInputStream("/Users/Ushima/ui-automation-poc/src/test/resources/config/config.properties");
            properties.load(fileInputStream);
            return properties;
        } catch (Exception e) {
            log.error("Exception occurred property!!!");
            e.printStackTrace();
        }
        return null;
    }

    public static void webDriverStart() {
        System.setProperty("webdriver.chrome.driver", "/Users/Ushima/ui-automation-poc/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://itera-qa.azurewebsites.net/home/automation?");
    }

    public static void webDriverQuit() {
        driver.quit();
    }

    public static String randomInteger(Integer length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String randomEmailAddress(Integer length) {
        String email = randomAlphanumeric(length) + "@mailinator.com";
        return email.toLowerCase();
    }

    public static String randomAlphabetic(Integer length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

}
