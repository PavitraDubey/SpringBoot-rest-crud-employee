package com.springbootdemo.cruddemo.dao;

import com.springbootdemo.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //entity type, primary key
    //that's it ... no need to write any code :) beauty of spring data jpa
}
