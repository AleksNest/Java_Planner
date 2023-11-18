package UI;

import model.Process;

import java.io.*;
import java.util.ArrayList;

public class LoadFromFile {
    public File file;
    public Process process;
    private ArrayList<Process> processes;

    public LoadFromFile() {
        processes = new ArrayList<>();
    }

    public ArrayList<Process> loadFromFile() throws FileNotFoundException {

        this.file = new File("Date.txt");
        System.out.println("data from file Date.txt: ");
        try {

            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            int i = 0;

            while (line != null) {
                String[] numbersString = line.split(" ");
                int id = Integer.parseInt(numbersString[0]);
                int priority = Integer.parseInt(numbersString[1]);
                int aTime = Integer.parseInt(numbersString[2]);
                int bTime = Integer.parseInt(numbersString[3]);
                processes.add(new Process(id, priority, aTime, bTime));

                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Process p : processes) {
            System.out.print(p + "\n");
        }

        return processes;


    }
}



