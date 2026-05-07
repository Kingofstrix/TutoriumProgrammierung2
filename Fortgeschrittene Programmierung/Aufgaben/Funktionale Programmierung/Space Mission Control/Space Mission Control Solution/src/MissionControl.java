package src;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MissionControl {

    // ==========================================
    // AUFGABE 1: Standard-Interfaces als Variablen
    // ==========================================

    // TODO: Schreibe ein Predicate, das true liefert, wenn fuelLevel < 20.0 ist
    public final Predicate<Spaceship> isLowOnFuel =
            ship -> ship.fuelLevel() < 20.0;

    // TODO: Schreibe eine Function, die einen Status-String generiert
    public final Function<Spaceship, String> generateStatusReport =
            ship -> "Raumschiff " + ship.name() + " (Klasse: " + ship.shipClass() + ") - Schild: " + ship.shieldPercentage() + "%";

    // TODO: Schreibe einen Consumer, der eine Warnung auf der Konsole ausgibt
    public final Consumer<Spaceship> sendWarningSign =
            ship -> System.out.println("WARNUNG: " + ship.name() + " benötigt sofortige Wartung!");


    // ==========================================
    // AUFGABE 2: Eigenes Functional Interface
    // ==========================================

    // TODO: Definiere in einer eigenen Datei das Interface 'FleetCommander'
    // TODO: Lege eine Variable vom Typ 'FleetCommander' an und implementiere sie mit einem Lambda.
    public final FleetCommander defaultCommander =
            (ship, destination, crew) -> crew > 2 && !destination.equalsIgnoreCase("Black Hole");

    // ==========================================
    // AUFGABE 3: High-Order Function
    // ==========================================

    // TODO: Implementiere die Methode processFleet.
    public void processFleet(List<Spaceship> fleet, Predicate<Spaceship> filter, Consumer<Spaceship> action) {
        for (Spaceship ship : fleet) {
            if (filter.test(ship)) {
                action.accept(ship);
            }
        }
    }
    // Alternative Lösung mit Streams:
    public void processFleetWithStreams(List<Spaceship> fleet, Predicate<Spaceship> filter, Consumer<Spaceship> action) {
        fleet.stream().filter(filter).forEach(action);
    }

    // ==========================================
    // TESTLAUF (Main Methode zum Ausprobieren)
    // ==========================================
    public static void main(String[] args) {
        MissionControl missionControl = new MissionControl();

        List<Spaceship> myFleet = List.of(
                new Spaceship("Apollo", "Explorer", 45.0, 100),
                new Spaceship("Icarus", "Fighter", 12.5, 40),
                new Spaceship("Voyager", "Cruiser", 88.0, 95)
        );

        System.out.println("--- Space Mission Control gestartet ---");

        System.out.println("1. Statusbericht aller Schiffe (ohne Filter):");
        for (Spaceship ship : myFleet) {
            System.out.println(missionControl.generateStatusReport.apply(ship));
        }
        System.out.println();

        System.out.println("2. Flotte auf Treibstoff prüfen (High-Order Function):");
        // Wir übergeben das WIE als Parameter, nicht die Daten selbst!
        missionControl.processFleet(myFleet, missionControl.isLowOnFuel, missionControl.sendWarningSign);
        System.out.println();


        System.out.println("3. Mission prüfen:");
        Spaceship Apollo = myFleet.get(0);
        boolean canLaunch = missionControl.defaultCommander.assignMission(Apollo, "Mars", 5);
        System.out.println("Mission zum Mars mit Crew 5 gestattet? " + canLaunch);
    }
}
