package model;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import constants.PathSet;
import persistence.ReadFileTxtGeneric;

/**
 * Clase que maneja la logica del laberinto
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class MazeAdmin {
	
	private ArrayList<Box> boxSet;
	private int mousePosition;
	private int cheesePosition;
	private int lastPosition;
	private ArrayList<Integer> actions;
	private ArrayList<Boolean> actionsAccepted;
	
	/**
	 * Metodo constructor
	 */
	public MazeAdmin() {
		actions = new ArrayList<>();
		actionsAccepted =  new ArrayList<>();
		initPositions();
		initBoxSet();
	}

	/**
	 * Metodo que lee el archibo json donde esta la informacion de las casillas del laberinto y
	 * los registra en boxSet 
	 */
	private void initBoxSet() {
		Gson gson = new Gson();
		ReadFileTxtGeneric readFile = new ReadFileTxtGeneric(PathSet.JSON_BOX_SET);
		Type type = new TypeToken<ArrayList<Box>>(){}.getType(); 
		boxSet = gson.fromJson(readFile.allInALine(), type);
		readFile.close();
	}
	
	/**
	 * Metodo que le asiga unos valores al azar a mousePosition y cheeesePosition y se 
	 * asegura que no reciban valores iguales
	 */
	private void initPositions() {
		mousePosition = new Random().nextInt(64);
		lastPosition = mousePosition; 
		boolean acept = false;
		while(!acept) {
			cheesePosition = new Random().nextInt(64);
			if(cheesePosition != mousePosition)
				acept = true;
		}
	}
	
	/**
	 * Metodo que verifica si el raton puede hacer el movimiento ingresado por parametro estando en la posicion 
	 * indicada por mousePosition
	 * @param arrow - 1 es izquierda, 2 es abajo, 3 es derecha, 4 es arriba 
	 * @return - verdadero si se puede mover, falso si no
	 */
	private boolean moveAccept(int arrow) {
		boolean accepted = false;
		switch(arrow) {
		case 1:
			accepted = boxSet.get(mousePosition).isLeft();
			break;
		case 2:
			accepted = boxSet.get(mousePosition).isDown();
			break;
		case 3:
			accepted = boxSet.get(mousePosition).isRight();
			break;
		case 4:
			accepted = boxSet.get(mousePosition).isUp();
			break;
		default:
			break;
		}
		return accepted;
	}
	
	/**
	 * Metodo para realizar un movimiento del raton en el laberinto, se ingresa la direccion por parametros y
	 * se guarda en la lista de actions y actionsAcepted, ademas de actualizar la ultima posicion
	 * @param arrow
	 */
	public void moveMouse(int arrow) {
		boolean accepted = moveAccept(arrow);
		actions.add(arrow);
		actionsAccepted.add(accepted);
		lastPosition = mousePosition;
		if(accepted) {
			switch(arrow) {
			case 1:
				mousePosition = mousePosition-1;
				break;
			case 2:
				mousePosition = mousePosition+8;
				break;
			case 3:
				mousePosition = mousePosition+1;
				break;
			case 4:
				mousePosition = mousePosition-8;
				break;
			default:
				break;
			}
		}
	}
	
	/**
	 * Metodo para ver si ya se encontro el queso
	 * @return - verdadero si es su turno, falso si no
	 */
	public boolean foundQueese() {
		return mousePosition == cheesePosition;
	}

	/**
	 * Metodo get para la lista de casillas
	 * @return - lista de casillas
	 */
	public ArrayList<Box> getBoxSet() {
		return boxSet;
	}

	/**
	 * Metodo set para la lista de casillas
	 * @param boxSet - lista de casillas a actualizar
	 */
	public void setBoxSet(ArrayList<Box> boxSet) {
		this.boxSet = boxSet;
	}

	/**
	 * Metodo get para la posicion del raton
	 * @return - posicion del raton
	 */
	public int getMousePosition() {
		return mousePosition;
	}

	/**
	 * Metodo get para la posicion del queso
	 * @return - posicion del queso
	 */
	public int getCheesePosition() {
		return cheesePosition;
	}

	/**
	 * Metodo get para la ultima posicion del raton
	 * @return - ultima posicion del raton
	 */
	public int getLastPosition() {
		return lastPosition;
	}
	
	/**
	 * Metodo que registra el ArrayList de actions en un Array normal y lo retorn
	 * @return - Array de la lista de acciones
	 */
	public int[] getActions() {
		int[] actionSet = new int[actions.size()];
		for(int i=0; i< actions.size(); i++) {
			actionSet[i]= actions.get(i);
		}
		return actionSet;
	}
	
	/**
	 * Metodo que registra el ArrayList de actionsAccepted en un Array normal y lo retorn
	 * @return - Array de las acciones aceptadas y las que no
	 */
	public boolean[] getActionsAccepted() {
		boolean[] acceptedSet = new boolean[actionsAccepted.size()];
		for(int i=0; i< actionsAccepted.size(); i++) {
			acceptedSet[i]= actionsAccepted.get(i);
		}
		return acceptedSet;
	}
	
	/**
	 * Metodo que resetea los valores de pas acciones y las posiciones 
	 */
	public void resetValues() {
		actions = new ArrayList<>();
		actionsAccepted =  new ArrayList<>();
		initPositions();
	}
}
