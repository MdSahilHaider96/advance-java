package org.first.service;

import org.first.model.City;
import org.first.model.Store;
import org.first.repository.CityRepo;
import org.first.repository.StoreRepo;

import java.util.List;

public class CityService {
    public void create(String name , String state , int pinCode)throws Exception{
        CityRepo.create(name , state , pinCode);
    }
    public List<City> findAll() throws Exception{
        return CityRepo.findAll();
    }
    public City findById(int id) throws Exception{
        return  CityRepo.findById(id);
    }
    public void deleteById(int id) throws Exception{
        CityRepo.deleteById(id);
    }
    public void updateById(int id ,String name , String state , int pinCode) throws Exception{
        CityRepo.updateById(id , name , state , pinCode);
    }
}
