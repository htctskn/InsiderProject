package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.InsiderPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class Useinsider {


    InsiderPage insiderPage=new InsiderPage();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void useinsiderTest() throws InterruptedException, IOException {


    //1. Visit https://useinsider.com/ and check Insider home page is opened or not
        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        String expectedUrl="https://useinsider.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Insider home page is not");

        insiderPage.cookiesAcceptAllElement.click();


    //2. Select “More” menu in navigation bar, select “Careers” and check Career page, its
    //Locations, Teams and Life at Insider blocks are opened or not
        insiderPage.moreMenuElement.click();
        Thread.sleep(2000);
        insiderPage.careersElement.click();

        ReusableMethods.waitForVisibility(insiderPage.ourLocationsElement,5);
        insiderPage.ourLocationsElement.isDisplayed();

        ReusableMethods.waitForVisibility(insiderPage.lifeAtInsiderElement,5).isDisplayed();


    //3. Click “See All Teams”, select Quality Assurance, click “See all QA jobs”, filter jobs by
    //Location - Istanbul, Turkey and department - Quality Assurance, check presence of  jobs list
        /*ReusableMethods.waitForVisibility(insiderPage.seeAllTeamsElement,6);
        ReusableMethods.waitFor(3);
        insiderPage.seeAllTeamsElement.click();*/

        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        insiderPage.seeAllTeamsElement.click();


       actions//.sendKeys(Keys.PAGE_DOWN)
               .sendKeys(Keys.ARROW_DOWN)
                //.sendKeys(Keys.ARROW_UP)
                .perform();
       Thread.sleep(2000);
       Driver.waitAndClick(insiderPage.qualityAssuranceElement);

       insiderPage.seeAllQAJobsButtonElement.click();

       Select select=new Select(insiderPage.locationDropdownElement);
       select.selectByVisibleText("Istanbul, Turkey");

       Select select1=new Select(insiderPage.departmenrDropdownElement);
       select1.selectByVisibleText("Quality Assurance");


    //4. Check that all jobs’ Position contains “Quality Assurance”, Department contains
    //“Quality Assurance”, Location contains “Istanbul, Turkey” and “Apply Now” button

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        ReusableMethods.hover(insiderPage.applyNowDivElement);

        ReusableMethods.getScreenshot("screenshot");


    //5. Click “Apply Now” button and check that this action redirects us to Lever Application
        insiderPage.applyNowButtonElement.click();
        Thread.sleep(2000);
        ReusableMethods.switchToWindow("https://jobs.lever.co/useinsider/0ba4065b-955a-4661-ad4a-f32479f63757");

        String expectedUrll="https://jobs.lever.co/useinsider/0ba4065b-955a-4661-ad4a-f32479f63757";
        String actualUrll=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrll,expectedUrll,"Failed to navigate to the requested page");

        Thread.sleep(2000);
        Driver.getDriver().quit();


    }


}
