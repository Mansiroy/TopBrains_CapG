package Day4;

public class StaticDemo {
	
int counter = 0;
public void incrCounter () {
	counter++;
	System.out.println(counter);
}

public static void main(String[] args) {
	StaticDemo s1 = new StaticDemo();
	StaticDemo s2 = new StaticDemo();
	StaticDemo s3 = new StaticDemo();
	s1.incrCounter();
	s2.incrCounter();
	s3.incrCounter();
}
}
