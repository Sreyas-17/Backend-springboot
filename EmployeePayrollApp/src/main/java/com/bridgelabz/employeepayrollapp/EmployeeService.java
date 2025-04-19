package com.bridgelabz.employeepayrollapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }


    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
       employeeRepository.deleteById(id);
   }

    public List<Employee> findUsersByUsername(String name) {
        return employeeRepository.findByUsername(name);
    }

    public List<Employee> getUserByUserNameAndEmail(String name,String email) {
        return employeeRepository.findByUserNameAndEmail( name,email);
    }
}
