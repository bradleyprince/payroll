/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.factory;

import com.bradley.payroll.domain.Job;

/**
 *
 * @author Balla
 */
public class JobFactory {
    private static Job job;

    private JobFactory() {
    }
    
    public static Job getJob(){
        if(job == null){
            job = new Job();
        }
        
        return job;
    }
}
