package org.first.service;

import org.first.model.Car;
import org.first.repository.CarRepo;

import java.util.List;

public class CarService {
    //( carId, model, company, engine, color, type )
    public void create(String model , String company , String engine , String color, String type) throws Exception{
        CarRepo.create(model,company,engine,color,type);
    }
    public void updateById(int carId , String model , String company , String engine , String color, String type)throws Exception{
        CarRepo.updateById(carId , model , company , engine , color , type);
    }
    public void deleteById(int carId)throws Exception{
        CarRepo.deleteById(carId);
    }
    public List<Car> findAll() throws Exception{
        return CarRepo.findAll();
    }
    public Car findById(int id) throws Exception{
        return CarRepo.findByCarId(id);
    }
}
