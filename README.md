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
  
### Owner
- *OWNER* can create a new *EMPLOYEE*
- Program calculates the weekly pay for an employee;
    <if (totalHrs > 40) {
			salary = (totalHrs - 40) * 1.5 * wage + (40 * wage);
		} else {
			salary = totalHrs * wage;
		}>



## Quick Demo

https://user-images.githubusercontent.com/84524297/144302233-08a1279b-07fd-47ea-b20c-26fdc70444c6.mp4

## 

### Security User Roles
- 2 Roles; OWNER and EMPLOYEE
- OWNER can access owner page which has function of Add Employee and View Weekly Payroll.
- When Owener add Employee 
- Track of users  
