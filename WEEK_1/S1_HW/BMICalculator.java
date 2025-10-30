import java.util.Scanner;

class Person {
    private String name;
    private double heightCm;
    private double weightKg;

    public Person(String name, double heightCm, double weightKg) {
        this.name = name;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
    }

    public double calculateBMI() {
        double heightM = heightCm / 100.0;
        return weightKg / (heightM * heightM);
    }

    public String getBMICategory() {
        double bmi = calculateBMI();
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal weight";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public void displayInfo() {
        double bmi = calculateBMI();
        System.out.printf("\nName: %s\nHeight: %.2f cm\nWeight: %.2f kg\nBMI: %.2f\nCategory: %s\n",
                          name, heightCm, weightKg, bmi, getBMICategory());
    }
}

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter height (in cm): ");
        double height = scanner.nextDouble();

        System.out.print("Enter weight (in kg): ");
        double weight = scanner.nextDouble();

        Person person = new Person(name, height, weight);
        person.displayInfo();

        scanner.close();
    }
}