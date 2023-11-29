package simpleList;

/**
 * Clase estandar de un nodo que guarda un dato
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class Node<T> {

	private T data;
	private Node<T> node;
	
	/**
	 * Metodo costructor que recibe el valor a guardar
	 * @param data - valor a guardar
	 */
	public Node (T data) {
		this.data = data;
	}

	/**
	 * Metodo get del nodo siguiente
	 * @return - nodo siguiente
	 */
	public Node<T> getNextNode() {
		return node;
	}

	/**
	 * Metodo set del nodo siguiente
	 * @param node - nodo siguiente
	 */
	public void setNextNode(Node<T> node) {
		this.node = node;
	}

	/**
	 * Metodo get del valor
	 * @return - valor que guarda
	 */
	public T getData() {
		return data;
	}
	
}
