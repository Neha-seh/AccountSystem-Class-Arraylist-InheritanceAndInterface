import java.util.ArrayList;

import ecs100.UI;
public class Person implements Contact {
	// common properties of person class
	private String name;
	private int age;
	
	// define an arraylist of transaction 
	private ArrayList<Transaction> Transactions = new ArrayList<>();
	
	public Person (String name, int age) {   
		
		//we set the value for the variable at object creation time
		this.name = name;     // this.name refers to the variable in person class and name refers to constructor 
		this.age = age;
	}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		} 
		
		public void displayContact() {
			UI.println("person name:" +this.name+" : " +" person age: " +this.age);
		}
		

		@Override
		public ArrayList<Transaction> getTransactions() { //To return An arraylist to the caller outside of this class
			// TODO Auto-generated method stub
			return Transactions;
		}


		@Override
		public void addTransaction(Transaction t) {
			Transactions.add(t);
			
		}
}
		