import java.util.Objects;

public class Game {
    protected String name;
    protected int players;

    public Game(String name, int players) {
        this.name = name;
        this.players = players;
    }

    @Override
    public String toString() {
        return "Game{name='" + name + "', players=" + players + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Game)) return false;
        Game g = (Game) o;
        return players == g.players && Objects.equals(name, g.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, players);
    }
}
