package com.example.geektrust.tracks;

import java.util.ArrayList;
import java.util.HashMap;


// this is Regular Track
class RegularRacingTrack extends RacingTrack{

    // define the initial values and loads the priceChart.
    RegularRacingTrack(){
        onTrack=new ArrayList<>();
        offTrack=new ArrayList<>();
        costChart=new HashMap<>();
        loadCostChart();
    }


    // this function loads the prices.
    @Override
    void loadCostChart() {
        costChart.put(CostChartType.BIKE,60);
        costChart.put(CostChartType.CAR,120);
        costChart.put(CostChartType.SUV,200);
        costChart.put(CostChartType.EXTRAS,50);
    }

}
