package org.first.model;

public class Teachers {
    //firstName , midddleName , surName ,  emailId , age , gender , specialisation , schoolName
    private int id;
    private String firstName;
    private String middleName;
    private String surName;
    private String emailId;
    private int age;
    private String gender;
    private String specialisation;
    private String schoolName;

    public Teachers() {
    }

    public Teachers(int id, String firstName, String middleName, String surName, String emailId, int age, String gender, String specialisation, String schoolName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.surName = surName;
        this.emailId = emailId;
        this.age = age;
        this.gender = gender;
        this.specialisation = specialisation;
        this.schoolName = schoolName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "Teachers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surName='" + surName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", specialisation='" + specialisation + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
