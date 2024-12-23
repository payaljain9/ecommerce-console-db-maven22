package Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserManagement {
	public static void usermanagement() 
	{
		try
		{
	    User user=new User();
		Scanner sc=new Scanner(System.in);
		

		//establishing connection with db
		String url="jdbc:mysql://localhost:3306/managment";
		String password="Payal@j9067";
		String username="root";
		Connection con=DriverManager.getConnection(url,username,password);
		
		//creating stmt obj 
		Statement stmt=con.createStatement();
		
		//resultset reference variable
		ResultSet resultset = null;
		
		while(true)
		{
			System.out.println("**************************USER MANAGEMENT************************");
			System.out.println("1.Add User\n2.Update User\n3.Delete User\n4.Search User\n5.Display Users\n6.Exit");
			System.out.println("what would you like to do:");
			int choice=sc.nextInt();
			sc.nextLine();
			if(choice==1)
			{

				System.out.println("**************************ADD USER************************");
				System.out.print("Enter User Name:");
				user.uname=sc.nextLine();
				System.out.print("Enter User ID:");
				user.uid=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter User Password:");
				user.upassword=sc.nextLine();
				System.out.print("Enter User Mail:");
				user.uemail=sc.nextLine();
				
				//inserting records into Product table
				stmt.executeUpdate("insert into user values("+user.uid+",'"+user.uname+"','"+user.upassword+"','"+user.uemail+"')");
				System.out.println("User Information is added Successfully..!\n");
			}
			else if(choice==2)
			{
				System.out.println("**************************UPDATE USER************************");
				System.out.print("Enter User ID to Modify User Record:");
				user.uid=sc.nextInt();
				sc.nextLine();
				resultset=stmt.executeQuery("Select * from user where ID="+user.uid+"");
				if(resultset.next())
				{
				    System.out.println("User Information:");
				    System.out.print(resultset.getInt(1) + " ");
				    System.out.print(resultset.getString(2) + " ");
				    System.out.print(resultset.getString(3) + " ");
				    System.out.print(resultset.getString(4) + "\n");
				  
				    System.out.print("Enter User New Name:");
					user.uname=sc.nextLine();
					System.out.print("Enter User New Password:");
					user.upassword=sc.nextLine();
					System.out.print("Enter User New E-mail:");
					user.uemail=sc.nextLine();
					
					//updating 
					stmt.executeUpdate("update user set Name='"+user.uname+"',Password='"+user.upassword+"',Email='"+user.uemail+"' where ID="+user.uid+"");
					System.out.println("User Information Modified Successfully..!\n");
				} 
				else
				{
					 System.out.println("User Record not Available in the Databse..!");
				}
				
			}
			else if(choice==3)
			{
				System.out.println("**************************DELETE USER************************");
				System.out.print("Enter User ID to Delete User Record:");
				user.uid=sc.nextInt();
				sc.nextLine();
				resultset=stmt.executeQuery("Select * from user where ID="+user.uid+"");
				if(resultset.next())
				{
				    System.out.println("User Information:");
				    System.out.print(resultset.getInt(1) + " ");
				    System.out.print(resultset.getString(2) + " ");
				    System.out.print(resultset.getString(3) + " ");
				    System.out.print(resultset.getString(4) + "\n");
				    stmt.executeUpdate("delete from user where ID="+user.uid+"");
				    System.out.println("User Record Deleted from the Databse..!");
				} 
				else 
				{
					System.out.println("User Record not Available in the Databse..!");
				}
			}
			else if(choice==4)
			{
				System.out.println("**************************SEARCH USER************************");
				System.out.print("Enter User ID to Search User Record:");
				user.uid=sc.nextInt();
				sc.nextLine();
				resultset=stmt.executeQuery("Select * from user where ID="+user.uid+"");
				if(resultset.next())
				{
					System.out.println("User Record Present in the Database..!");
				    System.out.println("User Information:");
				    System.out.print(resultset.getInt(1) + " ");
				    System.out.print(resultset.getString(2) + " ");
				    System.out.print(resultset.getString(3) + " ");
				    System.out.print(resultset.getString(4) + "\n");
			    }
				else 
				{
					System.out.println("User Record not Available in the Databse..!");
				}
			}
			else if(choice==5)
			{
				System.out.println("**************************DISPLAY USER************************");
				resultset=stmt.executeQuery("Select * from user");
				if(resultset.next())
				{
				    System.out.print(resultset.getInt(1) + " ");
				    System.out.print(resultset.getString(2) + " ");
				    System.out.print(resultset.getString(3) + " ");
				    System.out.print(resultset.getString(4) + "\n");
				} 
				else 
				{
					System.out.println("User Record not Available in the Databse..!");
				}
			}
			else if(choice==6)
			{
				return;
			}
			else
			{
				System.out.println("Invlid Option..!");
			}
		}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
