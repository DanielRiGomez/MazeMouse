package view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Clase estandar para un boton con un icono
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class JButtonIconStandard extends JButton{
	
	private int height;
	private int width;
	private String tipText;
	private String pathIcon;
	
	/**
	 * Metodo constructor
	 * @param width - ancho del boton
	 * @param height - alto del boton
	 * @param tipText - Texto guia
	 * @param pathIcon - direccion de la imagen del boton
	 */
	public JButtonIconStandard(int width, int height, String tipText, String pathIcon) {
		super();
		this.width = width;
		this.height = height;
		this.tipText = tipText;
		this.pathIcon = pathIcon;
		init();
	}
	
	/**
	 * Metodo donde se asigna las caracteristicas al boton
	 */
	private void init() {
		this.setSize(width, height);
		this.setToolTipText(tipText);
		changeIcon();
		pressedButton();
		this.setBorderPainted(false);
		this.setFocusPainted(false); 
		this.setContentAreaFilled(false);
		this.setOpaque(false);
	}
	
	/**
	 * Metodo para configurar un efecto el precionar el boton
	 */
	private void pressedButton() {
		ImageIcon image = (ImageIcon) this.getIcon();
		int width = (int)(this.width*0.9);
		int height = (int)(this.height*0.9);
		this.setPressedIcon(new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
	}
	
	/**
	 * Metodo donde se cambia el icono de la imagen
	 */
	private void changeIcon() {
		ImageIcon icon = new ImageIcon(pathIcon);
		this.setIcon(new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
	}
}
