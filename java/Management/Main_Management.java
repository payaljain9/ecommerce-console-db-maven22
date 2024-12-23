package Management;

import java.sql.SQLException;
import java.util.Scanner;


public class Main_Management {
	public static void main(String args[]) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		Login.login();
		while(true)
		{
			System.out.println("*******************MANAGEMENT******************");
			System.out.println("1.User Management\n2.Product Management\n3.Exit");
			System.out.print("What Would You Like To Do:");
			int choice=sc.nextInt();
			if(choice==1)
			{
				UserManagement.usermanagement();
				System.out.println();
			}
		
			else if(choice==2)
			{
				ProductManagement.productmanagement();
				System.out.println();
			}
			
			else if(choice==3)
			{
				return;
			}
			
			else
			{
				System.out.println("Invlid option...");
			}
		}
	}
}
