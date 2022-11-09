package pkg.pageobjects;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pkg.helpers.Helper;
import pkg.models.IteraAutomationModel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static pkg.helpers.Helper.*;

public class IteraAutomationPage {
    private static final By userName = By.id("name");
    private static final By userMobileNumber = By.id("phone");
    private static final By userEmail = By.id("email");
    private static final By userPassword = By.id("password");
    private static final By userAddress = By.id("address");
    private static final By submitButton = By.xpath("//button[@name='submit']");
    private static final By femaleRadioButton = By.id("female");
    private static final By tuesdayCheckbox = By.id("tuesday");
    private static final By fridayCheckbox = By.id("friday");
    private static final By placesDropdown = By.xpath("//select[@class='custom-select']");
    private static final By years = By.xpath("//label[@for='2years']");
    private static final By seleniumWebdriver = By.xpath("//label[@for='selenium']");
    private static final By testng = By.xpath("//label[@for='testng']");
    private static final By file = By.id("inputGroupFile02");
    private WebElement placesDropdownValue;
    private String image;

    private String getResourceDir() throws IOException {
        return new File(".").getCanonicalPath() + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    }

    public void enterUserDetails(List<IteraAutomationModel> iteraAutomationModelList) {
        webDriverStart();
        try {
            for (IteraAutomationModel iteraAutomationModel : iteraAutomationModelList) {
                if (StringUtils.isNotBlank(iteraAutomationModel.getName())) {
                    driver.findElement(userName).sendKeys(Helper.randomAlphabetic(5));
                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                }
                if (StringUtils.isNotBlank(iteraAutomationModel.getMobileNumber())) {
                    driver.findElement(userMobileNumber).sendKeys(Helper.randomInteger(10));
                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                }
                if (StringUtils.isNotBlank(iteraAutomationModel.getEmailAddress())) {
                    driver.findElement(userEmail).sendKeys(Helper.randomEmailAddress(5));
                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                }
                if (StringUtils.isNotBlank(iteraAutomationModel.getPassword())) {
                    driver.findElement(userPassword).sendKeys(Helper.property().getProperty("password"));
                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                }
                if (StringUtils.isNotBlank(iteraAutomationModel.getAddress())) {
                    driver.findElement(userAddress).sendKeys(Helper.property().getProperty("address"));
                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void submitButton() {
        driver.findElement(submitButton).click();
        try {
            this.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriverQuit();
    }

    public void femaleRadioButton() {
        webDriverStart();
        driver.findElement(femaleRadioButton).click();
    }

    public synchronized void checkboxes() {
        driver.findElement(tuesdayCheckbox).click();
        driver.findElement(fridayCheckbox).click();
        try {
            this.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriverQuit();
    }

    public Select dropdown() {
        webDriverStart();
        placesDropdownValue = driver.findElement(placesDropdown);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        return new Select(placesDropdownValue);
    }

    public void yearsOfExperience() {
        webDriverStart();
        driver.findElement(years).click();
    }

    public synchronized void automationTools() {
        driver.findElement(seleniumWebdriver).click();
        driver.findElement(testng).click();
        try {
            this.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriverQuit();
    }

    public synchronized void uploadImage(List<IteraAutomationModel> iteraAutomationModelList) {
        webDriverStart();
        try {
            for (IteraAutomationModel iteraAutomationModel : iteraAutomationModelList) {
                if (StringUtils.isNotBlank(iteraAutomationModel.getImage())) {
                    image = iteraAutomationModel.getImage();
                    try {
                        driver.findElement(file).sendKeys(getResourceDir() + File.separator + "images" + File.separator + iteraAutomationModel.getImage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriverQuit();
    }
}

