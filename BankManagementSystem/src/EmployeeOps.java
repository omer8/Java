import java.util.Scanner;

public class EmployeeOps extends BankOperations {
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
}