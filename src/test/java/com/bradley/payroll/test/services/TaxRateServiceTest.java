/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.test.services;

import com.bradley.payroll.app.conf.ConnectionConfig;
import com.bradley.payroll.domain.Entries;
import com.bradley.payroll.repository.EntriesRepository;
import com.bradley.payroll.services.TaxRateService;
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
public class TaxRateServiceTest {
    
    private static ApplicationContext ctx;
    private TaxRateService taxRateService;
    private EntriesRepository entriesRepository;
    
    public TaxRateServiceTest() {
    }
    
    @Test
    public void getTaxRate() {
        taxRateService = ctx.getBean(TaxRateService.class);
        entriesRepository = ctx.getBean(EntriesRepository.class);
        
        Entries entries1 = new Entries();
        entries1.setLowerBand(new BigDecimal(6000.00));
        entries1.setUpperband(new BigDecimal(10000.00));
        entries1.setTaxPercentRate(10);
        entriesRepository.save(entries1);
        
        Entries entries2 = new Entries();
        entries2.setLowerBand(new BigDecimal(10000.00));
        entries2.setUpperband(new BigDecimal(20000.00));
        entries2.setTaxPercentRate(20);
        entriesRepository.save(entries2);
        
        Entries entries3 = new Entries();
        entries3.setLowerBand(new BigDecimal(20000.00));
        entries3.setUpperband(new BigDecimal(30000.00));
        entries3.setTaxPercentRate(30);
        entriesRepository.save(entries3);
        
        Entries entries4 = new Entries();
        entries4.setLowerBand(new BigDecimal(30000.00));
        entries4.setUpperband(new BigDecimal(40000.00));
        entries4.setTaxPercentRate(40);
        entriesRepository.save(entries4);
        
        Entries entries5 = new Entries();
        entries5.setLowerBand(new BigDecimal(40000.00));
        entries5.setUpperband(new BigDecimal(50000.00));
        entries5.setTaxPercentRate(50);
        entriesRepository.save(entries5);
        
        BigDecimal grossPay = new BigDecimal(40000.00);
        
        Integer taxRate = taxRateService.getTaxRate(grossPay);
        System.out.println("Tax for Gross Pay R" + grossPay + " = " + taxRate + "%");
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