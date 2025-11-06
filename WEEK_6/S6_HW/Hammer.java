public class Hammer extends Tool {
    public void testAccess() {
        // System.out.println(serial);   // ❌ private – not accessible
        System.out.println("Protected type: " + type);   // ✅
        System.out.println("Public brand: " + brand);    // ✅
        System.out.println("Private via getter: " + getSerial()); // ✅
    }

    public static void main(String[] args) {
        new Hammer().testAccess();
    }
}