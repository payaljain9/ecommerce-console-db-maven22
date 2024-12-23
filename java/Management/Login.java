package Management;

import java.util.Scanner;

public class Login {
	public static void login() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Username:");
		String username=sc.nextLine();
		System.out.print("Enter Password:");
		String password=sc.nextLine();
		if(username.equals("payal"))
		{
			if(password.equals("123"))
			{
				System.out.println();
				return;
			}
		}
		return;
	}
}
