package UI;

import java.io.*;

public class WriteToFile {
    public File file ;

    public WriteToFile() {
        this.file =new File("Date.txt");

    }

    public void writeToFile (int id, int priority, int aTime, int bTime ) throws IOException {
        PrintWriter pw = new PrintWriter((new FileWriter("Date.txt", true)));
        pw.println(id + " " +  priority + " " +  aTime + " " +  bTime );
        pw.close();
    }



}
