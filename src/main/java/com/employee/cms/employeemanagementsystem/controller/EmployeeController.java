package com.employee.cms.employeemanagementsystem.controller;

import com.employee.cms.employeemanagementsystem.model.Employee;
import com.employee.cms.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

//    display list of employee

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
//        creating model attribute to bind form data
        Employee employee = new Employee();
        System.out.println("employeename" + employee);
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployeeNew(@ModelAttribute("employee") Employee employee){
//        save employee to db
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable(value = "id") long id , Model model){

//        get all employee from the service
        Employee employee = employeeService.getEmployeeById(id);
//        set employee as model attribute to pre-populate the form

        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id){

//        call delete Employee method
        employeeService.deleteEmployee(id);
        return  "redirect:/";
    }
}
