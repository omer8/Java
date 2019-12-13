import java.util.ArrayList;
import java.util.Scanner;

public class BankOperations {
	static Bank bank = BankProjectMain.bank;
	static ArrayList<Client> c = bank.getClients();
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