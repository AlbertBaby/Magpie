package stepDefinition;

import io.cucumber.java.en.And;
import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class WebStepDef {

    @DataProvider(parallel = true)
    @And("User searches for a product")
    public Iterator<Object[]> searchWithString(String searchTerm){

        return null;
    }
}
