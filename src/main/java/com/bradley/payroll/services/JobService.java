/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.services;

/**
 *
 * @author Balla
 */
public interface JobService {
    public Integer getClosedPositions(String jobTitle);
    
    public Integer getOpenPositions(String jobTitle);
}
