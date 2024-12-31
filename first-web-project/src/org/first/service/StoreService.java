package org.first.service;

import org.first.model.Store;
import org.first.repository.StoreRepo;
import org.first.repository.StudentRepo;

import java.util.List;

public class StoreService {
    public void create(String firstName, String lastName, String email, String address, String phnNo, String totalBill)throws Exception{
        StoreRepo.create(firstName,lastName,email,address,phnNo,totalBill);
    }
    public List<Store> findAll() throws Exception{
        return StoreRepo.findAll();
    }
    public Store findById(int id) throws Exception{
        return  StoreRepo.findById(id);
    }
    public  void updateById(int id) throws Exception{
        StoreRepo.updateById(id);
    }
}
