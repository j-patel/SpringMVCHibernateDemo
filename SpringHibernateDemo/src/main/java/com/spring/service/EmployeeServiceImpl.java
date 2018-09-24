/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.service;

import com.spring.dao.EmployeeDAO;
import com.spring.model.Employee;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jay20
 */

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    
    @Transactional
    @Override
    public void addEmployee(Employee p) {
        this.employeeDAO.addEmployee(p);
    }

    @Transactional
    @Override
    public void updateEmployee(Employee p) {
        this.employeeDAO.updateEmployee(p);
    }

    @Transactional
    @Override
    public List<Employee> listEmployees() {
        return this.employeeDAO.listEmployees();
    }

    @Transactional
    @Override
    public Employee getEmployeeById(int id) {
        return this.employeeDAO.getEmployeeById(id);
    }

    @Transactional
    @Override
    public void removeEmployee(int id) {
        this.employeeDAO.removeEmployee(id);
    }
}
