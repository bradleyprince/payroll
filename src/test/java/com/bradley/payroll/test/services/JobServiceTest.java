/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.test.services;

import com.bradley.payroll.app.conf.ConnectionConfig;
import com.bradley.payroll.domain.Job;
import com.bradley.payroll.domain.Position;
import com.bradley.payroll.factory.JobFactory;
import com.bradley.payroll.repository.JobRepository;
import com.bradley.payroll.repository.PositionRepository;
import com.bradley.payroll.services.JobService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
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
public class JobServiceTest {
    
    private static ApplicationContext ctx;
    private JobService jobService;
    private JobRepository jobRepository;
    private PositionRepository positionRepository;
    
    public JobServiceTest() {
    }
    
    @Test
    public void getPositionStatus() {
        jobService = ctx.getBean(JobService.class);
        jobRepository = ctx.getBean(JobRepository.class);
        positionRepository = ctx.getBean(PositionRepository.class);
        
        List<Position> positionList = new LinkedList<>();
        Job job = JobFactory.getJob();
        job.setJobTitle("Software Development");
        Position position1 = new Position();
        position1.setStatus("Open");
        position1.setPositionCode("SD12345");
        
        Position position2 = new Position();
        position2.setStatus("Closed");
        position2.setPositionCode("SD36521");
        
        Position position3 = new Position();
        position3.setStatus("Open");
        position3.setPositionCode("SD00000");
        
        positionList.add(position1);
        positionList.add(position2);
        positionList.add(position3);
        
        for(Position position : positionList){
            positionRepository.save(position);
        }
        
        job.setPositionList(positionList);
        
        jobRepository.save(job);
        
        Integer numberOfClosedPositions = jobService.getClosedPositions(job.getJobTitle());
        Integer numberOfOpenPositions = jobService.getOpenPositions(job.getJobTitle());
        
        System.out.println("Number of Closed Positions = " + numberOfClosedPositions);
        System.out.println("Number of Open Positions = " + numberOfOpenPositions);
        Assert.assertNotNull(job);
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
        jobRepository.deleteAll();
        positionRepository.deleteAll();
    }
}