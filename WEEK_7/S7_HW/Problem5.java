class Artwork {
    String title;
    public Artwork(String title) { this.title = title; }
    public void display() { System.out.println("Displaying artwork: " + title); }
}

class Painting extends Artwork {
    String technique;
    public Painting(String title, String technique) { super(title); this.technique = technique; }
    public void showFrameSpecs() { System.out.println(title + " with frame technique: " + technique); }
}

class Sculpture extends Artwork {
    String material;
    public Sculpture(String title, String material) { super(title); this.material = material; }
    public void showLighting() { System.out.println(title + " made of " + material + " requires spotlight."); }
}

class DigitalArt extends Artwork {
    String format;
    public DigitalArt(String title, String format) { super(title); this.format = format; }
    public void interactiveDemo() { System.out.println(title + " in format " + format + " has interactive demo."); }
}

class Photography extends Artwork {
    String camera;
    public Photography(String title, String camera) { super(title); this.camera = camera; }
    public void showEditingDetails() { System.out.println(title + " shot on " + camera + " with editing details."); }
}

public class Problem5 {
    public static void main(String[] args) {
        Artwork[] gallery = {
            new Painting("Mona Lisa", "Oil on canvas"),
            new Sculpture("David", "Marble"),
            new DigitalArt("Cyber Dreams", "4K HDR"),
            new Photography("Sunset Glow", "Canon EOS R5")
        };

        for (Artwork art : gallery) {
            art.display();
            if (art instanceof Painting) ((Painting) art).showFrameSpecs();
            else if (art instanceof Sculpture) ((Sculpture) art).showLighting();
            else if (art instanceof DigitalArt) ((DigitalArt) art).interactiveDemo();
            else if (art instanceof Photography) ((Photography) art).showEditingDetails();
        }
    }
}
