package com.example.geektrust.commands;

// class to handle Revenue command
import com.example.geektrust.tracks.TrackManager;
import com.example.geektrust.tracks.TrackManagerImpl;

import java.util.StringTokenizer;

class RevenueCommand implements Command{

    // get the manager
    static TrackManager trackManager=new TrackManagerImpl();

    // we don't need this function implementation as there is no input for revenue command.
    @Override
    public void execute(StringTokenizer stringTokenizer) {

        if(stringTokenizer.countTokens() == 0){
            trackManager.revenue();
        }

    }
}
