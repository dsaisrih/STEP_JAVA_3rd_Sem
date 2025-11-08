// Animal.java
abstract class Animal {
    protected String name;
    protected String habitat;

    public Animal(String name, String habitat) {
        this.name = name;
        this.habitat = habitat;
    }

    abstract void eat();
}

// Interface
interface Soundable {
    void makeSound();
}

// Dog class
class Dog extends Animal implements Soundable {

    public Dog(String name, String habitat) {
        super(name, habitat);
    }

    @Override
    void eat() {
        System.out.println(name + " eats meat and dog food.");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof Woof!");
    }

    public static void main(String[] args) {
        Dog d = new Dog("Buddy", "Domestic");
        d.eat();
        d.makeSound();
    }
}
