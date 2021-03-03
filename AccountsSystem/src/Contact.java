import java.util.ArrayList;

// AN INTERFACE DEFINES THE COMMON BEHAVIOUS OF ALL CLASSES
//we implement the interface to have all common attribute, by using Implement keyword.

public interface Contact {
	
	public void displayContact ();   // Abstract method
	
    public String getName();
	
    public void addTransaction (Transaction t);   //this method will be use to add an individual transaction
    
    public ArrayList <Transaction> getTransactions(); // this method will be used to get all the transactions belong to a particular contact
    
}
