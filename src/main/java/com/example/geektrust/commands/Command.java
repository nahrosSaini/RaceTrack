package com.example.geektrust.commands;

import java.util.StringTokenizer;


// interface to handle command form input file
public interface Command {

    void execute(StringTokenizer stringTokenizer);

}
