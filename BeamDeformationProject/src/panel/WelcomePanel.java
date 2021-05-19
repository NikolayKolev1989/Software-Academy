package panel;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JPasswordField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import db.User;
import frame.MainFrame;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;

public class WelcomePanel extends JPanel {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MainFrame root;
	private JTextField usernameTxtField;
	private JPasswordField passwordField;
	private JLabel usernameLabel, passwordLabel, titleLabel;
	private JButton loginButton, registerButton;
	private char[] password;
	private String stringToHash;
	private String hashedPass;
	private boolean isValidPass;
	private boolean isValidUser;

	
	public WelcomePanel (MainFrame root){
		
		titleLabel = new JLabel("Structure Deformation calculator");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		
		usernameTxtField = new JTextField();
		usernameTxtField.setColumns(10);
		
		passwordField = new JPasswordField();
		
//		LOGIN BUTTON
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
//			FIRST TRY - USERNAME. IF OK THEN HASH ENTERED PASSWORD AND == WITH EXISTED PASSWORD FOR THIS USERNAME. IF OK -> LOGIN
			@Override
			public void actionPerformed(ActionEvent e) {
				validateUsername();
				if (!isValidUser) {
					JOptionPane.showMessageDialog(null, "Wrong username or password", "Error", JOptionPane.INFORMATION_MESSAGE);
				}else {
					hashPassword();
					validatePassword();
					if (isValidPass) {
						root.showChooseCasePanel();
					}else {
						JOptionPane.showMessageDialog(null, "Wrong username or password", "Error", JOptionPane.INFORMATION_MESSAGE);
					}
					System.out.println(hashedPass);
				}
				
			}
		});
		
//		REGISTER BUTTON
		registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				root.showRegisterPanel();
				
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(93)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(registerButton)
									.addGap(18)
									.addComponent(loginButton))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(passwordLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(passwordField))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(usernameLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(usernameTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addComponent(titleLabel)))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(titleLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameLabel)
						.addComponent(usernameTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordLabel))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(registerButton)
						.addComponent(loginButton))
					.addContainerGap(296, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		
	}
	
//	VALIDATE USERNAME - IF USERNAME EXISTS IN DB -> OK
	public boolean validateUsername() {
		User user;
		isValidUser = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
		EntityManager em = emf.createEntityManager();
		if ((user = em.find(User.class,usernameTxtField.getText())) != null) {
			return isValidUser = true;
		}else {
			return isValidUser = false;
		}
		
	}
	
//	VALIDATE PASSWORD - IF ENTERED HASHED PASSWORD IS DIFFERENT THAN STORED HASHED PASSWORT -> FALSE
	public boolean validatePassword() {
		isValidPass = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
		EntityManager em = emf.createEntityManager();
		User user = em.find(User.class,usernameTxtField.getText());
		String passToCheck = user.getHashedPassword();
		if (passToCheck.equals(hashedPass)) {
			isValidPass = true;
		}else {
			isValidPass = false;
		}
		em.close();
		emf.close();
		return isValidPass;
	}
	
//	HASHING PASSWORD JAVA ALGORITHM
	public String hashPassword() {
		stringToHash = "";
		hashedPass = "";
		password = passwordField.getPassword();
		for (char c : password) {
			stringToHash += c;
		}
		
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		messageDigest.update(stringToHash.getBytes());
		hashedPass = new String(messageDigest.digest());
		return hashedPass;
	}
	

}
