package controller;

import java.net.Socket;
import com.google.gson.Gson;
import model.MazeAdmin;
import model.StructureMessageJson;
import model.User;
import net.ServerConnection;

/**
 * Clase que controla el manejo de los clientes
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class ClientConnection extends Thread{
	
	private ServerConnection connection;
	private IObserver observer;
	private User user;
	private MazeAdmin model;

	/**
	 * Metodo costructor 
	 * @param socket - socket del servidor
	 */
	public ClientConnection(Socket socket, MazeAdmin model, IObserver observer, boolean myTurn, int position) {
		connection = new ServerConnection(socket);
		user = new User(myTurn, position);
		this.model = model;
		this.observer = observer;
		start();
	}

	public void run() {
		init();
	}

	/**
	 * Metodo que inicia la interaccion con el cliente,
	 */
	private void init() {
		user.setUserName(connection.reciveMessage());
		observer.notify(0);
		while(!model.foundQueese()) {
			if(user.isTurn()) {
				int arrow = connection.reciveInt();
				observer.notify(arrow);
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}					
	}

	/**
	 * Metodo que envia un archivo de texto con la estructura de json para unformar el usuarion de los valores del laberinto
	 * @param userNames - lista de nombres de usuario
	 */
	public void notifyAction(String[] userNames) {
		StructureMessageJson message = new StructureMessageJson(user.isTurn(), model.getMousePosition(), model.foundQueese(), 
				model.getLastPosition(), model.getActions(), userNames, model.getActionsAccepted(), model.getCheesePosition());
		String messageeJson = new Gson().toJson(message);
		connection.sendMessage(messageeJson);
	}

	
	/**
	 * Metodo get para la clase que tiene la informacion de usuario
	 * @return - clase con la informacion del usuairo
	 */
	public User getUser() {
		return user;
	}
	
	
}
