package org.first.service;

import org.first.model.Company;
import org.first.repository.CompanyRepo;

import java.util.List;

public class CompanyService {
    //        //id , name , location , totalEmployees , email ,  contactNo
    public void create(String name, String location, String totalEmployees,  String email, String contactNo)throws Exception{
        CompanyRepo.create(name, location , totalEmployees , email, contactNo);
    }
    public List<Company> findAll() throws Exception{
        return CompanyRepo.findAll();
    }
    public Company findById(int id) throws Exception{
        return  CompanyRepo.findById(id);
    }
    public void deleteById(int id) throws Exception{
        CompanyRepo.deleteById(id);
    }
    public void updateById(int id , String name, String location, String totalEmployees,  String email, String contactNo) throws Exception{
        CompanyRepo.updateById(id , name , location ,totalEmployees , email ,contactNo);
    }
}
