package pkg.step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pkg.models.IteraAutomationModel;
import pkg.pageobjects.IteraAutomationPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static pkg.helpers.Helper.driver;
import static pkg.helpers.Helper.webDriverQuit;

public class IteraAutomationSteps {
    IteraAutomationPage iteraAutomationPage = new IteraAutomationPage();

    @When("^User enters all the valid details in the given textfields$")
    public void userEntersAllTheValidDetailsInTheGivenTextfields(List<IteraAutomationModel> iteraAutomationModelList) {
        iteraAutomationPage.enterUserDetails(iteraAutomationModelList);
    }

    @And("^User clicks on submit button in textarea practice section$")
    public void userClicksOnSubmitButtonInTextareaPracticeSection() {
        iteraAutomationPage.submitButton();
    }

    @When("^User selects female radio button in gender field$")
    public void userSelectsFemaleRadioButtonInGenderField() {
        iteraAutomationPage.femaleRadioButton();
    }

    @And("^User selects tuesday and friday checkbox in days field$")
    public void userSelectsTuesdayAndFridayCheckboxInDaysField() {
        iteraAutomationPage.checkboxes();
    }

    @When("^User selects \"([^\"]*)\" in destination dropdown$")
    public void userSelectsInDestinationDropdown(String text) {
        iteraAutomationPage.dropdown().selectByVisibleText(text);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        webDriverQuit();
    }

    @When("^User selects two years of experience in test automation$")
    public void userSelectsTwoYearsOfExperienceInTestAutomation() {
        iteraAutomationPage.yearsOfExperience();
    }

    @And("^User selects selenium webdriver and testng automation tools$")
    public void userSelectsSeleniumWebdriverAndTestngAutomationTools() {
        iteraAutomationPage.automationTools();
    }

    @When("^User browses and uploads valid file in file input section$")
    public void userBrowsesAndUploadsValidFileInFileInputSection(List<IteraAutomationModel> iteraAutomationModelList) {
        iteraAutomationPage.uploadImage(iteraAutomationModelList);
    }
}

