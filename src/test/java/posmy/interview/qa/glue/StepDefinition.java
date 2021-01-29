package posmy.interview.qa.glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.chrome.ChromeDriver;
import posmy.interview.qa.page.GoogleLandingPage;
import posmy.interview.qa.page.NewsPage;
import posmy.interview.qa.page.ResultPage;

public class StepDefinition {

    ChromeDriver driver = new ChromeDriver();
    String googleUrl = "https://www.google.com/";

    @Given("that I am on Google")
    public void open(){
        driver.get(googleUrl);
    }

    @Then("I want to search about {word} in Malaysia")
    public void iWantToSearchAboutCovid19InMalaysia(String word){
        new GoogleLandingPage().searchboxIsDisplayed();
    }

    @Then("I will key in covid {int} in Malaysia")
    public void iWillKeyInCovid19InMalaysia(int number) {
        String COVID_19 = "covid 19 in Malaysia";
        new GoogleLandingPage()
                .setSearch(COVID_19);
    }

    @And("click on Google Search button")
    public void andClickOnGoogleSearchButton(){
        new GoogleLandingPage().clickGoogleSearchButton();
    }

    @Then("I will reach results page")
    public void iWillReachResultsPage(){
        new ResultPage().totalMatchingResultsIsDisplayed();
    }

    @Then("I will see Top stories section")
    public void iWillSeeTopStoriesSection(){
        new ResultPage().topStoriesSectionIsDisplayed();
    }

    @Then("I will see Common questions section")
    public String iWillSeeCommonQuestionsSection(){
       return new ResultPage().getCommonQuestionHeader();
    }

    @Then("I will click on first result for Top results")
    public void iWillClickFirstResultForTopResult(){
        new ResultPage().selectFirstStory();
    }

    @And("will leave Google Website")
    public void andWillLeaveGoogleWebsite(){
        new NewsPage().closeBrowser();
    }
}
