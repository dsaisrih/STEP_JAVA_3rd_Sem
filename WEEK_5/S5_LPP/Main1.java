import java.util.*;

// a) Immutable KingdomConfig
final class KingdomConfig {
    private final String kingdomName;
    private final int foundingYear;
    private final String[] allowedStructureTypes;
    private final Map<String, Integer> resourceLimits;

    public KingdomConfig(String name, int year, String[] structures, Map<String, Integer> resources) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Invalid kingdom name");
        if (year <= 0) throw new IllegalArgumentException("Invalid year");
        if (structures == null || structures.length == 0) throw new IllegalArgumentException("Invalid structures");
        if (resources == null || resources.isEmpty()) throw new IllegalArgumentException("Invalid resources");

        this.kingdomName = name;
        this.foundingYear = year;
        this.allowedStructureTypes = Arrays.copyOf(structures, structures.length);
        this.resourceLimits = new HashMap<>(resources);
    }

    public String getKingdomName() { return kingdomName; }
    public int getFoundingYear() { return foundingYear; }
    public String[] getAllowedStructureTypes() { return Arrays.copyOf(allowedStructureTypes, allowedStructureTypes.length); }
    public Map<String, Integer> getResourceLimits() { return new HashMap<>(resourceLimits); }

    public static KingdomConfig createDefaultKingdom() {
        return new KingdomConfig("Avaloria", 1023,
                new String[]{"WizardTower", "EnchantedCastle", "MysticLibrary", "DragonLair"},
                Map.of("Gold", 10000, "Mana", 5000));
    }

    public static KingdomConfig createFromTemplate(String type) {
        switch (type.toLowerCase()) {
            case "war":
                return new KingdomConfig("Warhold", 900,
                        new String[]{"EnchantedCastle", "DragonLair"},
                        Map.of("Gold", 20000, "Iron", 15000));
            case "magic":
                return new KingdomConfig("Mystara", 1200,
                        new String[]{"WizardTower", "MysticLibrary"},
                        Map.of("Mana", 30000, "Crystals", 5000));
            default:
                return createDefaultKingdom();
        }
    }

    @Override
    public String toString() {
        return "KingdomConfig{" +
                "name='" + kingdomName + '\'' +
                ", year=" + foundingYear +
                ", structures=" + Arrays.toString(allowedStructureTypes) +
                ", resources=" + resourceLimits + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KingdomConfig)) return false;
        KingdomConfig that = (KingdomConfig) o;
        return foundingYear == that.foundingYear &&
                Objects.equals(kingdomName, that.kingdomName) &&
                Arrays.equals(allowedStructureTypes, that.allowedStructureTypes) &&
                Objects.equals(resourceLimits, that.resourceLimits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(kingdomName, foundingYear, resourceLimits);
        result = 31 * result + Arrays.hashCode(allowedStructureTypes);
        return result;
    }
}

// b) MagicalStructure base class
class MagicalStructure {
    private final String structureId;
    private final long constructionTimestamp;
    private final String structureName;
    private final String location;

    private int magicPower;
    private boolean isActive;
    private String currentMaintainer;

    static final int MIN_MAGIC_POWER = 0;
    static final int MAX_MAGIC_POWER = 1000;
    public static final String MAGIC_SYSTEM_VERSION = "3.0";

    public MagicalStructure(String name, String location) {
        this(name, location, 100, true);
    }

    public MagicalStructure(String name, String location, int power) {
        this(name, location, power, true);
    }

    public MagicalStructure(String name, String location, int power, boolean active) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Invalid name");
        if (location == null || location.isBlank()) throw new IllegalArgumentException("Invalid location");
        if (power < MIN_MAGIC_POWER || power > MAX_MAGIC_POWER) throw new IllegalArgumentException("Invalid power");

        this.structureId = UUID.randomUUID().toString();
        this.constructionTimestamp = System.currentTimeMillis();
        this.structureName = name;
        this.location = location;
        this.magicPower = power;
        this.isActive = active;
        this.currentMaintainer = "Unknown";
    }

    public String getStructureId() { return structureId; }
    public long getConstructionTimestamp() { return constructionTimestamp; }
    public String getStructureName() { return structureName; }
    public String getLocation() { return location; }
    public int getMagicPower() { return magicPower; }
    public boolean isActive() { return isActive; }
    public String getCurrentMaintainer() { return currentMaintainer; }

    public void setMagicPower(int power) {
        if (power < MIN_MAGIC_POWER || power > MAX_MAGIC_POWER) throw new IllegalArgumentException("Out of range");
        this.magicPower = power;
    }

    public void setActive(boolean active) { this.isActive = active; }
    public void setCurrentMaintainer(String maintainer) { this.currentMaintainer = maintainer; }

    @Override
    public String toString() {
        return structureName + " at " + location + " [Power=" + magicPower + ", Active=" + isActive + "]";
    }
}

