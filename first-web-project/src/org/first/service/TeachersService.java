package org.first.service;

import org.first.model.Teachers;
import org.first.repository.TeachersRepo;

import java.util.List;

public class TeachersService {
    public List<Teachers> findAll() throws Exception{
        return TeachersRepo.findAll();
    }
    public void create(String firstName, String middleName, String surName, String emailId, int age, String gender, String specialisation, String schoolName) throws Exception{
        TeachersRepo.create(firstName,  middleName,  surName,  emailId,  age,  gender,  specialisation,  schoolName);
    }
    public Teachers findById(int id) throws Exception{
     return TeachersRepo.findById(id);
    }
    public  void updateById(int id , String firstName,String middleName , String surName, String emailId, int age, String gender,String specialisation , String schoolName ) throws Exception{
        TeachersRepo.updateById(id , firstName , middleName , surName , emailId , age , gender , specialisation , schoolName);
    }
    public  void deleteById(int id) throws Exception{
        TeachersRepo.deleteById(id);
    }
}
