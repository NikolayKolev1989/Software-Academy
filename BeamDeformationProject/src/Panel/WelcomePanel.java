package Panel;

import javax.swing.JPanel;

import Frame.MainFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JPasswordField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;

public class WelcomePanel extends JPanel {
		
	public MainFrame root;
	private JTextField userNameTextField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JLabel userNameLabel;
	private JLabel passwordLabel;
	private JLabel welcomeLabel;
	
	public WelcomePanel (MainFrame root){
		setLayout(new MigLayout("", "[48px][86px][][][][][][][][]", "[20px][20px][23px][][][][]"));
		
		welcomeLabel = new JLabel("Welcome to Beam deformation calculator. Please log in");
		add(welcomeLabel, "cell 2 0 6 1,alignx center");
		
		userNameLabel = new JLabel("Username: ");
		add(userNameLabel, "cell 5 3,alignx right,aligny center");
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		add(userNameTextField, "cell 6 3,growx,aligny top");
		
		passwordLabel = new JLabel("Password: ");
		add(passwordLabel, "cell 5 4,alignx right,aligny center");
		
		passwordField = new JPasswordField();
		add(passwordField, "cell 6 4,growx,aligny top");
		
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				root.showChooseMaterialPanel();
				
			}
		});
		add(loginButton, "cell 6 5,growx,aligny top");
		
		
	}
}
