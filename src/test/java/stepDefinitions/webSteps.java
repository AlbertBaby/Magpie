package stepDefinitions;

import io.cucumber.java.en.Given;

public class webSteps {

    @Given("^user navigates to application$")
    public void userApplicationNavigation(){

        System.out.println("Inside step");
    }
}
