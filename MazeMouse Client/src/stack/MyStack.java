package stack;

import simpleList.Node;

/**
 * Clase que represetan una pila
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 * @param <T> - Tipo de dato que para apilar
 */
public class MyStack<T> {

	private  Node<T> top;

	/**
	 * Metodo que crea un nuevo nodo con el dato recibido y los coloca
	 * en la cima de la pila
	 * @param date - dato a ingresar
	 */
	public void push(T date) {
		Node<T> newTop = new Node<T>(date);
		newTop.setNextNode(top);
		top = newTop;
	}
	
	/**
	 * Metodo que retorna el elemento en la cima de la pila
	 * sin quitarlo de la misma pila 
	 * @return - Nodo en la cima de la pila
	 */
	public Node<T> peek(){
		return top;
	}
	
	/**
	 * Metodo que quita el nodo que esta en la cima de la pila
	 * y deja como top al siguiente nodo
	 */
	public Node<T> pop() {
		top = top.getNextNode();
		return top;
	}
	
	/**
	 * Metodo que verifica un dato el la pila de nodos
	 * @param data - dato a buscar dentro de la lista de nodos
	 * @return - true si existe, y flase si no
	 */
	public boolean exist(T data) {
		Node<T> node = top;
		while(node != null) {
			if(node.getData().equals(data)) {
				return true;
			}else {
				node = node.getNextNode();
			}
		}
		return false;
	}
	
	/**
	 * Metodo que nos dice si la lista esta vacia
	 * @return true si esta vacia, false si no
	 */
	public boolean isEmpty() {
		return top == null ? true : false;
	}
	
	public int size() {
		int size = 0;
		Node<T> node = top;
		while(node != null) {
			size++;
			node = node.getNextNode();
		}
		return size;
	}
	
}
