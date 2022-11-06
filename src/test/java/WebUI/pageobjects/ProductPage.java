package WebUI.pageobjects;

import WebUI.utils.DriverFactory;
import common.operations.TextFileOperations;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
    }

    @FindBy(how = How.XPATH, using = "//h1[@class='o-productDetail__title']//a")
    public WebElement h1_productDetail__title;

    @FindBy(how = How.XPATH, using = "//h1[@class='o-productDetail__title']//span")
    public WebElement h1_productDetail__description;

    @FindBy(how = How.XPATH, using = "//div[@class='m-price__list']//ins[@id='priceNew']")
    public WebElement h1_productPrice;

    @FindBy(how = How.XPATH, using = "//a[@title='Sepetim']")
    public WebElement a_myBasket;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class='m-variation']//span[not(contains(@class,'disabled'))]"))
    public List<WebElement> variationsList;

    @FindBy(how = How.XPATH, using = "//button[@id='addBasket']")
    public WebElement btn_addBasket;

    private Random random = new Random();

    public void saveProductDetailsToTextFile() throws IOException {

        String productName = h1_productDetail__title.getText();
        String productDescription = h1_productDetail__description.getText();
        String productPrice = h1_productPrice.getText();

        TextFileOperations.writeToTextFile(productName, productDescription, productPrice);

    }

    public void addSelectedProductToBasket() {
        try {
            WebElement selectedVariation = variationsList.get(random.nextInt(variationsList.size()));
            selectedVariation.click();
            btn_addBasket.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

}
