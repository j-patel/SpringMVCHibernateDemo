/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dao;

import com.spring.model.Employee;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jay20
 */
public class EmployeeDAOImpl implements EmployeeDAO{
    private static final Logger log = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

    @Transactional
    @Override
    public void addEmployee(Employee e) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(e);
        log.info("Employee saved successfully, Employee Details = " + e);
    }

    @Transactional
    @Override
    public void updateEmployee(Employee e) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(e);
        log.info("Employee updated successfully, Employee Details = " + e);
    }

    @Transactional
    @Override
    public List<Employee> listEmployees() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeesList = session.createQuery("from Employee").list();
        for(Employee e : employeesList){
                log.info("Employee List::" + e);
        }
        return employeesList;
    }

    @Transactional
    @Override
    public Employee getEmployeeById(int id) {
        Session session = this.sessionFactory.getCurrentSession();		
        Employee e = (Employee) session.load(Employee.class, id);
        log.info("Employee loaded successfully! Employee details = " + e);
        return e;
    }

    @Transactional
    @Override
    public void removeEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee e = (Employee) session.load(Employee.class, id);
        if(null != e){
                session.delete(e);
        }
        log.info("Employee deleted successfully! Employee details = " + e);
    }
}
