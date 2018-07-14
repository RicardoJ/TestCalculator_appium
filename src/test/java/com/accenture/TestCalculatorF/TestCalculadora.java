package com.accenture.TestCalculatorF;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.accenture.TestCalculatorF.LecturaExcel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestCalculadora {

	public static AppiumDriver<MobileElement> driver; //Este driver es el que contralara los eventos de la automatizacion
	DesiredCapabilities capabilities = new DesiredCapabilities(); //caracteristicas de la automatizacion

	@BeforeMethod
	public void setUpAppium() throws MalformedURLException, InterruptedException {
		String packagename = "com.android.calculator2"; //Paquete principal de la aplicacion a automatizar
		String URL = "http://127.0.0.1:4723/wd/hub"; //IP y puerto de Appium
		String activityname = "com.android.calculator2.Calculator"; //Nombre de la actividad (o vista) en donde empezara la automatizacion
		capabilities.setCapability("deviceName", "Moto G (5) Plus"); //No es obligatorio que este nombre coincida
		capabilities.setCapability("udid", "0123456789ABCDEF"); //Serial del dispositivo, se obtiene activando la depuración USB y con el comando adb devices
		capabilities.setCapability("platformVersion", "7.0"); //No es obligatorio que la version coincida
		capabilities.setCapability("platformName", "Android"); //Nombre del sistema operativo
		capabilities.setCapability("appPackage", packagename);
		capabilities.setCapability("appActivity", activityname);
		driver = new AndroidDriver<MobileElement>(new URL(URL), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}

	@AfterTest
	public void CleanUpAppium() {
		driver.quit();
	}

	@Test
	public void mytest() throws InterruptedException {
		LecturaExcel lectura = new LecturaExcel();
		
		ArrayList<MobileElement> teclasDeLaCalculadora = new ArrayList<MobileElement>();
		
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/digit0")));
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/digit1")));
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/digit2")));
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/digit3")));
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/digit4")));
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/digit5")));
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/digit6")));
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/digit7")));
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/digit8")));
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/digit9")));
		
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/plus")));
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/minus")));
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/mul")));
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/div")));
		
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/equal")));
		teclasDeLaCalculadora.add(driver.findElementByClassName("android.widget.EditText"));
		teclasDeLaCalculadora.add(driver.findElement(By.id("com.android.calculator2:id/dot")));
		
		
		
		for (Dato teclas : lectura.leer()) {
		
			for (char num : teclas.getNumber1().toCharArray()) {
				
				if(num!='.') {
				 teclasDeLaCalculadora.get(Character.getNumericValue(num)).click();
				//System.out.println("numero que imprime" + num);
					
				}else {
					teclasDeLaCalculadora.get(16).click();
				}
				
			}
			
			Thread.sleep(346);
			
		
			
			if(teclas.getOperator().equalsIgnoreCase("+")) {
				teclasDeLaCalculadora.get(10).click();;
				
			}
			if(teclas.getOperator().equals("-")) {
				teclasDeLaCalculadora.get(11).click();;
			}
			if(teclas.getOperator().equals("*")) {
				teclasDeLaCalculadora.get(12).click();;
			}
			if(teclas.getOperator().equals("/")) {
				teclasDeLaCalculadora.get(13).click();
			}
			Thread.sleep(178);
			for (char num2 : teclas.getNumber2().toCharArray()) {
				
				if(num2!='.') {
				 teclasDeLaCalculadora.get(Character.getNumericValue(num2)).click();
				//System.out.println("numero que imprime" + num2);
					
				}else {
					teclasDeLaCalculadora.get(16).click();
				}
				
			}
			//igual
			teclasDeLaCalculadora.get(14).click();
			
			
		}
		
	}
}

