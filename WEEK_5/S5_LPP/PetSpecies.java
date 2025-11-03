package pets;

import java.util.Arrays;
import java.util.Objects;

/**
 * Immutable species configuration for pets.
 */
public final class PetSpecies {
    private final String speciesName;
    private final String[] evolutionStages;
    private final int maxLifespan;
    private final String habitat;

    public PetSpecies(String speciesName, String[] evolutionStages, int maxLifespan, String habitat) {
        if (speciesName == null || speciesName.trim().isEmpty())
            throw new IllegalArgumentException("speciesName required");
        if (evolutionStages == null || evolutionStages.length == 0)
            throw new IllegalArgumentException("At least one evolution stage required");
        if (maxLifespan <= 0)
            throw new IllegalArgumentException("maxLifespan must be > 0");
        if (habitat == null || habitat.trim().isEmpty())
            throw new IllegalArgumentException("habitat required");

        this.speciesName = speciesName;
        this.evolutionStages = Arrays.copyOf(evolutionStages, evolutionStages.length);
        this.maxLifespan = maxLifespan;
        this.habitat = habitat;
    }

    public String getSpeciesName() { return speciesName; }

    public String[] getEvolutionStages() {
        return Arrays.copyOf(evolutionStages, evolutionStages.length);
    }

    public int getMaxLifespan() { return maxLifespan; }

    public String getHabitat() { return habitat; }

    @Override
    public String toString() {
        return "PetSpecies{" + "name=" + speciesName +
                ", maxLifespan=" + maxLifespan +
                ", habitat=" + habitat + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetSpecies)) return false;
        PetSpecies that = (PetSpecies) o;
        return maxLifespan == that.maxLifespan &&
                Objects.equals(speciesName, that.speciesName) &&
                Arrays.equals(evolutionStages, that.evolutionStages) &&
                Objects.equals(habitat, that.habitat);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(speciesName, maxLifespan, habitat);
        result = 31 * result + Arrays.hashCode(evolutionStages);
        return result;
    }
}
