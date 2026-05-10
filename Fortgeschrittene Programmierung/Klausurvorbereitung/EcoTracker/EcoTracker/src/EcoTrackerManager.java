import java.nio.file.Path;
import java.util.*;

public class EcoTrackerManager {

    // TODO Erstelle einen globalen Logger für diese Klasse
    // private static final Logger LOGGER =

    // Globale observations Liste
    private final List<AnimalObservation> observations = new ArrayList<>();

    // TODO AUFGABE 1: Exceptions & Logging
    // TODO: Prüfe ob count < 1. Wenn ja, werfe die InvalidObservationException.
    // TODO: Logge (Level WARNING), falls der Fehler auftritt.
    // TODO: Füge die Beobachtung zur Liste hinzu und logge (Level INFO) den Erfolg.


    // TODO AUFGABE 2: Comparator & Datenstrukturen
    // TODO: Erstelle einen Comparator für AnimalObservation (Sortierung: 1. species (A-Z), 2. count (absteigend))
    // TODO: Erstelle eine TreeMap und übergebe den Comparator
    // TODO: Iteriere über die Liste 'observations' und füge sie in die TreeMap ein. Value: "Sichtung bestätigt"
    // TODO: Gib die Map zurück


    // TODO AUFGABE 3: Funktionale Programmierung & Streams
    // TODO: Erstelle eine Variable vom Typ Predicate, die auf "Wolf" oder "Bär" prüft.
    // TODO: Erstelle eine Variable vom Typ Function, die den String formatiert.
    // TODO: Nutze die Stream API, wende Predicate und Function an und sammle die Ergebnisse in einer Liste.


    // TODO AUFGABE 4: IO-Operationen
    // TODO: Schreibe die Liste 'alerts' zeilenweise in die Datei
    // TODO: Lies die Datei anschließend aus
    // TODO: Iteriere über das Ergebnis des Lesens und gib die Zeilen aus.
    // TODO: Fange mögliche IOExceptions mit einem try-catch-Block ab.
    public void saveAndReadAlerts(List<String> alerts) {
        Path filePath = Path.of("alerts.txt");

    }
}