/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.services.impl;

import com.bradley.payroll.domain.Employee;
import com.bradley.payroll.domain.IdentityDocument;
import com.bradley.payroll.repository.EmployeeRepository;
import com.bradley.payroll.repository.IdentityRepository;
import com.bradley.payroll.services.EmployeeIdentityService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Balla
 */

@Service
public class EmployeeIdentiityServiceImpl implements EmployeeIdentityService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private IdentityRepository idRepo;
    
    @Override
    public List<IdentityDocument> getIdentityDocument(Integer employeeNumber) {
        List<Employee> employeeList = employeeRepository.findAll();
        List<IdentityDocument> identityDocumentsList = new LinkedList<>();
        
        for(Employee employee : employeeList){
            if(employee.getEmployeeNumber().compareTo(employeeNumber) == 0){
                identityDocumentsList = employee.getIdentityList();
            }
        }
        
        return identityDocumentsList;
    }
    
}
