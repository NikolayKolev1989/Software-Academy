package Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Panels.GamePanel;
import Panels.HomePanel;

public class MainFrame extends JFrame{
	
	public HomePanel homePanel;
	public GamePanel gamePanel;
	
	public MainFrame(){
		super("Bulls and cows");
		setSize(270, 300);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		showHomePanel();
	}
	
	public void showHomePanel() {
		setSize(270, 300);
		if (gamePanel!=null) {
			gamePanel.setVisible(false);
		}
		if (homePanel == null) {
			homePanel = new HomePanel(this);
			homePanel.setSize(getWidth(), getHeight());
			add(homePanel);
		}else {
			homePanel.setVisible(true);
		}
	}
	
	public void newGamePanel() {
		if (gamePanel!=null) {
			gamePanel.setVisible(false);
		}
		homePanel.setVisible(false);
		setSize(600, 500);
		gamePanel = new GamePanel(this);
		gamePanel.setSize(getWidth(), getHeight());
		add(gamePanel);
	}
	public void resumeGamePanel() {
		if (gamePanel != null) {
			homePanel.setVisible(false);
			gamePanel.setVisible(true);
			setSize(600, 500);
		}else {
			JOptionPane.showMessageDialog(this, "Няма създадена игра!");
		}
	}
	
}
