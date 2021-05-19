package frame;

import javax.swing.JFrame;

import panel.ChooseCasePanel;
import panel.ProfilesPanel;
import panel.RegisterPanel;
import panel.WelcomePanel;

public class MainFrame extends JFrame {

	public WelcomePanel welcomePanel;
	public ProfilesPanel profilesPanel;
	public ChooseCasePanel chooseCasePanel;
	public RegisterPanel registerPanel;

	public MainFrame() {
		super("Deformation Calculator");
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		showWelcomePanel();
	}

//	SHOW LOGIN PAGE
	public void showWelcomePanel() {
		if (chooseCasePanel != null) {
			chooseCasePanel.setVisible(false);
		}
		if (registerPanel != null) {
			remove(registerPanel);
		}
		if (welcomePanel!=null) {
			remove(welcomePanel);
		}
		welcomePanel = new WelcomePanel(this);
		setSize(400, 250);
		add(welcomePanel);
		welcomePanel.setVisible(true);

	}

//	SHOW SECTION AND CALCULATION PAGE. WHEN BackButton = PRESSED -> THE PAGE = DELETED
	public void showProfilesPanel() {
//		if (welcomePanel != null) {
//			welcomePanel.setVisible(false);
//		}
		if (chooseCasePanel != null) {
			chooseCasePanel.setVisible(false);
		}
		profilesPanel = new ProfilesPanel(this);
		setSize(650, 600);
		add(profilesPanel);
//		if (profilesPanel == null) {
//			profilesPanel = new ProfilesPanel(this);
//			setSize(650, 600);
//			add(profilesPanel);
//		}else {
//			profilesPanel.setVisible(true);
//			setSize(650, 600);
//		}
	}

//	SHOW LOADING CASES PAGE
	public void showChooseCasePanel() {
		if (welcomePanel != null) {
			welcomePanel.setVisible(false);
		}
		if (profilesPanel != null) {
			remove(profilesPanel);
		}
		if (chooseCasePanel == null) {
			chooseCasePanel = new ChooseCasePanel(this);
			setSize(535, 800);
			add(chooseCasePanel);
		} else {
			chooseCasePanel.setVisible(true);
			setSize(535, 800);
		}
	}

	public void showRegisterPanel() {
		if (welcomePanel != null) {
			welcomePanel.setVisible(false);
		}
		registerPanel = new RegisterPanel(this);
		setSize(400, 400);
		add(registerPanel);

	}
}
