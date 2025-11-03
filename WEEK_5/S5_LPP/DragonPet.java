package pets;

/**
 * Specialized Dragon Pet class using composition.
 */
public class DragonPet {
    private final String dragonType;
    private final String breathWeapon;
    private final VirtualPet corePet;

    public DragonPet(String dragonType, String breathWeapon, String name) {
        this.dragonType = dragonType;
        this.breathWeapon = breathWeapon;
        this.corePet = new VirtualPet(name, new PetSpecies("Dragon",
                VirtualPet.DEFAULT_EVOLUTION_STAGES, 200, "Mountain"));
    }

    public String getDragonType() { return dragonType; }
    public String getBreathWeapon() { return breathWeapon; }
    public VirtualPet getCorePet() { return corePet; }

    @Override
    public String toString() {
        return "DragonPet{" + "type=" + dragonType +
                ", weapon=" + breathWeapon +
                ", core=" + corePet + "}";
    }
}
