package Frame;

import javax.swing.JFrame;

import Panel.ChooseCasePanel;
import Panel.ChooseMaterialPanel;
import Panel.WelcomePanel;

public class MainFrame extends JFrame {

	public WelcomePanel welcomePanel;
	public ChooseMaterialPanel chooseMaterialPanel;
	public ChooseCasePanel chooseCasePanel;

	public MainFrame() {
		super("Deformation Calculator");
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		showWelcomePanel();
	}

	public void showWelcomePanel() {
		if (chooseMaterialPanel != null) {
			chooseMaterialPanel.setVisible(false);
			}
		if (chooseCasePanel != null) {
			chooseCasePanel.setVisible(false);
		}
		if (welcomePanel == null) {
			welcomePanel = new WelcomePanel(this);
			welcomePanel.setSize(600, 600);
			add(welcomePanel);
		}else {
			welcomePanel.setVisible(true);
		}
	}
	
	public void showChooseMaterialPanel() {
		if (welcomePanel != null) {
			welcomePanel.setVisible(false);
		}
		if (chooseCasePanel != null) {
			chooseCasePanel.setVisible(false);
		}
		if (chooseMaterialPanel == null) {
			chooseMaterialPanel = new ChooseMaterialPanel(this);
			chooseMaterialPanel.setSize(600, 600);
			add(chooseMaterialPanel);
		}else {
			chooseMaterialPanel.setVisible(true);
		}
	}
	
	public void showChooseCasePanel() {
		if (welcomePanel != null) {
			welcomePanel.setVisible(false);
		}
		if (chooseMaterialPanel != null) {
			welcomePanel.setVisible(false);
		}
		if (chooseCasePanel == null) {
			chooseCasePanel = new ChooseCasePanel(this);
			chooseCasePanel.setSize(600, 600);
			add(chooseCasePanel);
		}else {
			chooseCasePanel.setVisible(true);
		}
	}
}
