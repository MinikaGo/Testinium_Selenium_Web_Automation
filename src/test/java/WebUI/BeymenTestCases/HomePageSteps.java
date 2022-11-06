package WebUI.BeymenTestCases;

import WebUI.pageobjects.CartPage;
import WebUI.pageobjects.HomePage;
import WebUI.pageobjects.ProductPage;
import WebUI.utils.BrowserFactory;
import WebUI.utils.ConfigReader;
import WebUI.utils.DriverFactory;
import common.operations.ExcelReader;
import common.operations.TextFileOperations;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.time.Duration;


public class HomePageSteps extends AbstractStep {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @BeforeAll
    static void setupClass() {
        BrowserFactory bf = new BrowserFactory();
        DriverFactory.getInstance().setDriver(bf.createBrowserInstance());
        DriverFactory.getInstance().getDriver();
        DriverFactory.getInstance().getDriver().manage().window().maximize();
        DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @BeforeEach
    void setupTest() {

    }

    @AfterEach
    void teardown() {
        DriverFactory.getInstance().closeBrowser();
    }

    @Test
    public void beymenTest() throws InterruptedException, IOException {


        // Kullanici "https://www.beymen.com" sayfasina gider.
        homePage.open(ConfigReader.getProperties("beymen.com.url"));
        waitForPageReload();
        Thread.sleep(650);

        //Cookie pop-up açılması olasılığında kabul butonuna basılır - Ümit Sinanoğlu
        click(homePage.btn_acceptCookies);
        Thread.sleep(650);

        //- Ana sayfanın açıldığı kontrol edilir.
        Assertions.assertTrue(homePage.getCommonLogo().isDisplayed(), "Beymen.com Ana sayfa açılmalıdır. ");

        //- Arama kutucuğuna “şort” kelimesi girilir.(Not = Şort kelimesi excel dosyası
        //üzerinden 1 sütun 1 satırdan alınarak yazılmalıdır. )
        sendKeys(homePage.txtbx_searchBox, (ExcelReader.getCellValue(0)));
        Thread.sleep(650);

        //- Arama kutucuğuna girilen “şort” kelimesi silinir.
        clear(homePage.txtbx_searchBox);
        Thread.sleep(650);

        //- Arama kutucuğuna “gömlek” kelimesi girilir.(Not = Gömlek kelimesi excel dosyası
        //üzerinden 2 sütun 1 satırdan alınarak yazılmalıdır. )
        sendKeys(homePage.txtbx_searchBox, (ExcelReader.getCellValue(1)));
        Thread.sleep(650);

        //- Klavye üzerinden “enter” tuşuna bastırılır
        sendEnterButtonAction(homePage.txtbx_searchBox);
        Thread.sleep(650);

        //- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
        homePage.selectRandomProduct();
        Thread.sleep(650);

        //        - Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.
        productPage.saveProductDetailsToTextFile();

        //        - Seçilen ürün sepete eklenir.
        productPage.addSelectedProductToBasket();
        Thread.sleep(650);

        //        - Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
        cartPage.open();
        Thread.sleep(650);
        Assertions.assertEquals(TextFileOperations.getProductPrice(), cartPage.span_summary__Value.getText());

        //- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        selectElementFromDropDown(cartPage.select_quantitySelect, "2 adet");
        Thread.sleep(1000);

        //- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir
        click(cartPage.btn_removeCartItem);
        Thread.sleep(650);
        Assertions.assertEquals("SEPETINIZDE ÜRÜN BULUNMAMAKTADIR", cartPage.text_empty__messageTitle.getText());

    }
}
