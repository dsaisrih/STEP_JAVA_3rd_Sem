class HotelBooking {

    // Standard booking
    public void calculatePrice(String roomType, int nights) {
        double baseRate = getRoomRate(roomType);
        double cost = baseRate * nights;
        System.out.println("Standard Booking: " + roomType + ", Nights = " + nights + ", Cost = ₹" + cost);
    }

    // Seasonal booking
    public void calculatePrice(String roomType, int nights, double seasonalMultiplier) {
        double baseRate = getRoomRate(roomType);
        double cost = (baseRate * nights) * seasonalMultiplier;
        System.out.println("Seasonal Booking: " + roomType + ", Nights = " + nights + ", Multiplier = " + seasonalMultiplier + ", Cost = ₹" + cost);
    }

    // Corporate booking
    public void calculatePrice(String roomType, int nights, double discount, boolean mealPackage) {
        double baseRate = getRoomRate(roomType);
        double cost = baseRate * nights;
        double savings = (cost * discount) / 100;
        cost -= savings;
        if (mealPackage) cost += 200 * nights; // meals per night
        System.out.println("Corporate Booking: " + roomType + ", Nights = " + nights + ", Discount = " + discount + "%, Meal Package = " + mealPackage + ", Final Cost = ₹" + cost);
    }

    // Wedding package
    public void calculatePrice(String roomType, int nights, int guestCount, double decorationFee, double cateringPerGuest) {
        double baseRate = getRoomRate(roomType);
        double roomCost = baseRate * nights;
        double cateringCost = cateringPerGuest * guestCount;
        double total = roomCost + decorationFee + cateringCost;
        System.out.println("Wedding Package: " + roomType + ", Nights = " + nights + ", Guests = " + guestCount + ", Decoration = ₹" + decorationFee + ", Catering = ₹" + cateringCost + ", Total = ₹" + total);
    }

    private double getRoomRate(String roomType) {
        switch (roomType.toLowerCase()) {
            case "deluxe": return 3000;
            case "suite": return 5000;
            default: return 2000; // standard
        }
    }
}

public class Problem1 {
    public static void main(String[] args) {
        HotelBooking hb = new HotelBooking();
        hb.calculatePrice("Standard", 3);
        hb.calculatePrice("Deluxe", 2, 1.5);
        hb.calculatePrice("Suite", 5, 10, true);
        hb.calculatePrice("Deluxe", 2, 100, 5000, 800);
    }
}
