class GameCharacter {
    // Attack with no weapon
    void attack() {
        System.out.println("Character attacks with fists!");
    }

    // Attack with weapon
    void attack(String weapon) {
        System.out.println("Character attacks with " + weapon + "!");
    }

    // Attack with weapon and power
    void attack(String weapon, int power) {
        System.out.println("Character attacks with " + weapon + " with power " + power);
    }
}

public class OverloadingDemo {
    public static void main(String[] args) {
        GameCharacter hero = new GameCharacter();
        hero.attack();
        hero.attack("Sword");
        hero.attack("Bow", 50);
    }
}
