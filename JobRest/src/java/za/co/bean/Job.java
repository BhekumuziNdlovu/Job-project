/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bean;

import java.util.Objects;

/**
 *
 * @author HP
 */
public class Job {
    private int jobId;
    private String jobDescription;
    private int salary;
    private String experience;
    private String qualification;
    private String address;
    

    public Job(int jobId, String jobDescription, int salary, String experience, String qualification, String address) {
        this.jobId = jobId;
        this.jobDescription = jobDescription;
        this.salary = salary;
        this.experience = experience;
        this.qualification = qualification;
        this.address = address;
    }

    public Job(String jobDescription, int salary, String experience, String qualification, String address) {
        this(0,jobDescription,salary,experience,qualification,address);
    }
    
    

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.jobDescription);
        hash = 29 * hash + this.salary;
        hash = 29 * hash + Objects.hashCode(this.qualification);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Job other = (Job) obj;
        if (this.jobId != other.jobId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Job{" + "jobId=" + jobId + ", jobDescription=" + jobDescription + ", salary=" + salary + ", experience=" + experience + ", qualification=" + qualification + ", address=" + address + '}';
    }

    
    
    
}
