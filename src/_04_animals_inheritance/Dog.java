package _04_animals_inheritance;

public class Dog {
	String name;
	String color;
	boolean isGirl;
	Dog(String name, String color, boolean isGirl){
		this.name=name;
		this.color=color;
		this.isGirl=isGirl;
	}
	public void printName() {
		System.out.println("My name is "+name);
	}
	public void play() {
		System.out.println("Playing");
	}
	public void eat() {
		System.out.println("Eating");
	}
	public void sleep() {
		System.out.println("Sleeping");
	}
}
