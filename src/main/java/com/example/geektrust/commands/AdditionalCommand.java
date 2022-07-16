package com.example.geektrust.commands;

import com.example.geektrust.tracks.TrackManager;
import com.example.geektrust.tracks.TrackManagerImpl;

import java.util.StringTokenizer;

// class to handle Additional Command
class AdditionalCommand implements Command{

    // get the manager
    static TrackManager trackManager=new TrackManagerImpl();

    // we will use this to set the additional exit time for the tracks
    @Override
    public void execute(StringTokenizer stringTokenizer) {
        while(stringTokenizer.hasMoreTokens()){
            String vehicleNumber1=stringTokenizer.nextToken();
            String vehicleExitTime1=stringTokenizer.nextToken();

            // convert string to LocalTime
            StringTokenizer time=new StringTokenizer(vehicleExitTime1,":");
            java.time.LocalTime exitTime= java.time.LocalTime.of(Integer.parseInt(time.nextToken()),Integer.parseInt(time.nextToken()));

            trackManager.additional(vehicleNumber1,exitTime);
        }
    }
}
