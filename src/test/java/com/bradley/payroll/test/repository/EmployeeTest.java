/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.test.repository;

import com.bradley.payroll.app.conf.ConnectionConfig;
import com.bradley.payroll.domain.Address;
import com.bradley.payroll.domain.Benefits;
import com.bradley.payroll.domain.Contact;
import com.bradley.payroll.domain.Demographics;
import com.bradley.payroll.domain.Employee;
import com.bradley.payroll.domain.IdentityDocument;
import com.bradley.payroll.domain.Names;
import com.bradley.payroll.domain.PaySlip;
import com.bradley.payroll.domain.Position;
import com.bradley.payroll.factory.EmployeeFactory;
import com.bradley.payroll.factory.IdentityFactory;
import com.bradley.payroll.factory.InformationFactory;
import com.bradley.payroll.repository.EmployeeRepository;
import com.bradley.payroll.repository.IdentityRepository;
import com.bradley.payroll.repository.PaySlipRepository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Balla
 */
public class EmployeeTest {
    
    private static ApplicationContext ctx;
    private Long id;
    private EmployeeRepository employeeRepo;
    private IdentityRepository idRepo;
    private PaySlipRepository paySlipRepo;
    
    public EmployeeTest() {
    }
    
    @Test
    public void createEmployee() {
        employeeRepo = ctx.getBean(EmployeeRepository.class);
        idRepo = ctx.getBean(IdentityRepository.class);
        paySlipRepo = ctx.getBean(PaySlipRepository.class);
        
        Employee employee = EmployeeFactory.getEmployee();
        employee.setNumberOfDependants(5);
        employee.setEmployeeNumber(211093637);
        
        Address address = InformationFactory.getAddress();
        address.setPhysicalAddress("53 Da Gama Street");
        address.setPostalAddress("53 Da Gama Street");
        address.setPostalCode(7100);
        
        Contact contact = InformationFactory.getContact();
        contact.setCellNumber("072 326 0148");
        contact.setHomeNumber("021 904 4454");
        
        Names employeeNames = InformationFactory.getNames();
        employeeNames.setFirstName("Bradley");
        employeeNames.setLastName("Prince");
        
        Demographics demographic = InformationFactory.getDemographics();
        demographic.setGender("Male");
        demographic.setRace("Other");
        
        List<IdentityDocument> identityList = new LinkedList<>();
        IdentityDocument identity = IdentityFactory.getIdDocument();
        
        identity.setIdType("Passport");
        identity.setIdValue("ZG1234");
        identityList.add(identity);
        
        List<PaySlip> payslipList = new LinkedList<>();
        PaySlip paySlip = new PaySlip();
        
        paySlip.setGrossPay(new BigDecimal(25000.00));
        paySlip.setTotalDeductions(new BigDecimal(3500.00));
        paySlip.setTotalTax(new BigDecimal(1500.00));
        paySlip.setNetPay(new BigDecimal(20000.00));
        paySlip.setPayDate(new Date());      
        payslipList.add(paySlip);
        
        Benefits benefit1 = new Benefits();
        benefit1.setBenefitType("Medical Aid");
        benefit1.setBenefitValue(new BigDecimal(999.99));
        
        Benefits benefit2 = new Benefits();
        benefit2.setBenefitType("Housing Subsurdy");
        benefit2.setBenefitValue(new BigDecimal(500.00));
        
        Position position = new Position();
        position.setPositionCode("SD1234");
        position.setStatus("Closed");
        
        employee.setAddress(address);
        employee.setContact(contact);
        employee.setDemographics(demographic);
        employee.setIdentityList(identityList);
        employee.setPaySlipList(payslipList);
        employee.setEmployeeNames(employeeNames);
        
        id = employee.getId();
        
        paySlipRepo.save(paySlip);
        idRepo.save(identity);
        employeeRepo.save(employee);
        
        Assert.assertNotNull(employee);
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
        employeeRepo.deleteAll();
        paySlipRepo.deleteAll();
        idRepo.deleteAll();
    }
}