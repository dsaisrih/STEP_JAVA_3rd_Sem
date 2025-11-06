// File: ColorHierarchyDemo.java
class Color {
    protected String name;
    public Color(String name) {
        this.name = name;
        System.out.println("Color constructor: " + name);
    }
}

class PrimaryColor extends Color {
    protected int intensity;
    public PrimaryColor(String name, int intensity) {
        super(name);
        this.intensity = intensity;
        System.out.println("PrimaryColor constructor: intensity " + intensity);
    }
}

class RedColor extends PrimaryColor {
    private String shade;
    public RedColor(String name, int intensity, String shade) {
        super(name, intensity);
        this.shade = shade;
        System.out.println("RedColor constructor: shade " + shade);
    }
}

public class ColorHierarchyDemo {
    public static void main(String[] args) {
        RedColor red = new RedColor("Red", 80, "Crimson");
        System.out.println(red.name + " intensity " + red.intensity);
    }
}
