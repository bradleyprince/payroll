/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.test.services;

import com.bradley.payroll.app.conf.ConnectionConfig;
import com.bradley.payroll.domain.Address;
import com.bradley.payroll.domain.Contact;
import com.bradley.payroll.domain.Demographics;
import com.bradley.payroll.domain.Names;
import com.bradley.payroll.repository.EmployeeRepository;
import com.bradley.payroll.services.EmployeeInformationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class EmployeeInformationServiceTest {
    
    private static ApplicationContext ctx;
    private EmployeeInformationService employeeInformationService;
    private EmployeeRepository employeeRepository;
    
    public EmployeeInformationServiceTest() {  
    }
    
    @Test
    public void getEmployeeNames() {
        employeeInformationService = ctx.getBean(EmployeeInformationService.class);
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        
        Names employeeNames = employeeInformationService.getEmployeeNames(211093637);
        System.out.println(employeeNames);
        
    }
    
    @Test
    public void getEmployeeDemographics(){
        employeeInformationService = ctx.getBean(EmployeeInformationService.class);
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        
        Demographics demographics = employeeInformationService.getEmployeeDemographics(211093637);
        System.out.println(demographics);
    }
    
    @Test
    public void getEmployeeContacts(){
        employeeInformationService = ctx.getBean(EmployeeInformationService.class);
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        
        Contact contact = employeeInformationService.getEmployeeContacts(211093637);
        System.out.println(contact);
    }
    
    @Test
    public void getEmployeeAddress(){
        employeeInformationService = ctx.getBean(EmployeeInformationService.class);
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        
        Address address = employeeInformationService.getEmployeeAddress(211093637);
        System.out.println(address);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}