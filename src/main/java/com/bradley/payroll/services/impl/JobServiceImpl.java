/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.services.impl;

import com.bradley.payroll.domain.Job;
import com.bradley.payroll.domain.Position;
import com.bradley.payroll.repository.JobRepository;
import com.bradley.payroll.repository.PositionRepository;
import com.bradley.payroll.services.JobService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Balla
 */
@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepository jobRepository;
    @Autowired 
    private PositionRepository positionRepository;
    
    @Override
    public Integer getClosedPositions(String jobTitle) {
        List<Job> jobList = jobRepository.findAll();
        List<Position> positionList = new LinkedList<>();
        Integer numberOfClosedPositions = 0; 
        
        for(Job job : jobList){
            if(job.getJobTitle().equals(jobTitle)){
                positionList = job.getPositionList();
            }
        }
        
        for(Position position : positionList){
            if(position.getStatus().equals("Closed")){
               numberOfClosedPositions++; 
            }
        }
        
        return numberOfClosedPositions;
    }

    @Override
    public Integer getOpenPositions(String jobTitle) {
        List<Job> jobList = jobRepository.findAll();
        List<Position> positionList = new LinkedList<>();
        Integer numberOfClosedPositions = 0; 
        
        for(Job job : jobList){
            if(job.getJobTitle().equals(jobTitle)){
                positionList = job.getPositionList();
            }
        }
        
        for(Position position : positionList){
            if(position.getStatus().equals("Open")){
               numberOfClosedPositions++; 
            }
        }
        
        return numberOfClosedPositions;
    }
    
}
