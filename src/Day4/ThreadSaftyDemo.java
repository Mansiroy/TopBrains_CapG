package Day4;

public class ThreadSaftyDemo implements Runnable {
	public void printMessage(String name) {
		for(int i = 0; i< 10; i++) {
			System.out.println(name);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public void run() {
		printMessage(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		ThreadSaftyDemo obj1 = new ThreadSaftyDemo();
		ThreadSaftyDemo obj2 = new ThreadSaftyDemo();
		ThreadSaftyDemo obj3 = new ThreadSaftyDemo();
		Thread t1 = new Thread(obj1, "A");
		Thread t2 = new Thread(obj2, "B");
		Thread t3 = new Thread(obj3, "C");
		t1.start();
		t2.start();
		t3.start();
	}
}
