package pets;

import java.util.Objects;
import java.util.UUID;

/**
 * VirtualPet with professional access control, encapsulation, and constructor chaining.
 */
public class VirtualPet {
    private final String petId;
    private final PetSpecies species;
    private final long birthTimestamp;

    private String petName;
    private int age;
    private int happiness;
    private int health;

    protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Baby", "Teen", "Adult", "Elder"};
    static final int MAX_HAPPINESS = 100;
    static final int MAX_HEALTH = 100;
    public static final String PET_SYSTEM_VERSION = "2.0";

    // Main constructor (all others chain here)
    public VirtualPet(String petName, PetSpecies species, int age, int happiness, int health) {
        this.petId = generatePetId();
        this.birthTimestamp = System.currentTimeMillis();
        this.petName = Objects.requireNonNullElse(petName, "Unknown");
        this.species = Objects.requireNonNull(species);
        this.age = validateStat(age, species.getMaxLifespan());
        this.happiness = validateStat(happiness, MAX_HAPPINESS);
        this.health = validateStat(health, MAX_HEALTH);
    }

    // Default constructor: random pet with default species
    public VirtualPet() {
        this("Defaulty", new PetSpecies("Default", DEFAULT_EVOLUTION_STAGES, 100, "Generic"),
                0, 50, 50);
    }

    // Constructor with name only
    public VirtualPet(String petName) {
        this(petName, new PetSpecies("Default", DEFAULT_EVOLUTION_STAGES, 100, "Generic"),
                0, 60, 60);
    }

    // Constructor with name and species
    public VirtualPet(String petName, PetSpecies species) {
        this(petName, species, 0, 60, 60);
    }

    // Getters/Setters (JavaBean style)
    public String getPetId() { return petId; }
    public PetSpecies getSpecies() { return species; }
    public long getBirthTimestamp() { return birthTimestamp; }

    public String getPetName() { return petName; }
    public void setPetName(String petName) { this.petName = Objects.requireNonNull(petName); }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = validateStat(age, species.getMaxLifespan()); }

    public int getHappiness() { return happiness; }
    public void setHappiness(int happiness) { this.happiness = validateStat(happiness, MAX_HAPPINESS); }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = validateStat(health, MAX_HEALTH); }

    // Public pet interactions
    public void feedPet(String foodType) {
        int bonus = calculateFoodBonus(foodType);
        modifyHealth(bonus);
        checkEvolution();
    }

    public void playWithPet(String gameType) {
        int effect = calculateGameEffect(gameType);
        modifyHappiness(effect);
        checkEvolution();
    }

    // Protected internal logic
    protected int calculateFoodBonus(String foodType) {
        return "treat".equalsIgnoreCase(foodType) ? 10 : 5;
    }

    protected int calculateGameEffect(String gameType) {
        return "fetch".equalsIgnoreCase(gameType) ? 15 : 7;
    }

    // Private helpers
    private int validateStat(int value, int max) {
        if (value < 0) return 0;
        if (value > max) return max;
        return value;
    }

    private String generatePetId() {
        return "PET-" + UUID.randomUUID();
    }

    private void modifyHappiness(int delta) {
        setHappiness(happiness + delta);
    }

    private void modifyHealth(int delta) {
        setHealth(health + delta);
    }

    private void checkEvolution() {
        // stub logic: every 20 happiness triggers "evolution"
        if (happiness % 20 == 0) {
            updateEvolutionStage();
        }
    }

    private void updateEvolutionStage() {
        System.out.println(petName + " is evolving!");
    }

    // Package-private debugging
    String getInternalState() {
        return "PetState{" +
                "id=" + petId +
                ", name=" + petName +
                ", age=" + age +
                ", happiness=" + happiness +
                ", health=" + health + "}";
    }

    @Override
    public String toString() {
        return "VirtualPet{" + "id=" + petId + ", name=" + petName +
                ", species=" + species.getSpeciesName() +
                ", happiness=" + happiness + ", health=" + health + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualPet)) return false;
        VirtualPet that = (VirtualPet) o;
        return Objects.equals(petId, that.petId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId);
    }
}
