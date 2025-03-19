package Row.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Spring.Banking_System.Employee;

public class Row_map implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee emp=new Employee();
		emp.setBalance(rs.getInt("balance"));
		emp.setFirst_Name(rs.getString("first_name"));
//		emp.setLast_Name(rs.getString("Last_name"));
		
		return emp;
		
	}

}
