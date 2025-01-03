package org.first.service;

import org.first.model.Employees;
import org.first.repository.EmployeesRepo;

import java.util.List;

public class EmployeesService {
    public void create(String firstName, String lastName, String userName,  String password, String address, String contactNo)throws Exception{
        EmployeesRepo.create(firstName,lastName,userName, password , address, contactNo);
    }
    public List<Employees> findAll() throws Exception{
        return EmployeesRepo.findAll();
    }
    public Employees findById(int id) throws Exception{
        return  EmployeesRepo.findById(id);
    }
    public void deleteById(int id) throws Exception{
        EmployeesRepo.deleteById(id);
    }
    public void updateById(int id , String firstName, String lastName, String userName,  String password, String address, String contactNo) throws Exception{
        EmployeesRepo.updateById(id , firstName , lastName ,userName , password , address ,contactNo);
    }
}
