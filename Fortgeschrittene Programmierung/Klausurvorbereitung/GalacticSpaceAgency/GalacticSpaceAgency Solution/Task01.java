import java.util.Optional;

record SpaceSuit(String model, double oxygenLevel) {}

class Astronaut {
    public String name;
    public Optional<SpaceSuit> suit;

    public Astronaut(String name) {
        this(name, null);
    }

    public Astronaut(String name, SpaceSuit suit) {
        this.name = name;
        this.suit = Optional.ofNullable(suit);
    }

    public String toString() {
        if (suit.isPresent()) {
            return String.join(" ", name, suit.get().model());
        } else {
            return this.name;
        }
    }

    public boolean isReadyForSpacewalk() {
        return suit.isPresent() && suit.get().oxygenLevel() > 50.0;
    }
}

public class Task01 {
    public static void main(String[] args) {
        Astronaut buzz = new Astronaut("Buzz", new SpaceSuit("EVA-Mark3", 100.0));
        System.out.println(buzz);
        
        buzz.suit = Optional.empty();
        
        if (buzz.isReadyForSpacewalk()) {
            System.out.println("Warnung: Buzz ist bereit, aber hat keinen Anzug!");
        } else {
            System.out.println("Buzz ist nicht bereit (Korrektes Verhalten).");
        }
    }
}