package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Clase de la conneccion del cliente
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class Client {

	private final int PORT = 26380;
	private final String HOST = "186.114.217.181";
	//private final int PORT = 1234;
	//private final String HOST = "localhost";
	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;
	
	/**
	 * Metodo constructor
	 */
	public Client() {
		init();
	}
	
	/**
	 * Metodo que instancia los atributos
	 */
	private void init() {
		try {
			socket = new Socket(HOST, PORT);
			output = new DataOutputStream(socket.getOutputStream());
			input = new DataInputStream(socket.getInputStream());	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que recibe un mensaje
	 * @return - mensaje recibido
	 */
	public String reciveMessage() {
		String path = "";
		try {
			path = input.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	/**
	 * Metodo que envia un boolean 
	 * @param data - boolean a enviar
	 */
	public void sendBoolean(boolean data) {
		try {
			output.writeBoolean(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que envia un mensaje
	 * @param message - mensaje a enviar
	 */
	public void sendInt(int arrow) {
		try {
			output.writeInt(arrow);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que envia un mensaje
	 * @param message - mensaje a enviar
	 */
	public void sendMessage(String message) {
		try {
			output.writeUTF(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que cierra el flujo del socket del cliente
	 */
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
