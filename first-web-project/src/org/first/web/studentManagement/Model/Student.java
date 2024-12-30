package org.first.web.studentManagement.Model;

public class Student {
    private int id;
    private String firstName;
    private String middleName;
    private String surName;
    private String email;
    private int age;
    private String gender;
    private int rollNo;
    private int standard;
    private String fatherName;
    private String schoolName;


    public Student() {
    }

    public Student(int id, String firstName, String middleName, String surName,
                   String email, int age, String gender, int rollNo, int standard, String fatherName, String schoolName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.surName = surName;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.rollNo = rollNo;
        this.standard = standard;
        this.fatherName = fatherName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", rollNo=" + rollNo +
                ", standard=" + standard +
                ", fatherName='" + fatherName + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
