/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.factory;

import com.bradley.payroll.domain.PaySlip;

/**
 *
 * @author Balla
 */
public class PaySlipFactory {
    private static PaySlip paySlip;
    
    private PaySlipFactory(){
    }
    
    public static PaySlip getPaySlip(){
        if(paySlip == null){
            paySlip = new PaySlip();
        }
        
        return paySlip;
    }
}
