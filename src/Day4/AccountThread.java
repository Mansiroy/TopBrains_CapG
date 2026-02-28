package Day4;

public class AccountThread {
    public static void main(String[] args) {
        Account account = new Account();
        Thread t1 = new Thread(account, "Samar");
        Thread t2 = new Thread(account, "Rishabh");
        Thread t3 = new Thread(account, "Sam");
        
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");
        
        t1.start();
        t2.start();
        t3.start();
    }    
}