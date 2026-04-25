import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example {
  public static void main(String[] args) {

    // Teil 1 Anaylse des bestehenden Codes
    Set<Integer> WDS125 = new HashSet<Integer>(List.of(1, 2, 3, 4));
    Set<Integer> WDS225 = new HashSet<Integer>(List.of(2, 3, 5));

    Set<Integer> union = new HashSet<Integer>(WDS125);
    union.addAll(WDS225);
    

    Set<Integer> intersection = new HashSet<Integer>(WDS125);
    intersection.retainAll(WDS225);
    

    Set<Integer> difference = new HashSet<Integer>(WDS125);
    difference.removeAll(WDS225);

    // Teil 2 Praktische Anwendung(Erweiterung)
    
  }

}