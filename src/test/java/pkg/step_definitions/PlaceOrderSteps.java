package pkg.step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pkg.models.PlaceOrderModel;
import pkg.pageobjects.PlaceOrderPage;

import java.util.List;

public class PlaceOrderSteps {
    PlaceOrderPage placeOrderPage = new PlaceOrderPage();
    @When("^User clicks on women section on home page$")
    public void userClicksOnWomenSectionOnHomePage() {
        placeOrderPage.womenSection();

    }

    @When("^User clicks on tops section under women section$")
    public void userClicksOnTopsSectionUnderWomenSection() {
        placeOrderPage.topSection();
    }

    @When("^User selects size and color on the product$")
    public void userSelectsSizeAndColorOnTheProduct() {
        placeOrderPage.selectSizeAndColor();

    }

    @When("^User clicks on add to card button on the product$")
    public void userClicksOnAddToCardButtonOnTheProduct() {
        placeOrderPage.addCart();
    }

    @When("^User clicks on cart option on home page$")
    public void userClicksOnCartOptionOnHomePage() throws InterruptedException {
        placeOrderPage.cart();
    }

    @When("^User clicks on proceed to checkout button$")
    public void userClicksOnProceedToCheckoutButton() throws InterruptedException {
        placeOrderPage.checkout();
    }

    @When("^User enters all the valid details on shipping address$")
    public void userEntersAllTheValidDetailsOnShippingAddress(List<PlaceOrderModel> placeOrderModelList) {
    placeOrderPage.enterDetails(placeOrderModelList);
    }

    @When("^User selects state on shipping address$")
    public void userSelectsStateOnShippingAddress() {
        placeOrderPage.state();
    }

    @When("^User selects country on shipping address$")
    public void userSelectsCountryOnShippingAddress() {
        placeOrderPage.country();
    }

    @When("^User selects shipping method on shipping address$")
    public void userSelectsShippingMethodOnShippingAddress() {
        placeOrderPage.shippingMethod();
    }

    @When("^User clicks on next button shipping address$")
    public void userClicksOnNextButtonShippingAddress() {
        placeOrderPage.submit();
    }

    @When("^User clicks on place order button on payment page$")
    public void userClicksOnPlaceOrderButtonOnPaymentPage() throws InterruptedException {
        placeOrderPage.placeOrder();
    }

    @Then("^User should be able to place order successfully$")
    public void userShouldBeAbleToPlaceOrderSuccessfully() throws InterruptedException {
        placeOrderPage.successfullyPlacedOrder();
    }
}
