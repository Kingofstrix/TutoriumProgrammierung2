import java.util.Optional;

record SpaceSuit(String model, double oxygenLevel) {}

class Astronaut {
    public String name;
    public Optional<SpaceSuit> suit;

    public Astronaut(String name) {
        // TODO: Initialisiere Konstruktor
    }

    public Astronaut(String name, SpaceSuit suit) {
        // TODO: Initialisiere Konstruktor mit Optional
    }

    public String toString() {
        // TODO: Gebe den Namen und falls vorhanden das Modell des Raumanzugs zurück
        return null;
    }

    public boolean isReadyForSpacewalk() {
        // TODO: Prüfe ob Anzug vorhanden und Sauerstoff > 50.0
        return false;
    }
}

public class Task01 {
    public static void main(String[] args) {
        // TODO: Astronaut Buzz mit Anzug erstellen und testen
    }
}