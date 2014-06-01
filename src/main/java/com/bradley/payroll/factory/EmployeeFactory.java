/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.factory;

import com.bradley.payroll.domain.Employee;

/**
 *
 * @author Balla
 */
public class EmployeeFactory {
    
    private EmployeeFactory(){ 
    }
    
    private static Employee employee;
    
    public static Employee getEmployee(){
        if(employee == null){
            employee = new Employee();
        }
        
        return employee;
    }
}
