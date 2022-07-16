package com.example.geektrust.tracks;

import com.example.geektrust.logger.Logger;
import com.example.geektrust.vehicles.Vehicle;

class SuvLogic extends Logic{

    Logger logger=Logger.getLogger();

    @Override
    public void handle(RacingTrack regular, RacingTrack vip, Vehicle vehicle,int onRegular,int onVip) {

        super.initializer(regular,vip,vehicle,onRegular,onVip);


        if(suvConditionOne()){
            successR();
        }

        if(suvConditionTwo() && !suvConditionOne()){
           successV();
        }

        if(!suvConditionOne() && !suvConditionTwo()){
            logger.printToConsole(RACETRACK_FULL);
        }

    }

    // condition methods
    private boolean suvConditionOne(){
        return this.onRegular < 2;
    }

    // condition methods
    private boolean suvConditionTwo(){
        return onVip < 1;
    }

    // success function
    private void successR(){
        regular.addToOnTrack(vehicle);
        logger.printToConsole(SUCCESS);
    }

    // success function
    private void successV(){
        vip.addToOnTrack(vehicle);
        logger.printToConsole(SUCCESS);
    }

}
