class Animal {
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;

    // Constructor
    public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }

    // Methods
    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void move() {
        System.out.println("Animal is moving");
    }

    public String getAnimalInfo() {
        return "Species: " + species + ", Habitat: " + habitat +
                ", Lifespan: " + lifespan + " years, Wildlife: " + isWildlife;
    }
}

// 🔹 Intermediate class
class Mammal extends Animal {
    protected String furColor;
    protected boolean hasWarmBlood;
    protected int gestationPeriod; // in days

    // Constructor
    public Mammal(String species, String habitat, int lifespan, boolean isWildlife,
                  String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        this.furColor = furColor;
        this.hasWarmBlood = true; // always true
        this.gestationPeriod = gestationPeriod;
        System.out.println("Mammal constructor: Adding mammal traits");
    }

    // Overridden method
    @Override
    public void move() {
        super.move();
        System.out.println("Mammal is walking/running");
    }

    // Mammal-specific methods
    public void nurse() {
        System.out.println("Mammal is nursing offspring");
    }

    public void regulateTemperature() {
        System.out.println("Maintaining body temperature");
    }
}

// 🔹 Specific class
class Dog extends Mammal {
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel; // scale 1-10
    private String favoriteActivity;

    // Constructor 1: Basic dog
    public Dog() {
        super("Dog", "Domestic", 13, false, "Varies", 60);
        this.breed = "Mixed";
        this.isDomesticated = true;
        this.loyaltyLevel = 5;
        this.favoriteActivity = "Playing";
        System.out.println("Dog constructor: Creating default dog");
    }

    // Constructor 2: Detailed dog
    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod,
               String breed, boolean isDomesticated, int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }

    // Constructor 3: Copy constructor
    public Dog(Dog other) {
        this(other.species, other.habitat, other.lifespan, other.isWildlife,
             other.furColor, other.gestationPeriod,
             other.breed, other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
        System.out.println("Dog copy constructor called");
    }

    // Overridden methods
    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog is wagging tail while eating");
    }

    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }

    // Dog-specific methods
    public void bark() {
        System.out.println("Woof! Woof!");
    }

    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }

    public void showLoyalty() {
        System.out.println("Loyalty level: " + loyaltyLevel + "/10");
    }

    // Demonstration method
    public void demonstrateInheritance() {
        System.out.println("\n=== Demonstrating Inheritance Chain ===");
        super.eat();     // Animal behavior
        super.move();    // Mammal + Animal behavior
        super.sleep();   // Animal behavior
        this.eat();      // Dog overridden
        this.move();     // Dog overridden
        this.sleep();    // Dog overridden
    }
}

// 🔹 Demo class with main()
public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Constructor Chaining Test 1 (Default Dog) ===");
        Dog d1 = new Dog();
        d1.demonstrateInheritance();

        System.out.println("\n=== Constructor Chaining Test 2 (Detailed Dog) ===");
        Dog d2 = new Dog("Dog", "Domestic", 12, false, "Brown", 63,
                "Labrador", true, 9, "Swimming");
        d2.eat();
        d2.move();
        d2.sleep();
        d2.bark();
        d2.fetch();
        d2.showLoyalty();

        System.out.println("\n=== Constructor Chaining Test 3 (Copy Dog) ===");
        Dog d3 = new Dog(d2);
        d3.showLoyalty();

        // instanceof demonstration
        System.out.println("\n=== instanceof Tests ===");
        System.out.println("d2 instanceof Dog: " + (d2 instanceof Dog));
        System.out.println("d2 instanceof Mammal: " + (d2 instanceof Mammal));
        System.out.println("d2 instanceof Animal: " + (d2 instanceof Animal));
    }
}
