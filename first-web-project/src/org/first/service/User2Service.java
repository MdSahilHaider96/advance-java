package org.first.service;

import org.first.model.User2;
import org.first.repository.User2Repo;

import java.sql.Date;
import java.util.List;

public class User2Service {
    public List<User2> findAll() throws Exception{
        return User2Repo.findAll();
    }
    public void create(String name ,String email, java.sql.Date dob)throws Exception{
        User2Repo.create(name,email, dob);
    }
    public void deleteById(int id) throws Exception{
        User2Repo.DeleteById(id);
    }
    public void updateById(int id ,String name , String email, java.sql.Date dob)throws Exception{
        User2Repo.UpdateById(id , name , email , dob);
    }
    public User2 findById(int id) throws Exception{
        return User2Repo.findById(id);
    }
}
