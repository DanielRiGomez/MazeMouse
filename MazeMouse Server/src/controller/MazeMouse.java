package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

import model.MazeAdmin;


/**
 * Clase que controla la lista de usuarios y el servidor
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class MazeMouse implements IObserver{
	
	//private final int PORT = 26380;
	private final int PORT = 1234;
	private ServerSocket server;
	private LinkedList<ClientConnection> clientCon;
	private MazeAdmin model;
	
	/**
	 * Metodo constructor
	 */
	public MazeMouse() {
		initPort();
		init();	
	}
	
	/**
	 * Metodo que inicializa el pueto de servidor
	 */
	private void initPort() {
		try {
			server = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que intancia una nueva lista de clientes y un nuevo modelo, ademas de permanence en bucle registrando los usuarios, y 
	 * al primero le asigna el turno de una vez
	 */
	private void init() {
		clientCon = new LinkedList<>();
		model = new MazeAdmin();
		try {
			while(true) {
				Socket socket = server.accept();
				boolean first = false;
				if(clientCon.size() == 0) {
					first = true;
				}
				ClientConnection client = new ClientConnection(socket, model, this, first, clientCon.size()+1);
				clientCon.add(client);	
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * Metodo que informa la accion registrada por el usuario que lleva el turno a todos los usuarios,  y si se encontro el queso
	 * llama al metodo notifyReset
	 */
	public void notify(int arrow) {	
		if(arrow != 0) {
			model.moveMouse(arrow);	
			passTurn();
		}
		String[] userNames = userNames();
		for(int i=0; i< clientCon.size(); i++) {
			clientCon.get(i).notifyAction(userNames);
		}	
		if(model.foundQueese())
			notifyReset();
	}
	
	/**
	 * Metodo para registrar el paso del turno en la lista enlazada clientCon
	 */
	private void passTurn() {
		ClientConnection first = clientCon.getFirst();
		clientCon.remove(first);
		first.getUser().setTurn(false);
		clientCon.add(first);	
		clientCon.getFirst().getUser().setTurn(true);
		
	}
	
	/**
	 * Metodo que retorna un Array con los nombres de los usuriarios
	 * @return
	 */
	private String[] userNames() {
		String[] userNames = new String[clientCon.size()];
		for(int i=0; i< clientCon.size(); i++) {
			userNames[i] = clientCon.get(i).getUser().getUserName();
		}
		return userNames;
	}

	/**
	 *Metodo que resetea a los valores inicialos 
	 */
	private void notifyReset() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
	}
}
