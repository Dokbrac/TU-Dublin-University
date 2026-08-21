package Assignment_SoftDev3_2023;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Csaba Palosi (B00148978)
 * ASSIGNMENT 2023
 */
public class CoffeeShopPanel extends JPanel {	
	private static final long serialVersionUID = 1L;
	
	private JPanel displayPanel, addPanel, deletePanel, updatePanel;
	private JTextArea displayArea;
	private JButton addButton, deleteButton, searchByIDButton, displayAllButton, updateqISButton;
	private JTextField idField, brandField, typeField, pPKField, qISField, deleteIDField, searchIDField, updateField, updateqISField;
	
	private ArrayList<Coffee> coffees = new ArrayList<>();
	
	public CoffeeShopPanel() {
		
				//instantiate and add the panels to the frame
				this.add(displayPanel = new JPanel(), BorderLayout.NORTH);
				displayPanel.setLayout(new FlowLayout());
				this.add(addPanel = new JPanel(), BorderLayout.CENTER);
				addPanel.setLayout(new FlowLayout());
				this.add(deletePanel = new JPanel(), BorderLayout.SOUTH);
				deletePanel.setLayout(new FlowLayout());
				this.add(updatePanel = new JPanel(), BorderLayout.SOUTH);
				updatePanel.setLayout(new FlowLayout());

				//add the area to the display panel
				displayArea = new JTextArea("", 20, 55);
				displayArea.setEditable(false);
				displayArea.setLineWrap(true);
				JScrollPane scroll = new JScrollPane(displayArea);		
				displayPanel.add(scroll);
				
				// fill the list with entries from the db
				this.loadData();
				
				displayPanel.add(new JLabel("Enter ID to search for brand"));
				displayPanel.add(searchIDField = new JTextField(2));
				displayPanel.add(searchByIDButton = new JButton("Search by ID"));
				searchByIDButton.addActionListener(e -> {
					int id = Integer.parseInt(searchIDField.getText());
					ArrayList<Coffee> search = (ArrayList)coffees.clone();
					search.removeIf(coffee -> coffee.getId() != id);
					displayArea.setText("");
					search.forEach(s -> displayArea.append(s.toString() + "\n"));
					searchIDField.setText("");
				});
				
				displayPanel.add(displayAllButton = new JButton("Display all coffees"));
				displayAllButton.addActionListener(ev -> {
					displayCoffees();
				});
				
				//add 3 labels, 3 fields, and the add button to the add panel
				addPanel.setBorder(new TitledBorder("Add new brand..."));
				addPanel.add(new JLabel("ID: "));
				addPanel.add(idField = new JTextField(5));
				addPanel.add(new JLabel("Brand: "));
				addPanel.add(brandField = new JTextField(15));
				addPanel.add(new JLabel("Type: "));
				addPanel.add(typeField = new JTextField(10));
				addPanel.add(new JLabel("pricePerKg: "));
				addPanel.add(pPKField = new JTextField(7));
				addPanel.add(new JLabel("quantityInStock: "));
				addPanel.add(qISField = new JTextField(7));
				addPanel.add(addButton = new JButton("Add coffee"));
				
				//add 1 label, 1 field, and the delete button to the delete panel
				deletePanel.setBorder(new TitledBorder("Delete coffees..."));
				deletePanel.add(new JLabel("ID: "));
				deletePanel.add(deleteIDField = new JTextField(5));
				deletePanel.add(deleteButton = new JButton("Delete By Id"));
				
				// add 2 labels, 2 fields, and the update button to the update panel
				updatePanel.setBorder(new TitledBorder("Update the quantity in stock by ID..."));
				updatePanel.add(new JLabel("ID: "));
				updatePanel.add(updateField = new JTextField(5));
				updatePanel.add(new JLabel("quantityInStock: "));
				updatePanel.add(updateqISField = new JTextField(7));
				updatePanel.add(updateqISButton = new JButton("Update coffee"));
				updateqISButton.addActionListener(e -> {
					int id = Integer.parseInt(updateField.getText());
					double quantityInStock = Double.parseDouble(updateqISField.getText());
					//clear the fields
					updateField.setText("");
					updateqISField.setText("");
					try (CoffeeShopCRUD dbOp = new CoffeeShopCRUD()){		
						dbOp.updateCoffee(quantityInStock, id);
						coffees = dbOp.getAllCoffees();
						displayCoffees();
					} catch (SQLException | IOException e1) {
						e1.printStackTrace();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				});
				
				displayCoffees();
		
				// register events with the 2 buttons
				addButton.addActionListener((ActionEvent e) -> {
						int id = Integer.parseInt(idField.getText());
						String brand = brandField.getText();
						String type = typeField.getText();
						double pricePerKg = Double.parseDouble(pPKField.getText());
						double quantityInStock = Double.parseDouble(qISField.getText());
						Coffee newCoffee = new Coffee(id, brand, type, pricePerKg, quantityInStock);
						coffees.add(newCoffee);
						//clear the fields
						idField.setText("");
						brandField.setText("");
						typeField.setText("");
						pPKField.setText("");
						qISField.setText("");
						try (CoffeeShopCRUD dbOp = new CoffeeShopCRUD()){		
							dbOp.insertCoffee(id, brand, type, pricePerKg, quantityInStock);
							coffees = dbOp.getAllCoffees();
							displayCoffees();
						} catch (SQLException | IOException e1) {
							e1.printStackTrace();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						displayCoffees();
					}			
				);
				deleteButton.addActionListener(e -> {
						String id = deleteIDField.getText();
						try (CoffeeShopCRUD dbOp = new CoffeeShopCRUD()){		
							dbOp.deleteCoffeeByID(id);
							coffees = dbOp.getAllCoffees();
							displayCoffees();
						} catch (SQLException | IOException e1) {
							e1.printStackTrace();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						displayCoffees();
						deleteIDField.setText("");
					}			
				);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(this.getWidth(), this.getHeight());
	}
	// method to display all coffees from the db
	private void displayCoffees() {
		displayArea.setText("");
		for (Coffee c: coffees)
			displayArea.append(c.toString() + "\n");
	}
	// method to instantiate the queries, populate the list and display it
	private void loadData() {
		try (CoffeeShopCRUD dbOp = new CoffeeShopCRUD()){			
			coffees = dbOp.getAllCoffees();
			displayCoffees();
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		var frame = new JFrame();
		frame.setSize(1000, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(new CoffeeShopPanel());
	}

}
