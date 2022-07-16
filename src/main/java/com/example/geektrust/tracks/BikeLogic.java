package com.example.geektrust.tracks;

import com.example.geektrust.logger.Logger;
import com.example.geektrust.vehicles.Vehicle;
import com.example.geektrust.vehicles.VehicleType;

class BikeLogic extends Logic{

    Logger logger=Logger.getLogger();

    @Override
    public void handle(RacingTrack regular, RacingTrack vip, Vehicle vehicle,int onRegular,int onVip) {

        super.initializer(regular,vip,vehicle,onRegular,onVip);


        if(bikeConditionOne()){
            bikeSuccess();
        }

        if(!bikeConditionOne()){
            logger.printToConsole(RACETRACK_FULL);
        }

    }

    // condition
    boolean bikeConditionOne(){
        return onRegular < 4 && vehicle.getVehicleType().equals(VehicleType.BIKE);
    }

    //bike success
    private void bikeSuccess(){
        regular.addToOnTrack(vehicle);
        logger.printToConsole(SUCCESS);
    }
}
