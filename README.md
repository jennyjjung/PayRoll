# PayRoll
## Function
- Implement database security and keep track of users in the security tables
- Spring Security User Role : *OWNER* and *EMPLOYEE*
### Employee Object
- Track the following information
  - id (Auto generated)
  - Employee Name 
  - Employee Id (String)
  - Hours worked on Monday (double)
  - Hours worked on Tuesday (double)
  - Hours worked on Wednesday (double)
  - Hours worked on Thursday (double)
  - Hours worked on Friday (double)
  - Hours worked on Saturday (double)
  - Hours worked on Sunday (double)
  - Hourly wage (double)
  
### OWNER
- *OWNER* can create a new *Employee* object as *EMPLOYEE* security user
- Program calculates the weekly pay for an employee;
```ts
	if (totalHrs > 40) {
		// any hours more than 40 are paid at 1.5 times the stated wage
		salary = (totalHrs - 40) * 1.5 * wage + (40 * wage); 
	} else {
		salary = totalHrs * wage;
	}
```
- Weekly Payroll includes following data:
	- List of all employee object
	- Total number of hours for each employee
	- Weekly pay for each employee
	- Sum of hours clocked for each day
	- Average number of hours worked by employee
	- Highlight the employees that worked more than 40 hours
	- Edit and Delete operation 

### EMPLOYEE
- Created by the *OWNER*
- Username is being the employee's name, and Password is being the employee id
- *EMPLOYEE* can only see their information

## Quick Demo

https://user-images.githubusercontent.com/84524297/144302233-08a1279b-07fd-47ea-b20c-26fdc70444c6.mp4


### Use of 
- Spring Boot, Spring Security
- Thymeleaf, H2, Lombok
- HTML, CSS
