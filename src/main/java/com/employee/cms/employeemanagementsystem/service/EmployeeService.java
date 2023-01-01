package com.employee.cms.employeemanagementsystem.service;

import com.employee.cms.employeemanagementsystem.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

    void deleteEmployee(long id);
}
