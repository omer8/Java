import java.util.ArrayList;

class Bank
{ 
	private final double interestRate = 12.5;
	private double transactionFees = 10;
	private ArrayList<Client> clients = new ArrayList();
	
	public void calculateInterest(Client client)
	{
		Account a = client.getAccount();
		double bal = a.getBalance();
		double interestAmount = bal*interestRate/100;
		double totalBalance  = bal+interestAmount;
		System.out.println("Interest Amount is : " + interestAmount + "$ & your total balance is " + totalBalance+"$");	
		System.out.println("*********************************************************************");
	}
	public double getInterestRate()
	{
		return interestRate;
	}
	public double getTransactionFees()
	{
		return transactionFees;
	}
	public ArrayList<Client> getClients()
	{
		return clients;
	}
}
