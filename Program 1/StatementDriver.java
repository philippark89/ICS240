/**
 * Testing with two statement with your choice of account holder names and balances.
 *
 * @author Taeju Park
 *
 */
public class StatementDriver {
	
	public static void main(String[] args) {
		// set the interest 4.5% as constant
		final double INTEREST = .045;
		boolean flag1, flag2 = true;
		
		// Two statements s1(Jon), s2(Snow) with $0
		Statement s1 = new Statement("Jon", 0.00);
		Statement s2 = new Statement("Snow", 0.00);

		// The three transactions to the first statement
		flag1 = s1.addTrans("payCheck", 500.00, "Jan-01-2020", 1);
		flag1 = s1.addTrans("dinner", 20.00, "Jan-02-2020", 0);
		flag1 = s1.addTrans("Interest", Statement.calculateInterest(INTEREST, s1), "Jan-05-2020", 2);
		
		
		// The two transactions to the second statement
		flag2 = s2.addTrans("payCheck", 200.00, "Feb-01-2020", 1);
		flag2 = s2.addTrans("Interest", Statement.calculateInterest(INTEREST, s2), "Feb-02-2020", 2);
		
		// Testing for more than 5 transactions and printing error message.
		flag1 = s1.addTrans("payCheck", 500.00, "Jan-01-2020", 1);
		flag1 = s1.addTrans("dinner", 20.00, "Jan-02-2020", 0);
		flag1 = s1.addTrans("dinner", 20.00, "Jan-02-2020", 0);

		
		// Prints the transactions information
		System.out.print(s1.toString());
		if(!flag1)
			System.out.println("Transaction can be added 5 maximum. It will be printed for first 5 transactions.\n");
		System.out.print(s2.toString());
		if(!flag2)
			System.out.println("Transaction can be added 5 maximum. It will be printed for first 5 transactions.\n");
		
	}
}
