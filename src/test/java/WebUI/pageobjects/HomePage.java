package WebUI.pageobjects;

import WebUI.utils.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
    }

    @FindBy(how = How.XPATH, using = "//img[contains(@class,'header__logo')]")
    public WebElement COMMON_LOGO;

    @FindBy(how = How.XPATH, using = "//input[@class='default-input o-header__search--input']")
    public WebElement txtbx_searchBox;

    @FindBy(how = How.XPATH, using = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement btn_acceptCookies;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[contains(@class,'o-productList__itemWrapper')]"))
    public List<WebElement> productListWrapper;

    private WebElement randomElement;
    private Random random = new Random();

    public void open(String url) {
        DriverFactory.getInstance().getDriver().get(url);
    }

    public WebElement getCommonLogo() {
        return COMMON_LOGO;
    }

    public void selectRandomProduct() {
        randomElement = productListWrapper.get(random.nextInt(productListWrapper.size()));
        randomElement.click();
    }


}
