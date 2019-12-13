import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class BankProject {
	static Bank bank = new Bank();
	static ArrayList<Client> c = bank.getClients();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		c.add(new Client("Mahmoud Abdelrahman",new Account(100,"10115","Checking"),"01095963256",19));
		c.add(new Client("Mamdouh Azzam",new Account(300,"10112","Saving"),"01095965261",20));
		c.add(new Client("Amr Abdelhady",new Account(450,"15212","Saving"),"01095856321",21));
		c.add(new Client("Mohamed Ahmed",new Account(300,"11212","Checking"),"01058746329",20));
		String[][] emps = {{"mohamed mohey","omar mohamed"},
						   {"12365","5698"}};		
		boolean bool = true;
		int type=0;
		while(bool) { 
			System.err.println("Enter Your Account Type (1 or 2)");
			System.out.println("1-Employee");
			System.out.println("2-Client");
			type = input.nextInt();
			if(type==1||type==2)
				bool = false;
		}
		input.nextLine();
		boolean flag = true;
		int z = 0;
		while(flag==true)
		if (type == 1 ) {
			if(z !=0) 
				System.err.println("Wrong Username or Password ");
			System.out.println("Enter Your Name");
			String name = input.nextLine();
			System.out.println("Enter Your Password");
			String password = input.nextLine();
			for (int x = 0 ;x<2;x++)
			{
				for (int y = 0;y<2;y++)
				{ 
					if (name.equalsIgnoreCase(emps[x][y])&&password.equalsIgnoreCase(emps[x+1][y])) {
						System.out.println("Welcome " + emps[x][y].toUpperCase() + " To the program.");
						System.out.println("***************************************************");
						flag = false;
						while(true)
						{
							System.out.println("Please Enter Your Choice : ");
							System.out.println("1: Add Client ");
							System.out.println("2: Remove Client");
							System.out.println("3: Display Clients");
							System.out.println("4: Deposit Money");
							System.out.println("5: Withdraw Money");
							System.out.println("6: Check Balance");
							System.out.println("7: Check Prev Transaction");
							System.out.println("8: Calculate Interest");
							System.out.println("9: Exit");
							int choice = input.nextInt();
							input.nextLine();
							switch(choice) {
							case 1:
								addNewCustomer();
								break;
							case 2 : 
								removeClient();
								break;
							case 3 : 
								displayClients();
								break;
							case 4:
								depositMoney();
								break;
							case 5:
								withdrawMoney();
								break;
							case 6:
								checkBalance();
								break;
							case 7 :
								checkPrevTransaction();
								break;
							case 8:
								calculateInterest();
								break;
							case 9:
								System.exit(1);
								break;
								
							}
						}
					}
					else 
						z++;
				}
			}
	}
		else if (type==2) { 
			System.out.println("Please Enter Your Choice : ");
			System.out.println("1: Display Account Details");
			System.out.println("2: Deposit Money");
			System.out.println("3: Withdraw Money");
			System.out.println("4: Check Balance");
			System.out.println("5: Calculate Interest");
			System.out.println("6: Check Previous Transaction");
			System.out.println("7: Exit");
			int choice = input.nextInt();
			input.nextLine();
			switch(choice) {
			case 1 :
				showAccountInfo();
				break;
			case 2:
				depositMoney();
				break;
			case 3:
				withdrawMoney();
				break;
			case 4:
				checkBalance();
				break;
			case 5:
				calculateInterest();
				break;
			case 6: 
				checkPrevTransaction();
				break;
			case 7:
				System.exit(0);
				break;
			}
		}
}
public static void addNewCustomer() { 
	Scanner input = new Scanner(System.in);
	System.out.println("Creating an account for a new client ........ ");
	System.out.println();
	System.out.println("Please Enter Your Full Name : ");
	String name  = input.nextLine();
	System.out.println("Enter Your Age : ");
	int age = input.nextInt();
	if (age<18)
	{
		System.err.println("Sorry You don't have the right to create bank account");
		System.exit(0);
		
	}
	input.nextLine();
	System.out.println("Enter Your Phone Number :");
	String phoneNumber  = input.nextLine();
	System.out.println("Please Enter Your Account Number To Create : ");
	String acc = input.nextLine();
	boolean check1 = true, check2 = true;
	String accType = null;
	while(check1) {
		if (check2 == false)
		{
			System.err.println("Please Make Sure You Have entered Checking or Saving type ");
		}
		System.out.println("Enter Your Account Type (checking or saving)");
		accType = input.nextLine();
		if (accType.equalsIgnoreCase("Checking")||accType.equalsIgnoreCase("Saving")) { 
			check1 = false;
		} else
			check2 = false;
			
	}
	System.out.println("Please Enter the initial amount in your account : ");
	double bal  = input.nextDouble();
	input.nextLine();
	Account account  = new Account(bal,acc,accType);
	Client client  = new Client(name,account,phoneNumber,age);
	c.add(client);
	System.err.println(client.getName() + " Account Has been added to the bank.");
	System.err.println("Number of Clients Has been updated to " + Client.numOfClients );

	}
