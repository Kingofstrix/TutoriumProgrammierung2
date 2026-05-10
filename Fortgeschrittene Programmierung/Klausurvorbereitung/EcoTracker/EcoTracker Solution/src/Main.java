import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        System.setErr(System.out);

        System.out.println("=== EcoTracker System Start ===");
        EcoTrackerManager manager = new EcoTrackerManager();

        // 1. Daten
        try {
            manager.addObservation(new AnimalObservation("Fuchs", "Sektor A", 3));
            manager.addObservation(new AnimalObservation("Wolf", "Sektor B", 2));
            manager.addObservation(new AnimalObservation("Fuchs", "Sektor B", 1));
            manager.addObservation(new AnimalObservation("Bär", "Sektor C", 1));

            manager.addObservation(new AnimalObservation("Reh", "Sektor A", 0));
        } catch (InvalidObservationException e) {
            System.out.println("[Catch] Erwarteter Fehler gefangen: " + e.getMessage());
        }

        // 2. TreeMap Test
        System.out.println("\n--- TreeMap Sortierung ---");
        TreeMap<AnimalObservation, String> treeMap = manager.getGroupedObservations();
        if(treeMap != null) {
            treeMap.forEach((obs, note) ->
                    System.out.println(obs.species() + " (" + obs.count() + ") -> " + note)
            );
        }

        // 3. Streams & Funktionen
        System.out.println("\n--- Warnliste (Streams) ---");
        List<String> alerts = manager.generateAlertList();
        for (String alert : alerts) {
            System.out.println(alert);
        }

        // 4. IO-Operationen
        System.out.println("\n--- Datei Export & Import ---");
        manager.saveAndReadAlerts(alerts);
    }
}