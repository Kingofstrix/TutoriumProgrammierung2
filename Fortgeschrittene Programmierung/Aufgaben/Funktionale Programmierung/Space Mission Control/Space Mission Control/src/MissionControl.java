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

    // TODO: Schreibe eine Function, die einen Status-String generiert

    // TODO: Schreibe einen Consumer, der eine Warnung auf der Konsole ausgibt

    // ==========================================
    // AUFGABE 2: Eigenes Functional Interface
    // ==========================================

    // TODO: Definiere in einer eigenen Datei das Interface 'FleetCommander'
    // TODO: Lege eine Variable vom Typ 'FleetCommander' an und implementiere sie mit einem Lambda.

    // ==========================================
    // AUFGABE 3: High-Order Function
    // ==========================================

    // TODO: Implementiere die Methode processFleet.
    // Tipps: .test() führt Predicates aus
    // Tipps: .accept() führt Consumer aus


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

        // Tests können hier reingeschrieben werden. Z.b. processFleet(...)
    }
}
