import java.text.DecimalFormat;

/** This class represents a deposit or withdrawal.
 *
 * The possible actions are
 * WITHRAWAL	(0)
 * DEPOSIT		(1)
 * INTEREST		(2)
 *   
 * @author Taeju Park
 *
 */
public class Transaction {
	
	// Constants
	final static int WITHDRAWAL = 0;
	final static int DEPOSIT = 1;
	final static int INTEREST = 2;
	
	// Instant variables
	private String description;
	private double amount;
	private String date;
	private int action;
	
	// Constructors
	public Transaction() {}
	
	/**
	 * The transaction information
	 * @param description	description of amount
	 * @param amount		amount of money
	 * @param date			transaction date
	 * @param action		actions between WITHDRAW(0), DEPOSIT(1), or INTEREST(2)
	 */
	public Transaction(String description, double amount, String date, int action) {
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.action = action;
	}
	
	// Getters
	public String getDescription() { return this.description; }
	public double getAmount() { return this.amount; }
	public String getDate() { return this.date; }
	public int getAction() { return this.action; }
	
	// Setters
	public void setDecription(String description) { this.description = description; }
	public void setAmount(double amount) { this.amount = amount; }
	public void setDate(String data) { this.date = date; }
	public void setAction(int action) { this.action = action; }
	
	/**
	 * Two items are considered to be equal if they have the same description and the same date. Compare in lower cases.
	 * @param target	the account for comparison
	 * @return	TRUE if two account's description and date are same
	 * 			FALSE if two account's description and date are not same
	 */
	public boolean equals(Transaction target) {
		
		boolean result = false;

		if (this.description.compareToIgnoreCase(target.description) == 0 && 
				this.date.compareToIgnoreCase(target.date) == 0)
			result = true;
			
		return result;
	}
	
	/**
	 * Return the information with string
	 */
	public String toString() {
		DecimalFormat dec = new DecimalFormat("#0.00");
		
		String actionStr = "";
		if (this.action == 0)
			actionStr += "Withrawal";
		else if (this.action == 1)
			actionStr += "Deposit";
		else if (this.action == 2)
			actionStr += "Interest";
		
		
		return "Description: " + this.description + "\tAmount: $" + dec.format(this.amount) +
				"\t\tDate: " + this.date + "\tAction: " + actionStr;
		
	}
}
