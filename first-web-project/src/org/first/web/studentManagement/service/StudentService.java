package org.first.web.studentManagement.service;

import org.first.web.studentManagement.Model.Student;
import org.first.web.studentManagement.repository.StudentRepo;

import java.util.List;

public class StudentService {
    public void create(String  firstName, String middleName, String surName, String email, int age, String gender, int rollNo, int standard , String fatherName, String schoolName)throws Exception{
        StudentRepo.Create(firstName, middleName, surName, email, age, gender, rollNo, standard, fatherName, schoolName);
    }
    public List<Student> findAll() throws Exception{
        return StudentRepo.findAll();
    }
    public Student findById(int id) throws Exception{
        return StudentRepo.findById(id);
    }
}
