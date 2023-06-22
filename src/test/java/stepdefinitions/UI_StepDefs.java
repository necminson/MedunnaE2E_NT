package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.Select;
import pages.MedunnaHomePage;
import pages.MedunnaLoginPage;
import pages.MedunnaRoomPage;
import utils.Driver;
import utils.WaitUtils;

import static org.junit.Assert.assertTrue;

public class UI_StepDefs {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    MedunnaLoginPage medunnaLoginPage = new MedunnaLoginPage();
    MedunnaRoomPage medunnaRoomPage = new MedunnaRoomPage();
    public static String  roomId;
    public static int fakeRoomNumber;
    @Given("user goes to {string}")
    public void user_goes_to(String url) {

        Driver.getDriver().get(url);
    }
    @When("user clicks on user icon")
    public void user_clicks_on_user_icon() {

        medunnaHomePage.userIcon.click();
        WaitUtils.waitFor(1);

    }
    @When("user clicks on sign in link")
    public void user_clicks_on_sign_in_link() {

        medunnaHomePage.signInLink.click();
        WaitUtils.waitFor(1);

    }
    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {

        medunnaLoginPage.username.sendKeys(username);
        WaitUtils.waitFor(1);
        medunnaLoginPage.password.sendKeys(password);
        WaitUtils.waitFor(1);

    }


    @When("user clicks on sign in submit button")
    public void user_clicks_on_sign_in_submit_button() {

        medunnaLoginPage.signInSubmitButton.click();
        WaitUtils.waitFor(1);

    }

    @Given("user clicks on ItemsAndTitles dropdown")
    public void user_clicks_on_items_and_titles_dropdown() {

        medunnaHomePage.itemsAndTitlesDropDown.click();
        WaitUtils.waitFor(1);

    }
    @When("user clicks on Room link")
    public void user_clicks_on_room_link() {

        medunnaHomePage.roomLink.click();
        WaitUtils.waitFor(1);

    }


    @When("user clicks on Create a new room link")
    public void user_clicks_on_create_a_new_room_link() {

        medunnaRoomPage.createNewRoomLink.click();
        WaitUtils.waitFor(1);

    }

    @When("user selects {string}")
    public void user_selects(String roomType) {

        new Select(medunnaRoomPage.roomTypeDropdown).selectByVisibleText(roomType);
        WaitUtils.waitFor(1);

    }
    @When("user clicks on Status")
    public void user_clicks_on_status() {

        medunnaRoomPage.roomStatusCheckBox.click();
        WaitUtils.waitFor(1);

    }
    @And("user enters Room Number {string}")
    public void userEntersRoomNumber(String roomNumber) {

        fakeRoomNumber = new Faker().number().numberBetween(100000,1000000);
        medunnaRoomPage.roomNumber.sendKeys(fakeRoomNumber+"");
        WaitUtils.waitFor(1);

    }

    @And("user enters Price {string}")
    public void userEntersPrice(String price) {

        medunnaRoomPage.roomPrice.sendKeys(price);
        WaitUtils.waitFor(1);

    }

    @And("user enters Description {string}")
    public void userEntersDescription(String description) {

        medunnaRoomPage.roomDescription.sendKeys(description);
        WaitUtils.waitFor(1);

    }


    @When("user clicks on Save button")
    public void user_clicks_on_save_button() {

        medunnaRoomPage.saveButton.submit();
        WaitUtils.waitFor(1);

    }
    @Then("assert the alert")
    public void assert_the_alert() {

        assertTrue(medunnaRoomPage.alert.getText().contains("A new Room is created"));

        roomId = medunnaRoomPage.alert.getText().replaceAll("[^0-9]","");

    }
    @Then("close application")
    public void close_application() {

        WaitUtils.waitFor(3);
        Driver.closeDriver();

    }


}