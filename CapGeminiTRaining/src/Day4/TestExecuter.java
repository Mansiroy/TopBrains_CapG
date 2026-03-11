package Day4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecuter {
	public static void main(String[] args) {
		
 Runnable r = ()-> System.out.println(Thread.currentThread().getName());
 ExecutorService ex = Executors.newFixedThreadPool(2);
 
 for(int i = 0; i < 10; i++) {
	// Thread t = new Thread(r);
	 
//	 t.start();
	 ex.execute(r);
 }
}
}
