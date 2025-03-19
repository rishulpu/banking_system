package Spring.Banking_System.oparation;

import java.util.List;
import java.util.Scanner;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Row.Mapper.RowMapperBalance;
import Row.Mapper.RowMapperName;
import Row.Mapper.Row_map;
import Row.Mapper.Row_mapper_pass;
import Spring.Banking_System.Employee;

public class Opration {

	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int insert(Employee emp) {
		String query = "INSERT INTO Banking_System (First_Name, Last_Name, Age, Acc_Type, Username, Email, DOB, Password, Balance) VALUES (?,?,?,?,?,?,?,?,?)";
		int up = template.update(query, emp.getFirst_Name(), emp.getLast_Name(), emp.getAge(), emp.getAcc_Type(),
				emp.getUserName(), emp.getEmail(), emp.getDob(), emp.getPassword(), emp.getBalance());
		return up;

	}

	public void updatePass(String username) {
		String query = "UPDATE Banking_System SET Password = ? WHERE Username = ?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Password");
		String new_Pass = sc.nextLine();
		int update = template.update(query, new_Pass, username);
		System.out.println(update);
//		return update;
	}

	public void delete(String username) {
		String query = "DELETE FROM Banking_System WHERE Username = ?";
		int affected = template.update(query);
		if (affected < 0) {
			System.out.println(username + " deleted");
		}

	}

	public List allData() {
		String query = "Select * from Banking_System";
		List ll = template.queryForList(query);

		System.out.println(ll);
		return ll;
	}

	public int updatebalance(String username, int balance) {
		String query = "UPDATE Banking_System SET Balance = ? WHERE Username = ?";
		int i = template.update(query, balance, username);

		if (i > 0) {
			System.out.println("Trasaction Successfully");
		} else {
			System.out.println("Username not found");
		}

		return 0;

	}

	public int addBalance(String username, int bal) {
		String query = "UPDATE Banking_System SET Balance = ? WHERE Username = ?";
		String query2 = "SELECT Balance,First_Name FROM Banking_System WHERE Username = ?";

		RowMapper<Employee> em = new Row_map();
		Employee el = (Employee) template.queryForObject(query2, em, username);
//	    System.out.println(el.getBalance());
		int balance = el.getBalance();
		int total = balance + bal;

		int upd = template.update(query, total, username);
		System.out.println("Upadate" + upd);

		if (upd > 0) {
			System.out.println("balanced Adding");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Balance Added");

		}

		Employee el2 = (Employee) template.queryForObject(query2, em, username);
		System.out.println("Your Total balance is.." + el2.getBalance());
		System.out.println("Thanku sir..." + el2.getFirst_Name());

		return 0;
	}

	public void deductBalance(String username, int bal) {
		String query = "UPDATE Banking_System SET Balance = ? WHERE Username = ?";
		String query2 = "SELECT Balance,First_Name FROM Banking_System WHERE Username = ?";
		RowMapper<Employee> ell = new Row_map();
		Employee e = template.queryForObject(query2, ell, username);
		int balance = e.getBalance();
		int total;
		if (bal > balance) {
			System.out.println("Low balance");
			return;
		} else {
			total = balance - bal;

		}
		int i = template.update(query, total, username);
		if (i > 0) {
			System.out.println("Balance Updating....");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Your new balance is: " + total);
		}

	}

	public int login(String username, String pass) {
		String query = "SELECT Username,Password FROM Banking_System WHERE Username = ?";
		RowMapper<Employee> r = new Row_mapper_pass();
		Employee emp = null;

		try {
			emp = template.queryForObject(query, r, username);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("UserName not found");

			return 0;
		}

		String userN = emp.getUserName();
		String Pass = emp.getPassword();
//		System.out.println(userN);
//		System.out.println(Pass);

		if (userN.equals(username) && Pass.equals(pass)) {
//			System.out.println("valid USer");
			return 1;

		} else {
			
			System.err.println("Wrong Password");
			return 0;
		}

	}

	public Employee insertData() {
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
	
	public Employee getName(String username) {
		Employee ree=new Employee();
		String query="Select First_Name,Last_Name from Banking_System WHERE Username = ?";
		RowMapper<Employee> ee=new RowMapperName();
		ree=template.queryForObject(query,ee,username);
		return ree;
	}
	
	public Employee checkBalance(String username) {
		
		Employee rer=new Employee();
		String query="Select Balance from Banking_System where username=?";
		RowMapper<Employee> em=new RowMapperBalance();
		rer=template.queryForObject(query,em,username);
		
		return rer;
	}

}
