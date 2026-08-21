package Assignment_SoftDev3_2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Csaba Palosi (B00148978)
 * ASSIGNMENT 2023
 */
public class CoffeeShopCRUD implements AutoCloseable {
	private static final String PROPS_FILE = "src/Assignment_SoftDev3_2023/connDetails.properties";
	private String db;
	private String user;
	private String password;
	private Connection conn;
	private final static String selectAllCoffeesQ = "SELECT * FROM coffee";
	private final static String insertCoffeeQ = "INSERT INTO coffee(id, brand, type, pricePerKg, quantityInStock) VALUES(?, ?, ?, ?, ?)";
	private final static String deleteCoffeeByIDQ = "DELETE FROM coffee WHERE id=?";
	private final static String updateCoffeequantityInStockQ = "UPDATE coffee SET quantityInStock=? WHERE id=?";
	
		// method that loads the db details
		private void setConnectionProperties() throws IOException {
			var reader = new BufferedReader(new FileReader(PROPS_FILE));
			Properties props = new Properties();
			props.load(reader);
			this.db = props.getProperty("db");
			this.user = props.getProperty("user");
			this.password = props.getProperty("password");
		}
		// method to establish connection
		private Connection establishConnection() throws SQLException, IOException {
			setConnectionProperties();
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ this.db, this.user, this.password);
		}	
		// constructor
		public CoffeeShopCRUD() throws SQLException, IOException {
			this.conn = establishConnection();
		}
		// method to select all coffees
		public ArrayList<Coffee> getAllCoffees() throws SQLException{
			ArrayList<Coffee> coffees = new ArrayList<>();
			PreparedStatement st = conn.prepareStatement(selectAllCoffeesQ);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				Coffee c = new Coffee(
							result.getInt(1),
							result.getString(2),
							result.getString(3),
							result.getDouble(4),
							result.getDouble(5)
						);
				coffees.add(c);
			}		
			return coffees;
		}
		
		// method to insert a coffee into the db
		public int insertCoffee(int id, String brand, String type, double pPKg, double qIStock) throws SQLException {
			PreparedStatement st = conn.prepareStatement(insertCoffeeQ);
			st.setInt(1, id);
			st.setString(2, brand);
			st.setString(3, type);
			st.setDouble(4, pPKg);
			st.setDouble(5, qIStock);
			return st.executeUpdate();
		}
		
		// method to update a coffee into the db
		public int updateCoffee(double qIStock, int id) throws SQLException {
			PreparedStatement st = conn.prepareStatement(updateCoffeequantityInStockQ);
			st.setDouble(1, qIStock);
			st.setInt(2, id);
			return st.executeUpdate();
		}
		
		// method to delete coffee
		public int deleteCoffeeByID(String id) throws SQLException {
			PreparedStatement st = conn.prepareStatement(deleteCoffeeByIDQ);
			st.setString(1, id);
			return st.executeUpdate();
		}
		
		
		@Override
		public void close() throws Exception {
			conn.close();
		}
		
		public static void main(String[] args) {
			try(var cofOps = new CoffeeShopCRUD (); ){
				System.out.println("Connection established");
				for(Coffee c : cofOps.getAllCoffees())
					System.out.println(c);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
