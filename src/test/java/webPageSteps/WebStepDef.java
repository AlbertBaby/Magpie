package webPageSteps;

import io.cucumber.java.en.Given;

public class WebStepDef {

    @Given("^user navigates to application$")
    public void userApplicationNavigation(){
        System.out.println("Inside step");
    }
}
