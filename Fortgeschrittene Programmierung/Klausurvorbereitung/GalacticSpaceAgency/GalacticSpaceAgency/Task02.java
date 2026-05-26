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

    

    

    public static Predicate<Mission> isMoreExpensiveThan(double amount) {
        
        return null;
    }

    public static Stream<Mission> getMissions() {
        
        return null;
    }
}

public class Task02 {
    public static void main(String[] args) {
        
    }
}