public static void removeClient() { 
	Scanner input = new Scanner(System.in);
	System.out.println("Enter The Account Number");
	String acc = input.nextLine();
	if(Client.numOfClients==0)
	{ 
		System.err.println("Account Number Not Found");
	}
	else 
	{
		boolean found = false;
		for(int i = 0 ;i<Client.numOfClients;i++)
		{
			Account temp = c.get(i).getAccount();
			String tempNum = temp.getAccountNumber();
			if(tempNum.equalsIgnoreCase(acc))
			{
				System.err.println(c.get(i).getName() + " Account has been removed successfylly" );
				c.remove(i);
				
				Client.numOfClients--;
				found = true;
			}
		}
		if (found==false)
			System.err.println("Account Number Not Found");
	}
}
public static void displayClients() { 
	for (int i = 0;i<Client.numOfClients;i++)
	{ 
		c.get(i).display();
	}

}
public static void depositMoney() { 
	Scanner input = new Scanner(System.in);
	System.out.println("Enter Your Account Number : ");
	String acc = input.nextLine();
	if(Client.numOfClients==0)
	{ 
		System.err.println("Account Number Not Found");
	}
	else 
	{
		boolean found = false;
		for(int i = 0 ;i<Client.numOfClients;i++)
		{
			Account temp = c.get(i).getAccount();
			String tempNum = temp.getAccountNumber();
			if(tempNum.equals(acc))
			{
				System.out.println("Enter the amount to deposit : ");
				double money = input.nextDouble();
				input.nextLine();
				temp.deposit(money);
				found = true;
			}
		}
		if (found==false)
			System.err.println("Account Number Not Found");
	}
}
public static void withdrawMoney() { 
	Scanner input  = new Scanner(System.in);
	System.out.println("Enter Your Account Number : ");
	String acc = input.nextLine();
	if(Client.numOfClients==0)
	{ 
		System.err.println("Account Number Not Found");
	}
	else 
	{
		boolean found = false;
		for(int i = 0 ;i<Client.numOfClients;i++)
		{
			Account temp = c.get(i).getAccount();
			String tempNum = temp.getAccountNumber();
			if(tempNum.equals(acc))
			{
				System.out.println("Enter the Amount to withdraw : ");
				double money = input.nextDouble();
				input.nextLine();
				temp.withdraw(money);
				found = true;
			}
		}
		if (found==false)
			System.err.println("Account Number Not Found");
	}
}
public static void checkBalance() { 
	Scanner input = new Scanner(System.in);
	System.out.println("Enter Your Account Number : ");
	String acc = input.nextLine();
	if(Client.numOfClients==0)
	{ 
		System.err.println("Account Number Not Found");
	}
	else 
	{
		boolean found = false;
		for(int i = 0 ;i<Client.numOfClients;i++)
		{
			Account temp = c.get(i).getAccount();
			String tempNum = temp.getAccountNumber();
			if(tempNum.equals(acc))
			{
				System.out.println("Your Current Balance Without Interest Is : " + temp.getBalance() + "$");
				found = true;
			}
		}
		if (found==false)
			System.err.println("Account Number Not Found");
	}
}
public static void checkPrevTransaction() { 
	Scanner input = new Scanner(System.in);
	System.out.println("Enter Your Account Number : ");
	String acc = input.nextLine();
	if(Client.numOfClients==0)
	{ 
		System.err.println("Account Number Not Found");
	}
	else 
	{
		boolean found = false;
		for(int i = 0 ;i<Client.numOfClients;i++)
		{
			Account temp = c.get(i).getAccount();
			String tempNum = temp.getAccountNumber();
			if(tempNum.equals(acc))
			{
				temp.getPreviousTransaction();
				found = true;
			}
		}
		if (found==false)
			System.err.println("Account Number Not Found");
	}
}
public static void  calculateInterest() { 
	Scanner input = new Scanner(System.in);
	System.out.println("Enter Your Account Number : ");
	String acc = input.nextLine();
	if(Client.numOfClients==0)
	{ 
		System.err.println("Account Number Not Found");
	}
	else 
	{
		boolean found = false;
		for(int i = 0 ;i<Client.numOfClients;i++)
		{
			Account temp = c.get(i).getAccount();
			String tempNum = temp.getAccountNumber();
			if(tempNum.equals(acc))
			{
				bank.calculateInterest(c.get(i));
				found = true;
			}
		}
		if (found==false)
			System.err.println("Account Number Not Found");
	}
}
public static void showAccountInfo() { 
	Scanner input  = new Scanner(System.in);
	System.out.println("Enter Your Account Number : ");
	String acc = input.nextLine();
	if(Client.numOfClients==0)
	{ 
		System.err.println("Account Number Not Found");
	}
	else 
	{
		boolean found = false;
		for(int i = 0 ;i<Client.numOfClients;i++)
		{
			Account temp = c.get(i).getAccount();
			String tempNum = temp.getAccountNumber();
			if(tempNum.equals(acc))
			{
				c.get(i).display();
				found = true;
			}
		}
		if (found==false)
			System.err.println("Account Number Not Found");
	}
}
}