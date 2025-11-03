abstract class MagicalStructure {
    protected String structureName;
    protected int magicPower;
    protected String location;
    protected boolean isActive;

    public MagicalStructure() {
        this("Unnamed", 10, "Unknown", true);
    }

    public MagicalStructure(String structureName) {
        this(structureName, 20, "Mystic Plains", true);
    }

    public MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    public abstract void castMagicSpell();
}

class WizardTower extends MagicalStructure {
    private int spellCapacity;
    private String[] knownSpells;

    public WizardTower() {
        this("Basic Tower", 30, "Arcane Hill", true, 5, new String[]{"Fireball"});
    }

    public WizardTower(String name, int spellCapacity) {
        this(name, 40, "Mage Valley", true, spellCapacity, new String[]{"Lightning"});
    }

    public WizardTower(String name, int magicPower, String location, boolean isActive, int spellCapacity, String[] knownSpells) {
        super(name, magicPower, location, isActive);
        this.spellCapacity = spellCapacity;
        this.knownSpells = knownSpells;
    }

    public void castMagicSpell() {
        System.out.println(structureName + " casts " + knownSpells[0]);
    }
}

class EnchantedCastle extends MagicalStructure {
    private int defenseRating;
    private boolean hasDrawbridge;

    public EnchantedCastle(String name, int defenseRating, boolean hasDrawbridge) {
        super(name, 50, "Royal Grounds", true);
        this.defenseRating = defenseRating;
        this.hasDrawbridge = hasDrawbridge;
    }

    public void castMagicSpell() {
        System.out.println(structureName + " activates magical shield!");
    }
}

class MysticLibrary extends MagicalStructure {
    private int bookCount;
    private String ancientLanguage;

    public MysticLibrary(String name, int bookCount, String ancientLanguage) {
        super(name, 35, "Silent Hollow", true);
        this.bookCount = bookCount;
        this.ancientLanguage = ancientLanguage;
    }

    public void castMagicSpell() {
        System.out.println(structureName + " invokes wisdom in " + ancientLanguage);
    }
}

class DragonLair extends MagicalStructure {
    private String dragonType;
    private int treasureValue;

    public DragonLair(String dragonType, int treasureValue) {
        super(dragonType + " Lair", 60, "Volcanic Ridge", true);
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
    }

    public void castMagicSpell() {
        System.out.println(structureName + " unleashes fiery breath!");
    }
}