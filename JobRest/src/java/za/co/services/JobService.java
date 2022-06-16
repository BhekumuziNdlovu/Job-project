/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.services;

import java.util.List;
import za.co.bean.Job;

/**
 *
 * @author HP
 */
public interface JobService {
     public boolean addJob(Job job);
    
    public boolean updateJob(int jobId, String jobDescription);
    
    public boolean deleteJob(int jobId);
    
    public List<Job> readJob();
}
