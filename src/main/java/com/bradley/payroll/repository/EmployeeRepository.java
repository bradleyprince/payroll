package com.bradley.payroll.repository;

import com.bradley.payroll.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bradley
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
