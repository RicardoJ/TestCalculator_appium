package com.accenture.TestCalculatorF;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class LecturaExcel {
	
	static String nombreArchivo = "appiumtest.xlsx";
	static String rutaArchivo = "C:\\Users\\ricardo.diaz\\Documents\\" + nombreArchivo;
	String hoja = "Hoja1";
public static void main(String []arg) {
	
	LecturaExcel excel = new LecturaExcel();
	excel.leer();
	
}
	
	
public  ArrayList<Dato> leer() {

	 
	 ArrayList<Dato> dato  = new ArrayList<Dato>();
	
	try  {
		FileInputStream file = new FileInputStream(new File(rutaArchivo));
		// leer archivo excel
		XSSFWorkbook worbook = new XSSFWorkbook(file);
		//obtener la hoja que se va leer
		XSSFSheet sheet = worbook.getSheetAt(0);
		//obtener todas las filas de la hoja excel 
		Iterator<Row> rowIterator = sheet.iterator();

		Row row;
		 Dato datosDeExcel=null;
		// se recorre cada fila hasta el final
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			//se obtiene las celdas por fila
			Iterator<Cell> cellIterator = row.cellIterator();
			Cell cell;
			//se recorre cada celda  
		     int contador = 0;
		     
		     
		  datosDeExcel  = new  Dato();
			while (cellIterator.hasNext()) {
				// se obtiene la celda en específico y se la imprime
				cell = cellIterator.next();
           
            switch (contador) {
				
				case 0:
				   datosDeExcel.setNumber1(String.valueOf(cell.getNumericCellValue()));
					System.out.println(" numero 1 ---"+ datosDeExcel.getNumber1());
					
					
					break;
				case 1:
					datosDeExcel.setOperator(cell.getStringCellValue());
					System.out.println(" operator--- "+ datosDeExcel.getOperator());
					break;
				case 2:
					datosDeExcel.setNumber2(String.valueOf(cell.getNumericCellValue()));
					System.out.println(" numero 2 ----"+ datosDeExcel.getNumber2());
					break;
			
				}
				
            System.out.println("entra al while");
				contador++;
				;
			}
			System.out.println();
			dato.add(datosDeExcel);
		}
		
		
	} catch (Exception e) {
		e.getMessage();
	}
	return dato;
}

}
