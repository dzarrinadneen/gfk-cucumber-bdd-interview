package posmy.interview.qa;

import io.cucumber.testng.*;
import org.junit.jupiter.api.Test;
import org.testng.annotations.Listeners;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
@Listeners()
@CucumberOptions(
        features = {"src/test/resources/features/"},
        tags = "not @ignore and not @api",
        plugin = {
                "pretty", // pretty console logging
                "json:target/json/cucumber-results.json", // json results file
                "listener.CukeScreenshotListener"
        },
        // NB: change these to match your glue packages.
        glue = {"dzarrinadneen/gfk-cucumber-bdd-interview"})
public class AppTest extends AbstractTestNGCucumberTests {

    @Test
    public void shouldAnswerWithTrue() {
        //method
        assertTrue( true );


    }


}
