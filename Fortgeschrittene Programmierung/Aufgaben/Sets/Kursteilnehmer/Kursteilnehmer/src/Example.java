package src;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example {
  public static void main(String[] args) {

    // Teil 1 Anaylse des bestehenden Codes
    HashSet<Integer> WDS125 = new HashSet<>(Set.of(1, 2, 3, 4));
    HashSet<Integer> WDS225 = new HashSet<>(Set.of(2, 3, 5));

    HashSet<Integer> union = new HashSet<>(WDS125);
    union.addAll(WDS225);


    HashSet<Integer> intersection = new HashSet<>(WDS125);
    intersection.retainAll(WDS225);


    HashSet<Integer> difference = new HashSet<>(WDS125);
    difference.removeAll(WDS225);

    // Teil 2 Praktische Anwendung(Erweiterung)
    
  }

}