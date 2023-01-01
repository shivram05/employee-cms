package com.employee.cms.employeemanagementsystem.service_impl;

import com.employee.cms.employeemanagementsystem.model.Employee;
import com.employee.cms.employeemanagementsystem.repository.EmployeeRepository;
import com.employee.cms.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee;
        if (optionalEmployee.isPresent()) {
           employee =  optionalEmployee.get();
        } else {
            throw  new RuntimeException("Employee not found for id : " + id);
        }
        return employee;

    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
