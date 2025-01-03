package org.first.repository;

import org.first.model.Community;
import org.first.sql.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommunityRepo {
    //id , firstName , lastName , address , gender , contactNo
    private static Connection connection;
    public static void create(String firstName , String lastName , String address , String gender , String contactNo)throws  Exception{
        PreparedStatement preparedStatement =  null;
        connection = ConnectionUtil.openConnection();
        try{
            String query =  "INSERT into community(firstName , lastName , address , gender , contactNo ) VALUES (? , ? , ? , ? , ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,address);
            preparedStatement.setString(4,gender);
            preparedStatement.setString(5,contactNo);
            int executeUpdate = preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        ConnectionUtil.closeConnection();
    }
    public static List<Community> findAll() throws Exception{

        //id , firstName , lastName , address , gender , contactNo

        connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Community> communityList = new ArrayList<>();
        try {
            String query ="SELECT * FROM community";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String address = resultSet.getString(4);
                String gender = resultSet.getString(5);
                String contactNo = resultSet.getString(6);
                Community community = new Community(id, firstName , lastName , address , gender , contactNo);
                communityList.add(community);
            }
        }

        finally {
            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            try {
                if (resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ConnectionUtil.closeConnection();
        }
        return communityList;
    }

    public static  Community findById(int id) throws Exception{
        connection = ConnectionUtil.openConnection();
        //        //id , firstName , lastName , address , gender , contactNo
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =  null;
        Community  community = null;
        try{
            String query = "SELECT * FROM community WHERE id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String address = resultSet.getString(4);
                String gender = resultSet.getString(5);
                String contactNo = resultSet.getString(6);
                community = new Community(id, firstName , lastName , address , gender , contactNo );
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            try {
                if (resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ConnectionUtil.closeConnection();
        }
        return community;
    }
    //id , firstName , lastName , address , gender , contactNo
    public static void updateById(int id , String firstName , String lastName , String address , String gender , String contactNo) throws Exception {
        connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement=null;

        try {
            String query="UPDATE community SET firstName = ? , lastName = ? ,address = ? , gender = ? , contactNo = ? WHERE id=? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,address);
            preparedStatement.setString(4,gender);
            preparedStatement.setString(5,contactNo);
            preparedStatement.setInt(6,id);
            int executeUpdate = preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (preparedStatement !=null){
                    preparedStatement.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        ConnectionUtil.closeConnection();
    }

    public static void deleteById(int id)throws Exception{
        connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement=null;
        try{
            String query ="DELETE FROM community WHERE id=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            int Delete = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        ConnectionUtil.closeConnection();
    }
}
