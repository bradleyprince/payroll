/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.services;

import com.bradley.payroll.domain.IdentityDocument;
import java.util.List;

/**
 *
 * @author Balla
 */
public interface EmployeeIdentityService {
    public List<IdentityDocument> getIdentityDocument(Integer employeeNumber); 
}
