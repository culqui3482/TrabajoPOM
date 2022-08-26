package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadore y acciones de la page
    By locatorTxtCorreo = By.xpath("//input[@id='Email']");
    By locatorTxtPassword = By.xpath("//input[@id='Password']");
    By locatorBtnLogin = By.xpath("//button[contains(text(),'Log in')]");
    By locatorLblErrorLogin = By.xpath("//li[contains(text(),'The credentials provided are incorrect')]");

    public void iniciarSesion(String correo,String pass){
        limpiarTexto(esperaExplicita(locatorTxtCorreo));
        limpiarTexto(esperaExplicita(locatorTxtPassword));
        agregarTexto(esperaExplicita(locatorTxtCorreo),correo);
        agregarTexto(esperaExplicita(locatorTxtPassword),pass);
        click(esperaExplicita(locatorBtnLogin));
    }

    public String obtenerErrorLogin(){
       return obtenerTexto(esperaExplicita(locatorLblErrorLogin));
   }

}
