package AssignmentDay4;

public class TimerThread implements Runnable {

    @Override
    public void run() {
        int seconds = 0;

        try {
            while (true) {
                System.out.println("Timer : " + seconds + " seconds");
                Thread.sleep(10000); 
                seconds += 10;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
