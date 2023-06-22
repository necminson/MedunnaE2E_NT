package hooks;

import io.cucumber.java.Before;

import static base_urls.MedunnaBaseUrl.setSpec;

public class Hooks {

    @Before("@api_test")//This method will run before each api tests
    public void beforeApi(){

        setSpec();

    }

}