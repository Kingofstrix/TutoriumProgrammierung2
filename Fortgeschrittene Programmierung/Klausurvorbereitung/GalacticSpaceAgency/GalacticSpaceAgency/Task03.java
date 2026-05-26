import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

record CrewMember(String name, double salary, List<String> skills) {}
record SpaceShip(String name, int launchYear, Map<String, Integer> cargo) {}

record SpaceAgency(List<SpaceShip> ships, List<CrewMember> crew) {

    public double q1() {
        
        return 0.0;
    }

    public void q2() {
        
    }

    public Map<Character, List<CrewMember>> q3() {
        
        return null;
    }

    public Optional<CrewMember> q4(String skill) {
        
        return null;
    }

    public List<String> q5() {
        
        return null;
    }
}