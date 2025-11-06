// File: InstrumentFamilyDemo.java
class Instrument {
    protected String name;
    protected String material;

    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }

    public void play() {
        System.out.println("Playing instrument: " + name);
    }
}

class Piano extends Instrument {
    private int keys;
    public Piano(String material, int keys) {
        super("Piano", material);
        this.keys = keys;
    }
    @Override
    public void play() {
        System.out.println("Piano with " + keys + " keys is playing.");
    }
}

class Guitar extends Instrument {
    private int strings;
    public Guitar(String material, int strings) {
        super("Guitar", material);
        this.strings = strings;
    }
    @Override
    public void play() {
        System.out.println("Guitar with " + strings + " strings is strumming.");
    }
}

class Drum extends Instrument {
    private double diameter;
    public Drum(String material, double diameter) {
        super("Drum", material);
        this.diameter = diameter;
    }
    @Override
    public void play() {
        System.out.println("Drum of " + diameter + " inch diameter is beating.");
    }
}

public class InstrumentFamilyDemo {
    public static void main(String[] args) {
        Instrument[] band = {
            new Piano("Wood", 88),
            new Guitar("Maple", 6),
            new Drum("Metal", 14)
        };
        for (Instrument i : band) i.play();
    }
}
