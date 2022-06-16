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

import za.co.dao.ApplicantDAO;
import za.co.bean.Applicant;

/**
 *
 * @author HP
 */
public class ApplicantDaoImpl implements ApplicantDAO {
    private Connection con=null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ApplicantDaoImpl(Connection con) {
        this.con = con;
    }

    @Override
    public boolean addApplicant(Applicant applicant) {
        boolean ans = false;
        if(con!=null){
            try {
                ps = con.prepareStatement("INSERT INTO applicant(applicantId, firstName, lastName, address, qualification,email, experience, cellNumber) values(null,?,?,?,?,?,?,?)");
                ps.setString(1, applicant.getFirstName());
                ps.setString(2, applicant.getLastName());
                ps.setString(3,applicant.getAddress());
                ps.setString(4, applicant.getQualification());
                ps.setString(5, applicant.getEmail());
                ps.setString(6, applicant.getExperience());
                ps.setString(7, applicant.getCellNumber());
                
                if(ps.executeUpdate()>0){
                    ans=true;
                }
            } catch (SQLException ex) {
                System.out.println("Failed to add applicant: "+ex.getMessage());
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
    public boolean updateApplicant(int applicantId, String qualification, String experience) {
        boolean ans = false;
        if(con!=null){
            try {
                ps = con.prepareStatement("UPDATE applicant SET qualification=? AND experience=? WHERE applicantId=?");
                ps.setInt(1, applicantId);
                ps.setString(2, qualification);
                ps.setString(3, experience);
                
                if(ps.executeUpdate()>0){
                    ans = true;
                }
            } catch (SQLException ex) {
                System.out.println("Failed to update information: "+ex.getMessage());
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
    public boolean deleteApplicant(int applicantId) {
        boolean ans = false;
        if(con!=null){
            try {
                ps = con.prepareStatement("DELETE FROM applicant WHERE applicantId=?");
                ps.setInt(1, applicantId);
                if(ps.executeUpdate()>0){
                    ans=true;
                }
            } catch (SQLException ex) {
                System.out.println("Failed to delete applicant: "+ex.getMessage());
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
    public List<Applicant> readApplicant() {
        List<Applicant> applicant = new ArrayList<>();
        
        try {
            ps = con.prepareStatement("SELECT * FROM applicant");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                applicant.add(new Applicant(rs.getInt("applicantId"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("address"), rs.getString("qualification"), rs.getString("email"), rs.getString("experience"), rs.getString("cellNumber")));
            }
        } catch (SQLException ex) {
            System.out.println("Failed to get applicants: "+ex.getMessage());
        }
        return applicant;
    }
    
}
