/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.factory;

import com.bradley.payroll.domain.Benefits;

/**
 *
 * @author Balla
 */
public class BenefitsFactory {
    private static Benefits benefits;

    private BenefitsFactory() {
    }
    
    public static Benefits getBenefit(){
        if(benefits == null){
            benefits = new Benefits();
        }
        
        return benefits;
    }
}
