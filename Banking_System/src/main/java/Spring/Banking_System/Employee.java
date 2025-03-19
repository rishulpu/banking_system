package Spring.Banking_System;

public class Employee {
	
	private int id;
	private String first_Name;
	private String Last_Name;
	private int age;
	private String acc_Type;
	private String userName;
	private String email;
	private String dob;
	private String Password;
	private int Balance;
	
	public Employee(int id, String first_Name, String last_Name, int age, String acc_Type, String userName,
			String email, String dob, String password, int balance) {
		super();
		this.id = id;
		this.first_Name = first_Name;
		Last_Name = last_Name;
		this.age = age;
		this.acc_Type = acc_Type;
		this.userName = userName;
		this.email = email;
		this.dob = dob;
		Password = password;
		Balance = balance;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAcc_Type() {
		return acc_Type;
	}
	public void setAcc_Type(String acc_Type) {
		this.acc_Type = acc_Type;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	public Employee() {
		
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_Name=" + first_Name + ", Last_Name=" + Last_Name + ", age=" + age
				+ ", acc_Type=" + acc_Type + ", userName=" + userName + ", email=" + email + ", dob=" + dob
				+ ", Password=" + Password + ", Balance=" + Balance + "]";
	}
	
	
	
	
}
