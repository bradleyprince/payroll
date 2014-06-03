/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.test.services;

import com.bradley.payroll.app.conf.ConnectionConfig;
import com.bradley.payroll.domain.IdentityDocument;
import com.bradley.payroll.repository.EmployeeRepository;
import com.bradley.payroll.services.EmployeeIdentityService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Balla
 */
public class EmployeeIdenetityServiceTest {
    
    private static ApplicationContext ctx;
    private EmployeeRepository employeeRepository;
    private EmployeeIdentityService employeeIdentityService;
    
    public EmployeeIdenetityServiceTest() {
    }
    
    @Test
    public void getIdentityDocuments() {
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        employeeIdentityService = ctx.getBean(EmployeeIdentityService.class);
        
        List<IdentityDocument> identityDocumentsList = new LinkedList<>(employeeIdentityService.getIdentityDocument(211093637));
        
        for(IdentityDocument identityDocument : identityDocumentsList){
            System.out.println(identityDocument.toString());
        }
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}