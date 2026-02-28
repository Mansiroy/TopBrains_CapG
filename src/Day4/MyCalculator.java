package Day4;

class Calculator extends Thread{
	int total;
	public void run() {
		synchronized(this) {
			for(int i = 0; i <= 100; i++) {
				total += i;
		}
		notify();
		//notifyAll();
		}
	}
}
public class MyCalculator {
public static void main(String[] args) {
	Calculator cal = new Calculator();
	cal.start();
	synchronized(cal) {
		try {
			System.out.println("Waiting for calculation");
			cal.wait();
			System.out.println("Total = "  +cal.total);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	}
}
