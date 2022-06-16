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
import za.co.dao.ApplicationDAO;
import za.co.bean.Application;

/**
 *
 * @author HP
 */
public class ApplicationDaoImpl implements ApplicationDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ApplicationDaoImpl(Connection con) {
        this.con = con;
    }

    @Override
    public boolean apply(Application application) {
        boolean ans = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("INSERT INTO jobapplicant(jobId,applicantId) values(?,?)");
                ps.setInt(1, application.getJobId());
                ps.setInt(2, application.getApplicantId());

                if (ps.executeUpdate() > 0) {
                    ans = true;
                }
            } catch (SQLException ex) {
                System.out.println("Failed to apply for a job: " + ex.getMessage());
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        System.out.println("Failed to close Prepared Statement: " + ex.getMessage());
                    }
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        System.out.println("Failed to close connection: " + ex.getMessage());
                    }
                }
            }
        }
        return ans;
    }

    @Override
    public boolean deleteApplication(Application application) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Application> getApplications() {
        List<Application> application = new ArrayList<>();
        
        try {
            ps = con.prepareStatement("SELECT * FROM jobapplicant");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                application.add(new Application(rs.getInt("jobId"), rs.getInt("applicantId")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return application;
    }

}
