package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductListPage;
import utils.DataDriven;
import utils.PropertiesDriven;
import java.util.ArrayList;

public class Tests {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ProductListPage productListPage;
    private ArrayList<String> dataCPs;


    @AfterMethod
    public void preparacionPrueba() {
        loginPage.cerrarBrowser();
    }

    @BeforeMethod
    public void posPrueba() {
        dataCPs = new ArrayList<String>();
        homePage = new HomePage(driver);
        homePage.conexionDriver(PropertiesDriven.getProperty("browser"));

        loginPage = new LoginPage(homePage.getDriver());
        productListPage = new ProductListPage(homePage.getDriver());

        homePage.cargarSitio(PropertiesDriven.getProperty("url"));
        homePage.maximizarBrowser();
    }

    @Test
    public void CP001_login_fallido(){
        dataCPs= DataDriven.getData("CP001_login_fallido");
        loginPage.iniciarSesion(dataCPs.get(1),dataCPs.get(2));
        Assert.assertEquals(loginPage.obtenerErrorLogin(),dataCPs.get(3));
    }

    @Test
    public void CP002_login_exitoso(){
        dataCPs= DataDriven.getData("CP002_login_exitoso");
        loginPage.iniciarSesion(dataCPs.get(1),dataCPs.get(2));
        Assert.assertEquals(homePage.obtenerTextoAlert(),dataCPs.get(3));
    }

    @Test
    public void CP003_Catalogo(){
        dataCPs= DataDriven.getData("CP003_Catalogo");
        loginPage.iniciarSesion(dataCPs.get(1),dataCPs.get(2));
        homePage.irCatalog();
        homePage.irProduct();
        productListPage.irSearch(dataCPs.get(3));
        homePage.scrollPageVerticalBottom();
        Assert.assertEquals(productListPage.obtenerListVerificacion(),dataCPs.get(4));
    }

    @Test
    public void CP004_Products_editar() throws Exception {
        this.genericStepsSearchScroll("CP004_Products_editar");
        productListPage.irEditar();
        homePage.scrollPageVerticalBottom();
        Assert.assertEquals(productListPage.obtenerTextEditVerificacion(),dataCPs.get(4));
    }

    @Test
    public void CP005_Import_Product() throws Exception {
        this.genericStepsProducts("CP005_Import_Product");
        productListPage.errorProducto();
        Assert.assertEquals(productListPage.obtenerTextoError(),dataCPs.get(3));
    }


    @Test
    public void CP006_New_producto_save() throws Exception {
        this.genericStepsProducts("CP006_New_producto_save");
        productListPage.irAddProducts();
        productListPage.irAddProductSave();
        Assert.assertEquals(productListPage.obtenerTextoErrorAdd(),dataCPs.get(3));
    }

    @Test
    public void CP007_New_producto_Settings() throws Exception {
        this.genericStepsProducts("CP007_New_producto_Settings");
        productListPage.irAddProducts();
        productListPage.irSetting();
        Assert.assertEquals(productListPage.obtenerTextorSetting(),dataCPs.get(3));
    }

    @Test
    public void CP008_New_producto_SaveConti () throws Exception {
        this.genericStepsProducts("CP008_New_producto_SaveConti");
        productListPage.irAddProducts();
        productListPage.saveContinue(dataCPs.get(4));
        Assert.assertEquals(productListPage.obtenerTextoAlert(),dataCPs.get(3));
    }

    // ----- Se crea un metodo generico para agregar solo una linea en cada test --//
    public void genericStepsProducts(String caso){
        dataCPs= DataDriven.getData(caso);
        loginPage.iniciarSesion(dataCPs.get(1),dataCPs.get(2));
        homePage.irCatalog();
        homePage.irProduct();
    }

    public void genericStepsSearchScroll(String caso){
        dataCPs= DataDriven.getData(caso);
        loginPage.iniciarSesion(dataCPs.get(1),dataCPs.get(2));
        homePage.irCatalog();
        homePage.irProduct();
        productListPage.irSearch(dataCPs.get(3));
        homePage.scrollPageVerticalBottom();
    }

}
