import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
	
	private JComboBox<Object> countryComboBox;
	private JComboBox<Object> cityComboBox;
	private JComboBox<Object> streetComboBox;
	private JPanel northPanel;
	
	public Main () {
		
		setLayout(new BorderLayout());
		northPanel = new JPanel(new BorderLayout());
		add(northPanel, BorderLayout.NORTH);
		
		ArrayList<String> countries = new ArrayList<>();
		countries.add("Bulgaria");
		countries.add("Romania");
		countries.add("Ukraine");
		
		ArrayList<String> cities = new ArrayList<>();
		cities.add("Sofia");
		cities.add("Varna");
		cities.add("Plovdiv");
		cities.add("Bucuresti");
		cities.add("Calarasi");
		cities.add("Slobozia");
		cities.add("Kyev");
		cities.add("Odessa");
		cities.add("Poltava");
		
		ArrayList<String> streets = new ArrayList<>();
		streets.add("Vitoshka");
		
		countryComboBox = new JComboBox<>();
		DefaultComboBoxModel<Object> countriesModel = new DefaultComboBoxModel<Object>();
		countriesModel.addAll(countries);
		countryComboBox.setModel(countriesModel);
		countryComboBox.setSelectedItem("Bulgaria");
//		countryComboBox.setFont(Font.BOLD);
		
		cityComboBox = new JComboBox<>();
		DefaultComboBoxModel<Object> citiesModel = new DefaultComboBoxModel<Object>();
		citiesModel.addAll(cities);
		cityComboBox.setModel(citiesModel);
		
		streetComboBox = new JComboBox<>();
		DefaultComboBoxModel<Object> streetsModel = new DefaultComboBoxModel<Object>();
		streetsModel.addAll(streets);
		streetComboBox.setModel(streetsModel);
		
		northPanel.add(countryComboBox, BorderLayout.NORTH);
		northPanel.add(cityComboBox, BorderLayout.CENTER);
		northPanel.add(streetComboBox, BorderLayout.SOUTH);
		
		setSize(600, 400);
		setTitle("countryDB");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Main countries = new Main();
	}
}
