package com.example.geektrust.tracks;

import com.example.geektrust.vehicles.Vehicle;

abstract class Logic {

    RacingTrack regular;
    RacingTrack vip;
    Vehicle vehicle;
    int onRegular=0;
    int onVip=0;

    protected static final String SUCCESS="SUCCESS";
    protected static final String RACETRACK_FULL="RACETRACK_FULL";

    abstract void handle(RacingTrack regular, RacingTrack vip, Vehicle vehicle,int onRegular,int onVip);

    protected void initializer(RacingTrack regular, RacingTrack vip, Vehicle vehicle,int onRegular,int onVip){
        this.regular=regular;
        this.vip=vip;
        this.vehicle=vehicle;
        this.onRegular=onRegular;
        this.onVip=onVip;
    }
}
