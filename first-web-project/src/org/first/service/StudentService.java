package org.first.service;

import org.first.model.Student;
import org.first.repository.StudentRepo;

import java.util.List;

public class StudentService {
    public void create(String name , String email)throws Exception{
        StudentRepo.Create(name, email);
    }
    public List<Student> findAll() throws Exception{
      return   StudentRepo.findAll();
    }
}
