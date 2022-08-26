package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BaseClass;


public class ProductListPage extends BaseClass {

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    By locatorTxtProducto= By.xpath("//input[@id='SearchProductName']");
    By locatorBtnSearchProd = By.xpath("//button[@id='search-products']");
    By locatorBtnEditar = By.xpath("//tbody/tr[1]/td[8]/a[1]");
    By locatorBtnImport= By.xpath("//body/div[3]/div[1]/form[1]/div[1]/div[1]/button[2]");
    By locatorBtnImportExcel= By.xpath("//button[contains(text(),'Import from Excel')]");
    By locatorLblSecurity= By.xpath("//body/div[3]/div[1]/div[1]");
    By locatorBtnAddnew= By.xpath("//body/div[3]/div[1]/form[1]/div[1]/div[1]/a[1]");
    By locatorBtnSave= By.xpath("//body/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]");
    By locatorLblErrorSaveproduct= By.xpath("//li[contains(text(),'Please provide a name.')]");
    By locatorBtnSettings= By.xpath("//button[@id='product-editor-settings']");
    By locatorCheckProd= By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
    By locatorBtnsaveSetting= By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/button[1]");
    By locatorLblErrorSetting= By.xpath("//body/div[3]/div[1]/div[1]");
    By locatorTxtProductName= By.xpath("//input[@id='Name']");
    By locatorBtnSaveConti= By.xpath("//body/div[3]/div[1]/form[1]/div[1]/div[1]/button[2]");
    By locatorLblalert= By.xpath("//body/div[3]/div[1]/div[1]");
    By locatorListVeri= By.xpath("//td[contains(text(),'Apple MacBook Pro 13-inch')]");
    By locatorTxtEditVeri= By.xpath("//a[contains(text(),'back to product list')]");


    //Acciones de la pagina
    public void irSearch(String producto){
        agregarTexto(esperaExplicita(locatorTxtProducto),producto);
        click(esperaExplicita(locatorBtnSearchProd));
    }

    public void irEditar() throws Exception {
        this.esperarXSegundos(2000);
        click(esperaExplicita(locatorBtnEditar));
    }

    public void irAddProducts() throws Exception {
        click(esperaExplicita(locatorBtnAddnew));
    }
    public void irAddProductSave() throws Exception {
        click(esperaExplicita(locatorBtnSave));
    }

    public void irSetting() throws Exception {
        click(esperaExplicita(locatorBtnSettings));
        click(esperaExplicita(locatorCheckProd));
        scrollPageVerticalBottom();
        click(esperaExplicita(locatorBtnsaveSetting));
    }
    public void saveContinue(String name){
        agregarTexto(esperaExplicita(locatorTxtProductName),name);
        click(esperaExplicita(locatorBtnSaveConti));
    }

    public void errorProducto() throws Exception {
        click(esperaExplicita(locatorBtnImport));
        //Thread.sleep(3000);
        click(esperaExplicita(locatorBtnImportExcel));
    }

    public String obtenerTextoError(){
        return obtenerTexto(esperaExplicita(locatorLblSecurity));
    }
    public String obtenerTextoErrorAdd(){
        return obtenerTexto(esperaExplicita(locatorLblErrorSaveproduct));
    }

    public String obtenerTextorSetting(){
        return obtenerTexto(esperaExplicita(locatorLblErrorSetting));
    }

    public String obtenerTextoAlert(){
        return obtenerTexto(esperaExplicita(locatorLblalert));
    }

    public String obtenerListVerificacion(){
        return obtenerTexto(esperaExplicita(locatorListVeri));
    }

    public String obtenerTextEditVerificacion(){
        return obtenerTexto(esperaExplicita(locatorTxtEditVeri));
    }

}
