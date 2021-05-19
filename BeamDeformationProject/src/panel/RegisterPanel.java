package panel;

import javax.swing.JPanel;

import frame.MainFrame;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import antlr.collections.List;
import antlr.debug.MessageAdapter;
import db.User;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class RegisterPanel extends JPanel{
	
	public MainFrame root;
	private JLabel usernameLabel;
	private JTextField usernameTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JLabel repeatPassLabel;
	private JTextField emailTextField;
	private JLabel emailLabel;
	private JButton addRegistrationButton;
	private JButton backButton;
	private JPasswordField repeatPassField;
	private boolean isValidEmail;
	private boolean isPasswordsEqual;
	private char[] password;
	private String stringToHash;
	private String hashedPass;
	
	public RegisterPanel(MainFrame root) {
		this.root = root;
		
		usernameLabel = new JLabel("Username:");
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		
		passwordLabel = new JLabel("Password:");
		passwordField = new JPasswordField();
		
		repeatPassLabel = new JLabel("Repeat password:");
		repeatPassField = new JPasswordField();
		
		emailLabel = new JLabel("Email adress:");
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		
		addRegistrationButton = new JButton("Register");
		addRegistrationButton.addActionListener(e->{
			
/*			== ENTERED PASSWORD WITH SECOND ENTERED PASSWORD.IF OK -> CHECK FOR VALID EMAIL ADRESS. IF OK
*			-> CHECK IF USERNAME EXISTS (BECAUSE IS ID IN DB). IF OK -> CHECK IF EMAIL ADRESS EXISTS (BECAUSE HAVE UNIQUE INDEX IN DB)
*/
			isPasswordsEqual();
			if(!isPasswordsEqual) {
				JOptionPane.showMessageDialog(null, "Both fields must contain similar password", "Error", JOptionPane.INFORMATION_MESSAGE);
			}else {
				hashPassword();
				validateEmail();
				if (!isValidEmail) {
					JOptionPane.showMessageDialog(null, "Email is not valid", "Error", JOptionPane.INFORMATION_MESSAGE);
				}else {
					EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
					EntityManager em = emf.createEntityManager();
					User user = em.find(User.class, usernameTextField.getText());
					try {
						registerUser();
					} catch (Exception e2) {
						if (user.getUsername().equals(usernameTextField.getText())) {
							JOptionPane.showMessageDialog(null, "User exists", "Error", JOptionPane.INFORMATION_MESSAGE);
						}else if(user.getEmail().equals(emailTextField.getText())) {
							JOptionPane.showMessageDialog(null, "Email exists", "Error", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
			
			
		});
			
		
		backButton = new JButton("Back");
		backButton.addActionListener(e->{
			root.showWelcomePanel();
		});
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(usernameLabel)
						.addComponent(passwordLabel)
						.addComponent(emailLabel)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(backButton)
							.addComponent(repeatPassLabel)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(repeatPassField)
						.addComponent(emailTextField)
						.addComponent(passwordField)
						.addComponent(usernameTextField)
						.addComponent(addRegistrationButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(252, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameLabel)
						.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(repeatPassLabel)
						.addComponent(repeatPassField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(emailLabel))
					.addGap(18)
					.addComponent(addRegistrationButton)
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addComponent(backButton)
					.addGap(21))
		);
		setLayout(groupLayout);
		
		
	}
	
//	CHECK IF PASSFIELD AND REPEATPASSFIELD ARE EQUALS
	public boolean isPasswordsEqual() {
		char [] password = passwordField.getPassword();
		char [] repeatPassword = repeatPassField.getPassword();
		String checkFirstPass = "";
		String checkSecondPass = "";
		for (char c : password) {
			checkFirstPass += c;
		}
		for (char c : repeatPassword) {
			checkSecondPass += c;
		}
		if (checkFirstPass.equals(checkSecondPass)) {
			return isPasswordsEqual = true;
		}else {
			return isPasswordsEqual = false;
		}
	}
	
//	HASHING PASSWORDS
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
	
	
	
//	VALIDATING EMAIL REGEX
	public boolean validateEmail() {
		String email = emailTextField.getText();
		String regex = "^[A-Za-z0-9+_.-]+@(?:[A-Za-z0-9.-])+[A-Za-z0-9]+\\.[a-z]{2,7}+$";

		if(email.matches(regex)) {
			isValidEmail = true;
		}else {
			isValidEmail = false;
		}
		return isValidEmail;
	}
	
//	ADD USER TO DATABASE
	public void registerUser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		User user = new User (usernameTextField.getText(), hashedPass, stringToHash , emailTextField.getText());
		em.persist(user);
		tx.commit();
		em.close();
		emf.close();
	}
	
	
	
	
}
