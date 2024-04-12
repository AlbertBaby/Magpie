import io.cucumber.testng.*;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/features/Web",
        glue = {"webPageSteps"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
