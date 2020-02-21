import java.text.DecimalFormat;

/** This class represents a collection of transactions. The maximum transaction is 5 as a default.
 * 
 * @author Taeju Park
 *
 */
public class Statement {
	
	// Instance variables
	private String account;
	private Transaction[] trans;
	private int numTrans;
	private double balance;
	private final static double INTEREST = 0.045;
	
	// Constructors
	public Statement() {}
	
	/**
	 * The Statements contains the holders name and balance.
	 * @param name		holder's name
	 * @param balance	holder's total balance of account 
	 */
	public Statement(String name, double balance) {
		this.account = name;
		this.balance = balance;
		this.trans = new Transaction[5];
		this.numTrans = 0;
	}
	
	/**
	 * Add transaction from user with each parameters.
	 * @param description	description of earn/spent
	 * @param amount		amount of action
	 * @param date			date of transaction
	 * @param action		user action either withdrawal(0), deposit(1), or interest(2)
	 * @return				checking if the transactions are more than 5
	 */
	public boolean addTrans(String description, double amount, String date, int action) { 
		Transaction newTrans = new Transaction(description, amount, date, action);
		
		if (numTrans < 5) {
			trans[numTrans] = newTrans;
			numTrans++;
			return true;
		}
		else
			return false;	
	}
	
	/**
	 * 
	 * @return The value of withdrawals
	 */
	public double getWithdrawalValue() {
		double total = 0;
		for (int i = 0; i < numTrans; i++) {
			if (trans[i].getAction() == 0)
				total += trans[i].getAmount();
		}
		
		return total;
	}
	
	/**
	 * 
	 * @return The number of withdrawals
	 */
	public int getNumWithdrawals() {
		int count = 0;
		for (int i = 0; i < numTrans; i++) {
			if (trans[i].getAction() == 0)
				count += 1;
		}
		
		return count;
	}
	
	/**
	 * 
	 * @return The value of deposits
	 */
	public double getDepositValue() {
		double total = 0;
		for (int i = 0; i < numTrans; i++) {
			if (trans[i].getAction() == 1)
				total += trans[i].getAmount();
		}
		
		return total;
	}
	
	/**
	 * 
	 * @return The number of deposits
	 */
	public int getNumDeposits() {
		int count = 0;
		for (int i = 0; i < numTrans; i++) {
			if (trans[i].getAction() == 1)
				count += 1;
		}
		
		return count;
	}
	
	/**
	 * Return the interests of the balance which is 4.5%
	 * @param interestRate	The interest
	 * @param target		The target to apply the interest
	 * @return	The current balance * interest(.045)
	 */
	public static double calculateInterest(double interestRate, Statement target) {
		return target.getBalance() * INTEREST;
	} 
	
	/**
	 * 
	 * @return	The total balance
	 */
	public double getBalance() {
		double total = 0;		
		total += balance + getDepositValue() - getWithdrawalValue();		
		return total;
	} 
	
	/**
	 * 
	 * @return	The number of transactions
	 */
	public int getTransacitons() {
		return numTrans;
	}
	
	/**
	 * the information with string
	 */
	public String toString() {
		DecimalFormat dec = new DecimalFormat("#0.00");
		String str = "";
		str += "Account holder: " + this.account + "\n";
		str += "Number of transactions: " + this.numTrans + "\n";
		for (int i = 0; i < this.numTrans; i++)
			str += trans[i].toString() + "\n";
		str += "Total balace: $" + dec.format(this.getBalance()) + "\n";
		str += "Amount of interest to be added: $" + dec.format(this.calculateInterest(INTEREST, this)) + "\n";
		str += "Statement total after interest added: $" + dec.format(this.getBalance() + this.calculateInterest(INTEREST, this)) + "\n\n";
		
		return str;
	}

}
