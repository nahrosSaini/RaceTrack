package com.example.geektrust.tracks;

import com.example.geektrust.vehicles.Vehicle;
import com.example.geektrust.vehicles.VehicleType;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

// class to handle Revenue logic
public class Revenue {

    // fetch the track and cost chart of track
    RacingTrack racingTrack;
    Map<Object,Integer>cost;

    Revenue(RacingTrack racingTrack){
        this.racingTrack=racingTrack;
        cost=racingTrack.getCostChart();
    }

    // function to calculate the Revenue
    int getRevenue(){
        int revenueAmount=0;

        revenueAmount+=revenueCalculator(racingTrack.onTrack);
        revenueAmount+=revenueCalculator(racingTrack.offTrack);

        return revenueAmount;
    }


    // this is a helper function to calculate to revenue of individual track
    int revenueCalculator(List<Vehicle> vehicles){

        int Revenue_R=0;

        for (Vehicle vehicle:vehicles){
            LocalTime total_Time;
            total_Time = vehicle.getExitTime().minusHours(vehicle.getEntryTime().getHour()).minusMinutes(vehicle.getEntryTime().getMinute());
            int total_hrs=total_Time.getHour();
            int total_min=total_Time.getMinute();
            int extraHrs=total_hrs-3;
            int extraMin=total_min-15;



            if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
                Revenue_R+=((total_hrs-extraHrs) * cost.get(CostChartType.BIKE));
            }

            if(vehicle.getVehicleType().equals(VehicleType.CAR)){
                Revenue_R+=(total_hrs-extraHrs)*cost.get(CostChartType.CAR);
            }
            if(vehicle.getVehicleType().equals(VehicleType.SUV)){
                Revenue_R+=(total_hrs-extraHrs) * cost.get(CostChartType.SUV);
            }

            if(extraHrs>0){
                Revenue_R+=extraHrs * cost.get(CostChartType.EXTRAS);
            }

            if(extraMin >0 ){
                Revenue_R+=cost.get(CostChartType.EXTRAS);
            }

        }

        return Revenue_R;

    }

}
