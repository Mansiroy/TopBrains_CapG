package AssignmentDay4;

public class TimerMain {

    public static void main(String[] args) {

        TimerThread timer = new TimerThread();
        Thread t = new Thread(timer);
        t.start();
    }
}

