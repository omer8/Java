class Account 
{ 
	private double balance = 100;
	private double prevTransaction;
	private String accountNumber;
	private boolean firstTime = true;
	private String accountType;
	
	public Account(String acc)
	{ 
		accountNumber = acc;
	}
	public Account(double bal,String acc,String accountType)
	{
		if(bal>=100)
			balance = bal;
		else 
			balance = 100;
		this.accountNumber = acc;
		this.accountType = accountType;
	}
	public void deposit(double howMuch)
	{
		if(howMuch>0)
		{
			balance+=howMuch;
			prevTransaction = howMuch;
			System.out.println(howMuch+"$ was added successfully in your account.  The new balance of your account is " + balance + "$");
			System.out.println("****************************************************************");
		}
		else { 
			System.err.println("Please Make Sure that the amount to be depoisted is not negative");
			System.out.println("****************************************************************");
		}
	}
	public void withdraw(double howMuch) 
	{ 
		if(howMuch>0)
		{
			if(firstTime==true)
			{
				double tempBalance = balance-howMuch;
				if(tempBalance>=100)
				{
					balance-=howMuch;
					prevTransaction = -howMuch;
					System.out.println(howMuch+"$ Is Withdrwan Successfully And Your New Balance is " + balance + "$");
					firstTime=false;
				}
				else
					System.err.println("Insufficient balance to remove " + howMuch);
			} 
			else 
			{
				Bank bank = new Bank();
				double tempBalance = balance-howMuch-bank.getTransactionFees();
				if(tempBalance>=100)
				{
					balance-=howMuch-bank.getTransactionFees();
					System.out.println(howMuch+"$ is withdrwan successfully you new balance after fees is " + balance);
				}
				else
					System.err.println("Insufficient balance to remove " + howMuch);
			}
		}
		else 
		{
			System.err.println("Please Make Sure that the amount to be withdrawn is not negative");
		}
	}
	
	public String getAccountType() {
		return this.accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public void getPreviousTransaction() { 
		if (this.prevTransaction > 0) { 
			System.err.println("Deposited : " + this.prevTransaction + "$");
		} 
		else if (this.prevTransaction < 0 ) { 
			System.err.println("Withdrawn : " + Math.abs(this.prevTransaction) + "$");
		}
		else { 
			System.err.println("No Transaction Happened yet");

		}
	}
	public double getBalance()
	{ 
		return this.balance;
	}
	public String getAccountNumber() 
	{
		return this.accountNumber;
	}
}