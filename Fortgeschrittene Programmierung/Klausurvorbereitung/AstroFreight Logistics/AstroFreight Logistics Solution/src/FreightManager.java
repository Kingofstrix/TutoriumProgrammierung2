import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FreightManager {

    // TODO AUFGABE 1: Datentypen
    // Deklariere ein Set vom Typ CargoMission namens 'missions' und initialisiere es als HashSet.
    private Set<CargoMission> missions = new HashSet<>();

    // TODO AUFGABE 1: addMission Methode
    // Füge die übergebene Mission zum Set hinzu.
    /* THEORIE-FRAGE HIER:
       Warum funktioniert die Duplikat-Prüfung (equals/hashCode) automatisch?
       -> Weil der Java-Compiler für Records automatisch die Methoden equals() und hashCode()
          basierend auf allen definierten Attributen generiert. Zwei Record-Instanzen gelten
          als gleich (equals == true und gleicher Hash), wenn die Werte all ihrer Felder identisch sind.
    */
    public void addMission(CargoMission mission) {
        missions.add(mission);
        System.out.println("Neue Größe: " + missions.size());
    }

    // TODO AUFGABE 2: getHeaviestMissionTo Methode
    // Nutze Streams auf deinem Set
    public CargoMission getHeaviestMissionTo(String planet) {
        Optional<CargoMission> max = missions.stream()
                .filter(m -> m.planet().equals(planet))
                .max(Comparator.comparingDouble(m -> m.payloadKg()));

        // oder .max(Comparator.comparingDouble(CargoMission::payloadKg));
        // oder .max((m1, m2) -> Double.compare(m1.payloadKg(), m2.payloadKg()));

        return max.orElse(null);
    }

    // TODO AUFGABE 3: getAveragePayloadPerPlanet Methode
    // Nutze Streams auf deinem Set
    // Tipp: Gruppieren mit Collectors.groupingBy
    // Tipp: Collectors.averagingDouble
    public Map<String, Double> getAveragePayloadPerPlanet() {
        return missions.stream()
                .collect(Collectors.groupingBy(
                        cargoMission -> cargoMission.planet(),
                        Collectors.averagingDouble(cargoMission -> cargoMission.payloadKg())
                ));
    }

    // TODO AUFGABE 4.1 & 4.2: generateUrgencyReport Methode
    // Nutze Streams auf deinem Set
    // Tipp: .forEach() um auf jedem Stream-Element eine Aktion auszuführen
    public void generateUrgencyReport() {
        Predicate<CargoMission> isUrgent = m -> m.urgency() >= 4;
        Function<CargoMission, String> formatReport = m ->
                "ACHTUNG: " + m.missionId() + " zum " + m.planet() + " mit " + m.payloadKg() + "kg Fracht!";
        Consumer<String> printAlert = alert -> System.out.println("DASHBOARD-ANZEIGE: " + alert);

        missions.stream()
                .filter(isUrgent)
                .sorted(Comparator.comparing(CargoMission::missionId))
                .map(formatReport)
                .forEach(printAlert);
    }
}