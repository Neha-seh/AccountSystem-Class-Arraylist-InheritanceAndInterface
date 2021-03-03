import java.util.ArrayList;

public class Sales implements Transaction {
	
	private String product ;
	private double price;
	
	
	public Sales(String product, double price) {    //constructor with parameter
	this.product = product;
	this.price = price;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}

	
	
	//private ArrayList<Transaction> Transactions = new ArrayList<>();

	