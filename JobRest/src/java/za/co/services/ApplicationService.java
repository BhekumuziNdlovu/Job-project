/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.services;

import java.util.List;
import za.co.bean.Application;

/**
 *
 * @author HP
 */
public interface ApplicationService {
    public boolean apply(Application application);
    
    public List<Application> getApplications();
    
    public boolean deleteApplication(Application application);
}
