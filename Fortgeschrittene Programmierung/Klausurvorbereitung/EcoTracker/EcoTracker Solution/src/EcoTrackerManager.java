import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class EcoTrackerManager {

    // Erstellen des Loggers
    private static final Logger LOGGER = Logger.getLogger(EcoTrackerManager.class.getName());

    // Globale observations Liste
    private final List<AnimalObservation> observations = new ArrayList<>();

    // --- AUFGABE 1: Exceptions & Logging ---
    public void addObservation(AnimalObservation observation) throws InvalidObservationException {
        if (observation.count() < 1) {
            LOGGER.warning("Fehlgeschlagen: Anzahl < 1 bei Tierart " + observation.species());
            throw new InvalidObservationException("Die Anzahl der Tiere muss mindestens 1 betragen! Gemeldet: " + observation.count());
        }

        observations.add(observation);
        LOGGER.info("Erfolgreich hinzugefügt: " + observation.count() + " mal " + observation.species() + " in " + observation.area());
    }

    // --- AUFGABE 2: Comparator & Datenstrukturen ---
    public TreeMap<AnimalObservation, String> getGroupedObservations() {
        // Variante 1 Comparator (Fortgeschritten)
        Comparator<AnimalObservation> observationComparator = Comparator
                .comparing(AnimalObservation::species)
                .thenComparing(AnimalObservation::count, Comparator.reverseOrder());

        // Variante 2 Comparator
        Comparator<AnimalObservation> observationComparator2 = (obs1, obs2) -> {
            int speciesCompare = obs1.species().compareTo(obs2.species());
            if (speciesCompare != 0) {
                return speciesCompare;
            }
            return Integer.compare(obs2.count(), obs1.count());
        };

        TreeMap<AnimalObservation, String> groupedMap = new TreeMap<>(observationComparator2);

        for (AnimalObservation observation : observations) {
            groupedMap.put(observation, "Sichtung bestätigt");
        }

        return groupedMap;
    }

    // --- AUFGABE 3: Funktionale Programmierung & Streams ---
    public List<String> generateAlertList() {
        Predicate<AnimalObservation> isDeadly = observation ->
                observation.species().equalsIgnoreCase("Wolf") || observation.species().equalsIgnoreCase("Bär");

        Function<AnimalObservation, String> format = observation ->
                "ACHTUNG: " + observation.count() + " x " + observation.species() + " in " + observation.area() + " gesichtet!";


        List<String> deadlyObservationsFormatted = observations.stream()
                .filter(isDeadly)
                .map(format)
                .toList();

        return deadlyObservationsFormatted;
    }

    // --- AUFGABE 4: IO-Operationen ---
    public void saveAndReadAlerts(List<String> alerts) {
        Path filePath = Path.of("alerts.txt");

        LOGGER.info("Speichere " + alerts.size() + " Alerts in Datei: " + filePath);

        try {
            Files.write(filePath, alerts);

            List<String> readLines = Files.readAllLines(filePath);
            for (String line : readLines) {
                LOGGER.info("Gelesen aus Datei: " + line);
            }
            LOGGER.info(readLines.size() + " Zeilen gelesen aus Datei: " + filePath);
        } catch (IOException e) {
            LOGGER.severe("Fehler bei den IO-Operationen: " + e.getMessage());
        }
    }
}