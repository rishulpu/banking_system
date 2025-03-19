package Spring.Banking_System;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Spring.Banking_System.oparation.Opration;
import Spring.admin.Admin;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Macine Started!");
		ApplicationContext app = new AnnotationConfigApplicationContext(config.class);

		Opration op = (Opration) app.getBean("oper");
//		
		
		
		System.out.println("Welcome to Internet Banking");
		System.out.println("Login .1");
		System.out.println("Signup .2");
		System.out.println("Admin .3");

		int value = sc.nextInt();

		switch (value) {
		case 1:
			System.out.println("Enter username");
			String user = sc.next();

			System.out.println("Enter Password");
			String pasS = sc.next();

			int val = op.login(user, pasS);
			if (val == 1) {
				Employee lkj = op.getName(user);
				System.out.println("Hi " + lkj.getFirst_Name() + " " + lkj.getLast_Name());
				boolean bool = true;
				while (bool) {
					
					System.out.println(" ");
					System.out.println("Withdraw Money..1");
					System.out.println("Deposite Money..2");
					System.out.println("Check Balance...3");
					System.out.println("Exits...4");
					System.out.println(" ");
					
					int ope = sc.nextInt();

					switch (ope) {
					case 2:
						System.out.println("Enter Money to Deposite");
						int balan = sc.nextInt();
						op.addBalance(user, balan);
						break;

					case 1:

						System.out.println("Enter Money to Withdraw");
						int money = sc.nextInt();
						op.deductBalance(user, money);
						break;
					case 3:

						System.out.println("Loading...");
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Employee checkBal = op.checkBalance(user);
						System.out.println("Your Balance is : "+checkBal.getBalance());
						break;

					case 4:
						bool = false;
						Employee emm=new Employee();
						emm=op.getName(user);
						System.out.println("Tnqq sir : "+emm.getFirst_Name()+" "+emm.getLast_Name());
						break;
					default:
						System.out.println("Enter Valid Number");

					}
				}
			}
			break;
			
		case 2:
			op.insertData();
			break;
		case 3:
			
			String aname="admin";
			String apassword="admin";
			
			System.out.println("Enter Username");
			String aname2 ="admin"; 

			System.out.println("Enter Password");
			String apassword2 = "admin"; 
			
			if(aname.equals(aname2)&& apassword.equals(apassword2)) {
				
				System.out.println("Hello Admin");
				System.out.println(" ");
				System.out.println("Insert data.1");
				System.out.println("Delete data.2");
				System.out.println("All data   .3");
				int data=sc.nextInt();
				switch(data) {
				case 1:
					
					Admin.insert(Admin.insertData());
					break;
					
				case 2:
					System.out.println("Enter username to delete account");
					String use=sc.nextLine();
					Admin.delete(use);
					break;
					
				case 3:
					List ll=Admin.allData();
					Employee emp=new Employee();
					
					for(Object dd:ll) {
					   System.out.println(dd);
					}
					break;
				
				}
				
			}
			

		}

	}
}
