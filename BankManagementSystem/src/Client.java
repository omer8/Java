class Client extends BankOperations
{
	private String name;
	private Account account;
	private String PhoneNumber;
	private int age;
	public static int numOfClients;
	public Client(String name, Account account, String phoneNumber, int age) {
		this.name = name;
		this.account = account;
		PhoneNumber = phoneNumber;
		this.age = age;
		numOfClients++;
	}
	
	public void display()
	{ 
		System.out.println("Client Name  : " + this.name + ",  Client Age : "+ this.age +",  Client Phone Number : " + this.PhoneNumber+ ",  Account Number : " + account.getAccountNumber() +",  Account Type is " + this.getAccount().getAccountType()+",  And Client Balance  : " + account.getBalance()+" $");
		System.out.println("************************************************************************************************************************************************************************************");
	}
	
	public String getName()
	{
		return this.name;
	}
	public Account getAccount()
	{
		return this.account;
	}
	public String getPhoneNumber() { 
		return this.PhoneNumber;
	}
}