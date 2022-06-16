package co.za.proccesses;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import za.co.bean.Application;
import za.co.dbManager.DBManager;
import za.co.services.ApplicationService;
import za.co.services.impl.ApplicationServiceImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

@Path("/application")
public class ApplicationProcess {
  private ApplicationService applicationservice;
  private Application application;
  private DBManager dbman;
  
  @POST
  @Path("/apply/{jobId:[0-9]+}/{applicantId: [0-9]+}")
  public void apply(@PathParam("jobId") int jobId, @PathParam("applicantId") int applicantId){
      applicationservice = new ApplicationServiceImpl(dbman);
      
      applicationservice.apply(application);
  }
  
  @GET
  @Path("/applications")
  public void getApplications(){
      applicationservice = new ApplicationServiceImpl(dbman);
      
      applicationservice.getApplications();
  }
}
