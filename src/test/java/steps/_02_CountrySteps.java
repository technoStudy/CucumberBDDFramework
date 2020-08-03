package steps;

import cucumber.api.java.en.*;
import org.testng.Assert;
import poms.CountryPOM;
import poms.MenuPOM;

public class _02_CountrySteps {

    CountryPOM countryPage;

    @Given("^I navigate to country screen$")
    public void i_navigate_to_country_screen()  {
        countryPage =new CountryPOM();
        MenuPOM menu = new MenuPOM();
        menu.waitAndClick(menu.setupMenuLocator);
        menu.waitAndClick(menu.parametersMenuLocator);
        menu.waitAndClick(menu.countriesMenuLocator);

    }

    @When("^I create a country$")
    public void i_create_a_country()  {
        countryPage.waitAndClick(countryPage.createButtonLocator);
        countryPage.waitAndSendKeys(countryPage.nameInputLocator, "country name");
        countryPage.waitAndClick(countryPage.saveButtonLocator);
    }

    @Then("^country is successfully created$")
    public void country_is_successfully_created()  {
        String actual = countryPage.waitForNewAndGetText(countryPage.alertDialogLocator);
        Assert.assertEquals(actual, "Country successfully created");
    }

    @When("^I create \"([^\"]*)\" country$")
    public void i_create_country(String countryName) {
        countryPage.waitAndClick(countryPage.createButtonLocator);
        countryPage.waitAndSendKeys(countryPage.nameInputLocator, countryName);
        countryPage.waitAndClick(countryPage.saveButtonLocator);
    }

    @When("^I edit \"([^\"]*)\" country$")
    public void i_edit_country(String countryName) {
        countryPage.waitAndClick(countryPage.editButtonLocator);
        countryPage.waitAndSendKeys(countryPage.nameInputLocator, countryName);
        countryPage.waitAndClick(countryPage.saveButtonLocator);
    }


    @When("^I edit a country$")
    public void i_edit_a_country(){
        countryPage.waitAndClick(countryPage.editButtonLocator);
        countryPage.waitAndSendKeys(countryPage.nameInputLocator, "country name");
        countryPage.waitAndClick(countryPage.saveButtonLocator);
    }

    @Then("^country is successfully edited$")
    public void country_is_successfully_edited() {
        String actual = countryPage.waitForNewAndGetText(countryPage.alertDialogLocator);
        Assert.assertEquals(actual, "Country successfully updated");
    }

    @When("^I delete a country$")
    public void i_delete_a_country()  {
        countryPage.waitAndClick(countryPage.deleteButtonLocator);
        countryPage.waitAndClick(countryPage.dialogSubmitButtonLocator);
    }

    @Then("^country is successfully deleted$")
    public void country_is_successfully_deleted() {
        String actual = countryPage.waitForNewAndGetText(countryPage.alertDialogLocator);
        Assert.assertEquals(actual, "Country successfully deleted");
        // TODO: the list doesn't contain the country that we deleted
    }

    @And("^\"([^\"]*)\" country doesn't exist$")
    public void countryDoesnTExist(String countryName) {
        countryPage.waitAndSendKeys(countryPage.nameSearchLocator, countryName);
        countryPage.waitAndClick(countryPage.searchButtonLocator);
        countryPage.waitForProgressBar();

        countryPage.deleteAllElementsFromTable();
    }


    @When("^I edit  \"([^\"]*)\" to \"([^\"]*)\" country$")
    public void iEditToCountry(String oldCountry, String newCountry) {
        countryPage.waitAndSendKeys(countryPage.nameSearchLocator, oldCountry);
        countryPage.waitAndClick(countryPage.searchButtonLocator);

        countryPage.waitForProgressBar();

        countryPage.waitAndClick(countryPage.editButtonLocator);
        countryPage.waitAndSendKeys(countryPage.nameInputLocator, newCountry);
        countryPage.waitAndClick(countryPage.saveButtonLocator);
    }

    @When("^I delete \"([^\"]*)\" country$")
    public void iDeleteCountry(String countryName) throws Throwable {
        countryPage.waitAndSendKeys(countryPage.nameSearchLocator, countryName);
        countryPage.waitAndClick(countryPage.searchButtonLocator);

        countryPage.waitForProgressBar();

        countryPage.waitAndClick(countryPage.deleteButtonLocator);
        countryPage.waitAndClick(countryPage.dialogSubmitButtonLocator);
    }
}