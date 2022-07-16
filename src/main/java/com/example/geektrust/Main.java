package com.example.geektrust;

import com.example.geektrust.commands.Command;
import com.example.geektrust.commands.CommandFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        try {

            CommandFactory commandFactory=new CommandFactory();

            // fetching the input file "sample_input/input5.txt"
            FileInputStream fis = new FileInputStream("sample_input/input1.txt");
            //FileInputStream fis = new FileInputStream(args[0]);
            // passing the file to scanner
            Scanner sc = new Scanner(fis);
            // defining the delimiter
            sc.useDelimiter("\n");

            // iterate the scanner object until we have inputs in file
            while (sc.hasNextLine()) {

                String TestCase=sc.next();

                // split the test case to check the commandType
                StringTokenizer TestCaseInput=new StringTokenizer(TestCase);

                // getting the respective command class from commandFactory
                Command command=commandFactory.getCommand(TestCaseInput.nextToken());

                command.execute(TestCaseInput);

            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
