class Animal {
    void sound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }

    void fetch() {
        System.out.println("Dog fetches the ball");
    }
}

public class UpcastingDemo {
    public static void main(String[] args) {
        Animal a = new Dog(); // Upcasting
        a.sound();            // Calls Dog’s overridden method

        // a.fetch(); // ❌ Not allowed, reference is Animal type
    }
}
