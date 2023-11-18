package UI;

import java.io.*;
import java.util.Scanner;

public class ReadFromFile {
    public File file;
    public Scanner input;


    public ReadFromFile() {
        this.file = new File("Date.txt");
    }

    public void readFromFile() throws FileNotFoundException {       // метод чтения  данных из файла
        input = new Scanner(System.in);
        System.out.println("Do you want to print  data from file Date.txt:  y/n ");   // загрузка данных с файла
        if (input.next().equals("y")) {

            System.out.println("---------------------------------------- ");
            System.out.println("Date.txt: ");
            System.out.println("Id " + "Priority " + "aTime " + "bTime");
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                reader.lines().forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {return;}
    }
}








