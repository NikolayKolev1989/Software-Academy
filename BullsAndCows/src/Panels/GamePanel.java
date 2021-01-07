package Panels;

import javax.swing.JPanel;

import Frame.MainFrame;
//import jdk.nashorn.api.tree.ForInLoopTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.TextArea;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class GamePanel extends JPanel{

	public MainFrame root;

	private JTextField enterNumTxtField;
	private JLabel enterNumLabel;
	private JLabel historyLabel;
	private JButton enterNumButton;
	private char[] numToGuessArr;
	private char[] enteredNumArr;
	private int bullCounter = 0;
	private int cowCounter = 0;
	private JButton backButton;
	private JButton restartButton;
	private int keyStrokeCounter = 0;
	private JList history;
	private DefaultListModel<String> historyItems;
	private JScrollPane scrollPane;
	
	
	public GamePanel (MainFrame root) {
		setBackground(SystemColor.control);
		this.root = root;
		
//		Лист, в който се съхранява историята на играта
		historyItems = new DefaultListModel<String>();
		historyItems.removeAllElements();
		
//		Метод за генериране на 4-цифрено число
		randomNumGenerator();
		
		enterNumLabel = new JLabel("Въведи 4-цифрено число");
		enterNumLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		
/*		Текстово поле за въвеждане на числови стойности
*		като позволява да се въвеждат само 4 символа
*/
		enterNumTxtField = new JTextField();
		enterNumTxtField.setColumns(4);
		enterNumTxtField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (enterNumTxtField.getText().length() == 4) {
					numComparison();
					enterNumTxtField.setText("");
				}
	/*		Въвежда числовите стойности
	 *		като позволява да се въвеждат до 4 символа
	 *		Всеки 5-ти символ действа като ENTER BUTTON
	 *		Проблем е, че брои DELETE и BACKSPACE като
	 *		натискане на бутони. Не мога да го оправя
	 */		
//				keyStrokeCounter++;
//				if (keyStrokeCounter > 4) {
//					numComparison();
//					e.consume();
//					System.out.println(enterNumTxtField.getText());
//					enterNumTxtField.setText("");
//					keyStrokeCounter = 0;
//				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});

//		Бутон за въвеждане на числото от потребителя
		enterNumButton = new JButton("Въведи");
		enterNumButton.setBackground(SystemColor.controlHighlight);
		enterNumButton.addActionListener(new ActionListener() {
			@Override
//			позволява да се въвеждат само 4 символа
			public void actionPerformed(ActionEvent e) {
				if (enterNumTxtField.getText().length() == 4) {
					numComparison();
					enterNumTxtField.setText("");
				}
			}
		});
		
//		Разделяща вертикална линия
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
//		Бутон НАЗАД. Връща в Home менюто, като играта може да се продължи по-късно
		backButton = new JButton("Назад");
		backButton.setBackground(SystemColor.controlHighlight);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				root.showHomePanel();
			}
		});
		
//		Бутон РЕСТАРТ. Започва играта наново
		restartButton = new JButton("Рестарт");
		restartButton.setBackground(SystemColor.controlHighlight);
		restartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				root.newGamePanel();
			}
		});
		
//		Скрол на менюто с историята
		scrollPane = new JScrollPane();		
		historyLabel = new JLabel("История");
		historyLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		historyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(historyLabel);
		
//		Менюто вдясно, което показва историята на текущата игра
		history = new JList(historyItems);
		scrollPane.setViewportView(history);
		
		
