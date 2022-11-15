package pkg.pageobjects;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import pkg.helpers.Helper;
import pkg.models.PlaceOrderModel;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static pkg.helpers.Helper.*;

public class PlaceOrderPage {
    private static final By womenSection = By.xpath("//span[text()='Women']");
    private static final By topSection = By.xpath("//a[contains(text(),'Tops')]");
    private static final By size = By.xpath("//div[@class='swatch-opt-1812']//div[@id='option-label-size-143-item-167']");
    private static final By color = By.xpath("//div[@class='swatch-opt-1812']//div[@id='option-label-color-93-item-57']");
    private static final By addCart = By.xpath("/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[4]/div[1]/div[1]/form[1]/button[1]/span[1]");
    private static final By proceedToCheckOut = By.xpath("//button[@id='top-cart-btn-checkout']");
    private static final By cart = By.xpath("//a[@class='action showcart']");
    private static final By email = By.xpath("//div[@class='control _with-tooltip']//input[@id='customer-email']");
    private static final By firstName = By.xpath("//input[@name='firstname']");
    private static final By lastName = By.xpath("//input[@name='lastname']");
    private static final By company = By.xpath("//input[@name='company']");
    private static final By street = By.xpath("//input[@name='street[0]']");
    private static final By city = By.xpath("//input[@name='city']");
    private static final By zipCode = By.xpath("//input[@name='postcode']");
    private static final By phoneNumber = By.xpath("//input[@name='telephone']");
    private static final By state = By.xpath("//select[@name='region_id']/option[text()='Arizona']");
    private static final By country = By.xpath("//select[@name='country_id']/option[text()='United Kingdom']");
    private static final By shipping = By.xpath("//input[@name='ko_unique_1']");
    private static final By nextButton = By.xpath("//button[@class='button action continue primary']/span");
    private static final By placeOrder = By.xpath("//button[@title='Place Order']/span");
    private static final By message = By.xpath("//span[@data-ui-id='page-title-wrapper']");


    public void womenSection() {
        webDriverStart();
        driver.findElement(womenSection).click();
    }

    public void topSection() {
        driver.findElement(topSection).click();
    }

    public void selectSizeAndColor() {
        driver.findElement(size).click();
        driver.findElement(color).click();
    }

    public void addCart() {
        driver.findElement(addCart).click();
    }

    public void cart() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(cart).click();
    }

    public void checkout() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(proceedToCheckOut).click();

    }

    public void enterDetails(List<PlaceOrderModel> placeOrderModelList) {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        try {
            for (PlaceOrderModel placeOrderModel : placeOrderModelList) {
                if (StringUtils.isNotBlank(placeOrderModel.getEmailAddress())) {
                    driver.findElement(email).sendKeys(Helper.randomEmailAddress(5));
                }
                if (StringUtils.isNotBlank(placeOrderModel.getFirstName())) {
                    driver.findElement(firstName).sendKeys(Helper.randomAlphabetic(5));
                }
                if (StringUtils.isNotBlank(placeOrderModel.getLastName())) {
                    driver.findElement(lastName).sendKeys(Helper.randomAlphabetic(5));
                }
                if (StringUtils.isNotBlank(placeOrderModel.getCompany())) {
                    driver.findElement(company).sendKeys(Helper.randomAlphabetic(7));
                }
                if (StringUtils.isNotBlank(placeOrderModel.getStreetAddress())) {
                    driver.findElement(street).sendKeys(Helper.randomAlphabetic(10));
                }
                if (StringUtils.isNotBlank(placeOrderModel.getCity())) {
                    driver.findElement(city).sendKeys(Helper.randomAlphabetic(6));
                }
                if (StringUtils.isNotBlank(placeOrderModel.getPostalCode())) {
                    driver.findElement(zipCode).sendKeys(Helper.randomInteger(4));
                }
                if (StringUtils.isNotBlank(placeOrderModel.getPhoneNumber())) {
                    driver.findElement(phoneNumber).sendKeys(Helper.randomInteger(9));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void state() {
        driver.findElement(state).click();

    }

    public void country() {
        driver.findElement(country).click();

    }

    public void shippingMethod() {
        driver.findElement(shipping).click();

    }

    public void submit() {
        driver.findElement(nextButton).click();

    }

    public void placeOrder() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(placeOrder).click();

    }

    public void successfullyPlacedOrder() throws InterruptedException {

        String expected = "Thank you for your purchase!";
        String actual = driver.findElement(message).getText();

        Assert.assertEquals(actual, expected);
        webDriverQuit();
    }

}
