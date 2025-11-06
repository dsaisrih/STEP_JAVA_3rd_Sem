import java.util.Objects;

public class CardGame extends Game {
    private String deckType;

    public CardGame(String name, int players, String deckType) {
        super(name, players);
        this.deckType = deckType;
    }

    @Override
    public String toString() {
        return super.toString() + ", deckType='" + deckType + "'";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CardGame)) return false;
        if (!super.equals(o)) return false;
        CardGame c = (CardGame) o;
        return Objects.equals(deckType, c.deckType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deckType);
    }

    public static void main(String[] args) {
        CardGame c1 = new CardGame("Poker", 4, "Standard");
        CardGame c2 = new CardGame("Poker", 4, "Standard");
        System.out.println(c1);
        System.out.println("Equals? " + c1.equals(c2));
    }
}