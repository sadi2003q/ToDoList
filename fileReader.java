package com.example.newtodo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class fileReader {
    public static ArrayList<ArrayList<String>> readTasksFromFile() throws FileNotFoundException {
        ArrayList<ArrayList<String>> taskInfoList = new ArrayList<>();
        try(BufferedReader reader= new BufferedReader(new FileReader("taskFile.txt"))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                ArrayList<String> taskInfo = new ArrayList<>();
                for (String part : parts) {
                    taskInfo.add(part.trim());
                }
                taskInfoList.add(taskInfo);
            }
        } catch (Exception e){
            System.out.println("file reading problem found");
        }

        return taskInfoList;
    }
    public static ArrayList<ArrayList<String>> readTasksFromFile2() throws FileNotFoundException {
        ArrayList<ArrayList<String>> taskInfoList = new ArrayList<>();
        try(BufferedReader reader= new BufferedReader(new FileReader("C_taskFile.txt"))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                ArrayList<String> taskInfo = new ArrayList<>();
                for (String part : parts) {
                    taskInfo.add(part.trim());
                }
                taskInfoList.add(taskInfo);
            }
        } catch (Exception e){
            System.out.println("file reading problem found");
        }

        return taskInfoList;
    }
}
