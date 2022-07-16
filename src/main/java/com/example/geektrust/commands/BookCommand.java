package com.example.geektrust.commands;

import com.example.geektrust.tracks.TrackManager;
import com.example.geektrust.tracks.TrackManagerImpl;
import com.example.geektrust.vehicles.Vehicle;
import com.example.geektrust.vehicles.VehicleFactory;

import java.time.LocalTime;
import java.util.StringTokenizer;

// class to handle Book command
class BookCommand implements Command{

    // get the manager
    static TrackManager trackManager=new TrackManagerImpl();


    // we will use this to make the track booking
    @Override
    public void execute(StringTokenizer stringTokenizer) {

        while(stringTokenizer.hasMoreTokens()){
            VehicleFactory vehicleFactory=new VehicleFactory();

            // extract the inputs
            String vehicleType=stringTokenizer.nextToken();
            String vehicleNumber=stringTokenizer.nextToken();
            String vehicleEntryTime=stringTokenizer.nextToken();

            // convert string to LocalTime
            StringTokenizer time=new StringTokenizer(vehicleEntryTime,":");
            LocalTime entryTime= LocalTime.of(Integer.parseInt(time.nextToken()),Integer.parseInt(time.nextToken()));

            // Calculate ExitTime
            LocalTime exitTime=entryTime.plusHours(3).plusMinutes(0);

            // fetch the vehicleObject from factory
            Vehicle vehicle= vehicleFactory.getVehicle(vehicleType);


            // set the Vehicle attributes
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setEntryTime(entryTime);
            vehicle.setExitTime(exitTime);

            // make the booking
            trackManager.book(vehicle);

        }
    }
}
