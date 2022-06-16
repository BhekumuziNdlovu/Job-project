/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.za.proccesses;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import za.co.bean.Applicant;
import za.co.dbManager.DBManager;
import za.co.services.ApplicantService;
import za.co.services.impl.ApplicantServiceImpl;

@Path("/signup")
public class ApplicantProcess {
    private ApplicantService applicantservice;
    private DBManager dbman;
    private Applicant applicant;
    
    @POST
    @Path("/register/{firstName:[a-zA-Z]+}/{lastName:[a-zA-Z]+}/{address}/{qualification:[a-zA-Z]+}/0{email}/{experience:[a-zA-Z]+}/{cellNumber}")
    public void register(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName, @PathParam("address") String address, @PathParam("qualification") String qualification, @PathParam("email") String email, @PathParam("experience") String experience, @PathParam("cellNumber") String cellNumber){
        applicantservice = new ApplicantServiceImpl(dbman);
        
        applicant = new Applicant(0,firstName,lastName,address,qualification,email,experience,cellNumber);
        
        applicantservice.addApplicant(applicant);
    }
    
    @PUT
    @Path("/update/{applicantId:[0-9]+}/{qualification:[a-zA-Z]+}/{experience: :[a-zA-Z]+}")
    public void updateApplicant(@PathParam("applicantId") int applicantId, @PathParam("qualification") String qualification, @PathParam("experience") String experience){
        applicantservice = new ApplicantServiceImpl(dbman);
        
        applicantservice.updateApplicant(applicantId, qualification, experience);
    }
    
    @GET
    @Path("/applicants")
    public void getApplicants(){
        applicantservice = new ApplicantServiceImpl(dbman);
        
        applicantservice.readApplicant();
    }
    
    @DELETE
    @Path("/delete/{applicantId: [0-9]+}")
    public void deleteApplicant(@PathParam("applicantId") int applicantId){
        applicantservice = new ApplicantServiceImpl(dbman);
        
        applicantservice.deleteApplicant(applicantId);
    }
}
