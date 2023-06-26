package stepdefinitions;

import io.cucumber.java.en.*;
import utils.DBUtils;
import java.sql.*;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.UI_StepDefs.fakeRoomNumber;

public class DB_StepDefs {
    private Statement statement;
    private Connection connection;
    private ResultSet resultSet;

    @Given("connect to database")
    public void connect_to_database() throws SQLException {
       //connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2", "select_user", "Medunna_pass_@6");
       DBUtils.createConnection();
       //statement = connection.createStatement();
        statement =DBUtils.getStatement();

    }

    @Then("read the room and validate body")
    public void read_the_room_and_validate_body() throws SQLException {
        String query = "SELECT * FROM room WHERE room_number = " + fakeRoomNumber;
        resultSet = statement.executeQuery(query);
        resultSet.next();

        Object actRoomNumber = resultSet.getObject("room_number");
        Object actRoomType = resultSet.getObject("room_type");
        Object actStatus = resultSet.getObject("status");
        Object actPrice = resultSet.getObject("price");
        Object actDescription = resultSet.getObject("description");

        assertEquals(fakeRoomNumber, actRoomNumber);
        assertEquals("DAYCARE", actRoomType);
        assertEquals(true, actStatus);
        assertEquals("222.00", actPrice + "");
        assertEquals("Created For E2E Test 1", actDescription);

    }
}