import java.util.ArrayList;

public class Purchase implements Transaction{

	private String product ;
	private double price;
	
	
	public Purchase(String purchase, double price) {    //parameterised constructor
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
