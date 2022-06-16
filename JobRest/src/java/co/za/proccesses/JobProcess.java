package co.za.proccesses;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import za.co.bean.Job;
import za.co.dao.Impl.JobDaoImpl;
import za.co.dao.JobDAO;
import za.co.dbManager.DBManager;
import za.co.services.JobService;
import za.co.services.impl.JobServiceImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

@Path("/job")
public class JobProcess {
    private JobService jobservice;
    private Job job;
    private DBManager dbman;
    
    @POST
    @Path("/createListing/jobDescription:[a-zA-Z]+}/{salary:[0-9]+}/{experience:[a-zA-Z]+}/{qualification:[a-zA-Z]+}/{address}")
    public void createListing(@PathParam("jobDescription") String jobDescription, @PathParam("salary") int salary, @PathParam("experience") String experience, @PathParam("qualification") String qualification, @PathParam("address") String address){
        jobservice = new JobServiceImpl(dbman);
        job = new Job(0,jobDescription,salary,experience,qualification,address);
        
        jobservice.addJob(job);
    }
    
    @PUT
    @Path("/updateJob/{jobId:[0-9]+}/{jobDescription:[a-zA-Z]+}")
    public void updateJob(@PathParam("jobId") int jobId, @PathParam("jobDescription") String jobDescription){
        jobservice = new JobServiceImpl(dbman);
        jobservice.updateJob(jobId, jobDescription);
    }
    
    @GET
    @Path("/jobs")
    public void getJobs(){
        jobservice = new JobServiceImpl(dbman);
        jobservice.readJob();
    }
    
    @DELETE
    @Path("/delete/{jobId:[0-9]+}")
    public void deleteListing(@PathParam("jobId") int jobId){
        jobservice = new JobServiceImpl(dbman);
        
        jobservice.deleteJob(jobId);
    }
}
