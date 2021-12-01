package ca.sheridancollege.jungjuyo.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

	private static final long serialVersionUID = -265204101199024553L;
	
	private long id;
	private String name;
	private String empId;
	private double wage;
	private double monHrs;
	private double tueHrs;
	private double wedHrs;
	private double thuHrs;
	private double friHrs;
	private double satHrs;
	private double sunHrs;
	
	private double totalHrs;
	private double salary;
	
	private String strWage;
	private String strSalary;

	public void setTotalHrs() {
		this.totalHrs = monHrs + tueHrs + wedHrs + thuHrs + friHrs + satHrs + sunHrs;
	}
	
	public void setSalary() {
		
		if (totalHrs > 40) {
			salary = (totalHrs - 40) * 1.5 * wage + (40 * wage);
		} else {
			salary = totalHrs * wage;
		}
		setStrSalary();
		setStrWage();
	}
	
	public void setStrWage() {
		strWage = String.format("%.2f", getWage());
	}
	
	public void setStrSalary() {
		strSalary = String.format("%.2f", getSalary());
	}

}