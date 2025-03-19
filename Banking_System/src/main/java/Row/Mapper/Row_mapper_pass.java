package Row.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Spring.Banking_System.Employee;

public class Row_mapper_pass implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp=new Employee();
		emp.setUserName(rs.getString("username"));
		emp.setPassword(rs.getString("password"));
		return emp;
	}

	
}
