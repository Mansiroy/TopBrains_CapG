package Day4;

public class Account implements Runnable {

    private double balance = 25000;

// Synchronized method to ensure thread safety when withdrawing money, preventing race conditions i.e. only one thread can access this withdraw method at a time
    
    public synchronized void withdraw(String name, double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println(name + " withdraws " + amt + ". Remaining balance: " + balance);
        } else {
            System.out.println(name + " cannot withdraw " + amt + ". Insufficient balance: " + balance);
        }
    }

// Alternatively, we can use a synchronized block to achieve the same thread safety, allowing for more granular control over the synchronization scope, which can be more efficient in certain scenarios where only a portion of the method needs to be synchronized.
    public  void withdraws(String name, double amt) {
        synchronized (this) {
            if (amt <= balance) {
                balance -= amt;
                System.out.println(name + " withdraws " + amt + ". Remaining balance: " + balance);
            } else {
                System.out.println(name + " cannot withdraw " + amt + ". Insufficient balance: " + balance);
            }
            
        }

    }

    @Override
    public void run() {
        withdraw(Thread.currentThread().getName(), 5000);
        withdraw(Thread.currentThread().getName(), 10000);
        withdraw(Thread.currentThread().getName(), 15000);
        withdraw(Thread.currentThread().getName(), 20000);
    
    }
}
