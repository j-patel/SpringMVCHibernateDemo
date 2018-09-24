/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Employee;
import com.spring.service.EmployeeService;
/**
 *
 * @author jay20
 */
@Controller
public class EmployeeController {
    private EmployeeService employeeService;

	@Autowired(required=true)
	@Qualifier(value="employeeService")
	public void setEmployeeService(EmployeeService es){
            this.employeeService = es;
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String listEmployees(Model model) {
            model.addAttribute("employee", new Employee());
            model.addAttribute("listEmployees", this.employeeService.listEmployees());
            return "employee";
	}
        
        //For add and update employee both
	@RequestMapping(value= "/employee/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee e){
		
            if(e.getId() == 0){
                    //new employee, add it
                    this.employeeService.addEmployee(e);
            }else{
                    //existing employee, call update
                    this.employeeService.updateEmployee(e);
            }

            return "redirect:/employees";
		
	}
	
        @RequestMapping("/remove/{id}")
        public String removeEmployee(@PathVariable("id") int id){

            this.employeeService.removeEmployee(id);
            return "redirect:/employees";
        }

        @RequestMapping("/edit/{id}")
        public String editEmployee(@PathVariable("id") int id, Model model){
            model.addAttribute("employee", this.employeeService.getEmployeeById(id));
            model.addAttribute("listEmployees", this.employeeService.listEmployees());
            return "employee";
        }
}
