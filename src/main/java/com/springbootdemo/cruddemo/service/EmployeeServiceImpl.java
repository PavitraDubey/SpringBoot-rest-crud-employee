package com.springbootdemo.cruddemo.service;

import com.springbootdemo.cruddemo.dao.EmployeeRepository;
import com.springbootdemo.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    //inject employee dao (use constructor injection)
    //we can remove @Transactional as jpa repository provides it automatically
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository=theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //no transactional here as we are only reading and not making any changes to the database
    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        //optional is different pattern introduced in java 8
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee=result.get();
        }
        else{
            //we didn't find the employee
            throw new RuntimeException("Did not find employee id - "+theId);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
