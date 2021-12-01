package ca.sheridancollege.jungjuyo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.jungjuyo.beans.Employee;
import ca.sheridancollege.jungjuyo.beans.User;
import ca.sheridancollege.jungjuyo.repositories.EmployeeRepository;
import ca.sheridancollege.jungjuyo.repositories.UserRepository;

@Controller
public class HomeController {
	
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private UserRepository userRepo;

	@GetMapping("/")
	public String goHome() {
		return "index.html";
	}
	
	@GetMapping("ownerPage")
	public String ownerPage(Model model) {
		
		ArrayList<Employee> employees = empRepo.getEmployees();
		model.addAttribute("employees", employees);
		
		double avgHrs = 0.0;
		double avgSalary = 0.0;
		double sumMon = 0.0;
		double sumTue = 0.0;
		double sumWed = 0.0;
		double sumThu = 0.0;
		double sumFri = 0.0;
		double sumSat = 0.0;
		double sumSun = 0.0;
		
		for (int i = 0; i < employees.size(); i++) {
			avgHrs += employees.get(i).getTotalHrs();
			avgSalary += employees.get(i).getSalary();
			sumMon += employees.get(i).getMonHrs();
			sumTue += employees.get(i).getTueHrs();
			sumWed += employees.get(i).getWedHrs();
			sumThu += employees.get(i).getThuHrs();
			sumFri += employees.get(i).getFriHrs();
			sumSat += employees.get(i).getSatHrs();
			sumSun += employees.get(i).getSunHrs();
		}
		avgHrs /= employees.size();
		String strAvgHrs = String.format("%.2f", avgHrs);
		
		avgSalary /= employees.size();
		String strAvgSalary = String.format("%.2f", avgSalary);
		
		model.addAttribute("avgHrs", strAvgHrs);
		model.addAttribute("avgSalary", strAvgSalary);
		model.addAttribute("sumMon", sumMon);
		model.addAttribute("sumTue", sumTue);
		model.addAttribute("sumWed", sumWed);
		model.addAttribute("sumThu", sumThu);
		model.addAttribute("sumFri", sumFri);
		model.addAttribute("sumSat", sumSat);
		model.addAttribute("sumSun", sumSun);
		
		return "ownerPage.html";
	}
	
	@GetMapping("/edit/{id}")
	public String loadEditForm(Model model, @PathVariable int id) {
		
		Employee e = empRepo.getEmployeeById(id);
		model.addAttribute("employee", e);
		
		return "editEmp.html";
	}
	
	@PostMapping("/editEmp")
	public String editEmp(@ModelAttribute Employee employee) {
		
		empRepo.editEmployee(employee);
		return "redirect:/ownerPage";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id, Model model) {
		
		Employee e = empRepo.getEmployeeById(id);
		empRepo.deleteEmployee(id);
		
		User user = userRepo.findUserAccount(e.getName());
		userRepo.deleteUserRole(user);
		userRepo.deleteUser(user);
		return "redirect:/ownerPage";
	}
	
	@GetMapping("/employeePage")
	public String employeePage(Authentication authentication, Model model) {
		
		String username = authentication.getName();
		
		Employee e = empRepo.getEmployee(username);
		model.addAttribute("employee", e);
		
		return "employeePage.html";
	}
	
	
}
