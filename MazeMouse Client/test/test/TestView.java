package test;

import java.util.LinkedList;

import javax.swing.JFrame;

import view.JPanelLogin;
import view.JWindowSplash;
import view.JDialogLogin;
import view.JFrameMazeMouse;

public class TestView {
	
	public static void main(String[] args) {
		/*
		JFrameMazeMouse mazeMouse = new JFrameMazeMouse();
		mazeMouse.getMainPanel().getArrowsPanel().disableButtons();
		mazeMouse.getMainPanel().getActionsPanel().registerAction(1, true);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(2, true);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(3, false);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(4, true);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(1, false);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(1, true);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(2, true);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(3, false);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(4, true);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(1, false);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(1, true);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(2, true);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(3, false);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(4, true);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(1, false);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(1, true);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(2, true);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(3, false);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(4, true);
		mazeMouse.getMainPanel().getActionsPanel().registerAction(1, false);
		mazeMouse.getMainPanel().getMazePanel().drawCheese(63);
		mazeMouse.getMainPanel().getMazePanel().moveMouse(0, 0);
		
		mazeMouse.getMainPanel().getMazePanel().moveMouse(1, 0);
		mazeMouse.getMainPanel().getMazePanel().moveMouse(2, 1);
		mazeMouse.getMainPanel().getMazePanel().moveMouse(3, 2);
		
		mazeMouse.revalidate();
		*/
		/*
		 JFrame frame = new JFrame();
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 JDialogLogin login = new JDialogLogin(frame);
		 login.setVisible(true);
		 */
		JWindowSplash splash = new JWindowSplash();
		splash.showSplashAMoment(10000);
 	}
	
}
