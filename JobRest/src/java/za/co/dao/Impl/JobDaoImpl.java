/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.dao.JobDAO;
import za.co.bean.Job;

/**
 *
 * @author HP
 */
public class JobDaoImpl implements JobDAO {
    private Connection con=null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public JobDaoImpl(Connection con) {
        this.con = con;
    }
    @Override
    public boolean addJob(Job job) {
        boolean ans = false;
        if(con!=null){
            try {
                ps = con.prepareStatement("INSERT INTO jobjobId,jobDescription,salary,experience,qualifications,address) values(null.?,?,?,?,?)");
                ps.setString(1, job.getJobDescription());
                ps.setInt(2, job.getSalary());
                ps.setString(3, job.getExperience());
                ps.setString(4, job.getQualification());
                ps.setString(5, job.getAddress());
               
                if(ps.executeUpdate()>1){
                    ans=true;
                }
            } catch (SQLException ex) {
                System.out.println("Error adding job: "+ex.getMessage());
            }finally{
                if(ps!=null){
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        System.out.println("Failed to close Prepared Statement: "+ex.getMessage());
                    }
                }
                if(con!=null){
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        System.out.println("Failed to close connection: "+ex.getMessage());
                    }
                }
            }
        }
        return ans;
    }

    @Override
    public boolean updateJob(int jobId, String jobDescription) {
        boolean ans = false;
        if(con!=null){
            try {
                ps = con.prepareStatement("UPDATE job SET jobDescription=? WHERE jobId=?");
                ps.setInt(1,jobId);
                ps.setString(2, jobDescription);
                if(ps.executeUpdate()>0){
                    ans = true;
                }
            } catch (SQLException ex) {
                System.out.println("Failed to update job description: "+ex.getMessage());
            }finally{
                if(ps!=null){
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        System.out.println("Failed to close Prepared Statement: "+ex.getMessage());
                    }
                }
                if(con!=null){
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        System.out.println("Failed to close connection: "+ex.getMessage());
                    }
                }
            }
        }
        return ans;
    }

    @Override
    public boolean deleteJob(int jobId) {
        boolean ans = false;
        
        if(con!=null){
            try {
                ps=con.prepareStatement("DELETE*FROM jobs WHERE jobId =?");
                ps.setInt(1, jobId);
                if(ps.executeUpdate()>1){
                    ans=true;
                }
            } catch (SQLException ex) {
                System.out.println("Failed to delete listing: "+ex.getMessage());
            }
        }
        return ans;
    }

    @Override
    public List<Job> readJob() {
        List<Job> jobs = new ArrayList<>();
        
        try {
            ps = con.prepareStatement("SELECT * FROM jobs");
            rs = ps.executeQuery();
            
            while(rs.next()){
                jobs.add(new Job(rs.getInt("jobId"), rs.getString("jobDescription"), rs.getInt("salary"), rs.getString("experience"), rs.getString("qualifications"), rs.getString("address")));
            }
        } catch (SQLException ex) {
            System.out.println("Failed to read jobs: "+ex.getMessage());
        }
        return jobs;
    }
    
}
