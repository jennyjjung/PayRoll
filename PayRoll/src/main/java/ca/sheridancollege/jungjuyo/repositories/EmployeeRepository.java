package ca.sheridancollege.jungjuyo.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.jungjuyo.beans.Employee;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	
	public void addEmployee(Employee employee) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO employees (name, empId, wage, monHrs, "
				+ "tueHrs, wedHrs, thuHrs, friHrs, satHrs, sunHrs)"
				+ "VALUES (:name, :empId, :wage, :monHrs, :tueHrs, :wedHrs,"
				+ ":thuHrs, :friHrs, :satHrs, :sunHrs)";
		
		parameters.addValue("name", employee.getName());
		parameters.addValue("empId", employee.getEmpId());
		parameters.addValue("wage", employee.getWage());
		parameters.addValue("monHrs", employee.getMonHrs());
		parameters.addValue("tueHrs", employee.getTueHrs());
		parameters.addValue("wedHrs", employee.getWedHrs());
		parameters.addValue("thuHrs", employee.getThuHrs());
		parameters.addValue("friHrs", employee.getFriHrs());
		parameters.addValue("satHrs", employee.getSatHrs());
		parameters.addValue("sunHrs", employee.getSunHrs());

		jdbc.update(query, parameters);
	}
	
	public Employee getEmployee(String username) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM employees WHERE name=:name";

		parameters.addValue("name", username);
		
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		for (Map<String, Object> row : rows) {
			
			Employee e = new Employee();
			
			e.setId((Long)row.get("id"));
			e.setName((String)row.get("name"));
			e.setEmpId((String)row.get("empId"));
			e.setWage((Double)row.get("wage"));
			e.setMonHrs((Double)row.get("monHrs"));
			e.setTueHrs((Double)row.get("thuHrs"));
			e.setWedHrs((Double)row.get("wedHrs"));
			e.setThuHrs((Double)row.get("thuHrs"));
			e.setFriHrs((Double)row.get("friHrs"));
			e.setSatHrs((Double)row.get("satHrs"));
			e.setSunHrs((Double)row.get("sunHrs"));
			e.setTotalHrs();
			e.setSalary();
			
			employees.add(e);
		}
		
		if (employees.size() == 1) {
			return employees.get(0);
		} else {
			return null;
		}
	}

	public ArrayList<Employee> getEmployees() {
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM employees";
		
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for (Map<String, Object> row : rows) {
			
			Employee e = new Employee();
			
			e.setId((Long)row.get("id"));
			e.setName((String)row.get("name"));
			e.setEmpId((String)row.get("empId"));
			e.setWage((Double)row.get("wage"));
			e.setMonHrs((Double)row.get("monHrs"));
			e.setTueHrs((Double)row.get("thuHrs"));
			e.setWedHrs((Double)row.get("wedHrs"));
			e.setThuHrs((Double)row.get("thuHrs"));
			e.setFriHrs((Double)row.get("friHrs"));
			e.setSatHrs((Double)row.get("satHrs"));
			e.setSunHrs((Double)row.get("sunHrs"));
			e.setTotalHrs();
			e.setSalary();
			
			employees.add(e);
		}
	
		return employees;
	}

	public Employee getEmployeeById(int id) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM employees WHERE id=:id";
		parameters.addValue("id", id);
		
		ArrayList<Employee> employees = (ArrayList<Employee>)jdbc.query
				(query, parameters, new BeanPropertyRowMapper<Employee>(Employee.class));
		
		if (employees.size() == 1) {
			return employees.get(0);
		} else {
			return null;
		}
	}
	
	public void editEmployee(Employee employee) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "UPDATE employees SET "
				+ "wage=:wage, monHrs=:monHrs, tueHrs=:tueHrs, wedHrs=:wedHrs, "
				+ "thuHrs=:thuHrs, friHrs=:friHrs, satHrs=:satHrs, "
				+ "sunHrs=:sunHrs WHERE id=:id";
		
		parameters.addValue("wage", employee.getWage());
		parameters.addValue("monHrs", employee.getMonHrs());
		parameters.addValue("tueHrs", employee.getTueHrs());
		parameters.addValue("wedHrs", employee.getWedHrs());
		parameters.addValue("thuHrs", employee.getThuHrs());
		parameters.addValue("friHrs", employee.getFriHrs());
		parameters.addValue("satHrs", employee.getSatHrs());
		parameters.addValue("sunHrs", employee.getSunHrs());		
		parameters.addValue("id", employee.getId());
	
		jdbc.update(query, parameters);
	}
	
	public void deleteEmployee(int id) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "DELETE FROM employees WHERE id=:id";
		
		parameters.addValue("id", id);
		jdbc.update(query, parameters);
	}

}
