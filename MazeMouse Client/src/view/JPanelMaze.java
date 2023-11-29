package view;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.PathSet;

/**
 * Clase del panel del laberinto
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class JPanelMaze extends JPanel{

	private final int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.8);
	private final int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.8);
	
	public Image mouse;
	public Image cheese;
	public Image lastPosition;
	public ArrayList<JLabel> boxSet;

	/**
	 * Metodo get que instancia la lista  de casillas de laberinto
	 */
	public JPanelMaze() {
		super();
		boxSet = new ArrayList<>();
		init();
	}

	/**
	 * Metodo que unstancia las imagenes y agrega el layout al panel
	 */
	private void init() {
		this.setLayout(new GridLayout(8, 8, 30, 30));
		mouse = new ImageIcon(PathSet.PATH_MOUSE).getImage();	
		cheese = new ImageIcon(PathSet.PATH_CHEESE).getImage();
		lastPosition = new ImageIcon(PathSet.PATH_POSITION).getImage();
		initBox();
	}
	
	/**
	 * Metodo que instancia cada uno de los labels que representan las casillas del laberinto y los agrega
	 */
	private void initBox() {
		for(int i=0; i<64; i++) {
			JLabel box = new JLabel();
			boxSet.add(box);
			this.add(box);
		}
	}

	public void paint(Graphics g) {
		ImageIcon maze = new ImageIcon(PathSet.PATH_MAZE);
		g.drawImage(maze.getImage(), 0, 0, getWidth(), getHeight(), this);
		this.setOpaque(false);
		super.paint(g);
	}
	
	/**
	 * Metodo para dibujar el raton en una posicion
	 * @param position - posicion del label donde se va a dibujar el raton
	 */
	private void drawMouse(int position) {
		boxSet.get(position).setIcon(new ImageIcon(mouse.getScaledInstance(width/ 12, height/12, Image.SCALE_DEFAULT)));
	}
	
	/**
	 * Metodo para dibujar el queso en una posicion
	 * @param position - posicion del label donde se va a dibujar el queso
	 */
	public void drawCheese(int position) {
		boxSet.get(position).setIcon(new ImageIcon(cheese.getScaledInstance(width/ 12, height/12, Image.SCALE_DEFAULT)));
	}
	
	/**
	 * Metodo para dibujar el raton en una nueva posicion y tanbien dibujar el icono de la huellas
	 * @param positionMouse - posicion del label donde se va a dibujar el queso
	 * @param lastPositionMouse - posicion del label donde se va a dibujar unas huellas
	 */
	public void moveMouse(int positionMouse, int lastPositionMouse) {
		boxSet.get(lastPositionMouse).setIcon(new ImageIcon(lastPosition.getScaledInstance(width/ 15, height/15, Image.SCALE_DEFAULT)));
		drawMouse(positionMouse);
	}
}
