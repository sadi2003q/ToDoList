package com.example.newtodo;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class fileWriter {
    public static void writeInformation(ArrayList<String> taskInfo) throws IOException {
        BufferedWriter writer= new BufferedWriter(new FileWriter("taskFile.txt", true));
        writer.write(taskInfo.get(0)+","+taskInfo.get(1)+"\n");
        writer.flush();
    }
    public void writeInformationComplete(String s1, String s2, String s3) throws Exception{
        BufferedWriter writer= new BufferedWriter(new FileWriter("C_taskFile.txt", true));
        if (fileIsEmpty("C_taskFile.txt")) {
            writer.write(s1 + "," + s2 + "," + s3);
        } else {
            writer.write("\n" + s1 + "," + s2+ "," + s3);
        }
        writer.flush();
    }
    public static void writeInformation(String s1, String s2, String s3) throws IOException {
        BufferedWriter writer= new BufferedWriter(new FileWriter("taskFile.txt", true));
        if (fileIsEmpty("taskFile.txt")) {
            writer.write(s1 + "," + s2 + "," + s3);
        } else {
            writer.write("\n" + s1 + "," + s2+ "," + s3);
        }
        writer.flush();
    }
    private static boolean fileIsEmpty(String filePath) {
        File file = new File(filePath);
        return file.length() == 0;
    }
    public void deleteTask(String taskName) throws IOException {
        ArrayList<ArrayList<String>> taskInfoList= fileReader.readTasksFromFile();
        try(BufferedWriter writer= new BufferedWriter(new FileWriter("taskFile.txt"))){
            for(ArrayList<String> taskInfo: taskInfoList){
                String currentTaskName=taskInfo.get(0);
                if(!taskName.equalsIgnoreCase(currentTaskName)){
                    if (fileIsEmpty("taskFile.txt")) {
                        writer.write(taskInfo.get(0) + "," + taskInfo.get(1) + "," + taskInfo.get(2));
                    } else {
                        writer.write("\n" + taskInfo.get(0) + "," + taskInfo.get(1)+ "," + taskInfo.get(2));
                    }
                    writer.flush();
                }
            }
        }
    }
    public void deleteTask2(String taskName) throws IOException {
        ArrayList<ArrayList<String>> taskInfoList= fileReader.readTasksFromFile();
        try(BufferedWriter writer= new BufferedWriter(new FileWriter("C_taskFile.txt"))){
            for(ArrayList<String> taskInfo: taskInfoList){
                String currentTaskName=taskInfo.get(0);
                if(!taskName.equalsIgnoreCase(currentTaskName)){
                    if (fileIsEmpty("C_taskFile.txt")) {
                        writer.write(taskInfo.get(0) + "," + taskInfo.get(1) + "," + taskInfo.get(2));
                    } else {
                        writer.write("\n" + taskInfo.get(0) + "," + taskInfo.get(1)+ "," + taskInfo.get(2));
                    }
                    writer.flush();
                }
            }
        }
    }
}
