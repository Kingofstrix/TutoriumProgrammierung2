import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== AstroFreight System Start ===");
        FreightManager manager = new FreightManager();

        // 1. Daten einfügen (Set Test)
        manager.addMission(new CargoMission("M-001", "Mars", 4500.5, 3));
        manager.addMission(new CargoMission("M-003", "Mars", 8200.0, 5));
        manager.addMission(new CargoMission("V-001", "Venus", 3100.0, 2));
        manager.addMission(new CargoMission("V-002", "Venus", 5000.0, 4));
        manager.addMission(new CargoMission("E-001", "Earth", 1200.0, 1));

        // Duplikat zum Testen des Sets: Wird nicht hinzugefügt, falls korrekt implementiert!
        manager.addMission(new CargoMission("M-001", "Mars", 4500.5, 3));

        // 3. Optional & Max Test
        System.out.println("\n--- Heaviest Mission to Mars ---");
        CargoMission heaviest = manager.getHeaviestMissionTo("Mars");
        if (heaviest != null) {
            System.out.println("Schwerste Mission: " + heaviest.missionId() + " mit " + heaviest.payloadKg() + "kg");
        } else {
            System.out.println("Keine Mission gefunden.");
        }

        // 4. GroupingBy & Averaging Test
        System.out.println("\n--- Average Payload per Planet ---");
        Map<String, Double> avgPayload = manager.getAveragePayloadPerPlanet();
        avgPayload.forEach((planet, avg) ->
            System.out.printf("%s: %.2f kg%n", planet, avg)
        );

        // 2 & 5. Urgency Report Test (Predicates & Functions)
        System.out.println("\n--- Urgency Report ---");
        manager.generateUrgencyReport();
    }
}