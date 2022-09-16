package com.greatlearning.springJDBC.main;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import java.util.List;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import com.greatlearning.springJDBC.entity.Employee;

public class Main {
	static JdbcTemplate jdbcTemplateOBJ;
	static SimpleDriverDataSource dataSourceOBJ;
	static String USERNAME = "root";
	static String PASSWORD = "J@iGuru1991";
	static String URL = "jdbc:mysql://localhost:3306/springJDBC";
	
	//1. Creating Connection
	//configure database
	
	public static SimpleDriverDataSource getDatabaseConnection() {
		
		//2. inform the Spring code about DB
		
		dataSourceOBJ = new SimpleDriverDataSource();
		try {
			
			//3. Setting Driver Class
			
			dataSourceOBJ.setDriver(new com.mysql.cj.jdbc.Driver());
			dataSourceOBJ.setUrl(URL);
			dataSourceOBJ.setUsername(USERNAME);
			dataSourceOBJ.setPassword(PASSWORD);
		}
		catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
		return dataSourceOBJ;
	}

	public static void main(String[] args) {
		
		//2. inform the Spring code about DB
		
	jdbcTemplateOBJ = new JdbcTemplate(getDatabaseConnection());
	
	System.out.println("The Connection :- "+jdbcTemplateOBJ);
		
		if(null!= jdbcTemplateOBJ) {
		
			//4. SQL Insert Query
			String sqlInsertQuery = "Insert INTO Employee(name, email, address, phoneNo) VALUES (?,?,?,?) ";
			
			for (int counter = 1; counter<5; counter++) {
				
				jdbcTemplateOBJ.update(sqlInsertQuery,"Employee"+counter,"Employee"+counter+ 
						"@greatlearning.in" + "delhi" , "123456789");
				
			}
		
	
		/*//5. SQL Update
			String sqlUpdateQuery = "UPDATE Employee set email = ? where name = ?";
			jdbcTemplateOBJ.update(sqlUpdateQuery, "admin@greatlearning.in", "Employee2");
		//6. SQL Read
			String sqlSelectQuery = "SELECT name, email,address,PhoneNo FROM Employee";
			List listEmployee = jdbcTemplateOBJ.query(sqlSelectQuery, new RowMapper() {
				public Employee mapRow(ResultSet result, int rowNum) throws SQLException{
					Employee employeeObj = new Employee();
					employeeObj.setName(result.getString("name"));
					employeeObj.setEmail(result.getString("email"));
					employeeObj.setAddress(result.getString("address"));
					employeeObj.setPhoneno(result.getString("phoneNo"));
					return employeeObj;
					
				}

				@Override
				public int[] getRowsForPaths(TreePath[] path) {
					// TODO Auto-generated method stub
					return null;
				}
			});
			System.out.println(listEmployee);
		//7. SQL Delete
			String sqlDeleteQuery = "DELETE from Employee where name = ?";
			jdbcTemplateOBJ.update(sqlDeleteQuery, "Employee1");
		
			
		}
		//8. Close Connection
		else {
			System.out.println("Please check Connection");
		}*/
		}

	}

}
