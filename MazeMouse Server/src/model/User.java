package model;

/**
 * Clase generica para un usuario
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class User {
	
	private final String SYMBOL = "° ";
	
	private String userName;
	private boolean turn;
	private int initPosition;
	
	/**
	 * Metodo constructor
	 * @param turn - verdadero si es su turno, falso si no
	 * @param initPosition - posicion en la que inicio
	 */
	public User( boolean turn, int initPosition) {
		this.turn = turn;
		this.initPosition = initPosition;
		this.userName = "";
	}

	/**
	 * Metodo get de nombre de usuario
	 * @return - nombre de usuario
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Metodo set para el nombre del usuario
	 * @param userName - nombre del usuario a registrar
	 */
	public void setUserName(String userName) {
		this.userName = initPosition + SYMBOL + userName;
	}
	

	/**
	 * Metodo para verificar el turno
	 * @return - verdadero si es su turno, falso si no
	 */
	public boolean isTurn() {
		return turn;
	}

	/**
	 * Metodo set para el turno
	 * @param turn - turno a registrar
	 */
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	
	
}
