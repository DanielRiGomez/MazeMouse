package model;

/**
 * Clase que representa una casilla del laberinto
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class Box {

	private boolean left;
	private boolean down;
	private boolean right;
	private boolean up;
	
	/**
	 * Metodo constructor
	 * @param left - booleano verificar si hay camino por la izquierda
	 * @param down - booleano verificar si hay camino por abajo
	 * @param right - booleano verificar si hay camino por la derecha
	 * @param up - booleano verificar si hay camino por arriba
	 */
	public Box(boolean left, boolean down, boolean right, boolean up) {
		this.left = left;
		this.down = down;
		this.right = right;
		this.up = up;
	}

	/**
	 * Metodo que me dice si hay camino por la izquierda
	 * @return - verdadero si puede ir a la izquierda, falso si no
	 */
	public boolean isLeft() {
		return left;
	}

	/**
	 * Metodo que me dice si hay camino por abajo
	 * @return- verdadero si puede ir abajo, falso si no
	 */
	public boolean isDown() {
		return down;
	}

	/**
	 * Metodo que me dice si hay camino por la derecha
	 * @return - verdadero si puede ir a la derecha, falso si no
	 */
	public boolean isRight() {
		return right;
	}

	/**
	 * Metodo que me dice si hay camino por la arriba
	 * @return - verdadero si puede ir arriba, falso si no
	 */
	public boolean isUp() {
		return up;
	}
	
	
}
