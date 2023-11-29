package view;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Clase del jframe del laberinto
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class JFrameMazeMouse extends JFrame {
	
	private JPanelMain mainPanel;
	
	/**
	 * Metodo constructor
	 */
	public JFrameMazeMouse() {
		this.mainPanel = new JPanelMain();
		init();
	}

	/**
	 * Metodo que le da los atributos al frame y agrega el panel
	 */
	private void init() {
	    this.setExtendedState(MAXIMIZED_BOTH); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(mainPanel);
	}	
	
	/**
	 * Metodo para agregar un listener al panel
	 * @param listener
	 */
	public void addListener(ActionListener listener) {
		mainPanel.addListener(listener);
	}

	/**
	 * Metodo get del panel principal
	 * @return - panel principal
	 */
	public JPanelMain getMainPanel() {
		return mainPanel;
	}
}
