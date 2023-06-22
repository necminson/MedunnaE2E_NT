package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static stepdefinitions.UI_StepDefs.fakeRoomNumber;
import static stepdefinitions.UI_StepDefs.roomId;


public class API_StepDefs {
    Response response;

    @Given("send get request")
    public void send_get_request() {
        //Set the url
        //https://medunna.com/api/rooms/63234
        spec.pathParams("first", "api", "second", "rooms", "third", roomId);

        //Send the request and get the response
        response = given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

    }

    @Then("validate body")
    public void validate_body() {

        response
                .then()
                .statusCode(200)
                .body("roomNumber", equalTo(fakeRoomNumber),
                        "roomType",equalTo("DAYCARE"),
                        "status",equalTo(true),
                        "price",equalTo(222.0F),
                        "description",equalTo("Created For E2E Test 1") );

    }

}