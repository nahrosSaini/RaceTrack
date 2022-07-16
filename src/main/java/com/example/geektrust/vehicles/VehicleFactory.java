package com.example.geektrust.vehicles;

import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {

    private  final Map<String, Vehicle> vehicleFactory=new HashMap<>();

     {
        vehicleFactory.put("BIKE",new Bike());
        vehicleFactory.put("CAR",new Car());
        vehicleFactory.put("SUV",new Suv());
    }

    public VehicleFactory(){

    }
    public Vehicle getVehicle(String vehicleType){
        return vehicleFactory.get(vehicleType);
    }
}
