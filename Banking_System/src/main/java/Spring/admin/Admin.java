package Spring.admin;

import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import Spring.Banking_System.Employee;

public class Admin {
	
	private static JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	
	public static List allData() {
		String query = "Select * from Banking_System";
		List ll = template.queryForList(query);

//		System.out.println(ll);
		return ll;
	}

	public static  int insert(Employee emp) {
		String query = "INSERT INTO Banking_System (First_Name, Last_Name, Age, Acc_Type, Username, Email, DOB, Password, Balance) VALUES (?,?,?,?,?,?,?,?,?)";
		int up = template.update(query, emp.getFirst_Name(), emp.getLast_Name(), emp.getAge(), emp.getAcc_Type(),
				emp.getUserName(), emp.getEmail(), emp.getDob(), emp.getPassword(), emp.getBalance());
		return up;

	}
	public static void delete(String username) {
		String query = "DELETE FROM Banking_System WHERE Username = ?";
		int affected = template.update(query);
		if (affected < 0) {
			System.out.println(username + " deleted");
		}

	}
	
	public static Employee insertData() {
		Scanner sc = new Scanner(System.in);
		Employee eml = new Employee();

		// Input First Name
		System.out.println("Enter First Name:");
		String Fname = sc.nextLine();
		eml.setFirst_Name(Fname);

		System.out.println("Enter Last Name:");
		String Lname = sc.nextLine();
		eml.setLast_Name(Lname);
		
		System.out.println("Enter Age:");
		int age = sc.nextInt();
		sc.nextLine(); 
		eml.setAge(age);

		
		System.out.println("Select Account Type:");
		System.out.println("1. Savings Account");
		System.out.println("2. Current Account");

		boolean valid = true;
		while (valid) {
			int accType = sc.nextInt();
			sc.nextLine(); 
			switch (accType) {
			case 1:
				eml.setAcc_Type("Savings");
				valid = false;
				break;
			case 2:
				eml.setAcc_Type("Current");
				valid = false;
				break;
			default:
				System.out.println("Enter a valid number (1 or 2).");
			}
		}
		System.out.println("Enter Email:");
		String mail = sc.nextLine();
		eml.setEmail(mail);
		String emailPrefix = mail.contains("@") ? mail.split("@")[0] : mail;
		String username = Fname.toLowerCase() + age + emailPrefix.charAt(0) + eml.getAcc_Type().charAt(0);
		eml.setUserName(username.toLowerCase());
		System.out.println("Enter Date of Birth:");
		System.out.print("Enter Day (DD): ");
		String day = sc.next();
		System.out.print("Enter Month (MM): ");
		String month = sc.next();
		System.out.print("Enter Year (YYYY): ");
		String year = sc.next();

		String dob = year + "-" + month + "-" + day;
		eml.setDob(dob);
		sc.nextLine(); 

		
		System.out.println("Enter Password:");
		String pass = sc.nextLine();
		eml.setPassword(pass);

		System.out.println("\nAccount Created Successfully!");
		System.out.println("Your Username: " + username);
		System.out.println("Your Password: " + pass);

		return eml;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
