// Abstract class - defines abstraction
abstract class Animal {
    // Abstract method (doesn't have a body)
    abstract void makeSound();

    // Regular method
    void eat() {
        System.out.println("This animal eats food.");
    }
}

// Subclass inherits from Animal
class Dog extends Animal {
    // Providing implementation of abstract method
    void makeSound() {
        System.out.println("Dog barks");
    }
}

class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();  // Polymorphism + abstraction
        myDog.makeSound();         // Outputs: Dog barks
        myDog.eat();               // Outputs: This animal eats food.
    }
}
