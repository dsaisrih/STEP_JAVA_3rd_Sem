// File: GiftBoxDemo.java
class Box {
    public void pack() {
        System.out.println("Box packed normally.");
    }
    public void unpack() {
        System.out.println("Box unpacked normally.");
    }
}

class GiftBox extends Box {
    @Override
    public void pack() {
        super.pack(); // preserve parent behavior
        System.out.println("Added ribbons and gift wrapping.");
    }
    @Override
    public void unpack() {
        System.out.println("Carefully remove gift decorations.");
        super.unpack();
    }
}

public class GiftBoxDemo {
    public static void main(String[] args) {
        GiftBox g = new GiftBox();
        g.pack();
        g.unpack();
    }
}
