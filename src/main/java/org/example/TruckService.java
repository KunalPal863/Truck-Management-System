package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TruckService {

    // INSERT OPERATION PERFORM
    public void addTruck(Truck truck)
    {
        String insert = "insert into trucks (tname,dname,model,capacity) values (?,?,?,?)";
        try {

            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setString(1,truck.getTname());
            preparedStatement.setString(2,truck.getDname());
            preparedStatement.setString(3,truck.getModel());
            preparedStatement.setString(4,truck.getCapacity());

            int update = preparedStatement.executeUpdate();
            System.out.println("Row Inserted :- "+update);
            connection.close();
        }
        catch (SQLException e) {
           e.printStackTrace();
        }
    }

    //SELECT operation for getting truck by ID
    public Truck getTruckById(int id)
    {
        Truck truck = new Truck();
        String sql = "select * from trucks where id = ?";
        try
        {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                truck.setId(resultSet.getInt("id"));
                truck.setTname(resultSet.getString("tname"));
                truck.setDname(resultSet.getString("dname"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getString("capacity"));

            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();        }
        return truck;
    }

    // SELECT OPERATION for All truck Fetching from DATABASE
    public List<Truck> getTruckList()
    {
        String fetch = "select *  from trucks ";
        List<Truck> truckList = new ArrayList<>();
        try{


            Connection connection = ConnectionDetails.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(fetch);

            while(resultSet.next())
            {
                Truck truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setTname(resultSet.getString("tname"));
                truck.setDname(resultSet.getString("dname"));
                truck.setCapacity(resultSet.getString("capacity"));
                truck.setModel(resultSet.getString("model"));

                truckList.add(truck);
            }
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();        }
        return truckList;
    }


    //UPDATE OPERATION PERFORM
    public void updateTruck(Truck truck)
    {
        String updateQuery = "update trucks set tname = ? , dname = ?, model = ?, capacity = ? where id = ?";
        try
        {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1,truck.getTname());
            preparedStatement.setString(2,truck.getDname());
            preparedStatement.setString(3,truck.getModel());
            preparedStatement.setString(4,truck.getCapacity());
            preparedStatement.setInt(5,truck.getId());

            int impactRow = preparedStatement.executeUpdate();
            System.out.println("Row updated ... :- "+ impactRow);
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();        }
    }

    //DELETE OPERATION perform In TRUCKMNG
    public void deleteTruck(int id)
    {
        String delete = "delete from trucks where id = ?";
        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1,id);
            int deleted = preparedStatement.executeUpdate();
            System.out.println("Deleted Row :- "+deleted);
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
