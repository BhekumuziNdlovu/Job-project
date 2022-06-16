/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bean;

/**
 *
 * @author HP
 */
public class Application {
  private int jobId;
  private int applicantId;

    public Application(int jobId, int applicantId) {
        this.jobId = jobId;
        this.applicantId = applicantId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.applicantId;
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
        final Application other = (Application) obj;
        if (this.jobId != other.jobId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Application{" + "jobId=" + jobId + ", applicantId=" + applicantId + '}';
    }
  
  
}
