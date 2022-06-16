
package za.co.bean;

import java.util.Objects;


public class Applicant {
   private int applicantId;
   private String firstName;
   private String lastName;
   private String address;
   private String qualification;
   private String email;
   private String experience;
   private String cellNumber;

    public Applicant(int applicantId, String firstName, String lastName, String address, String qualification, String email, String experience, String cellNumber) {
        this.applicantId =applicantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.qualification = qualification;
        this.email = email;
        this.experience = experience;
        this.cellNumber = cellNumber;
    }

    public Applicant(String firstName, String lastName, String address, String qualification, String email, String experience, String cellNumber) {
        this(0,firstName, lastName,address,qualification,email,experience,cellNumber);
    }
    
    

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.firstName);
        hash = 59 * hash + Objects.hashCode(this.lastName);
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
        final Applicant other = (Applicant) obj;
        if (this.applicantId != other.applicantId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Applicant{" + "applicantId=" + applicantId + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", qualification=" + qualification + ", email=" + email + ", experience=" + experience + ", cellNumber=" + cellNumber + '}';
    }

    
   
   
}
