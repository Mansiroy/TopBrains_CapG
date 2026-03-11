package day2;

//funcionalInterface is that which interface having only one abstract methood
@FunctionalInterface
public interface ICalculator {
     public int calculate(int a, int b);
     public static void m1() {
     //public default void m1() {
    	 System.out.println("Default Mathood");
    	 
     }    	 
   //abstract method cannot be private
     // private void m2();
  }

