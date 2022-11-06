package WebUI.pageobjects;

import WebUI.utils.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
    }

    @FindBy(how = How.XPATH, using = "//*[@class='m-orderSummary__item']//*[@class='m-orderSummary__value']")
    public WebElement span_summary__Value;

    @FindBy(how = How.XPATH, using = "//*[@class='m-orderSummary__item -grandTotal']//*[@class='m-orderSummary__value']")
    public WebElement span_grandTotal;

    @FindBy(how = How.XPATH, using = "//select[contains(@id,'quantitySelect')]")
    public WebElement select_quantitySelect;

    @FindBy(how = How.XPATH, using = "//button[contains(@id,'removeCartItem')]")
    public WebElement btn_removeCartItem;

    @FindBy(how = How.XPATH, using = "//strong[contains(@class,'m-empty__messageTitle')]")
    public WebElement text_empty__messageTitle;

    public void open() {
        DriverFactory.getInstance().getDriver().get("https://www.beymen.com/cart");
    }

}
