package posmy.interview.qa.page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.coronium.page.AutoPage;
import org.coronium.page.core.ui.annotations.Visible;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends AutoPage<ResultPage> {

    @Visible
    @Name("Result Page - Total matching results")
    @FindBy(css = "div#result-stats")
    private WebElement totalMatchingResults;

    @Name("Top Stories Section")
    @FindBy(css = "[data-hveid='CAQQAA']")
    private WebElement topStoriesSection;

    @Name("Common Question Section")
    @FindBy(css = "#kp-wp-tab-HealthStats div.ifM9O h2")
    private WebElement commonQuestionSect;

    @Name("Top Stories")
    @FindBy(css = "a[role='heading link']")
    private WebElement topStoriesLink;

    @Name("List of Covid 19 Stories")
    @FindBy(css = "[decode-data-ved='1'] g-card")
    private List<WebElement> listCovidStories;

    @Name("List of Covid 19 Stories Title ")
    @FindBy(css = "[decode-data-ved='1'] g-card div[role='heading']")
    private List<WebElement> listCovidStoriesTitle;

    @Step("Total matching result is displayed")
    public boolean totalMatchingResultsIsDisplayed(){
        /*driver.findElement(By.cssSelector("div#result-stats"))
                .isDisplayed();*/
        return totalMatchingResults.isDisplayed();
    }

    @Step("Top Stories Section is displayed")
    public boolean topStoriesSectionIsDisplayed(){
       /* driver.findElement(By.cssSelector("[data-hveid='CAQQAA']"))
                .isDisplayed();*/
        return topStoriesSection.isDisplayed();
    }

   @Step("Get common question header")
    public String getCommonQuestionHeader(){
        //Common Question header
       return commonQuestionSect.getText();
        /*String expectedAnswer = "Common questions";
        driver.findElement(By.cssSelector("#kp-wp-tab-HealthStats div.ifM9O h2"))
                .isDisplayed();
        //assertEquals(expectedAnswer, actualAnswer);

        driver.findElement(By.id("_T-gQYN60OsWLmge84proBw1602"))
                .isDisplayed();*/
    }

    @Step("Click Top Stories Link")
    public void clickTopStoriesLink(){
        topStoriesLink.click();
    }

    @Step("Get First Story title")
    public String getFirstStoryTitle(){
       String title =  listCovidStoriesTitle.stream()
               .map(e->e.getText())
               .findFirst()
               .orElseThrow(()-> new NoSuchElementException("Element not found"));

       return title;
    }

    @Step("Select first story")
    public void selectFirstStory(){
        listCovidStories.stream()
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("No matching found"))
                .click();
       /* driver.findElement(By.linkText("Top stories"))
                .click();

        //Click first result for Top Result
        driver.findElements(By.cssSelector("[decode-data-ved='1'] g-card"))
                .stream()
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("No matching found"))
                .click();*/
    }
}
