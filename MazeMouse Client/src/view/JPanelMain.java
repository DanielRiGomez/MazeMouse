package view;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import constants.PathSet;

/**
 * Clase del panel principal 
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class JPanelMain extends JPanel{
	
	private final int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight());
	private final int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
	
	private JPanelActions actionsPanel;
	private JPanelArrows arrowsPanel;
	private JPanelMaze mazePanel;
	private JPanelUsers usersPanel;
	
	/**
	 * Metodo constructor que instancia los paneles
	 */
	public JPanelMain() {
		super();
		this.actionsPanel = new JPanelActions();
		this.arrowsPanel = new JPanelArrows();
		this.mazePanel = new JPanelMaze();
		this.usersPanel = new JPanelUsers();
		init();
	}
	
	/**
	 * Metodo que agrega el layout 
	 */
	private void init() {	
		this.setLayout(new GridBagLayout());
		addPanels();
	}	
	
	/**
	 * Metodo que maneja el constraint para agregar los paneles
	 */
	private void addPanels() {
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.gridwidth = 5;
		constraint.gridheight = 5;
		constraint.weightx = 5.0;
		constraint.weighty = 5.0;
		constraint.fill = GridBagConstraints.BOTH;
		constraint.insets = new Insets(5, 5, 5, 5);
		this.add(mazePanel, constraint);
		constraint.gridx = 5;
		constraint.gridwidth = 1;
		constraint.gridheight = 1;
		constraint.weightx =0.0;
		constraint.weighty =0.0;
		this.add(arrowsPanel, constraint);
		constraint.gridx = 0;
		constraint.gridy = 5;
		constraint.gridwidth = 5;
		constraint.gridheight = 1;
		constraint.weightx =5.0;
		constraint.weighty =0.0;
		this.add(usersPanel, constraint);
		constraint.gridx = 5;
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		constraint.gridheight = 5;
		constraint.weightx =0.0;
		constraint.weighty =5.0;
		this.add(actionsPanel, constraint);
		
	}
	
	public void paint(Graphics g) {
		ImageIcon maze = new ImageIcon(PathSet.PATH_WALL);
		g.drawImage(maze.getImage(), 0, 0, getWidth(), getHeight(), this);
		this.setOpaque(false);
		super.paint(g);
	}
	
	/**
	 * Metodo para agregar un listener al panel de las flechas direccionales
	 * @param listener
	 */
	public void addListener(ActionListener listener) {
		 arrowsPanel.addListener(listener);
	}

	/**
	 * Metodo get del panel de la lista de acciones
	 * @return - Jpanel de la lista de acciones
	 */
	public JPanelActions getActionsPanel() {
		return actionsPanel;
	}

	/**
	 * Metodo get del panel de las flechas direccionales
	 * @return - JPanel de las flechas direccionales
	 */
	public JPanelArrows getArrowsPanel() {
		return arrowsPanel;
	}

	/**
	 * Metodo get del panel del laberinto
	 * @return - panel del laberinto
	 */
	public JPanelMaze getMazePanel() {
		return mazePanel;
	}

	/**
	 * Metodo get del panel de la lista de usuarios
	 * @return - panel de la lista de usuarios
	 */
	public JPanelUsers getUsersPanel() {
		return usersPanel;
	}

}
