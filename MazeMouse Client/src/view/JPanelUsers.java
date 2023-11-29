package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import constants.PathSet;
import simpleList.SimpleList;

/**
 * Clase para el panel de la lista de usuarios
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class JPanelUsers extends JPanel{
	
	private SimpleList<JLabel> users;
	
	
	private final int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.2);
	private final int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.8);
	
	
	/**
	 * Metodo constructor que instancia la lista enlazada de los usuarios
	 */
	public JPanelUsers() {
		super();
		users = new SimpleList<>();
		init();
	}

	/**
	 * Metodo constructor donde agrega valores al panel 
	 */
	private void init() {
		this.setOpaque(false);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
	}
	
	/**
	 * Metodo para la lista de usuarios, donde se resetea la lista de usuarios y se crea una nueva a partir del 
	 * arreglo ingresado por parametros
	 * @param names - Lista de nombres de los usuarios
	 */
	public void registerUsers(String[] names) {
		users = new SimpleList<>();
		this.removeAll();
		for(String i: names) {
			newUser(i);
		}
		fillUsers();
	}
	
	/**
	 * Metodo para agregar un nuevo usuario a la lista de usuarios 
	 * @param name - nombre del usuario
	 */
	private void newUser(String name) {
		ImageIcon icon = new ImageIcon(PathSet.PATH_USER);
		JLabel user = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(width/ 12, height/3, Image.SCALE_DEFAULT)));
		user.setPreferredSize(new Dimension(width/10, height/2));
		user.setName(name);
		user.setOpaque(true);
		users.insert(user);
	}
	
	/**
	 * Metodo para agregar la lista de labels que representan los usuarios al panel
	 */
	private void fillUsers() {
		int size = users.size();
		for(int i=0; i < size; i++) {
			JLabel label = users.getHead().getData();
			Border border = BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), label.getName());
			Color color = Color.LIGHT_GRAY;
			if(i==0) {
				border = BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), label.getName());
				color = Color.YELLOW;
			}
			label.setBorder(border);
			label.setBackground(color);
			this.add(label);
			users.remove(label);
		}
	}

}
