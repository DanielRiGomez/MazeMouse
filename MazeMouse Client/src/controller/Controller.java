package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import model.StructureMessageJson;
import com.google.gson.Gson;

import constants.Actions;
import view.JDialogLogin;
import view.JDialogTunr;
import view.JFrameMazeMouse;
import view.JWindowSplash;

/**
 * Clase controladora del cliente
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class Controller implements ActionListener {

	private Client client;
	private JFrameMazeMouse frame;
	private JDialogLogin login;
	private JWindowSplash splash;
	private JDialogTunr turn;
	
	/**
	 * Metodo constructor
	 */
	public Controller() {
		init();
	}
	
	/**
	 * Metodo qie instancia las los atributos
	 */
	private void init() {
		client = new Client();
		frame = new JFrameMazeMouse();
		login = new JDialogLogin(frame);
		splash = new JWindowSplash();
		turn = new JDialogTunr(frame);
	}
	
	/**
	 * Metodo que inicia la interaccion del cliente
	 */
	public void start() {
		frame.addListener(this);
		login.addListener(this);
		login.setVisible(true);
		while(true) {
			String messajeJson = client.reciveMessage();
			StructureMessageJson struct = new Gson().fromJson(messajeJson, StructureMessageJson.class);	
			frame.getMainPanel().getMazePanel().drawCheese(struct.getCheesePosition());
			frame.getMainPanel().getMazePanel().moveMouse(struct.getMousePosition(), struct.getLastPosition());
			frame.getMainPanel().getActionsPanel().registerAction(struct.getArrows(), struct.getArrowsAcepted());
			frame.getMainPanel().getUsersPanel().registerUsers(struct.getUsers());
			frame.getMainPanel().getArrowsPanel().disableButtons();
			if(struct.isFoundQueese()) {
				splash.showSplashAMoment(10000);
				System.exit(0);
			}else {
				if(struct.isMyTurn()) {
					turn.setVisible(true);
					frame.getMainPanel().getArrowsPanel().enableButtons();
				}
				frame.revalidate();	
			}	
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Actions.LEFT:
			client.sendInt(1);
			break;
		case Actions.DOWN:
			client.sendInt(2);
			break;
		case Actions.RIGHT:
			client.sendInt(3);
			break;
		case Actions.UP:
			client.sendInt(4);
			break;	
		case Actions.START:
			client.sendMessage(login.getPanel().getUserName());
			login.setVisible(false);
			break;
		default:
			break;
		}
		
	}
}
