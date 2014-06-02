/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.factory;

import com.bradley.payroll.domain.Salary;

/**
 *
 * @author Balla
 */
public class SalaryFactory {
    private static Salary salary;

    private SalaryFactory() {
    }
    
    public static Salary getSalary(){
        if(salary == null){
            salary = new Salary();
        }
        
        return salary;
    }
            
}
