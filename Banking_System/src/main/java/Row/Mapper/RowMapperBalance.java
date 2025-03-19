package Row.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Spring.Banking_System.Employee;

public class RowMapperBalance implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp=new Employee();
		emp.setBalance(rs.getInt("Balance"));
		return emp;
	}
	
	

}
