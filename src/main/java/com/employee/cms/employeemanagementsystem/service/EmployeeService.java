package com.employee.cms.employeemanagementsystem.service;

import com.employee.cms.employeemanagementsystem.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

    void deleteEmployee(long id);

    Page<Employee> findPaginated(int pageNumber, int pageSize);
}