//		Layout-и
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(78)
									.addComponent(enterNumLabel))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(107)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(enterNumButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(enterNumTxtField, Alignment.LEADING))))
							.addGap(81)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(backButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(restartButton)
							.addGap(30)))
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addComponent(enterNumLabel)
					.addGap(18)
					.addComponent(enterNumTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(enterNumButton)
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(backButton)
						.addComponent(restartButton))
					.addContainerGap(259, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	
	/*		Сравнява въведения номер с генерирания 
	*		и извежда броя на биковете и кравите
	*		При победа връща "YES / NO" прозорец
	*/		
	public void numComparison() {
		try {
			int testNum = Integer.parseInt(enterNumTxtField.getText());
			
			enteredNumArr = enterNumTxtField.getText().toCharArray();
			for (int i = 0; i < enteredNumArr.length; i++) {
				for (int j = 0; j < enteredNumArr.length; j++) {
					if (i == j) {
						if (enteredNumArr[i] == numToGuessArr[j]) {
							bullCounter++;
						}
					}else {
						if (enteredNumArr[i] == numToGuessArr[j]) {
							cowCounter++;
						}
					}
				}
			}
			
//			принтира въведеното число в конзолата и броя на биковете и кравите - ЗА ТЕСТВАНЕ
			System.out.println("User input -> " + Arrays.toString(enteredNumArr));
			System.out.println("BullCounter - "+bullCounter + " / cowCounter - " + cowCounter);
			
//			Ако биковете са 4 побеждаваш и извежда прозорез
			if (bullCounter == 4) {
				String number = "";
				for (int j = 0; j < enteredNumArr.length; j++) {
					number += enteredNumArr[j];
				}
				int result = JOptionPane.showConfirmDialog(null, "Честито! Искате ли да започнете нова игра?", "Ти позна числото " + number, JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					System.out.println("YES selected");
					root.newGamePanel();
				}else if (result == JOptionPane.NO_OPTION) {
					System.out.println("NO selected");
					System.exit(0);
				}else {
					System.out.println("None selected");
					System.exit(0);
				}
				System.out.println("bullCounter = 4");
			}
			
/*		Текст, който се създава на всеки ход, приема
*		резултата от текущия ход и влиза в историята
*/
			String historyText = "";
			for (int i = 0; i < enteredNumArr.length; i++) {
				historyText += enteredNumArr[i];
			}
			if (bullCounter == 1 && cowCounter == 1) {
				historyText +=  " - " + bullCounter +" бик;"  + cowCounter+ " крава";
			}else if(bullCounter == 1 && cowCounter != 1){
				historyText +=  " - " + bullCounter +" бик;"  + cowCounter+ " крави";
			}else if (bullCounter != 1 && cowCounter == 1) {
				historyText +=  " - " + bullCounter +" бика;"  + cowCounter+ " кравa";
			}else{
				historyText +=  " - " + bullCounter +" бика;"  + cowCounter+ " крави";
			}
			historyItems.addElement(historyText);

//			Зануляване на брояча след края на всеки ход
			bullCounter = 0;
			cowCounter = 0;	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Моля въведи число", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
/*	Генератор на произволно 4-цифрено число,
*	като проверява дали има повтарящи се цифри
*	и ако има, генерира ново число
*/
	public void randomNumGenerator() {
		boolean equalNumCheck = false;
		Random random = new Random();
		Integer randomNum = random.nextInt(8999)+1000;
		String randomNumStr = randomNum.toString();
		numToGuessArr = randomNumStr.toCharArray();
//		принтира генерираното число в конзолата - ЗА ТЕСТВАНЕ
		System.out.println("Gen. number -> " + Arrays.toString(numToGuessArr));
		do {
			if (equalNumCheck) {
				randomNum = random.nextInt(8999)+1000;
				randomNumStr = randomNum.toString();
				numToGuessArr = randomNumStr.toCharArray();
//				принтира новото генерирано число в конзолата - ЗА ТЕСТВАНЕ
				System.out.println("New gen. number -> " + Arrays.toString(numToGuessArr));
			}
			equalNumCheck=false;
			for (int i = 0; i < numToGuessArr.length; i++) {
				char[]temp = numToGuessArr;
				for (int j = 0; j < numToGuessArr.length; j++) {
					if (i != j) {
						if (temp[i] == numToGuessArr[j]) {
							equalNumCheck = true;
						}
					}
				}
			}
			
		} while (equalNumCheck);
	}
}
