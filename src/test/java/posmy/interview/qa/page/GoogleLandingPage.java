package posmy.interview.qa.page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.coronium.page.AutoPage;
import org.coronium.page.core.ui.pages.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

import static org.junit.Assert.assertEquals;

public class GoogleLandingPage extends AutoPage<GoogleLandingPage> {

    @Name("Search box")
    @FindBy(css = "input[title='Search']")
    private WebElement searchBox;

    @Name("Google search button")
    @FindBy(css = "center:nth-child(1) > .gNO89b")
    private WebElement googleSearchButton;


    @Step("Is searchbox displayed")
    public boolean searchboxIsDisplayed(){
        /*driver.findElement(By.cssSelector("input[title='Search']"))
                .isDisplayed();*/
        searchBox.isDisplayed();
        return true;
    }

    @Step("Set search value")
   public void setSearch(String cases){
        searchBox.sendKeys(cases);
        searchBox.sendKeys(Keys.TAB);
        /*driver.findElement(By.cssSelector("input[title='Search']"))
                .sendKeys(COVID_19);
        //Tab: to close search history dropdown
        driver.findElement(By.cssSelector("input[title='Search']"))
                .sendKeys(Keys.TAB);*/

    }

    @Step("Click Google Search button")
    public void clickGoogleSearchButton(){
      /*  driver.findElement(By.cssSelector("center:nth-child(1) > .gNO89b"))
                .click();*/
        googleSearchButton.click();
    }








}
