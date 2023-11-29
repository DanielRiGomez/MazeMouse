package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import constants.Actions;
import constants.PathSet;

/**
 * Clase para el panel de los botones direccionales
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class JPanelArrows extends JPanel{

	private JButtonIconStandard up;
	private JButtonIconStandard down;
	private JButtonIconStandard left;
	private JButtonIconStandard right;
	private ImageIcon background;
	
	private final int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.1);
	private final int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.1);
	
	/*
	 * Metodo costructor donde intrancia los botones y la imagen de fondo
	 */
	public JPanelArrows() {
		super();
		up = new JButtonIconStandard(width / 3, height / 2, "", PathSet.PATH_UP);
		down = new JButtonIconStandard(width / 3, height / 2, "", PathSet.PATH_DOWN);
		left = new JButtonIconStandard(width / 3, height / 2, "", PathSet.PATH_LEFT);
		right = new JButtonIconStandard(width / 3, height / 2, "", PathSet.PATH_RIGHT);
		background = new ImageIcon(PathSet.PATH_CHAINS);
		init(); 
	}

	/**
	 * Metodo que agrega valores al panel y agrega los botones y unos jlabels bacios 
	 */
	private void init() {
		this.setLayout(new GridLayout(3, 3));
		this.setBackground(Color.gray);
		this.setOpaque(false);
		this.add(new JLabel());
		this.add(up);
		this.add(new JLabel());
		this.add(left);
		this.add(new JLabel());
		this.add(right);
		this.add(new JLabel());
		this.add(down);
		this.add(new JLabel());
	}
	
	/**
	 * Metodo para agregar un listener a los botones
	 * @param listener - listener de los botones
	 */
	public void addListener(ActionListener listener) {
		up.setActionCommand(Actions.UP);
		left.setActionCommand(Actions.LEFT);
		right.setActionCommand(Actions.RIGHT);
		down.setActionCommand(Actions.DOWN);
		up.addActionListener(listener);
		left.addActionListener(listener);
		right.addActionListener(listener);
	    down.addActionListener(listener);
	}
	
	public void paint(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
		super.paint(g);
	}
	
	/**
	 * Metodo para habilitar los botones
	 */
	public void enableButtons() {
		background = new ImageIcon(PathSet.PATH_FLOWERS);
		super.paint(this.getGraphics());
		paint(getGraphics());
		up.setEnabled(true);
		left.setEnabled(true);
		right.setEnabled(true);
		down.setEnabled(true);
		
	}
	
	/**
	 * Metodo para deshabilitar los botones
	 */
	public void disableButtons() {
		background = new ImageIcon(PathSet.PATH_CHAINS);
		paint(getGraphics());
		up.setEnabled(false);
		left.setEnabled(false);
		right.setEnabled(false);
		down.setEnabled(false);
		
	}
}
