package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import constants.Actions;
import constants.PathSet;

/**
 * Clase del panel para el login
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class JPanelLogin extends JPanel{
	
	private final int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
	private final int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2);

	private JLabel image;
	private JTextField text;
	private JLabel userName;
	private JButtonIconStandard start;
	
	/**
	 * Metodo constructor
	 */
	public JPanelLogin() {
		super();
		this.setLayout(new GridBagLayout());
		init();
	}
	
	/**
	 * Metodo que instancia los elementos del panel y los agrega
	 */
	private void init() {
		image = new JLabel(new ImageIcon(new ImageIcon(PathSet.PATH_LOGIN).getImage().getScaledInstance(width/4, height/3, Image.SCALE_DEFAULT)));
		text = new JTextField(10);
		text.setSize(new Dimension(50, 20));
		userName = new JLabel("Nombre de Usuario");
		start = new JButtonIconStandard((int)(width/4), (int)(height/6), "", PathSet.PATH_START);
		start.setActionCommand(Actions.START);
		
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.gridwidth = 1;
		constraint.gridheight = 1;
		constraint.fill = GridBagConstraints.BOTH;
		constraint.insets = new Insets(5, 5, 5, 5);
		this.add(image, constraint);
		constraint.gridy = 1;
		this.add(userName, constraint);
		constraint.gridy = 2;
		this.add(text, constraint);
		constraint.gridy = 3;
		this.add(start, constraint);

	}
	public void paint(Graphics g) {
		ImageIcon maze = new ImageIcon(PathSet.PATH_WALL);
		g.drawImage(maze.getImage(), 0, 0, width/2, height, this);
		this.setOpaque(false);
		super.paint(g);
	}
	
	/**
	 * Metodo para agregarle un listener al botor de start
	 * @param listener - listener del boton
	 */
	public void addListener(ActionListener listener) {
		start.addActionListener(listener);
	}
	
	/**
	 * Metodo para obtener el nombre que el usuario ingreso
	 * @return - nombre que escribio el usuario en el JtextArea
	 */
	public String getUserName() {
		return text.getText();
	}

}
