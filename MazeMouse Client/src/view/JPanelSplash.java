package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import constants.PathSet;

/**
 * Clase del panel principal del splash
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class JPanelSplash extends JPanel {

	
	public static final String APP_VERSION = "MazeMouse - 1.0";
	public static final String APP_DATE = "2021";
	public static final String APP_AUTHOR_DANIEL = "Daniel Ricardo Gomez Gonzalez";

	private ImageIcon background;
	
	/**
	 * Metodo constructor que instancia las imagenes de fondo
	 */
	public JPanelSplash() {
		super();
		background = new ImageIcon(PathSet.PATH_BACKGROUND_SPLASH);
	}
	

	/**
	 * Metodo que pinta el fondo y los textos
	 */
	public void paint(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2, this);
		
		this.setOpaque(false);
		super.paint(g);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		
		g.drawString(APP_VERSION, 10, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2 -40);
		g.drawString(APP_DATE, 10, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2 -20);
		g.drawString(APP_AUTHOR_DANIEL, 10, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2 -60);
	}
	
	
}
