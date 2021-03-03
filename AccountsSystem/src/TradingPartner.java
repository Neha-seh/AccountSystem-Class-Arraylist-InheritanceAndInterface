import java.util.ArrayList;

import ecs100.UI;

public class TradingPartner implements Contact {
	
	private String name;
	private ArrayList<Transaction> Transactions = new ArrayList<>();
	
	
	public TradingPartner (String name) { 
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;


	}
	public void displayContent() {
		UI.println("person name:" +this.name);
	}
	
	@Override
	public ArrayList<Transaction> getTransactions() {
		// TODO Auto-generated method stub
		return Transactions;
	}


	@Override
	public void addTransaction(Transaction t) {
		Transactions.add(t);
		
	}

@Override
public void displayContact() {
	// TODO Auto-generated method stub
	UI.println("Trading partner name:" +this.name);
}
}

