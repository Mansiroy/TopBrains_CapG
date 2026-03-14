package AssignmentDay4;

import java.io.*;

public class CopyDataThread extends Thread {

    private FileReader fr;
    private FileWriter fw;

    // Constructor 
    public CopyDataThread(FileReader fr, FileWriter fw) {
        this.fr = fr;
        this.fw = fw;
    }

    @Override
    public void run() {
        try {
            int ch;
            int count = 0;

            while ((ch = fr.read()) != -1) {
                fw.write(ch);
                count++;

                if (count % 10 == 0) {
                    System.out.println("10 characters are copied");
                    Thread.sleep(5000); // 5 seconds delay
                }
            }

            fw.flush();
            System.out.println("File copying completed!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}