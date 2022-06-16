/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.services;

import java.util.List;
import za.co.bean.Applicant;

/**
 *
 * @author HP
 */
public interface ApplicantService {
    public boolean addApplicant(Applicant applicant);
    
    public boolean updateApplicant(int applicantId, String qualification, String experience);
    
    public boolean deleteApplicant(int applicantId);
    
    public List<Applicant> readApplicant();
}
