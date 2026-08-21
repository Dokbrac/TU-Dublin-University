package Assignment_SoftDev3_2023;

/**
 * Csaba Palosi (B00148978)
 * ASSIGNMENT 2023
 */
public class Coffee {
	private int id;
	private String brand;
	private String type;
	private double pPKg;
	private double qIStock;
	// constructor
	public Coffee(int id, String brand, String type, double pricePerKg, double quantityInStock) {
		this.id = id;
		if (id < 0)
			throw new RuntimeException("You cannot pass a value below 0 for ID");
		this.brand = brand;
		this.type = type;
		this.pPKg = pricePerKg;
		if (pricePerKg < 0)
			throw new RuntimeException("You cannot pass a value below 0 for pricePerKg");
		this.qIStock = quantityInStock;
		if (quantityInStock < 0)
			throw new RuntimeException("You cannot pass a value below 0 for quantityInStock");
	}
	// constructor, default
	public Coffee() {
		this(0, "N/A", "N/A", 0, 0);
	}
	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id < 0)
			throw new RuntimeException("You cannot pass a value below 0 for ID");
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getpPKg() {
		return pPKg;
	}

	public void setpPKg(double pPKg) {
		if (pPKg < 0)
			throw new RuntimeException("You cannot pass a value below 0 for pricePerKg");
		this.pPKg = pPKg;
	}

	public double getqIStock() {
		return qIStock;
	}

	public void setqIStock(double qIStock) {
		if (qIStock < 0)
			throw new RuntimeException("You cannot pass a value below 0 for quantityInStock");
		this.qIStock = qIStock;
	}
	// string override to display
	@Override
	public String toString() {
		return "Coffee [id=" + id + ", brand=" + brand + ", type=" + type + ", pricePerKg=" + pPKg
				+ ", quantityInStock=" + qIStock + "]";
	}
	
	public static void main(String[] args) {
		Coffee c1 = new Coffee();
		System.out.println(c1);
	}
}
