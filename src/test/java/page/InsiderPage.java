package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.Useinsider;
import utilities.Driver;

public class InsiderPage {

    public InsiderPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='Accept All']")
    public WebElement cookiesAcceptAllElement;

    @FindBy(xpath = "//span[.='More']")
    public WebElement moreMenuElement;

    @FindBy(xpath = "//h5[.='Careers']")
    public  WebElement careersElement;

    @FindBy(xpath ="//h3[@class='category-title-media ml-0']")
    public WebElement ourLocationsElement;

    @FindBy(xpath = "//h2[.='Life at Insider']")
    public  WebElement lifeAtInsiderElement;

    @FindBy(xpath = "//a[.='See all teams']")
    public WebElement seeAllTeamsElement;

    @FindBy(xpath = "(//img[@class='img-fluid mx-auto'])[12]")
    public  WebElement qualityAssuranceElement;

    @FindBy(xpath = "//a[.='See all QA jobs']")
    public WebElement seeAllQAJobsButtonElement;

    @FindBy(xpath = "//select[@name='filter-by-location']")
    public WebElement locationDropdownElement;

    @FindBy(xpath = "//select[@name='filter-by-department']")
    public WebElement departmenrDropdownElement;

    @FindBy(xpath = "(//div[@class='position-list-item-wrapper bg-light'])[1]")
    public WebElement applyNowDivElement;

    @FindBy(xpath = "(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5'])[1]")
    public WebElement applyNowButtonElement;























}
