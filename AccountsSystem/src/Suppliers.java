import java.util.ArrayList;

import ecs100.UI;

public class Suppliers implements Contact {
	
			private String name;
			private int nbn;
			private ArrayList<Transaction> Transactions = new ArrayList<>();
			
			public Suppliers (String name, int nbn) {
				this.name = name;
				this.nbn = nbn;
			}
		
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getNbn() {
				return nbn;
			}
			public void setNbn(int nbn) {
				this.nbn = nbn;
			}
		
			
			public void displayContent() {
				UI.println("Client name:" +this.name+" : " +" Client nbn: " +this.nbn);
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
				UI.println("Supplier name:" +this.name+" : " +" Supplier nbn: " +this.nbn);
				
			}

}
