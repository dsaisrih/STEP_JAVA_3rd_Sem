import java.util.Random;
import java.util.UUID;

public class VirtualPetEvolution {
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private String evolutionStage;

    private static final String[] EVOLUTION_STAGES = {
        "Egg", "Baby", "Child", "Teen", "Adult", "Elder"
    };

    private static int totalPetsCreated = 0;

    // Default constructor: mysterious egg
    public VirtualPetEvolution() {
        this("Mystery", getRandomSpecies(), 0, 50, 50, EVOLUTION_STAGES[0]);
    }

    // Constructor with name only: baby stage
    public VirtualPetEvolution(String petName) {
        this(petName, getRandomSpecies(), 1, 60, 60, EVOLUTION_STAGES[1]);
    }

    // Constructor with name and species: child stage
    public VirtualPetEvolution(String petName, String species) {
        this(petName, species, 2, 70, 70, EVOLUTION_STAGES[2]);
    }

    // Full constructor
    public VirtualPetEvolution(String petName, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.evolutionStage = stage;
        totalPetsCreated++;
    }

    private static String getRandomSpecies() {
        String[] speciesList = {"Fluffin", "Zorbo", "Glimmer", "Snark"};
        return speciesList[new Random().nextInt(speciesList.length)];
    }

    public static String generatePetId() {
        return UUID.randomUUID().toString();
    }

    public void feedPet() {
        happiness += 10;
        health += 5;
    }

    public void playWithPet() {
        happiness += 15;
        health -= 5;
    }

    public void healPet() {
        health += 20;
    }

    public void simulateDay() {
        age++;
        happiness -= new Random().nextInt(10);
        health -= new Random().nextInt(10);
        evolvePet();
    }

    public void evolvePet() {
        if (health <= 0) {
            species = "Ghost";
            evolutionStage = "Haunting";
        } else if (age < 2) {
            evolutionStage = EVOLUTION_STAGES[1];
        } else if (age < 4) {
            evolutionStage = EVOLUTION_STAGES[2];
        } else if (age < 6) {
            evolutionStage = EVOLUTION_STAGES[3];
        } else if (age < 8) {
            evolutionStage = EVOLUTION_STAGES[4];
        } else {
            evolutionStage = EVOLUTION_STAGES[5];
        }
    }

    public String getPetStatus() {
        return evolutionStage;
    }

    public void displayPet() {
        System.out.printf("🐾 %s (%s) | Age: %d | Happiness: %d | Health: %d | Stage: %s%n",
                petName, species, age, happiness, health, evolutionStage);
    }

    public static void main(String[] args) {
        VirtualPetEvolution p1 = new VirtualPetEvolution();
        VirtualPetEvolution p2 = new VirtualPetEvolution("Bubbles");
        VirtualPetEvolution p3 = new VirtualPetEvolution("Spark", "Zorbo");

        for (int i = 0; i < 5; i++) {
            p1.simulateDay();
            p2.simulateDay();
            p3.simulateDay();
        }

        p1.displayPet();
        p2.displayPet();
        p3.displayPet();

        System.out.println("Total Pets Created: " + totalPetsCreated);
    }
}