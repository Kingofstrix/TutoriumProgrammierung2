import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

enum MissionType {
    EXPLORATION, RESUPPLY, MAINTENANCE, COLONIZATION;

    public static List<MissionType> getDangerousTypes() {
        return List.of(MissionType.EXPLORATION, MissionType.MAINTENANCE);
    }
}

record Mission(String name, MissionType type, double budget) {

    // TODO: Predicate isDangerous (statisch)

    // TODO: Function cutBudget (statisch)

    public static Predicate<Mission> isMoreExpensiveThan(double amount) {
        // TODO: Gebe Predicate zurück
        return null;
    }

    public static Stream<Mission> getMissions() {
        // TODO: Gebe einen Stream mit einer Mission zurück
        return null;
    }
}

public class Task02 {
    public static void main(String[] args) {
        // TODO: Stream Pipeline aufbauen
    }
}