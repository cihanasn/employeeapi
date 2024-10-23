package com.example.employeeapi.service;

import com.example.employeeapi.model.Employee;
import com.example.employeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Tüm çalışanları getir
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // ID'ye göre bir çalışan getir
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Yeni bir çalışan kaydet
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Mevcut bir çalışanı güncelle
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setName(updatedEmployee.getName());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setSalary(updatedEmployee.getSalary());
            return employeeRepository.save(employee);
        } else {
            return null;
        }
    }

    // ID'ye göre bir çalışanı sil
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

