import io.cucumber.testng.*;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/features/Web",
        glue = {"stepDefinitions"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
