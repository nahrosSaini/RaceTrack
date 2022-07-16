package com.example.geektrust.tracks;

import com.example.geektrust.logger.Logger;
import com.example.geektrust.vehicles.Vehicle;


import java.time.LocalTime;

// This class contains the main Logic of the application
public class TrackManagerImpl implements TrackManager{

    protected static final String SUCCESS="SUCCESS";
    private static final String INVALID_ENTRY_TIME="INVALID_ENTRY_TIME";
    private static final String INVALID_EXIT_TIME="INVALID_EXIT_TIME";

    // fetches the Tracks
    static RacingTrack regular=new RegularRacingTrack();
    static RacingTrack vip=new VipRacingTrack();
    static LogicFactory logicFactory= new LogicFactory();

    Logger logger=Logger.getLogger();

    // function
    @Override
    public void book(Vehicle vehicle) {

        // check entry is greater than 1PM and less than 5PM
        if(entryCondition(vehicle)){
            logger.printToConsole(INVALID_ENTRY_TIME);
        }

        if(!entryCondition(vehicle)){
            // update the tracks
            regular.updateTracks(vehicle.getEntryTime());
            vip.updateTracks(vehicle.getEntryTime());

            // calling the helper function to make the booking
            makeBooking(vehicle);

        }
    }

    @Override
    public void additional(String vehicleNumber,LocalTime exitTime) {

        // if exit time is greater then 8PM
        if(exitCondition(exitTime)){
            logger.printToConsole(INVALID_EXIT_TIME);
        }

        if(!exitCondition(exitTime)){
            // fetch the vehicle from track
            Vehicle vehicle=regular.getVehicle(vehicleNumber);

            if (vehicle==null){
                vehicle=vip.getVehicle(vehicleNumber);
            }

            if(vehicle!=null){
                vehicle.setExitTime(exitTime);
                logger.printToConsole(SUCCESS);
            }
        }

    }

    // function to generate revenue
    @Override
    public void revenue() {

        Revenue revenue=new Revenue(regular);

        int regularAmount= revenue.getRevenue();

        Revenue revenue1=new Revenue(vip);
        int vipAmount=revenue1.getRevenue();

        logger.printToConsole(regularAmount,vipAmount);


    }

    // this is a helper function for booking
    void makeBooking(Vehicle vehicle){

        int onRegular= regular.getVehicleCount(vehicle.getVehicleType());
        int onVip= vip.getVehicleCount(vehicle.getVehicleType());

        Logic logic= logicFactory.getLogic(vehicle.getVehicleType());
        logic.handle(regular,vip,vehicle,onRegular,onVip);


    }

    // entry condition
    boolean entryCondition(Vehicle vehicle){
        return ((vehicle.getEntryTime().getHour() > LocalTime.of(17,0).getHour()) || vehicle.getEntryTime().getHour() < LocalTime.of(13,0).getHour()
                || vehicle.getEntryTime().getHour() == LocalTime.of(17,0).getHour() && vehicle.getEntryTime().getMinute() >  LocalTime.of(17,0).getMinute()
        );
    }

    // entry condition
    boolean exitCondition(LocalTime exitTime){
        return (exitTime.getHour() > LocalTime.of(20,0).getHour() || (exitTime.getHour()==LocalTime.of(20,0).getHour() && exitTime.getMinute() > LocalTime.of(20,0).getMinute()));
    }
}
