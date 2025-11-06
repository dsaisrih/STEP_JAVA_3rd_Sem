// File: BirdDemo.java
class Bird {
    public void fly() {
        System.out.println("Bird is flying in the sky.");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        System.out.println("Penguin cannot fly, it swims instead.");
    }
}

class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("Eagle soars high with powerful wings.");
    }
}

public class BirdDemo {
    public static void main(String[] args) {
        Bird[] birds = { new Bird(), new Penguin(), new Eagle() };
        for (Bird b : birds) {
            b.fly(); // polymorphic call
        }
    }
}
