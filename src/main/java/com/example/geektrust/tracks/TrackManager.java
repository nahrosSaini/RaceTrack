package com.example.geektrust.tracks;

import com.example.geektrust.vehicles.Vehicle;

import java.time.LocalTime;

public interface TrackManager {

    void book(Vehicle vehicle);

    void additional(String vehicleNumber, LocalTime exitTime);

    void revenue();

}
