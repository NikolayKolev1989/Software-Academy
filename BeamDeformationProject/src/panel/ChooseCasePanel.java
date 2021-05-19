package panel;

import javax.swing.JPanel;

import frame.MainFrame;

import java.awt.Image;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import db.CaseStatus;

import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class ChooseCasePanel extends JPanel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MainFrame root;
	public CaseStatus caseValue;
	private JButton case1Button;
	private JButton case2Button;
	private JButton case3Button;
	private JButton case4Button;
	private JLabel case1Label;
	private JLabel case2Label;
	private JLabel case3Label;
	private JLabel case4Label;
	private JButton backButton;
	private int caseStatus;

	public ChooseCasePanel (MainFrame root) {
		this.root = root;
		
//		Choose case buttons. Redirect to same panel, but keep different case status (get with getCaseStatus method)
		case1Button = new JButton("Choose");
		case1Button.addActionListener(e->{
//			setCaseStatus(1);
			setCaseValue(1);
			root.showProfilesPanel();
		});
		
		case1Label = new JLabel("case1");
		ImageIcon imgIcon1 = new ImageIcon("./cases-images/case1.png");
		Image image1 = imgIcon1.getImage();
		Image newImage1 = image1.getScaledInstance(350, 150, Image.SCALE_SMOOTH);
		ImageIcon case1img = new ImageIcon(newImage1);
		case1Label.setIcon((Icon) case1img);
		
		case2Button = new JButton("Choose");
		case2Button.addActionListener(e->{
//			this.caseStatus = 2;
			setCaseValue(2);
			root.showProfilesPanel();
		});
		
		case2Label = new JLabel("case2");
		ImageIcon imgIcon2 = new ImageIcon("./cases-images/case2.png");
		Image image2 = imgIcon2.getImage();
		Image newImage2 = image2.getScaledInstance(350, 150, Image.SCALE_SMOOTH);
		ImageIcon case2img = new ImageIcon(newImage2);
		case2Label.setIcon(case2img);
		
		case3Button = new JButton("Choose");
		case3Button.addActionListener(e->{
//			this.caseStatus = 3;
			setCaseValue(3);
			root.showProfilesPanel();
		});
		
		case3Label = new JLabel("case3");
		ImageIcon imgIcon3 = new ImageIcon("./cases-images/case3.png");
		Image image3 = imgIcon3.getImage();
		Image newImage3 = image3.getScaledInstance(350, 150, Image.SCALE_SMOOTH);
		ImageIcon case3img = new ImageIcon(newImage3);
		case3Label.setIcon(case3img);
		
		case4Button = new JButton("Choose");
		case4Button.addActionListener(e->{
//			this.caseStatus = 4;
			setCaseValue(4);
			root.showProfilesPanel();
		});
		
		case4Label = new JLabel("case4");
		ImageIcon imgIcon4 = new ImageIcon("./cases-images/case4.png");
		Image image4 = imgIcon4.getImage();
		Image newImage4 = image4.getScaledInstance(350, 150, Image.SCALE_SMOOTH);
		ImageIcon case4img = new ImageIcon(newImage4);
		case4Label.setIcon(case4img);
		validate();
		
//		Go Back Button
		backButton = new JButton("Back");
		backButton.addActionListener(e->{
			root.showWelcomePanel();
		});
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(case3Button)
								.addComponent(case2Button)
								.addComponent(case1Button)
								.addComponent(case4Button))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(case2Label)
								.addComponent(case1Label)
								.addComponent(case3Label)
								.addComponent(case4Label)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(backButton)))
					.addContainerGap(362, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(case1Button)
						.addComponent(case1Label))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(case2Button)
						.addComponent(case2Label))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(case3Button)
						.addComponent(case3Label))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(case4Button)
						.addComponent(case4Label))
					.addPreferredGap(ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
					.addComponent(backButton)
					.addContainerGap())
		);
		setLayout(groupLayout);
		
	}
//	public void setCaseStatus(int num) {
//		this.caseStatus = num;
//	}
//	
//	public int getCaseStatus () {
//		return this.caseStatus;
//	}
	
	public void setCaseValue(int statusNum) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		CaseStatus caseStatus = new CaseStatus(1,statusNum);
		em.persist(caseStatus);
		tx.commit();
		em.close();
		emf.close();
	}
}
