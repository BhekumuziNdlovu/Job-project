/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.services.impl;


import java.sql.Connection;
import java.util.List;
import za.co.bean.Applicant;
import za.co.dao.ApplicantDAO;
import za.co.dao.Impl.ApplicantDaoImpl;
import za.co.dbManager.DBManager;
import za.co.services.ApplicantService;


public class ApplicantServiceImpl implements ApplicantService {
    private ApplicantDAO applicantdao;
    
    public ApplicantServiceImpl(DBManager dbman) {
        applicantdao = new ApplicantDaoImpl(dbman.getConnection());
    }

    @Override
    public boolean addApplicant(Applicant applicant) {
        return applicantdao.addApplicant(applicant);
    }

    @Override
    public boolean updateApplicant(int applicantId, String qualification, String experience) {
        return applicantdao.updateApplicant(applicantId, qualification, experience);
    }

    @Override
    public boolean deleteApplicant(int applicantId) {
        return applicantdao.deleteApplicant(applicantId);
    }

    @Override
    public List<Applicant> readApplicant() {
        return applicantdao.readApplicant();
    }
    
}
