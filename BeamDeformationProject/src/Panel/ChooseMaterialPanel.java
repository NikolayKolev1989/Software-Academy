package Panel;

import javax.swing.JPanel;

import Frame.MainFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;


public class ChooseMaterialPanel extends JPanel  {
	
	private MainFrame root;
	private JLabel profiles;
	private JComboBox profileTypeComboBox;
	private JComboBox profileDimComboBox;
	private JLabel profilePicture;
	
	public ChooseMaterialPanel (MainFrame root) {
		this.root = root;
		
		profiles = new JLabel("Profiles");
		
		profileTypeComboBox = new JComboBox();
		
		profileDimComboBox  = new JComboBox();
		
		profilePicture = new JLabel("New label");
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(310, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(profiles)
							.addGap(82))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(profileDimComboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(profileTypeComboBox, Alignment.LEADING, 0, 83, Short.MAX_VALUE))
							.addGap(57))))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(98)
					.addComponent(profilePicture)
					.addContainerGap(306, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(profiles)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(profileTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(profileDimComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(profilePicture)
					.addContainerGap(127, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
