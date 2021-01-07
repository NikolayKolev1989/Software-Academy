package Panels;

import javax.swing.JPanel;

import Frame.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.Color;

public class HomePanel extends JPanel{
	
	public MainFrame root;
	private JButton newGameButton;
	private JButton exitButton;
	private JButton continueButton;
	
	public HomePanel (MainFrame root) {
		setBackground(SystemColor.control);
		this.root = root;
		
//		Бутон за стартиране на нова игра
		newGameButton = new JButton("Нова игра");
		newGameButton.setBackground(SystemColor.controlHighlight);
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				root.newGamePanel();
			}
		});
		
//		Бутон за изход от играта
		exitButton = new JButton("Изход");
		exitButton.setBackground(SystemColor.controlHighlight);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		continueButton = new JButton("Продължи");
		continueButton.setBackground(SystemColor.controlHighlight);
		continueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				root.resumeGamePanel();
				
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(exitButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
						.addComponent(continueButton, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
						.addComponent(newGameButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(94))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addComponent(newGameButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(continueButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(exitButton)
					.addContainerGap(144, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
}
