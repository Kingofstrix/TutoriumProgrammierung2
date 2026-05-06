import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Example {
    
    public static void main(String[] args) {
    Map<String, Double> studentGrades = new HashMap<>();
    // add value by key
    studentGrades.put("Steffen", 3.4);
    studentGrades.put("Steffen", 4.4); 
    studentGrades.put("Marianna", 1.4);
    studentGrades.put("Mirco", 5.4);

    // get value by key
    double gradeOfSteffen = studentGrades.get("Steffen");
    System.out.println(gradeOfSteffen);

    // remove value by key
    studentGrades.remove("Steffen");

    // all keys
    Set<String> keys = studentGrades.keySet();
    for (String key : keys) {
      System.out.println(key);
    }

    // all values
    Collection<Double> values = studentGrades.values();
    for (Double value : values) {
      System.out.println(value);
    }

    // all entries
    Set<Map.Entry<String, Double>> entries = studentGrades.entrySet();
    for (Map.Entry<String, Double> entry : entries) {
      System.out.println("Key: " + entry.getKey());
      System.out.println("Value: " + entry.getValue());
    }

    // get number of entries
    int numberOfEntries = studentGrades.size();
    System.out.println(numberOfEntries);

    // remove all entries
    studentGrades.clear();

   //Aufgabe: Überprüfen, ob ein Schlüssel existiert
    String studentName = "Darian";
    if (studentGrades.containsKey(studentName)) {
      double grade = studentGrades.get(studentName);
      System.out.println("Die Note von " + studentName + " ist: " + grade);
    } else {
      System.out.println("Fehler: Student " + studentName + " existiert nicht.");
    }

    //Praktische Anwendung: Notenverwaltungssystem
    Map<String, Double> grades = new HashMap<>();
    grades.put("Flo", 3.4);
    grades.put("Jonas", 1.4);
    grades.put("Darian", 5.4);
    grades.put("Steffen", 4.4);
    grades.put("Anna", 1.0);

    //Flo hat eine Nachkorrektur erhalten. Ändern Sie seine Note von `3.4` auf `4.0` [cite: 1].
    grades.put("Flo", 4.0);

    //Iterieren Sie über alle **Values** der Map und berechnen Sie die Durchschnittsnote des Kurses [cite: 1].
    double sum = 0;
    for (Double grade : grades.values()) {
        sum += grade;
    }
    double average = sum / grades.size();
    System.out.println("Die Durchschnittsnote des Kurses ist: " + average);

    //eben Sie alle Studenten (Name und Note) aus, die eine Note besser oder gleich `4.0` haben. Nutzen Sie dafür das `entrySet()` [cite: 1].
    System.out.println("Studenten mit Note besser oder gleich 4.0:");
    for (Map.Entry<String, Double> entry : grades.entrySet()) {
        if (entry.getValue() <= 4.0) {
            System.out.println("Name: " + entry.getKey() + ", Note: " + entry.getValue());
        }
    }

    //Drucken Sie eine alphabetisch sortierte Liste aller Studenten, die am Kurs teilgenommen haben (Hinweis: Nutzen Sie `keySet()`) [cite: 1].
    System.out.println("Alphabetisch sortierte Liste aller Studenten:");
    Set<String> studentNames = grades.keySet();
    studentNames.stream().sorted().forEach(System.out::println);
}
}


