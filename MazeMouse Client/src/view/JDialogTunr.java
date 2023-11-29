package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JDialogTunr extends JDialog{
	
	private JLabel information;
	
	public JDialogTunr(JFrame father) {
		super(father);
		this.setSize(new Dimension(100, 100));
		this.setLayout(new FlowLayout());
		init();
	}
	
	private void init() {
		// image = new JLabel(new ImageIcon(new ImageIcon(Student.IMAGE).getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT)));
		information = new JLabel("Es tu turno");
		this.getContentPane().add(information);
		this.setLocationRelativeTo(null);
	}

}
