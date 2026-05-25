import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

record CrewMember(String name, double salary, List<String> skills) {}
record SpaceShip(String name, int launchYear, Map<String, Integer> cargo) {}

record SpaceAgency(List<SpaceShip> ships, List<CrewMember> crew) {

    public double q1() {
        return crew.stream()
            .filter(member -> member.skills().stream()
                .anyMatch(skill -> List.of("Piloting", "Navigation").contains(skill)))
            .mapToDouble(CrewMember::salary)
            .average()
            .orElse(0.0);
    }

    public void q2() {
        crew.stream()
            .filter(member -> member.skills().contains("Mechanic"))
            .sorted((c1, c2) -> Double.compare(c1.salary(), c2.salary()))
            .limit(2)
            .map(member -> "Gute Arbeit " + member.name() + "! Hier ist ein Bonus.")
            .forEach(System.out::println);
    }

    public Map<Character, List<CrewMember>> q3() {
        return crew.stream()
            .filter(member -> !member.skills().contains("Leadership"))
            .collect(Collectors.groupingBy(member -> member.name().charAt(0)));
    }

    public Optional<CrewMember> q4(String skill) {
        return crew.stream()
            .filter(member -> member.skills().contains(skill))
            .min((c1, c2) -> {
                double r1 = c1.salary() / c1.skills().size();
                double r2 = c2.salary() / c2.skills().size();
                return Double.compare(r1, r2);
            });
    }

    public List<String> q5() {
        return ships.stream()
            .filter(ship -> ship.cargo().values().stream().anyMatch(weight -> weight > 1000))
            .map(ship -> ship.name().toUpperCase())
            .distinct()
            .toList();
    }
}

public class Task03 {
    public static void main(String[] args) {
        SpaceShip ship1 = new SpaceShip("Explorer", 2020, Map.of("Food", 500, "Equipment", 1500));
        SpaceShip ship2 = new SpaceShip("Voyager", 2021, Map.of("Food", 300, "Equipment", 800));
        SpaceShip ship3 = new SpaceShip("Pioneer", 2019, Map.of("Food", 200, "Equipment", 1200));

        CrewMember member1 = new CrewMember("Alice", 70000, List.of("Piloting", "Navigation"));
        CrewMember member2 = new CrewMember("Bob", 60000, List.of("Mechanic"));
        CrewMember member3 = new CrewMember("Charlie", 80000, List.of("Leadership"));
        CrewMember member4 = new CrewMember("Dave", 55000, List.of("Mechanic", "Piloting"));

        SpaceAgency agency = new SpaceAgency(List.of(ship1, ship2, ship3), List.of(member1, member2, member3, member4));

        System.out.println("Q1: Average Salary: " + agency.q1());
        System.out.println("\nQ2:");
        agency.q2();
        System.out.println("\nQ3: Grouped by Initial: " + agency.q3());
        System.out.println("\nQ4: Cheapest Mechanic: " + agency.q4("Mechanic").orElse(null));
        System.out.println("\nQ5: Ships with Heavy Cargo: " + agency.q5());
    }
}