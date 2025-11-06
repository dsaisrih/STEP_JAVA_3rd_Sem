public class AdvancedMath extends BasicMath {
    public double calculate(double a, double b, double c) {
        return a * b * c;
    }
    public double calculate(double a) {
        return Math.sqrt(a);
    }

    public static void main(String[] args) {
        AdvancedMath am = new AdvancedMath();
        System.out.println(am.calculate(2,3));
        System.out.println(am.calculate(2.5,3.5));
        System.out.println(am.calculate(2,3,4));
        System.out.println(am.calculate(2.0,3.0,4.0));
        System.out.println(am.calculate(16.0));
    }
}