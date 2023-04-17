package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.EmployeeServiceImpl;

@Controller
public class MainController {
	@Autowired
	private EmployeeServiceImpl serviceImpl;

	@GetMapping("/")
	public String home() {
		return "welcome";
	}

	@GetMapping("/report")
	public String getData(Map<String, Object> map) {

		List<Employee> list = serviceImpl.getEmployee();

		map.put("data", list);

		return "Get_Employee";

	}
	/*
	 * @PostMapping("/addEmployee") //@RequestMapping(value = "/addEmployee", method
	 * = { RequestMethod.GET, RequestMethod.POST }) public String
	 * addEmployee(Map<String,Object>map,@ModelAttribute("emp") Employee emp) {
	 * 
	 * Employee em=new Employee();
	 * 
	 * em.setDepno(emp.getDepno()); em.setEmpno(emp.getEmpno());
	 * em.setEname(emp.getEname()); em.setJob(emp.getJob());
	 * em.setSal(emp.getSal());
	 * 
	 * String msg =serviceImpl.addEmployee(emp); map.put("data1", msg); return
	 * "redirect:report";
	 * 
	 * }
	 */
	
	//or

	@PostMapping("/addEmployee")
	// @RequestMapping(value = "/addEmployee", method = { RequestMethod.GET,
	// RequestMethod.POST })
	public String addEmployee(RedirectAttributes  attrs, @ModelAttribute("emp") Employee emp) {
		/*
		 * Employee em=new Employee();
		 * 
		 * em.setDepno(emp.getDepno()); em.setEmpno(emp.getEmpno());
		 * em.setEname(emp.getEname()); em.setJob(emp.getJob());
		 * em.setSal(emp.getSal());
		 */
		String msg = serviceImpl.addEmployee(emp);
		attrs.addFlashAttribute("data1", msg);
		return "redirect:report";

	}

	@GetMapping("/addEmployee")
	public String addEmp(@ModelAttribute("emp") Employee emp) {
		return "add";
	}

}