// d) Specialized structures
class WizardTower {
    private final int maxSpellCapacity;
    private List<String> knownSpells;
    private String currentWizard;
    private final MagicalStructure base;

    public WizardTower(String name, String location, int capacity) {
        this.base = new MagicalStructure(name, location);
        this.maxSpellCapacity = capacity;
        this.knownSpells = new ArrayList<>();
        this.currentWizard = "None";
    }

    public void learnSpell(String spell) {
        if (knownSpells.size() < maxSpellCapacity) knownSpells.add(spell);
    }

    @Override
    public String toString() {
        return "WizardTower{" + base + ", spells=" + knownSpells + ", wizard=" + currentWizard + "}";
    }
}

class EnchantedCastle {
    private final String castleType;
    private int defenseRating;
    private boolean hasDrawbridge;
    private final MagicalStructure base;

    public EnchantedCastle(String name, String location, String type) {
        this.base = new MagicalStructure(name, location, 300);
        this.castleType = type;
        this.defenseRating = 100;
        this.hasDrawbridge = true;
    }

    @Override
    public String toString() {
        return "EnchantedCastle{" + base + ", type=" + castleType + ", defense=" + defenseRating + "}";
    }
}

class MysticLibrary {
    private final Map<String, String> bookCollection;
    private int knowledgeLevel;
    private final MagicalStructure base;

    public MysticLibrary(String name, String location, Map<String, String> books) {
        this.base = new MagicalStructure(name, location, 200);
        this.bookCollection = new HashMap<>(books);
        this.knowledgeLevel = books.size() * 10;
    }

    @Override
    public String toString() {
        return "MysticLibrary{" + base + ", books=" + bookCollection.size() + "}";
    }
}

class DragonLair {
    private final String dragonType;
    private long treasureValue;
    private int territorialRadius;
    private final MagicalStructure base;

    public DragonLair(String name, String location, String type, long treasure) {
        this.base = new MagicalStructure(name, location, 500);
        this.dragonType = type;
        this.treasureValue = treasure;
        this.territorialRadius = 100;
    }

    @Override
    public String toString() {
        return "DragonLair{" + base + ", type=" + dragonType + ", treasure=" + treasureValue + "}";
    }
}

// f) KingdomManager
class KingdomManager {
    private final List<Object> structures = new ArrayList<>();
    private final KingdomConfig config;

    public KingdomManager(KingdomConfig config) {
        this.config = config;
    }

    public void addStructure(Object structure) {
        structures.add(structure);
    }

    public static boolean canStructuresInteract(Object s1, Object s2) {
        return (s1 instanceof WizardTower && s2 instanceof MysticLibrary) ||
                (s1 instanceof DragonLair && s2 instanceof EnchantedCastle);
    }

    public static String performMagicBattle(Object attacker, Object defender) {
        if (attacker instanceof DragonLair && defender instanceof WizardTower) {
            return "Dragon breathes fire! Wizard defends with spells!";
        } else if (attacker instanceof WizardTower && defender instanceof DragonLair) {
            return "Wizard casts spell! Dragon retaliates!";
        }
        return "No battle occurs.";
    }

    public static int calculateKingdomPower(Object[] structures) {
        int total = 0;
        for (Object s : structures) {
            if (s instanceof WizardTower) total += 300;
            if (s instanceof EnchantedCastle) total += 500;
            if (s instanceof MysticLibrary) total += 200;
            if (s instanceof DragonLair) total += 800;
        }
        return total;
    }

    private String determineStructureCategory(Object structure) {
        if (structure instanceof WizardTower) return "Magic";
        if (structure instanceof EnchantedCastle) return "Defense";
        if (structure instanceof MysticLibrary) return "Knowledge";
        if (structure instanceof DragonLair) return "Beast";
        return "Unknown";
    }
}

// Demo Main
public class Main1 {
    public static void main(String[] args) {
        KingdomConfig config = KingdomConfig.createDefaultKingdom();
        KingdomManager manager = new KingdomManager(config);

        WizardTower tower = new WizardTower("Azure Spire", "North Peak", 5);
        EnchantedCastle castle = new EnchantedCastle("Ironhold", "West Valley", "Royal");
        MysticLibrary library = new MysticLibrary("Arcana Archives", "Central City", Map.of("Book1", "Spells"));
        DragonLair lair = new DragonLair("Flameheart", "Cave of Doom", "Fire Dragon", 10000);

        manager.addStructure(tower);
        manager.addStructure(castle);
        manager.addStructure(library);
        manager.addStructure(lair);

        System.out.println("Config: " + config);
        System.out.println("Interaction possible? " + KingdomManager.canStructuresInteract(tower, library));
        System.out.println("Battle: " + KingdomManager.performMagicBattle(lair, tower));
        System.out.println("Total Power: " + KingdomManager.calculateKingdomPower(new Object[]{tower, castle, library, lair}));
    }
}
