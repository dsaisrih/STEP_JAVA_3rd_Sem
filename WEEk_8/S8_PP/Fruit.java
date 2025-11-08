// Fruit.java
abstract class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    // Abstract method
    abstract void showDetails();
}

// Interface
interface Edible {
    void nutrientsInfo();
}

// Apple class
class Apple extends Fruit implements Edible {
    private String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    @Override
    void showDetails() {
        System.out.println("Apple Variety: " + variety);
        System.out.println("Color: " + color + ", Taste: " + taste);
    }

    @Override
    public void nutrientsInfo() {
        System.out.println("Nutrients: Rich in fiber, vitamin C, and antioxidants.");
    }

    public static void main(String[] args) {
        Apple a = new Apple("Red", "Sweet", "Fuji");
        a.showDetails();
        a.nutrientsInfo();
    }
}
