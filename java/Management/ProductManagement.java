package Management;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductManagement {
	public static void productmanagement()
	{
		try
		{
			//product class obj to access its variable
			Product product=new Product();
			
			//establishing connection with db
			String url="jdbc:mysql://localhost:3306/managment";
			String password="Payal@j9067";
			String username="root";
			Connection con=DriverManager.getConnection(url,username,password);
			
			
			//creating stmt obj 
			Statement stmt=con.createStatement();
			
			//resultset to store fetched records(reference variable)
			ResultSet resultset = null;

			//to take input
			Scanner sc=new Scanner(System.in);
			
			
			while(true)
			{
				System.out.println("**************************PRODUCT MANAGEMENT************************");
				System.out.println("1.Add Product\n2.Update Product\n3.Search Product\n4.Delete Product\n5.Display Product\n6.Exit");
				System.out.println("What Would You Like To Do:");
				int choice=sc.nextInt();
				sc.nextLine();
				if(choice==1)
				{
					System.out.print("Enter Product Name:");
					product.pname=sc.nextLine();
					System.out.print("Enter Product ID:");
					product.pid=sc.nextInt();
					System.out.print("Enter Product Price:");
					product.pprice=sc.nextInt();
					System.out.print("Enter Product Quantity:");
					product.pquantity=sc.nextInt();
					
					//inserting records into Product table
					stmt.executeUpdate("insert into product values("+product.pid+",'"+product.pname+"',"+product.pprice+","+product.pquantity+")");
					System.out.println("Product is added Successfully..!\n");
				}
				else if(choice==2)
				{
				    System.out.println("**************************UPDATE PRODUCT************************");
					System.out.print("Enter Product ID to Modify Product Stock:");
				    product.pid=sc.nextInt();
					resultset=stmt.executeQuery("Select * from product where ID="+product.pid+"");
					if(resultset.next())
					{
					    System.out.println("Product Information:");
					    System.out.print(resultset.getInt(1) + " ");
					    System.out.print(resultset.getString(2) + " ");
					    System.out.print(resultset.getInt(3) + " ");
					    System.out.print(resultset.getInt(4) + "\n");
						System.out.print("Enter Product New Price:");
						product.pprice=sc.nextInt();
						System.out.print("Enter Product New Quantity:");
						product.pquantity=sc.nextInt();
						
						//updating 
						stmt.executeUpdate("update product set Price="+product.pprice+",Quantity="+product.pquantity+" where ID="+product.pid+"");
						System.out.println("Product Stock Modified Successfully..!\n");
					} 
					else
					{
						 System.out.println("Product not Available in the Stock..!");
						 
					}
				}
				else if(choice==3)
				{
					System.out.println("**************************SEARCH PRODUCT************************");
					System.out.print("Enter Product ID to Search Product:");
					product.pid=sc.nextInt();
					resultset=stmt.executeQuery("Select * from product where ID="+product.pid+"");
					if(resultset.next())
					{
					    System.out.println("Product Available in the Stock..!");
					    System.out.println("Product Information:");
					    System.out.print(resultset.getInt(1) + " ");
					    System.out.print(resultset.getString(2) + " ");
					    System.out.print(resultset.getInt(3) + " ");
					    System.out.print(resultset.getInt(4) + "\n");
					} 
					else 
					{
					    System.out.println("Product not Available in the Stock..!");
					}
				}
				else if(choice==4)
				{
					System.out.println("**************************DELETE PRODUCT************************");
					System.out.print("Enter Product ID to Remove from the Stock:");
					product.pid=sc.nextInt();
					resultset=stmt.executeQuery("Select * from product where ID="+product.pid+"");
					if(resultset.next())
					{
					    System.out.println("Product Information:");
					    System.out.print(resultset.getInt(1) + " ");
					    System.out.print(resultset.getString(2) + " ");
					    System.out.print(resultset.getInt(3) + " ");
					    System.out.print(resultset.getInt(4) + "\n");
					    stmt.executeUpdate("delete from product where ID="+product.pid+"");
						System.out.println("Product from Stock Removed Successfully..!\n");
					} 
					else 
					{
					    System.out.println("Product not Available in the Stock..!");
					}
				}
				else if(choice==5)
				{
					System.out.println("**************************DISPLAY PRODUCT************************");
					//retrieve all product
					resultset=stmt.executeQuery("Select * from product");
					//running until records have
					while(resultset.next())
					{
						System.out.print(resultset.getInt(1)+" ");
						System.out.print(resultset.getString(2)+" ");
						System.out.print(resultset.getInt(3)+" ");
						System.out.print(resultset.getInt(4)+"\n");
					}
				}
				else if(choice==6)
				{
					return;
				}
				else
				{
					System.out.println("Invalid option...");
				}
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
}
