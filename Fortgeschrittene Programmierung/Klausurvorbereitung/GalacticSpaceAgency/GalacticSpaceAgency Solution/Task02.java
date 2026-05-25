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

    public static Predicate<Mission> isDangerous = m -> MissionType.getDangerousTypes().contains(m.type());

    public static Function<Mission, Mission> cutBudget = m -> new Mission(m.name() + " (Budget Cut)", m.type(), m.budget() * 0.8);

    public static Predicate<Mission> isMoreExpensiveThan(double amount) {
        return m -> m.budget() > amount;
    }

    public static Stream<Mission> getMissions() {
        return Stream.of(new Mission("Apollo 20", MissionType.EXPLORATION, 500.0));
    }
}

public class Task02 {
    public static void main(String[] args) {
        Mission.getMissions()
                .map(Mission.cutBudget)
                .filter(Mission.isDangerous)
                .filter(Mission.isMoreExpensiveThan(300.0))
                .forEach(System.out::println);
    }
}