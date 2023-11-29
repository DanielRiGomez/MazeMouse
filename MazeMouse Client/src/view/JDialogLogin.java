package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Clase del jdialog donde esta el login
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class JDialogLogin extends JDialog{
	
	private final int HEIGHT = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
	private final int WIDTH = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2);
	
	private JPanelLogin panel;
	
	/**
	 * Metodo cosntructor
	 * @param father - JFrame padre 
	 */
	public JDialogLogin(JFrame father) {
		super(father);
		this.setSize(new Dimension(WIDTH/2, HEIGHT));
		panel = new JPanelLogin();
		this.setLocationRelativeTo(null);
		this.add(panel);
	}

	/**
	 * Metodo para agregar un listener al panel
	 * @param listener
	 */
	public void addListener(ActionListener listener) {
		panel.addListener(listener);
	}

	/**
	 * Metodo get del panel
	 * @return - panel del login
	 */
	public JPanelLogin getPanel() {
		return panel;
	}
	
}
