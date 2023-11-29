package model;

/**
 * Clase para la estructura del mensaje json
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class StructureMessageJson {

	private boolean myTurn;
	private int mousePosition;
	private int cheesePosition;
	private int lastPosition;
	private int[] arrows;
	private boolean[] arrowsAcepted;
	private boolean foundQueese;
	private String[] users;
	
	/**
	 * Metodo constructor
	 * @param myTurn - dato booleano para el turno
	 * @param mousePosition - posicion del raton 
	 * @param foundQueese - boolean para saber si ya se encontro el queso
	 * @param lastPosition - ultima posicion
	 * @param arrows - listado de movimientos
	 * @param users - listado de nombres de usuarios
	 * @param arrowsAcepted - listado de booleanos para los movimientos aceptados y los que no
	 * @param cheesePosition - posicion del queso
	 */
	public StructureMessageJson(boolean myTurn, int mousePosition, boolean foundQueese, int lastPosition, int[] arrows, 
			String[] users, boolean[] arrowsAcepted, int cheesePosition) {
		this.myTurn = myTurn;
		this.mousePosition = mousePosition;
		this.foundQueese = foundQueese;
		this.lastPosition = lastPosition;
		this.arrows = arrows;
		this.users = users;
		this.arrowsAcepted = arrowsAcepted;
		this.cheesePosition = cheesePosition;
	}

	/**
	 * Metodo para saber si es su turno
	 * @return - verdadero si es su turno, falso si no
	 */
	public boolean isMyTurn() {
		return myTurn;
	}

	/**
	 * Metodo get de la posicion del raton
	 * @return - posicon del raton
	 */
	public int getMousePosition() {
		return mousePosition;
	}

	/**
	 * Metodo para saber si encontraron el queso
	 * @return - verdadero si lo encontraron, falso si no
	 */
	public boolean isFoundQueese() {
		return foundQueese;
	}

	/**
	 * Metodo get para la ultima posicion
	 * @return - ultima posicon
	 */
	public int getLastPosition() {
		return lastPosition;
	}

	/**
	 * Metodo get para el listado de movimientos
	 * @return
	 */
	public int[] getArrows() {
		return arrows;
	}

	/**
	 * Metodo get para la lista de booleanos de los movimientps aceptados y los que no
	 * @return - lista de booleanos de los movimientos aceptados y los que no
	 */
	public boolean[] getArrowsAcepted() {
		return arrowsAcepted;
	}
	
	/**
	 * Metodo get para la lista de nombres de usuarion
	 * @return
	 */
	public String[] getUsers() {
		return users;
	}

	/**
	 * Metodo get para la posicion del queso
	 * @return - posicion del queso
	 */
	public int getCheesePosition() {
		return cheesePosition;
	}
	
}
