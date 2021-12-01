package ca.sheridancollege.jungjuyo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.jungjuyo.beans.Employee;
import ca.sheridancollege.jungjuyo.beans.User;
import ca.sheridancollege.jungjuyo.repositories.EmployeeRepository;
import ca.sheridancollege.jungjuyo.repositories.UserRepository;

@Controller
public class SecurityController {
	
	@Autowired
	@Lazy
	private EmployeeRepository empRepo;
	@Autowired
	@Lazy
	private UserRepository userRepo;

	@GetMapping("/login")
	public String goLogin() {
		return "login.html";
	}
	
	@GetMapping("/access-denied")
	public String accessdenied() {
		return "access-denied.html";
	}
	
	@GetMapping("/addEmployee")
	public String getToRegisteration(Model model) {
		
		model.addAttribute("employee", new Employee());
		return "addEmployee.html";
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute Employee employee) {
		// add Employee in employees table
		//        also, in sec_user table
		
		empRepo.addEmployee(employee);
		userRepo.addUser(employee.getName(), employee.getEmpId());
						// employee name = username, employee ID = password
		
		User user = userRepo.findUserAccount(employee.getName());
		userRepo.addRole(user.getUserId(), 2); // will always register EMPLOYEE
		
		return "redirect:/addEmployee";
	}
}
