package AssignmentDay4;

import java.io.*;

public class FileProgram {

    public static void main(String[] args) {

        try {
            File source = new File("C:\\Users\\91843\\OneDrive\\Desktop\\Capgemini_Documents\\New folder\\assignment.txt");

            if (!source.exists()) {
                source.createNewFile();
                System.out.println("source.txt created. Please add content and run again.");
                return;
            }

            FileReader fr = new FileReader(source);
            FileWriter fw = new FileWriter("C:\\Users\\91843\\OneDrive\\Desktop\\Capgemini_Documents\\New folder\\target.txt");

            CopyDataThread t1 = new CopyDataThread(fr, fw);
            t1.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}