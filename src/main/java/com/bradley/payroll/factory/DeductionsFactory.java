/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.factory;

import com.bradley.payroll.domain.Deductions;
import com.bradley.payroll.domain.Entries;

/**
 *
 * @author Balla
 */
public class DeductionsFactory {
    private static Deductions deductions;

    private DeductionsFactory() {
    }
    
    public Deductions getDeductions(){
        if(deductions == null){
            deductions = new Deductions();
        }
        
        return deductions;
    }
}
