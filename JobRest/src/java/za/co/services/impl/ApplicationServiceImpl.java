/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.services.impl;

import java.util.List;
import za.co.bean.Application;
import za.co.dao.ApplicationDAO;
import za.co.dao.Impl.ApplicationDaoImpl;
import za.co.dbManager.DBManager;
import za.co.services.ApplicationService;

/**
 *
 * @author HP
 */
public class ApplicationServiceImpl implements  ApplicationService{
    private ApplicationDAO applicationdao;
    
    public ApplicationServiceImpl(DBManager dbman) {
        applicationdao = new ApplicationDaoImpl(dbman.getConnection());
    }

    @Override
    public boolean apply(Application application) {
        return applicationdao.apply(application);
    }

    @Override
    public boolean deleteApplication(Application application) {
        return applicationdao.deleteApplication(application);
    }

    @Override
    public List<Application> getApplications() {
        return applicationdao.getApplications();
    }
    
}
