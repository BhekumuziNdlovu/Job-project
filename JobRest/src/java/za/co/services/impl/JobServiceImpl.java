/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.services.impl;

import java.util.List;
import za.co.bean.Job;
import za.co.dao.Impl.JobDaoImpl;
import za.co.dao.JobDAO;
import za.co.dbManager.DBManager;
import za.co.services.JobService;

/**
 *
 * @author HP
 */
public class JobServiceImpl implements JobService {

    private JobDAO jobdao;

    public JobServiceImpl(DBManager dbman) {
        jobdao = new JobDaoImpl(dbman.getConnection());
    }

    @Override
    public boolean addJob(Job job) {
        return jobdao.addJob(job);
    }

    @Override
    public boolean updateJob(int jobId, String jobDescription) {
        return jobdao.updateJob(jobId, jobDescription);
    }

    @Override
    public boolean deleteJob(int jobId) {
        return jobdao.deleteJob(jobId);
    }

    @Override
    public List<Job> readJob() {
        return jobdao.readJob();
    }

}
