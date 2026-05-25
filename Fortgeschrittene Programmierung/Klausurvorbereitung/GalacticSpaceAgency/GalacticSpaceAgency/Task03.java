import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

record CrewMember(String name, double salary, List<String> skills) {}
record SpaceShip(String name, int launchYear, Map<String, Integer> cargo) {}

record SpaceAgency(List<SpaceShip> ships, List<CrewMember> crew) {

    public double q1() {
        // TODO: Durchschnittsgehalt Piloting / Navigation
        return 0.0;
    }

    public void q2() {
        // TODO: Top 2 Mechanic mit niedrigstem Gehalt grüßen
    }

    public Map<Character, List<CrewMember>> q3() {
        // TODO: Gruppieren nach erstem Buchstaben (ohne Leadership)
        return null;
    }

    public Optional<CrewMember> q4(String skill) {
        // TODO: Kosteneffizientestes Crewmitglied für Skill
        return null;
    }

    public List<String> q5() {
        // TODO: Raumschiffe mit schwerem Cargo (>1000) großgeschrieben
        return null;
    }
}