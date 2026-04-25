import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example {
  public static void main(String[] args) {

    Set<Integer> WDS125 = new HashSet<Integer>(List.of(1, 2, 3, 4));
    Set<Integer> WDS225 = new HashSet<Integer>(List.of(2, 3, 5));

    // Union -> Werte nicht doppelt, da es sich um die Vereinigung von zwei Mengen handelt
    Set<Integer> union = new HashSet<Integer>(WDS125);
    union.addAll(WDS225);
    printValuesInSet(union);

    // Intersection -> Werte, die in beiden Mengen vorkommen
    Set<Integer> intersection = new HashSet<Integer>(WDS125);
    intersection.retainAll(WDS225);
    printValuesInSet(intersection);

    // Difference -> Werte, die in der ersten Menge vorkommen, aber nicht in der zweiten
    Set<Integer> difference = new HashSet<Integer>(WDS125);
    difference.removeAll(WDS225);
    printValuesInSet(difference);

    // Teil 2 Praktische Anwendung(Erweiterung)
    Set<Integer> WDS125_Java1 = new HashSet<Integer>(List.of(101, 102, 103, 104, 105));
    Set<Integer> WDS125_Java2 = new HashSet<Integer>(List.of(103, 104, 106, 107));

    // Exklusivität -> Welche Studenten besuchen nur den Kurs Java 1(also nicht Java 2)?
    Set<Integer> exklusive = new HashSet<Integer>(WDS125_Java1);
    exklusive.removeAll(WDS125_Java2);
    printValuesInSet(exklusive);

    // Gesamtübersicht -> Erstellen Sie ein Set, das alle eindeutigen Matrikel Nr. aus beiden Kursen enthält.
    Set<Integer> totalOverview = new HashSet<Integer>(WDS125_Java1);
    totalOverview.addAll(WDS125_Java2);
    printValuesInSet(totalOverview);

    // Überschneidung -> Welche Studenten besuchen beide Kurse gleichzeitig?
    Set<Integer> overlap = new HashSet<Integer>(WDS125_Java1);
    overlap.retainAll(WDS125_Java2);
    printValuesInSet(overlap);

    // Symmetrische Differenz -> Finden Sie alle Studenten, die entweder Java 1 oder Java 2 besuchen, aber nicht beide gleichzeitig.
    Set<Integer> symmetricDifference = new HashSet<Integer>(totalOverview);
    symmetricDifference.removeAll(overlap);
    printValuesInSet(symmetricDifference);
  
  }
  // Hilfsmethode zum Ausgeben der Werte in einem Set
  private static void printValuesInSet(Set<Integer> numbers) {
    System.out.println("Values in Set: " + numbers.size());
    for (Integer number : numbers) {
      System.out.println(number);
    }
    System.out.println();
   }
  
}