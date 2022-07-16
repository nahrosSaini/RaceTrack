package com.example.geektrust.tracks;

import com.example.geektrust.vehicles.Vehicle;
import com.example.geektrust.vehicles.VehicleType;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

abstract class RacingTrack {

    protected List<Vehicle> onTrack;
    protected List<Vehicle> offTrack;
    protected Map<Object,Integer> costChart;

    abstract void loadCostChart();

    // function add the vehicle to track.
    void addToOnTrack(Vehicle vehicle) {
        onTrack.add(vehicle);
    }

    // function to fetch the count of vehicles of given type on runningTrack.
    int getVehicleCount(VehicleType vehicleType) {

        int count=0;

        for (Vehicle vehicle:onTrack){
            if(vehicle.getVehicleType().equals(vehicleType)){
                count++;
            }
        }
        return count;
    }

    // function to put vehicles from onTrack to offTrack after exit time is expired.
    void updateTracks(LocalTime entryTime) {

        List<Vehicle> vehicles;
        vehicles = new ArrayList<>();

        for (Vehicle vehicle:onTrack){

            if (vehicle.getExitTime().getHour() <= entryTime.getHour() && vehicle.getExitTime().getMinute() <= entryTime.getMinute()){
                offTrack.add(vehicle);
                vehicles.add(vehicle);
            }
        }
        // calling the helper function
        if(vehicles.size() > 0){
            removeFromOnTrack(vehicles);
        }

    }

    // fetch the vehicle from Track
    Vehicle getVehicle(String vehicleNumber) {

        for(Vehicle vehicle:onTrack){
            if(vehicle.getVehicleNumber().equalsIgnoreCase(vehicleNumber)){
                return vehicle;
            }
        }

        return null;
    }

    // this is internal helper function to remove vehicles to onTrack
    private void removeFromOnTrack(List<Vehicle> vehicleList){
        for (Vehicle vehicle:vehicleList){
            onTrack.remove(vehicle);
        }
    }

    public Map<Object, Integer> getCostChart() {
        return this.costChart;
    }

}
