package Spring.Banking_System;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import Spring.Banking_System.oparation.Opration;
import Spring.admin.Admin;

@Configuration
public class config {
	@Bean
	public DriverManagerDataSource du() {
		DriverManagerDataSource d=new DriverManagerDataSource();
		d.setUrl("jdbc:mysql://localhost:3306/Bank");
		d.setUsername("root");
		d.setPassword("root");
		return d;
	}
	@Bean
	public JdbcTemplate template() {
		JdbcTemplate t=new JdbcTemplate(du());
		return t;
	}
	@Bean
	public Opration oper() {
		Opration op=new Opration();
		op.setTemplate(template());
		
		return op;	
	}
	@Bean
	public Admin admin() {
		Admin ad=new Admin();
		ad.setTemplate(template());
		return ad;
	}

}
