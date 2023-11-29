package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Clase de la coneccion del server
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class ServerConnection {
	
	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;
	
	/**
	 * Metodo constructor
	 * @param socket - socket del server 
	 */
	public ServerConnection(Socket socket) {
		init(socket);
	}
	
	/**
	 * Metodo que instancia los atributos
	 * @param socket - socket del server
	 */
	private void init(Socket socket) {
		this.socket = socket;
		try {
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
	public int reciveInt() {
		int arrow = 0;
		try {
			arrow = input.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrow;
	}
	
	/**
	 * Metodo que recibe un boolean
	 * @return - boolean recibido
	 */
	public boolean reciveBoolean() {
		boolean bool= false;
		try {
			bool = input.readBoolean();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bool;
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
	 * Metodo que cierra el flujo del socket del servidor
	 */
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
