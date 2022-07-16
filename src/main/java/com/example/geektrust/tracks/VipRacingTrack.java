package com.example.geektrust.tracks;

import java.util.ArrayList;
import java.util.HashMap;


class VipRacingTrack extends RacingTrack{

    // define the initial values and loads the priceChart.
    VipRacingTrack(){
        onTrack=new ArrayList<>();
        offTrack=new ArrayList<>();
        costChart=new HashMap<>();
        loadCostChart();
    }


    // this function loads the prices.
    @Override
    void loadCostChart() {
        costChart.put(CostChartType.CAR,250);
        costChart.put(CostChartType.SUV,300);
        costChart.put(CostChartType.EXTRAS,50);
    }

}
