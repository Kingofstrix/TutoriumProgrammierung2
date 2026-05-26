import java.util.Optional;

record SpaceSuit(String model, double oxygenLevel) {}

class Astronaut {
    public String name;
    public Optional<SpaceSuit> suit;

    public Astronaut(String name) {
        
    }

    public Astronaut(String name, SpaceSuit suit) {
        
    }

    public String toString() {
        
        return null;
    }

    public boolean isReadyForSpacewalk() {
        
        return false;
    }
}

public class Task01 {
    public static void main(String[] args) {
        
    }
}