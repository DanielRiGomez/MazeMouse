package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.PathSet;
import stack.MyStack;

/**
 * Clase del panel de la lista de acciones
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class JPanelActions extends JPanel{

	private MyStack<JLabel> actions;
	
	private final int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.8);
	private final int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.2);

	/**
	 * Metodo constructor
	 */
	public JPanelActions() {
		super();
		actions = new MyStack<>();
		init();
	}

	/**
	 * Metodo que le da caracteristicas al panel
	 */
	private void init() {
		this.setOpaque(false);
		this.setLayout(new GridLayout(9, 3, 1, 1));
	}
	
	/**
	 * Metodo para registrar la lista de acciones y verificar cuales fueron aceptadas y las que no
	 * @param arrows - lista de acciones, 1 es izquierda, 2 es abajo, 3 es derecha, 4 es arriba 
	 * @param accepted - lista que identifica las acciones aceptadas
	 */
	public void registerAction(int[] arrows, boolean[] accepted) {
		for(int i=actions.size(); i < arrows.length; i++) {
			String path = "";
			switch(arrows[i]) {
			case 1:
				path = PathSet.PATH_LEFT;
				break;
			case 2:
				path = PathSet.PATH_DOWN;
				break;
			case 3:
				path = PathSet.PATH_RIGHT;
				break;
			case 4:
				path = PathSet.PATH_UP;
				break;
			}
			ImageIcon icon = new ImageIcon(path);
			JLabel newArrow = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(width/ 6, height / 15, Image.SCALE_DEFAULT)));
			newArrow.setPreferredSize(new Dimension(width/ 3, height / 9));
			actions.push(newArrow);
			fill(accepted[i]);
		}
	}
	
	/**
	 * Metodo que reviza la ultima accion registrada y le agrega un color dependiendo del parametro, verde si es tru y rojo si el false
	 * @param accepted - Dato para saber si la ultima accion fue acceptada
	 */
	private void fill(boolean accepted) {
		JLabel label = actions.peek().getData();
		label.setOpaque(true);
		if(accepted) {
			label.setBackground(Color.GREEN);
		}else {
			label.setBackground(Color.RED);
		}
		
		label.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), Integer.toString(actions.size()) + "°"));
		this.add(label);
	}

}
