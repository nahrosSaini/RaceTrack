package com.example.geektrust.tracks;

import com.example.geektrust.logger.Logger;
import com.example.geektrust.vehicles.Vehicle;
import com.example.geektrust.vehicles.VehicleType;

class CarLogic extends Logic{

    Logger logger=Logger.getLogger();

    @Override
    public void handle(RacingTrack regular, RacingTrack vip, Vehicle vehicle,int onRegular,int onVip) {

        super.initializer(regular,vip,vehicle,onRegular,onVip);


        if(carConditionOne()){
            carSuccessR();
        }

        if(carConditionTwo() && !carConditionOne()){
            carSuccessV();
        }

        if(!carConditionOne() && !carConditionTwo()){
            logger.printToConsole(RACETRACK_FULL);
        }

    }

    // condition methods
    boolean carConditionOne(){
        return onRegular < 2;
    }

    // condition methods
    boolean carConditionTwo(){
        return onVip < 1;
    }

    // car success function
    private void carSuccessR(){
        regular.addToOnTrack(vehicle);
        logger.printToConsole(SUCCESS);
    }

    // car success function
    private void carSuccessV(){
        vip.addToOnTrack(vehicle);
        logger.printToConsole(SUCCESS);
    }

}
