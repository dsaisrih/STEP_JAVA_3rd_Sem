package pets;

public class Main {
    public static void main(String[] args) {
        VirtualPet pet1 = new VirtualPet("Buddy", new PetSpecies(
                "Dog", VirtualPet.DEFAULT_EVOLUTION_STAGES, 300, "House"));
        System.out.println("VirtualPet created: " + pet1);

        DragonPet dragon = new DragonPet("Draco", "Fire", "Flame Breath");
        System.out.println("DragonPet created: " + dragon);

        RobotPet robot = new RobotPet("Robo");
        System.out.println("RobotPet created: " + robot);

        pet1.feedPet("Bone");
        pet1.playWithPet("Fetch");
        System.out.println("After playing with Buddy: " + pet1);

        robot.setBatteryLevel(50);
        robot.setNeedsCharging(true);
        System.out.println("Updated RobotPet: " + robot);

        dragon.getCorePet().playWithPet("Fly");
        System.out.println("After playing with Dragon: " + dragon);
    }
}
