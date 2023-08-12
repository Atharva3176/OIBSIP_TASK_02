package AtmInterface;
import java.util.Scanner;
class AtmInterface {
	String name;
	String username;
	String password;
	String accountinfo;
	float balance=1000000f;
	int transactions=0;
	String transactionHistory="";
	public void register()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("\nenter your name:");
		this.name=sc.nextLine();
		System.out.print("\nenter your User name:");
		this.username=sc.nextLine();
		System.out.print("\nenter your Password:");
		this.password=sc.nextLine();
		System.out.print("\nenter your Account number:");
		this.accountinfo=sc.nextLine();
		System.out.println("\nRegistration Successfully Done, Kindly Login!");
	}
	
	public boolean login()
	{
		boolean isLogin=false;
		Scanner sc=new Scanner(System.in);
		while(!isLogin)
		{
			System.out.print("\nenter your User name:");
			String Username=sc.nextLine();
			if(Username.equals(username))
			{
				while(!isLogin)
				{
					System.out.print("\nenter your Password:");
					String Password=sc.nextLine();
					if(Password.equals(password))
					{
						System.out.println("Login Succeessful!");
						isLogin=true;
					}
					else
					{
						System.out.println("Incorrect Password");
					}
				}
			}
			else 
			{
				System.out.println("Incorrect Username");
			}
		}
		return isLogin;
	}
	
	public void withdraw()
	{
		System.out.print("\nEnter Amount to withdraw!");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try
		{
			if(balance>=amount)
			{
				transactions++;
				balance=balance-amount;
				System.out.println("\nAmount Withdrawn Successfully!");
				String str=amount+"Rs Withdrawned\n";
				transactionHistory=transactionHistory.concat(str);
			}
			else
			{
				System.out.println("\nInsufficient Balance!");
			}
		}
		catch(Exception e)
		{}
	}
	
	public void deposit()
	{
		System.out.print("\nEnter Amount to Deposit!");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try
		{
			if(amount<=1000000f)
			{
				balance=balance+amount;
				System.out.println("\nAmount Deposited Successfully!");
				String str=amount+"Rs Deposited\n";
				transactionHistory=transactionHistory.concat(str);
			}
			else
			{
				System.out.println("Sorry limit is 1000000 Rs only");
			}
		}
		catch(Exception e){}
	}
	
	public void transfer()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnter Reciepent's Name:");
		String Reciepent=sc.nextLine();
		System.out.print("\nEnter Amount to tranfer:");
		float amount=sc.nextFloat();
		try
		{
			if(balance>=amount)
			{
				if(amount<=50000f)
				{
					transactions++;
					balance=balance-amount;
					System.out.println("\nSuccessfully tranfered to the reciepent "+Reciepent);
					String str=amount+"Rs Transferred to"+Reciepent+"\n";
					transactionHistory=transactionHistory.concat(str);
				}
				else
				{
					System.out.println("\nSorry Limit is 50000.0");
				}
			}
			else
			{
				System.out.println("\nInsufficient Balance");
			}
		}
		catch (Exception e) {}
	}
	
	public void checkBalance()
	{
		System.out.println("\n"+balance+"Rs");
	}
	
	public void History()
	{
		if(transactions==0)
		{
			System.out.println("\nEmpty");
		}
		
		else
		{
			System.out.println("\n"+transactionHistory);
		}
	}
}

public class Atm
{
	public static int takeIntegerInput(int limit)
	{
		int input=0;
		boolean flag=false;
		while(!flag)
		{
			try
			{
				Scanner sc=new Scanner(System.in);
				input=sc.nextInt();
				flag=true;
				if(flag && input >limit || input<1)
				{
					System.out.println("choose the number between 1 to"+limit);
					flag=false;
				}
			}
			catch(Exception e) 
			{
				System.out.println("enter only integer value");
				flag=false;
			}
		};
		return input;
	}
	
	public static void main(String args[])
	{
		System.out.println("1.Register\n2.Exit");
		System.out.print("enter your Choice:");
		int choice =takeIntegerInput(2);
		if(choice==1)
		{
			AtmInterface am=new AtmInterface();
			am.register();
			while(true)
			{
				System.out.println("1.Login \n2.Exit");
				System.out.print("Enter your choice:");
				int ch=takeIntegerInput(2);
				if(ch==1)
				{
					if(am.login())
					{
						boolean isFinished=false;
						while(!isFinished)
						{
							System.out.println("\n 1.Withdraw \n 2.Deposit \n 3.Transfer \n 4.Check balnce \n 5.Transaction history \n 6.Exit");
							System.out.print("\nEnter Your Choice:");
							int c=takeIntegerInput(6);
							switch(c)
							{
							   case 1:
							   {
								   am.withdraw();
								   break;
							   }
							   
							   case 2:
							   {
								   am.deposit();
								   break;
							   }
							   
							   case 3:
							   {
								   am.transfer();
								   break;
							   }
							   
							   case 4:
							   {
								   am.checkBalance();
								   break;
							   }
							   
							   case 5:
							   {
								   am.History();
								   break;
							   }
							   
							   case 6:
							   {
								   isFinished=true;
								   break;
							   }
							}
						}
					}
				}
				else
				{
					System.exit(0);
				}
			}
		}
		else
		{
			System.exit(0);
		}
	}
}



