package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 * Clasedel splash
 * @author Daniel Gomez
 * dd/mm/aaaa
 * @version 0.1
 */
public class JWindowSplash extends JWindow{
	
	private final int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
	private final int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2);
	
	private JPanelSplash panel;
	private JProgressBar progressBar;

	/**
	 * Metodo constructoe qe instancia el panel principal y la barra de progreso
	 */
	public JWindowSplash() {
		super();
		panel = new JPanelSplash();
		progressBar = new JProgressBar();
		init();
	}
	
	/**
	 * Metodo que le da las caracteristicas a los atributos y los adiciona
	 */
	private void init() {
		this.setSize(width, height);
		this.setLocation((int)(width*0.5), (int)(height*0.5));
		this.setLayout(new BorderLayout());
		
		progressBar.setValue(0);
		progressBar.setBackground(Color.GRAY);
		
		this.add(panel, BorderLayout.CENTER);
		this.add(progressBar, BorderLayout.SOUTH);
	}
	
	/**
	 * Metodo que mustra una fraccion de tiempo la ventana
	 * @param time - tiempo en mili-segundos que mostrara el splash
	 */
	public void showSplashAMoment(long time) {
		this.setVisible(true);
		try {
			for(int i=0; i< 100; i++) {
				progressBar();
				Thread.sleep(time/100);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		progressBar.setValue(0);
		this.setVisible(false);
	}
	
	private void progressBar() {
		progressBar.setValue(progressBar.getValue()+1);
	}
}
