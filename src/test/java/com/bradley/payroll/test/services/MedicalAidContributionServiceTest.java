/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.test.services;

import com.bradley.payroll.app.conf.ConnectionConfig;
import com.bradley.payroll.domain.MedicalAidContribution;
import com.bradley.payroll.repository.MedicalAidContributionRepository;
import com.bradley.payroll.services.MedicalAidContributionService;
import java.math.BigDecimal;
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
public class MedicalAidContributionServiceTest {
    
    private static ApplicationContext ctx;
    private MedicalAidContributionService medicalAidContributionService;
    private MedicalAidContributionRepository medicalAidContributionRepository;
    
    public MedicalAidContributionServiceTest() {
    }
    
    @Test
    public void getAmountContributed() {
        medicalAidContributionService = ctx.getBean(MedicalAidContributionService.class);
        medicalAidContributionRepository = ctx.getBean(MedicalAidContributionRepository.class);
        
        MedicalAidContribution contribution1 = new MedicalAidContribution();
        contribution1.setNumberOfPeople(0);
        contribution1.setAmount(new BigDecimal(700.00));
        medicalAidContributionRepository.save(contribution1);
        
        MedicalAidContribution contribution2 = new MedicalAidContribution();
        contribution2.setNumberOfPeople(1);
        contribution2.setAmount(new BigDecimal(1000.00));
        medicalAidContributionRepository.save(contribution2);
        
        MedicalAidContribution contribution3 = new MedicalAidContribution();
        contribution3.setNumberOfPeople(2);
        contribution3.setAmount(new BigDecimal(1400.00));
        medicalAidContributionRepository.save(contribution3);
        
        MedicalAidContribution contribution4 = new MedicalAidContribution();
        contribution4.setNumberOfPeople(3);
        contribution4.setAmount(new BigDecimal(1500.00));
        medicalAidContributionRepository.save(contribution4);
        
        MedicalAidContribution contribution5 = new MedicalAidContribution();
        contribution5.setNumberOfPeople(4);
        contribution5.setAmount(new BigDecimal(2000.00));
        medicalAidContributionRepository.save(contribution5);
        
        BigDecimal amountContributed = medicalAidContributionService.getMedicalAidContribution(3);
        System.out.println("Medical Aid Contribution Amount = R" + amountContributed);
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