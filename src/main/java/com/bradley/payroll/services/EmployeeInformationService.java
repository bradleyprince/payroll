/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.services;

import com.bradley.payroll.domain.Address;
import com.bradley.payroll.domain.Contact;
import com.bradley.payroll.domain.Demographics;
import com.bradley.payroll.domain.Names;

/**
 *
 * @author Balla
 */
public interface EmployeeInformationService {
    public Names getEmployeeNames(Integer employeeNumber);
    
    public Demographics getEmployeeDemographics(Integer employeeNumber);
    
    public Contact getEmployeeContacts(Integer employeeNumber);
    
    public Address getEmployeeAddress(Integer employeeNumber);
}
