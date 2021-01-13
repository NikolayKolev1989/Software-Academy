import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {

	private JComboBox<Object> countryComboBox;
	private JComboBox<Object> cityComboBox;
	private JComboBox<Object> streetComboBox;
	private JPanel northPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	ArrayList<String> countries;
	ArrayList<String> cities;
	ArrayList<String> streets;

	public Main() {

		setLayout(new BorderLayout());
		northPanel = new JPanel(new BorderLayout());
		add(northPanel, BorderLayout.CENTER);

		eastPanel = new JPanel(new BorderLayout());
		add(eastPanel, BorderLayout.EAST);

		westPanel = new JPanel(new BorderLayout());
		add(westPanel, BorderLayout.WEST);

		countries = new ArrayList<>();
		countries.add("Bulgaria");
		countries.add("Romania");
		countries.add("Ukraine");

		cities = new ArrayList<>();
//		cities.add("Sofia");
//		cities.add("Varna");
//		cities.add("Plovdiv");
//		cities.add("Bucuresti");
//		cities.add("Calarasi");
//		cities.add("Slobozia");
//		cities.add("Kyev");
//		cities.add("Odessa");
//		cities.add("Poltava");

		streets = new ArrayList<>();
		streets.add("Vitoshka");

		countryComboBox = new JComboBox<>();
		DefaultComboBoxModel<Object> countriesModel = new DefaultComboBoxModel<Object>();
		countriesModel.addAll(countries);
		countryComboBox.setModel(countriesModel);
		countryComboBox.setSelectedItem("Bulgaria");
//		countryComboBox.setFont(Font.BOLD);

		countryComboBox.addActionListener(e -> {
//			if (countryComboBox.getSelectedItem().equals("Bulgaria")) {
//				
//			}

			switch ((String) countryComboBox.getSelectedItem()) {
			case "Bulgaria":
				System.out.println("Bulgaria");
				if (cities.isEmpty()) {
					cities.add("Sofia");
					cities.add("Varna");
					cities.add("Plovdiv");

				} else {
					for (int i = 0; i < cities.size(); i++) {
						cities.remove(i);
					}
					cities.add("Sofia");
					cities.add("Varna");
					cities.add("Plovdiv");
				}

				break;
			case "Romania":
				if (cities.isEmpty()) {
					cities.add("Bucuresti");
					cities.add("Calarasi");
					cities.add("Slobozia");
				} else {
					for (int i = 0; i < cities.size(); i++) {
						cities.remove(i);
					}
					cities.add("BBBucuresti");
					cities.add("Calarasi");
					cities.add("Slobozia");
				}
				break;
			case "Ukraine":

				break;

			default:
				break;
			}

		});

		cityComboBox = new JComboBox<>();
		DefaultComboBoxModel<Object> citiesModel = new DefaultComboBoxModel<Object>();
		citiesModel.addAll(cities);
		cityComboBox.setModel(citiesModel);

		streetComboBox = new JComboBox<>();
		DefaultComboBoxModel<Object> streetsModel = new DefaultComboBoxModel<Object>();
		streetsModel.addAll(streets);
		streetComboBox.setModel(streetsModel);

		westPanel.add(countryComboBox, BorderLayout.NORTH);
		northPanel.add(cityComboBox, BorderLayout.NORTH);
		eastPanel.add(streetComboBox, BorderLayout.NORTH);

		setSize(600, 400);
		setTitle("countryDB");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		revalidate();
	}

	public static void main(String[] args) {
		Main countries = new Main();
	}
}
