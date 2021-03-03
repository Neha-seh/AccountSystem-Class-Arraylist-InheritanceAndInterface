import java.util.ArrayList;
import java.util.List;
import ecs100.UI;


public class AccountsUI {

	// need to create the "Contact" type ArrayList!
	
	private List<Contact> contacts = new ArrayList<>(); 
	//to store all the details of person, supplier,buyer and supplier/buyer
	
	
	public AccountsUI() {
		UI.initialise();
		UI.addButton("Add individual contact", this::addPerson);
		UI.addButton("Add business supplier contact", this::addSupplier);
		UI.addButton("Add business client contact", this::addBusinessClient);  //customer
		UI.addButton("Add trading partner contact", this::addTradingPartner);
		UI.addButton("List contacts", this::listContacts);
		UI.addButton("Find contact by name", this::findContact);
		UI.addButton("Record purchase from supplier", this::recordPurchase);
		UI.addButton("Record sale to client", this::recordSale);
		UI.addButton("Report sale/purchase balance for contact", this::reportBalance);
		UI.addButton("Compute total profit", this::computeProfit);
		UI.addButton("List all transactions with a contact", this::listTransactions);
		// Your code here?
	}
	
	//Method to add PERSON to the contact list
	private void addPerson() {
		String name = UI.askString("Name: ");
		int age = UI.askInt("Age: ");
		
		//create an individual person
		Person p =new Person(name, age);
		
		//add the person to Arraylist now
		contacts.add(p);  // 
		
	}
	
	
	//Method to add a supplier to the contact list
	private void addSupplier() {
		String name = UI.askString("Name: ");
		int nbn = UI.askInt("Business number: ");
		
		// Your code here...	
		contacts.add(new Suppliers(name,nbn));
	}
	
	
	
	//Method to add a Business client to the contact list
	private void addBusinessClient() {
		String name = UI.askString("Name: ");
		int nbn = UI.askInt("Business number: ");
		
		// Your code here...
		contacts.add(new BusinessClient(name,nbn));
	}
	
	
	
	
	//Method to add a Trading Partner(someone who is both a buyer and a seller) to the contact list
	private void addTradingPartner() {
		String name = UI.askString("Name: ");
		
		// Your code here...
		contacts.add(new TradingPartner(name));
	}
	
	
	
	// Method to Display all the contacts in the list
	private void listContacts() {
		for (int i=0; i<contacts.size(); i++) {
			
			//get person object from the Arraylist
			contacts.get(i).displayContact();  //its a common method defined in CONTACT interface
			
//			Contact c = contacts.get(i);
//			c.displayContact();
//			
		}
	}
	
	
	
	
	
	// Find one of the contacts by name and report on them
	private void findContact() {
		String name = UI.askString("Name: ");
		// Your code here...
		
			for (Contact c :contacts) {
				if (c.getName().equals(name)) {
					c.displayContact();
				}
			}
			
		}
		
	
	// Record a purchase from a supplier
	private void recordPurchase() {    // can create another class as Transaction for sales and purchase
		String name = UI.askString("Supplier: ");
		String product = UI.askString("Purchased: ");
		double price = UI.askInt("Price: ");
		
		 // find the correct contact object from contact list , to do that use a for each loop
		
		for (Contact c : contacts) {     //Contact is type and c is the object 
			
			if (c.getName().equalsIgnoreCase(name) && c instanceof Suppliers || c instanceof TradingPartner) {  
				//instance of is a keyword to check the type of object in arraylist.type mean if its supplier or person or trading partner
				
			Purchase p = new Purchase (product, price);  // creating a purchasing object
			c.addTransaction(p);   // Update the Client transaction list
			}
		}
	}
	
	
	
	// Record a sale to a customer
	private void recordSale() {
		String name = UI.askString("Customer: ");
		String product = UI.askString("Purchased: ");
		double price = UI.askInt("Price: ");
		// Your code here...
		for (Contact c : contacts) {
			if (c.getName().equalsIgnoreCase(name) && !(c instanceof Suppliers))  {  
				Sales s = new Sales (product, price);
				c.addTransaction(s);
			}
		}
	}
	
	// Report how much has been paid by/to a contact
	private void reportBalance() {
		double totalSales = 0;
		double totalPurchases = 0;
		String name = UI.askString("Name: ");
		
		// Your code here...
		for (Contact c : contacts) {
			if (c.getName().equalsIgnoreCase(name) && c instanceof TradingPartner)  { 
				ArrayList <Transaction> Transactions = c.getTransactions(); // getting all the transaction of trading partners
				for (Transaction t :Transactions ) { // compute total sales and total purchases
					if (t instanceof Sales) {						
						totalSales += t.getPrice();
					} else if 
							(t instanceof Purchase)
							totalPurchases += t.getPrice();
			   }
			}
		}
		
		double balance = Math.abs(totalPurchases - totalSales); //compute the difference between sales and purchases
		UI.println("Blance: " +balance);		
	}
	
	// Compute the total profit of the business (sales - purchases)
	private void computeProfit() {
		double totalSales = 0;
		double totalPurchases = 0;
		
		// Your code here...
		for (Contact c : contacts) {
			ArrayList <Transaction> Transactions = c.getTransactions(); // getting all the transaction of trading partners
			for (Transaction t :Transactions ) { // compute total sales and total purchases
				if (t instanceof Sales) {						
					totalSales += t.getPrice();
				} else if 
						(t instanceof Purchase)
						totalPurchases += t.getPrice();
		   }
		
		}
	}
	
	
	
	private void listTransactions() {
		for (Contact c : contacts) {
			ArrayList <Transaction> Transactions = c.getTransactions(); // getting all the transaction of trading partners
			for (Transaction t :Transactions ) { // compute total sales and total purchases
				if (t instanceof Sales) {						
					t.getPrice();
				} else if 
						(t instanceof Purchase)
						 t.getPrice();
		   }
		}
	}	
	
	
	public static void main(String[] args) {
		new AccountsUI();
	}

}
