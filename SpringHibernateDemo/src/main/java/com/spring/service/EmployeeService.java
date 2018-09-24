/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.service;

import com.spring.model.Employee;
import java.util.List;

/**
 *
 * @author jay20
 */
public interface EmployeeService {
    public void addEmployee(Employee p);
    public void updateEmployee(Employee p);
    public List<Employee> listEmployees();
    public Employee getEmployeeById(int id);
    public void removeEmployee(int id);
}
