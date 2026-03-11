package day2;

interface sizeable();
class Car{
	
}
class Animal{	
	public void eat() {
		//public void eat() {
			System.out.println("Animal Class");
		}
}

class Dog extends Animal{
	public void eat() {
		System.out.println("Dog Class");
	}
	
	public void bark() {
		System.out.println("Dog Bark");
	}
}

class Cat extends Animal{
	public void eat() {
		System.out.println("Cat Class");
	}
	
	public void mew() {
		System.out.println("Cat Mew");
	}
}

public class TestAnimal {
	public static void main(String[] args) {
//		Animal obj =  new Animal();
//		obj.eat();
//		//obj = new Dog();
//		obj.eat();
//		//Dog d = new Dog();
//		//d.eat();
//		//d.bark();
//		((Dog)obj).bark(); //DOWNCASTING
		
//		Dog obj = new Dog();
//		obj.eat();
//		((Animal)obj).eat();//UPCASTING
		
//		Animal arr[] = {new Animal(), new Dog(), new Cat()};
//		
//		for(Animal obj: arr) {
//			obj.eat();
//			if(obj instanceof Dog) 
//			((Dog)obj).bark();
//			
//			if(obj instanceof Cat) 
//			((Cat)obj).mew();
//			}	
		
//		Interface
		Cat obj = new Cat();
		System.out.println(obj instanceof Sizeable);

		}
	}


