package simpleList;

/**
 * Clase de una lista de nodos enlazados
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class SimpleList<T>{
	
	private  Node<T> head;

	/**
	 * Metodo que va insetando datos secuencialmente
	 * @param date - valor que guardara el nodo a crear
	 */
	public void insert(T date) {
		if(head == null) {
			head  = new Node<T>(date);
		} else {
			lastNode().setNextNode(new Node<T>(date));
		}
	}
	
	/**
	 * Metodo que devuelve el ultimo nodo
	 * @return - ultimo nodo de la lista
	 */
	private Node<T> lastNode() {
		Node<T> last = head;
		boolean isLast = false;
		while(!isLast) {
			if(last.getNextNode() == null) {
				isLast = true;
			}else {
				last = last.getNextNode();
			}
		}
		return last;
	}
	
	/**
	 * Metodo que verifica un valor en la lista de nodos
	 * @param data - valor a buscar dentro de la lista de nodos
	 * @return - true si existe, y flase si no
	 */
	public boolean exist(T data) {
		Node<T> node = head;
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
		return head == null ? true : false;
	}

	/**
	 * Metodo que va a eliminar los nodos que contengan el dato ingresado por
	 * parametros
	 * @param data - dato que tiene los nodos a eliminar
	 */
	public void remove(T data) {
		if(head != null){
			Node<T> previousNode = head;
			Node<T> actualNode = head.getNextNode();
			while(actualNode!= null) {
				if(head.getData().equals(data)) 
					head = head.getNextNode();
				else {
					if(actualNode.getData().equals(data)) {
						previousNode.setNextNode(actualNode.getNextNode());
					}
				}	
				previousNode = actualNode;
				actualNode = previousNode.getNextNode();
			}
			
		}	
	}
	
	/**
	 * Metodo get del nodo raiz
	 * @return - nodo raiz
	 */
	public Node<T> getHead() {
		return head;
	}
	
	public int size() {
		int size = 0;
		Node<T> node = head;
		while(node != null) {
			size++;
			node = node.getNextNode();
		}
		return size;
	}
}
