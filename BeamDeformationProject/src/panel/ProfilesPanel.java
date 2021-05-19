package panel;

import javax.swing.JPanel;

import frame.MainFrame;

import java.awt.Image;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.cj.Query;

import cases.Case1;
import cases.Case2;
import cases.Case3;
import cases.Case4;
import db.CaseStatus;
import db.CircularHollowSection;
import db.EqualAngleL;
import db.RectangularHollowSection;
import db.SquareHollowSection;
import db.UnequalAngleL;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.SystemColor;

public class ProfilesPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainFrame root;
	private JLabel chsLabel, rhsLabel, shsLabel, leLabel, luLabel;
	private JRadioButton chsRadio, rhsRadio, shsRadio, leRadio, luRadio;
	private JButton backButton;
	private JButton calculateButton;
	private JLabel reactionLabel;
	private JLabel elasticModulusLabel;
	private JLabel inertiaLabel;
	private JLabel forceLabel;
	private JLabel totalLenghtLabel;
	private JLabel randomLenghtLabel;
	private JLabel reactionDim;
	private JLabel forceDim;
	private JLabel totalLenghtDim;
	private JLabel xLenghtDim;
	private JLabel elasticityDim;
	private JLabel inertiaDim;
	private JLabel case2ImageLabel;
	private JLabel case3ImageLabel;
	private JLabel case4ImageLabel;
	private JLabel defAtPLabel;
	private JLabel defAtPDimLabel;
	private JLabel momentAtXLabel;
	private JLabel momentAtXDimLabel;
	private JLabel maxMomentLabel;
	private JLabel maxMomentDimLabel;
	private JTextField txtInertia;
	private JTextField txtElastic;
	private JTextField txtReaction;
	private JTextField txtForce;
	private JTextField txtTotalLenght;
	private JTextField txtRandomLenght;
	private JLabel case1ImageLabel;
	private JComboBox chsComboBox;
	private JComboBox rhsComboBox;
	private JComboBox shsComboBox;
	private JComboBox leComboBox;
	private JComboBox luComboBox;
	private JTextField defAtPTextField;
	private JTextField momentAtXTextField;
	private JTextField maxMomentTextField;
	private double inertia;
	private double force;
	private double totalLenght;
	private double randomLenght;
	
	
	@SuppressWarnings("unchecked")
	public ProfilesPanel(MainFrame root) {
		this.root = root;
//		ChooseCasePanel chooseCasePanel = new ChooseCasePanel(root);
//		System.out.println("case -> "+chooseCasePanel.getCaseStatus());	// zashto dava "0" vseki pyt ???
		
//		CREATE PROFILE LABELS, TEXTFIELDS AND BUTTONS
		chsLabel = new JLabel("CHS");
		ImageIcon chsIcon = new ImageIcon("./profile-icons/icon-profile-chs.png");
		chsLabel.setIcon(chsIcon);
		
		rhsLabel = new JLabel("RHS");
		ImageIcon rhsIcon = new ImageIcon("./profile-icons/icon-profile-rhs.png");
		rhsLabel.setIcon(rhsIcon);
		
		shsLabel = new JLabel("SHS");
		ImageIcon shsIcon = new ImageIcon("./profile-icons/icon-profile-shs.png");
		shsLabel.setIcon(shsIcon);
		
		leLabel = new JLabel("Le");
		ImageIcon leIcon = new ImageIcon("./profile-icons/icon-profile-le.png");
		leLabel.setIcon(leIcon);
		
		luLabel = new JLabel("Lu");
		ImageIcon luIcon = new ImageIcon("./profile-icons/icon-profile-lu.png");
		luLabel.setIcon(luIcon);
		validate();
		
		chsRadio = new JRadioButton("CHS");
		rhsRadio = new JRadioButton("RHS");
		shsRadio = new JRadioButton("SHS");
		leRadio = new JRadioButton("Le");
		luRadio = new JRadioButton("Lu");
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(chsRadio);
		buttons.add(rhsRadio);
		buttons.add(shsRadio);
		buttons.add(leRadio);
		buttons.add(luRadio);
		
//		------------------------
		
		backButton = new JButton("Back");
		backButton.addActionListener(e->{
			clearCaseStatus();
			root.showChooseCasePanel();
		});
		
		reactionLabel = new JLabel("Reaction [A]");
		elasticModulusLabel = new JLabel("Elastic Modulus [E]");
		inertiaLabel = new JLabel("Moment of Inertia [J]");
		forceLabel = new JLabel("Applied Force [P]");
		totalLenghtLabel = new JLabel("Total Lenght [L]");
		randomLenghtLabel = new JLabel("Random Lenght [x]");
		
//		FIELDS TO BE AUTO-FILLED
		txtInertia = new JTextField();
		txtInertia.setColumns(8);
		txtInertia.setEditable(false);
		
		txtElastic = new JTextField();
		txtElastic.setText("2.1e11");
		txtElastic.setColumns(8);
		txtElastic.setEditable(false);
		
		txtReaction = new JTextField();
		txtReaction.setColumns(8);
		txtReaction.setEditable(false);
		
//		FIELDS TO BE FILLED BY USER
		txtForce = new JTextField();
		txtForce.setColumns(8);
		
		txtTotalLenght = new JTextField();
		txtTotalLenght.setColumns(8);
		
		txtRandomLenght = new JTextField();
		txtRandomLenght.setColumns(8);
		
		
//		CASES IMAGES
		case1ImageLabel = new JLabel("pic1");
		case2ImageLabel = new JLabel("pic2");
		case3ImageLabel = new JLabel("pic3");
		case4ImageLabel = new JLabel("pic4");
		case1ImageLabel.setVisible(false);
		case2ImageLabel.setVisible(false);
		case3ImageLabel.setVisible(false);
		case4ImageLabel.setVisible(false);
		
		if(getCaseStatus() == 1) {
			case1ImageLabel = new JLabel("pic1");
			ImageIcon imgIcon1 = new ImageIcon("./cases-images/case1.png");
			Image image1 = imgIcon1.getImage();
			Image newImage1 = image1.getScaledInstance(350, 150, Image.SCALE_SMOOTH);
			ImageIcon case1img = new ImageIcon(newImage1);
			case1ImageLabel.setIcon(case1img);
			case1ImageLabel.setVisible(true);
			
		}
		if(getCaseStatus() == 2) {
			case2ImageLabel = new JLabel("pic2");
			ImageIcon imgIcon1 = new ImageIcon("./cases-images/case2.png");
			Image image1 = imgIcon1.getImage();
			Image newImage1 = image1.getScaledInstance(350, 150, Image.SCALE_SMOOTH);
			ImageIcon case1img = new ImageIcon(newImage1);
			case2ImageLabel.setIcon(case1img);
			case2ImageLabel.setVisible(true);
		}
		if(getCaseStatus() == 3) {
			case3ImageLabel = new JLabel("pic3");
			ImageIcon imgIcon1 = new ImageIcon("./cases-images/case3.png");
			Image image1 = imgIcon1.getImage();
			Image newImage1 = image1.getScaledInstance(350, 150, Image.SCALE_SMOOTH);
			ImageIcon case1img = new ImageIcon(newImage1);
			case3ImageLabel.setIcon(case1img);
			case3ImageLabel.setVisible(true);
		}
		if(getCaseStatus() == 4) {
			case4ImageLabel = new JLabel("pic4");
			ImageIcon imgIcon1 = new ImageIcon("./cases-images/case4.png");
			Image image1 = imgIcon1.getImage();
			Image newImage1 = image1.getScaledInstance(350, 150, Image.SCALE_SMOOTH);
			ImageIcon case1img = new ImageIcon(newImage1);
			case4ImageLabel.setIcon(case1img);
			case4ImageLabel.setVisible(true);
		}

		
//		CREATE COMBOBOXES WITH SECTION TYPES
		String [] chsTypes = {"21.3x2.3","21.3x2.6","21.3x3.2","26.9x2.3","26.9x2.6","26.9x3.2","33.7x2.6","33.7x3.2","33.7x4","42.4x2.6","42.4x3.2",
				"42.4x4","48.3x2.6","48.3x3.2","48.3x4","48.3x5","60.3x2.6","60.3x3.2","60.3x4","60.3x5","76.1x2.6","76.1x3.2","76.1x4","76.1x5","88.9x3.2",
				"88.9x4","88.9x5","88.9x6.3","101.6x3.2","101.6x4","101.6x5","101.6x6.3","101.6x8","101.6x10","114.3x3.2","114.3x4","114.3x5","114.3x6.3",
				"114.3x8","114.3x10","139.7x4","139.7x5","139.7x6.3","139.7x8","139.7x10","139.7x12.5","168.3x4","168.3x5","168.3x6.3","168.3x8","168.3x10",
				"168.3x12.5","177.8x5","177.8x6.3","177.8x8","177.8x10","177.8x12.5","193.7x5","193.7x6.3","193.7x8","193.7x10","193.7x12.5","193.7x14.2",
				"193.7x16","219.1x5","219.1x6.3","219.1x8","219.1x10","219.1x12.5","219.1x14.2","219.1x16","219.1x20","244.5x5","244.5x6.3","244.5x8",
				"244.5x10","244.5x12.5","244.5x14.2","244.5x16","244.5x20","244.5x25","273x5","273x6.3","273x8","273x10","273x12.5","273x14.2","273x16",
				"273x20","273x25","323.9x5","323.9x6.3","323.9x8","323.9x10","323.9x12.5","323.9x14.2","323.9x16","323.9x20","323.9x25","355.6x6.3","355.6x8",
				"355.6x10","355.6x12.5","355.6x14.2","355.6x16","355.6x20","355.6x25","406.4x6.3","406.4x8","406.4x10","406.4x12.5","406.4x14.2","406.4x16",
				"406.4x20","406.4x25","406.4x30","406.4x40","457x6.3","457x8","457x10","457x12.5","457x14.2","457x16","457x20","457x25","457x30","457x40",
				"508x6.3","508x8","508x10","508x12.5","508x14.2","508x16","508x20","508x25","508x30","508x40","508x50","610x6.3","610x8","610x10","610x12.5",
				"610x14.2","610x16","610x20","610x25","610x30","610x40","610x50","711x6.3","711x8","711x10","711x12.5","711x14.2","711x16","711x20","711x25",
				"711x30","711x40","711x50","711x60","762x6","762x6.3","762x8","762x10","762x12.5","762x14.2","762x16","762x20","762x25","762x30","762x40",
				"762x50","813x8","813x10","813x12.5","813x14.2","813x16","813x20","813x25","813x30","914x8","914x10","914x12.5","914x14.2","914x16","914x20",
				"914x25","914x30","1016x8","1016x10","1016x12.5","1016x14.2","1016x16","1016x20","1016x25","1016x30","1067x10","1067x12.5","1067x14.2","1067x16",
				"1067x20","1067x25","1067x30","1168x10","1168x12.5","1168x14.2","1168x16","1168x20","1168x25","1219x10","1219x12.5","1219x14.2","1219x16",
				"1219x20","1219x25"};
		
		String [] rhsTypes = {"50x30x2.6","50x30x3.2","50x30x4","50x30x5","60x40x2.6","60x40x3.2","60x40x4","60x40x5","60x40x6.3","80x40x3.2","80x40x4",
				"80x40x5","80x40x6.3","80x40x8","90x50x3.2","90x50x4","90x50x5","90x50x6.3","90x50x8","100x50x3.2","100x50x4","100x50x5","100x50x6.3",
				"100x50x8","100x60x3.2","100x60x4","100x60x5","100x60x6.3","100x60x8","120x60x4","120x60x5","120x60x6.3","120x60x8","120x60x10","120x80x4",
				"120x80x5","120x80x6.3","120x80x8","120x80x10","140x80x4","140x80x5","140x80x6.3","140x80x8","140x80x10","150x100x4","150x100x5","150x100x6.3",
				"150x100x8","150x100x10","150x100x12.5","160x80x4","160x80x5","160x80x6.3","160x80x8","160x80x10","160x80x12.5","180x100x4","180x100x5",
				"180x100x6.3","180x100x8","180x100x10","180x100x12.5","200x100x4","200x100x5","200x100x6.3","200x100x8","200x100x10","200x100x12.5","200x100x16",
				"200x120x6.3","200x120x8","200x120x10","200x120x12.5","250x150x6.3","250x150x8","250x150x10","250x150x12.5","250x150x14.2","250x150x16","260x180x6.3",
				"260x180x8","260x180x10","260x180x12.5","260x180x14.2","260x180x16","300x200x6.3","300x200x8","300x200x10","300x200x12.5","300x200x14.2","300x200x16",
				"350x250x6.3","350x250x8","350x250x10","350x250x12.5","350x250x14.2","350x250x16","400x200x8","400x200x10","400x200x12.5","400x200x14.2",
				"400x200x16","450x250x8","450x250x10","450x250x12.5","450x250x14.2","450x250x16","500x300x10","500x300x12.5","500x300x14.2","500x300x16","500x300x20"};
		
		String [] shsTypes = {"40x2.6","40x3.2","40x4","40x5","50x2.6","50x3.2","50x4","50x5","50x6.3","60x2.6","60x3.2","60x4","60x5",
				"60x6.3","60x8","70x3.2","70x4","70x5","70x6.3","70x8","80x3.2","80x4","80x5","80x6.3","80x8","90x4","90x5","90x6.","90x8","100x4","100x5",
				"100x6.3","100x8","100x10","120x5","120x6.3","120x8","120x10","120x12.5","140x5","140x6.3","140x8","140x10","140x12.5","150x5","150x6.3",
				"150x8","150x10","150x12.5","150x14.2","150x16","160x5","160x6.3","160x8","160x10","160x12.5","160x16","180x5","180x6.3","180x8","180x10",
				"180x12.5","180x14.2","180x16","200x5","200x6.3","200x8","200x10","200x12.5","200x14.2","200x16","220x6.3","220x8","220x10","220x12.5",
				"220x14.2","220x16","250x6.3","250x8","250x10","250x12.5","250x14.2","250x16","260x6.3","260x8","260x10","260x12.5","260x14.2","260x16",
				"300x6.3","300x8","300x10","300x12.5","300x14.2","300x16","350x8","350x10","350x12.5","350x14.2","350x16","400x10","400x12.5","400x14.2",
				"400x16","400x20"};
		
		String [] leTypes = {"20x20x3","22x22x3","25x25x3","25x25x4","28x28x3","30x30x4","32x32x3","32x32x4","35x35x3","35x35x4","36x36x3","36x36x4","40x40x3",
				"40x40x4","40x40x5","45x45x3","45x45x4","45x45x5","50x50x4","50x50x5","50x50x6","50x50x7","55x55x5","55x55x6","56x56x4","56x56x5","56x56x6","60x60x4",
				"60x60x5","60x60x6","60x60x8","63x63x4","63x63x5","63x63x6","65x65x6","65x65x7","65x65x8","70x70x5","70x70x6","70x70x8","70x70x9","75x75x4",
				"75x75x5","75x75x6","75x75x7","75x75x8","75x75x10","80x80x5","80x80x6","80x80x7","80x80x8","80x80x10","90x90x6","90x90x7","90x90x8","90x90x9",
				"90x90x10","90x90x11","100x100x6","100x100x7","100x100x8","100x100x10","100x100x12","110x110x8","110x110x10","110x110x12",
				"120x120x8","120x120x10","120x120x11","120x120x12","120x120x13","120x120x15","120x120x16","125x125x8","125x125x10","125x125x12","125x125x14",
				"130x130x10","130x130x12","130x130x13","130x130x14","130x130x16","140x140x10","140x140x12","140x140x14","150x150x10","150x150x12","150x150x13",
				"150x150x14","150x150x15","150x150x16","150x150x18","150x150x20","160x160x10","160x160x12","160x160x14","160x160x15","160x160x16","160x160x17",
				"180x180x12","180x180x13","180x180x14","180x180x15","180x180x16","180x180x17","180x180x18","180x180x19","180x180x20","200x200x14",
				"200x200x15","200x200x16","200x200x17","200x200x18","200x200x19","200x200x20","200x200x21","200x200x22","200x200x23","200x200x24","200x200x25",
				"200x200x26","250x250x20","250x250x21","250x250x22","250x250x23","250x250x24","250x250x25","250x250x26","250x250x27","250x250x28","250x250x35"};
		
		String [] luTypes = {"25x16x3","30x20x3","30x20x4","32x20x3","40x25x3","40x25x4","40x25x5","45x28x4","45x30x4","45x30x5","50x30x4","50x30x5","50x32x3",
				"50x32x4","56x36x4","56x36x5","60x40x5","60x40x6","60x40x7","63x40x4","63x40x5","63x40x6","65x50x5","65x50x6","65x50x7","65x50x8","70x45x5",
				"70x45x6","75x50x5","75x50x6","75x50x7","75x50x8","80x50x5","80x50x6","80x50x8","80x60x6","80x60x7","80x60x8","90x56x6","90x56x8","90x60x6",
				"90x60x8","100x63x8","100x63x10","100x65x7","100x65x8","100x65x9","100x65x10","100x65x12","110x70x8","110x70x10","110x70x12","120x80x8",
				"120x80x10","120x80x12","125x75x8","125x75x9","125x75x10","125x75x12","125x80x8","125x80x10","125x80x12","130x90x10","130x90x12",
				"130x90x14","140x90x8","140x90x10","140x90x12","140x90x14","150x75x9","150x75x10","150x75x11","150x75x12","150x90x10","150x90x11","150x90x12",
				"150x90x15","150x100x10","150x100x12","150x100x14","160x100x10","160x100x12","160x100x14","160x100x16","200x100x10","200x100x12",
				"200x100x14","200x100x15"};
		
		chsComboBox = new JComboBox(chsTypes);
		rhsComboBox = new JComboBox(rhsTypes);
		shsComboBox = new JComboBox(shsTypes);
		leComboBox = new JComboBox(leTypes);
		luComboBox = new JComboBox(luTypes);
		chsComboBox.setVisible(false);
		rhsComboBox.setVisible(false);
		shsComboBox.setVisible(false);
		leComboBox.setVisible(false);
		luComboBox.setVisible(false);
		
//		RADIOBUTTONS - SHOWS DIFFERENT COMBOBOX WHEN A RADIOBUTTON IS SELECTED
		chsRadio.addActionListener(e->{
			if (chsRadio.isSelected()) {
				chsComboBox.setVisible(true);
				rhsComboBox.setVisible(false);
				shsComboBox.setVisible(false);
				leComboBox.setVisible(false);
				luComboBox.setVisible(false);
			}
		});
		rhsRadio.addActionListener(e->{
			if(rhsRadio.isSelected()) {
				rhsComboBox.setVisible(true);
				chsComboBox.setVisible(false);
				shsComboBox.setVisible(false);
				leComboBox.setVisible(false);
				luComboBox.setVisible(false);
			}
		});
		shsRadio.addActionListener(e->{
			if(shsRadio.isSelected()) {
				shsComboBox.setVisible(true);
				chsComboBox.setVisible(false);
				rhsComboBox.setVisible(false);
				leComboBox.setVisible(false);
				luComboBox.setVisible(false);
			}
		});
		leRadio.addActionListener(e->{
			if(leRadio.isSelected()) {
				leComboBox.setVisible(true);
				chsComboBox.setVisible(false);
				rhsComboBox.setVisible(false);
				shsComboBox.setVisible(false);
				luComboBox.setVisible(false);
			}
		});
		luRadio.addActionListener(e->{
			if(luRadio.isSelected()) {
				luComboBox.setVisible(true);
				chsComboBox.setVisible(false);
				rhsComboBox.setVisible(false);
				shsComboBox.setVisible(false);
				leComboBox.setVisible(false);
			}
		});
		
//		DIMENTION LABELS
		reactionDim = new JLabel("N");
		forceDim = new JLabel("N");
		totalLenghtDim = new JLabel("m");	
		xLenghtDim = new JLabel("m");
		elasticityDim = new JLabel("N/m"+"\u00B2");
		inertiaDim = new JLabel("m"+"\u2074");
		defAtPDimLabel = new JLabel("m");
		momentAtXDimLabel = new JLabel("Nm");
		maxMomentDimLabel = new JLabel("Nm");
		
//		RESULT FIELDS
		defAtPLabel = new JLabel("Deformation at P");
		defAtPTextField = new JTextField();
		defAtPTextField.setBackground(SystemColor.info);
		defAtPTextField.setColumns(7);
		defAtPTextField.setEditable(false);;
		
		momentAtXLabel = new JLabel("Bending moment at X");
		momentAtXTextField = new JTextField();
		momentAtXTextField.setBackground(SystemColor.info);
		momentAtXTextField.setColumns(8);
		momentAtXTextField.setEditable(false);
		
		
		maxMomentLabel = new JLabel("Max. bending moment");
		maxMomentTextField = new JTextField();
		maxMomentTextField.setBackground(SystemColor.info);
		maxMomentTextField.setColumns(8);
		
//		CALCULATION
		calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(e->{
			getInertia();
			getResult();
			
		});
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(chsRadio)
								.addComponent(chsLabel))
							.addGap(53)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rhsRadio)
								.addComponent(rhsLabel))
							.addGap(57)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(shsRadio)
								.addComponent(shsLabel))
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(leLabel)
								.addComponent(leRadio))
							.addGap(63)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(luLabel)
								.addComponent(luRadio)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(chsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rhsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(shsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(leComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(luComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(inertiaLabel)
								.addComponent(elasticModulusLabel)
								.addComponent(reactionLabel)
								.addComponent(forceLabel)
								.addComponent(totalLenghtLabel)
								.addComponent(randomLenghtLabel))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtRandomLenght, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
								.addComponent(txtTotalLenght, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
								.addComponent(txtForce, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
								.addComponent(txtInertia, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
								.addComponent(txtElastic, 0, 0, Short.MAX_VALUE)
								.addComponent(txtReaction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(xLenghtDim)
								.addComponent(inertiaDim)
								.addComponent(forceDim)
								.addComponent(totalLenghtDim)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(elasticityDim)
										.addComponent(reactionDim))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(case1ImageLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(case2ImageLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(case3ImageLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(case4ImageLabel)))))
					.addGap(74))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(calculateButton)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(defAtPTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(defAtPDimLabel))
						.addComponent(defAtPLabel))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(momentAtXLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(momentAtXTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(momentAtXDimLabel)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(maxMomentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(maxMomentDimLabel))
						.addComponent(maxMomentLabel))
					.addContainerGap(35, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(backButton)
					.addContainerGap(465, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(chsLabel)
								.addComponent(luLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(luRadio)
								.addComponent(chsRadio)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(shsLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(shsRadio))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rhsLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rhsRadio))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(leLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(leRadio)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rhsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(shsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(leComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(luComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(reactionLabel)
								.addComponent(txtReaction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(reactionDim))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(elasticModulusLabel)
								.addComponent(txtElastic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(elasticityDim))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(inertiaLabel)
								.addComponent(txtInertia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(inertiaDim))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(forceLabel)
								.addComponent(txtForce, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(forceDim))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(totalLenghtLabel)
								.addComponent(txtTotalLenght, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(totalLenghtDim))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(randomLenghtLabel)
								.addComponent(txtRandomLenght, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(xLenghtDim)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(case1ImageLabel)
								.addComponent(case2ImageLabel)
								.addComponent(case3ImageLabel)
								.addComponent(case4ImageLabel))))
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(maxMomentLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(maxMomentDimLabel)
										.addComponent(maxMomentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(momentAtXLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(momentAtXTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(momentAtXDimLabel)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(defAtPLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(defAtPTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(defAtPDimLabel))))
							.addGap(1))
						.addComponent(calculateButton))
					.addGap(97)
					.addComponent(backButton)
					.addGap(29))
		);
		setLayout(groupLayout);
		
		
	}
	
//	FILL TEXT FIELDS WITH PARAMETERS
	public void getResult() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
		EntityManager em = emf.createEntityManager();
		if (!chsRadio.isSelected() && !shsRadio.isSelected() && !rhsRadio.isSelected() && !leRadio.isSelected() && !luRadio.isSelected()) {
			JOptionPane.showMessageDialog(null, "Select profile!", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			if (getCaseStatus() == 1) {
				try {
					force = Double.parseDouble(txtForce.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter Number for \"Applied Force\"!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					totalLenght = Double.parseDouble(txtTotalLenght.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter Number for \"Total Lenght\"!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					randomLenght = Double.parseDouble(txtRandomLenght.getText());
					if (randomLenght >= totalLenght) {
						JOptionPane.showMessageDialog(null, "\"Random Lenght\" should be less than \"Total Lenght\"", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter Number for \"Random Lenght\"!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				Case1 case1 = new Case1(force, totalLenght ,randomLenght , inertia);
				txtInertia.setText(""+ inertia);
				txtReaction.setText(""+ case1.getReactionAtA());
				defAtPTextField.setText(String.format("%.4f", case1.getDeformationAtP()));
				maxMomentTextField.setText(String.format("%.2f",case1.getMaxMoment()));
				momentAtXTextField.setText(String.format("%.2f",case1.getxMoment()));
			}
			if (getCaseStatus() == 2) {
				try {
					force = Double.parseDouble(txtForce.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter Number for \"Applied Force\"!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					totalLenght = Double.parseDouble(txtTotalLenght.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter Number for \"Total Lenght\"!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					randomLenght = Double.parseDouble(txtRandomLenght.getText());
					if (randomLenght >= totalLenght) {
						JOptionPane.showMessageDialog(null, "\"Random Lenght\" should be less than \"Total Lenght\"", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter Number for \"Random Lenght\"!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				Case2 case2 = new Case2(force, totalLenght ,randomLenght , inertia);
				txtInertia.setText(""+ inertia);
				txtReaction.setText(""+ case2.getReactionAtA());
				defAtPTextField.setText(String.format("%.4f", case2.getDeformationAtP()));
				maxMomentTextField.setText(""+ case2.getMaxMoment());
				momentAtXTextField.setText(""+ case2.getxMoment());
			}
			if (getCaseStatus() == 3) {
				try {
					force = Double.parseDouble(txtForce.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter Number for \"Applied Force\"!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					totalLenght = Double.parseDouble(txtTotalLenght.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter Number for \"Total Lenght\"!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					randomLenght = Double.parseDouble(txtRandomLenght.getText());
					if (randomLenght >= totalLenght) {
						JOptionPane.showMessageDialog(null, "\"Random Lenght\" should be less than \"Total Lenght\"", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter Number for \"Random Lenght\"!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				Case3 case3 = new Case3(force, totalLenght ,randomLenght , inertia);
				txtInertia.setText(""+ inertia);
				txtReaction.setText(""+ case3.getReactionAtA());
				defAtPTextField.setText(String.format("%.4f", case3.getDeformationAtP()));
				maxMomentTextField.setText(""+ case3.getMaxMoment());
				momentAtXTextField.setText(""+ case3.getxMoment());
			}
			if (getCaseStatus() == 4) {
				try {
					force = Double.parseDouble(txtForce.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter Number for \"Applied Force\"!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					totalLenght = Double.parseDouble(txtTotalLenght.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter Number for \"Total Lenght\"!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					randomLenght = Double.parseDouble(txtRandomLenght.getText());
					if (randomLenght >= totalLenght) {
						JOptionPane.showMessageDialog(null, "\"Random Lenght\" should be less than \"Total Lenght\"", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Enter Number for \"Random Lenght\"!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				Case4 case4 = new Case4(force, totalLenght ,randomLenght , inertia);
				txtInertia.setText(""+ inertia);
				txtReaction.setText(""+ case4.getReactionAtA());
				defAtPTextField.setText(String.format("%.4f", case4.getDeformationAtP()));
				maxMomentTextField.setText(""+ case4.getMaxMoment());
				momentAtXTextField.setText(""+ case4.getxMoment());
			}
		}

	}
	
//	GET SECTION INERTIA MOMENT FROM DATABASE
	public void getInertia() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
		EntityManager em = emf.createEntityManager();
		
		if (chsRadio.isSelected()) {
			CircularHollowSection chs = em.find(CircularHollowSection.class, chsComboBox.getSelectedItem());
			inertia = chs.getInertia()/1000000000000L;
		}
		if (rhsRadio.isSelected()) {
			RectangularHollowSection rhs = em.find(RectangularHollowSection.class, rhsComboBox.getSelectedItem());
			inertia = rhs.getInertia()/1000000000000L;
		}
		if (shsRadio.isSelected()) {
			SquareHollowSection shs = em.find(SquareHollowSection.class, shsComboBox.getSelectedItem());
			inertia = shs.getInertia()/1000000000000L;
		}
		if (leRadio.isSelected()) {
			EqualAngleL le = em.find(EqualAngleL.class, leComboBox.getSelectedItem());
			inertia = le.getInertia()/1000000000000L;
		}
		if (luRadio.isSelected()) {
			UnequalAngleL lu = em.find(UnequalAngleL.class, luComboBox.getSelectedItem());
			inertia = lu.getInertia()/1000000000000L;
		}
		em.close();
		emf.close();
	}
	
//	DELETE CONTENT IN TABLE HOLDING THE CURRENT CASE STATUS
	public void clearCaseStatus() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		CaseStatus caseStatus = em.find(CaseStatus.class, 1);
		if (caseStatus == null) {
			System.out.println("caseStatus e null");	// for debug purposes
		}else{
			em.remove(caseStatus);
		}
		tx.commit();
		em.close();
		emf.close();
	}
	
	
//	GET THE CONTENT IN TABLE HOLDING THE CURRENT CASE STATUS
	public int getCaseStatus() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("static_tools");
		EntityManager em = emf.createEntityManager();
		CaseStatus caseStatus = em.find(CaseStatus.class, 1);
		int status = caseStatus.getStatus();
		em.close();
		emf.close();
		return status;
	}
}
