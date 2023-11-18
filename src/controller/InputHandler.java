package controller;

import UI.LoadFromFile;
import UI.WriteToFile;
import model.Process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class  InputHandler {
    private ArrayList<Process> processes;
    private Scanner input;

    public InputHandler() {
        processes = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public ArrayList<Process> getProcesses() throws IOException {


        System.out.println("Do you want to load data from file Date.txt:  y/n ");   // загрузка данных с файла
        if (input.next().equals("y")) {
            LoadFromFile loadFromFile = new LoadFromFile();
            processes = loadFromFile.loadFromFile();
        }
        System.out.println("Do you want to input other data:  y/n ");
        if (input.next().equals("y")) {

            System.out.println("------------------------------------ ");
            System.out.println("Enter processes properties. ");
            int id, priority, aTime, bTime;

            // ввод параметров планировщика задач
            do {
                System.out.print("Enter process ID: ");
                while (!input.hasNextInt()) {
                    System.out.print("Error! Enter process id as an integer: ");
                    input.next();
                }
                id = input.nextInt();

                System.out.print("Enter process priority: ");
                while (!input.hasNextInt()) {
                    System.out.print("Error! Enter process priority as an integer: ");
                    input.next();
                }
                priority = input.nextInt();
                System.out.print("Enter process arriving time: ");
                while (!input.hasNextInt()) {
                    System.out.print("Error! Enter process arriving time as an integer: ");
                    input.next();
                }
                aTime = input.nextInt();
                System.out.print("Enter process burst time: ");
                while (!input.hasNextInt()) {
                    System.out.print("Error! Enter process burst time as an integer: ");
                    input.next();
                }
                bTime = input.nextInt();
                processes.add(new Process(id, priority, aTime, bTime));

                WriteToFile writeToFile = new WriteToFile();
                writeToFile.writeToFile(id, priority, aTime, bTime);        // запись в файл

                System.out.print("Do you want to continue? (y/n): ");
            } while (input.next().equals("y"));
        }
        System.out.println("------------------------------------");
        return processes;
    }

    public static ArrayList<Process> cloneInputProcesses(ArrayList<Process> processes) {
        ArrayList<Process> processesCpy = new ArrayList<>();
        for (Process p : processes) {
            processesCpy.add(new Process(p.getProcessID(), p.getPriority(), p.getArrivingTime(), p.getBurstTime()));
        }
        return processesCpy;
    }
}

