package src;

@FunctionalInterface
public interface FleetCommander {

    boolean assignMission(Spaceship ship, String destination, int crew);
}
