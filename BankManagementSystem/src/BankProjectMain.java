import java.util.ArrayList;
import java.util.Scanner;

public class BankProjectMain {

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
								EmployeeOps.addNewCustomer();
								break;
							case 2 : 
								EmployeeOps.removeClient();
								break;
							case 3 : 
								EmployeeOps.displayClients();
								break;
							case 4:
								EmployeeOps.depositMoney();
								break;
							case 5:
								EmployeeOps.withdrawMoney();
								break;
							case 6:
								EmployeeOps.checkBalance();
								break;
							case 7 :
								EmployeeOps.checkPrevTransaction();
								break;
							case 8:
								EmployeeOps.calculateInterest();
								break;
							case 9:
								System.exit(0);
								break;
								
							}
						}
					}
					else 
						z++;
				}
			}
	}
		 if (type==2) { 
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
				Client.showAccountInfo();
				break;
			case 2:
				Client.depositMoney();
				break;
			case 3:
				Client.withdrawMoney();
				break;
			case 4:
				Client.checkBalance();
				break;
			case 5:
				Client.calculateInterest();
				break;
			case 6: 
				Client.checkPrevTransaction();
				break;
			case 7:
				System.exit(0);
				break;
			}
		}
}
}
