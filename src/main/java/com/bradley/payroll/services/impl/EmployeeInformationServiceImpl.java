/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.services.impl;

import com.bradley.payroll.domain.Address;
import com.bradley.payroll.domain.Contact;
import com.bradley.payroll.domain.Demographics;
import com.bradley.payroll.domain.Employee;
import com.bradley.payroll.domain.Names;
import com.bradley.payroll.repository.EmployeeRepository;
import com.bradley.payroll.services.EmployeeInformationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Balla
 */
@Service
public class EmployeeInformationServiceImpl implements EmployeeInformationService{
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public Names getEmployeeNames(Integer employeeNumber) {
        Names employeeNames = null;
        List<Employee> employeeList = employeeRepository.findAll();
        
        for(Employee employee : employeeList){           
            if(employee.getEmployeeNumber().compareTo(employeeNumber) == 0){
                employeeNames = employee.getEmployeeNames();
                break;
            }
        }
        
        return employeeNames;
    }

    @Override
    public Demographics getEmployeeDemographics(Integer employeeNumber) {
        Demographics demographics = null;
        List<Employee> employeeList = employeeRepository.findAll();
        
        for(Employee employee : employeeList){           
            if(employee.getEmployeeNumber().compareTo(employeeNumber) == 0){
                demographics = employee.getDemographics();
                break;
            }
        }
        
        return demographics;
    }

    @Override
    public Contact getEmployeeContacts(Integer employeeNumber) {
        Contact contact = null;
        List<Employee> employeeList = employeeRepository.findAll();
        
        for(Employee employee : employeeList){           
            if(employee.getEmployeeNumber().compareTo(employeeNumber) == 0){
                contact = employee.getContact();
                break;
            }
        }
        
        return contact;
    }

    @Override
    public Address getEmployeeAddress(Integer employeeNumber) {
        Address address = null;
        List<Employee> employeeList = employeeRepository.findAll();
        
        for(Employee employee : employeeList){           
            if(employee.getEmployeeNumber().compareTo(employeeNumber) == 0){
                address = employee.getAddress();
                break;
            }
        }
        
        return address;
    }
    
}
