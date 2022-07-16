package com.example.geektrust.tracks;

import com.example.geektrust.vehicles.VehicleType;

import java.util.HashMap;
import java.util.Map;

class LogicFactory {

    private final Map<VehicleType,Logic> logics=new HashMap<>();

    {
        logics.put(VehicleType.BIKE,new BikeLogic());
        logics.put(VehicleType.CAR,new CarLogic());
        logics.put(VehicleType.SUV,new SuvLogic());
    }

    LogicFactory(){}

    protected Logic getLogic(VehicleType vehicleType){
        return logics.get(vehicleType);
    }

}
