package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase generica para leer archivos de texto
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 1.0
 */
public class ReadFileTxtGeneric {

	private File file;
	private FileReader reader;
	private BufferedReader buffer;

	/**
	 * Metodo constructor que recibe la direccion del archivo 
	 * @param pathName - direccion del archivo
	 */
	public ReadFileTxtGeneric(String pathName) {
		file = new File(pathName);
		init();
	}
	
	/**
	 * Metodo que instancia el buffer y el reader
	 */
	private void init() {
		try {
			reader = new FileReader(file);
			buffer = new BufferedReader(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que lee todas las lineas y crea un solo String
	 * @return - todas las lineas de texto
	 */
	public String allInALine(){
		String all = "";
		String line = "";
		try {
			while((line = buffer.readLine()) !=null) {
					all+=line;
			}
		} catch (IOException e) {
				e.printStackTrace();	
		}
		return all;
	}
	
	/**
	 * Cerrar el flujo
	 */
	public void close() {
		try {
			buffer.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
