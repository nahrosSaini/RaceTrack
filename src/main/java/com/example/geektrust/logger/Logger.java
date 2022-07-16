package com.example.geektrust.logger;

// Class to log the message to console
// SingleTon class
public class Logger {

    private static volatile Logger logger=null;

    private Logger(){}

    public static Logger getLogger(){

        if(logger==null){
            synchronized (Logger.class){
                if(logger==null){
                    logger=new Logger();
                }
            }
        }

        return logger;
    }

    public void printToConsole(String message){
        System.out.println(message);
    }
    public void printToConsole(int regularAmount,int vipAmount){
        System.out.println(regularAmount+ " " + vipAmount);
    }
}
