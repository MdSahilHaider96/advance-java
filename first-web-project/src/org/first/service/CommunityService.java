package org.first.service;

import org.first.model.Community;
import org.first.repository.CommunityRepo;

import java.util.List;

public class CommunityService {
    //    //id , firstName , lastName , address , gender , contactNo
    public void create(String firstName, String lastName, String address,  String gender, String contactNo)throws Exception{
        CommunityRepo.create(firstName, lastName , address , gender, contactNo);
    }
    public List<Community> findAll() throws Exception{
        return CommunityRepo.findAll();
    }
    public Community findById(int id) throws Exception{
        return  CommunityRepo.findById(id);
    }
    public void deleteById(int id) throws Exception{
        CommunityRepo.deleteById(id);
    }
    public void updateById(int id ,String firstName, String lastName, String address,  String gender, String contactNo) throws Exception{
        CommunityRepo.updateById(id , firstName , lastName ,address , gender ,contactNo);
    }
}
