package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class HomePage extends BaseClass {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By locatorBtnIniciarSesion = By.xpath("//button[contains(text(),'Log in')]");
    By locatorBtnCatalog = By.xpath("//body/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/p[1]/i[1]");
    By locatorBtnProducts = By.xpath("//body/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]");
    By locatorTextHome = By.xpath("//h1[contains(text(),'Dashboard')]");

    //Acciones menu catalogo
    public void irCatalog(){
        click(esperaExplicita(locatorBtnCatalog));
    }
    public void irProduct(){
        //esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnProducts));
        //esperarXSegundos(3000);
    }

    public String obtenerTextoAlert(){
        return obtenerTexto(esperaExplicita(locatorTextHome));
    }

}
