# Übungsaufgabe: Mengenoperationen mit dem Java Set-Interface

## Kontext
In der Softwareentwicklung werden häufig Datenmengen miteinander verglichen, kombiniert oder voneinander abgezogen. In Java bietet das `Set`-Interface (hier speziell die Implementierung `HashSet`) mächtige Methoden, um mathematische Mengenoperationen effizient abzubilden.

## Lernziele
* Verstehen der Funktionsweise von `HashSet`.
* Anwendung von Mengenoperationen: Vereinigung, Schnittmenge und Differenzmenge.
* Umgang mit der Ungeordnetheit und Einzigartigkeit von Elementen in Sets.

---

## Aufgabenstellung

Basierend auf der bereitgestellten Klasse `Example` sollen Sie ein Programm zur Verwaltung von Kurs-Teilnehmerlisten erweitern.

### Teil 1: Analyse des bestehenden Codes
Betrachten Sie den Code in der `Example.java`. Analysieren Sie die Ausgaben für die drei Operationen:
1.  **Union (Vereinigung):** Welche Elemente befinden sich in `union`? Warum ist die `2` und `3` nicht doppelt vorhanden?
2.  **Intersection (Schnittmenge):** Welche Elemente bleiben in `intersection` übrig?
3.  **Difference (Differenz):** Welche Elemente befinden sich in `difference`? Was passiert, wenn man `b.removeAll(a)` statt `a.removeAll(b)` aufrufen würde?
4.  **Ausgabe der Sets** Implementieren Sie die Methode printValuesInSet(Set<Integer> numbers) welche die Anzahl der Werte und zusätzlich die einzelenen Werte in deb einzelenen Sets in der Konsole ausgibt. Kontrollieren Sie ihre Antworten aus Teil 1. mit der Ausgabe in der Konsole.

### Teil 2: Praktische Anwendung (Erweiterung)
Stellen Sie sich vor, Sie verwalten zwei Kurse an der DHBW:
* **Kurs WDS125 (Java 1):** Matrikel Nr.: `101, 102, 103, 104, 105`
* **Kurs WDS125 (Java 2):** Matrikel Nr.: `103, 104, 106, 107`
Erstellen sie zwei Sets und fügen sie die Matrikel Nr. hinzu.

Erweitern Sie den Code, um folgende Fragen programmatisch zu beantworten:

1.  **Exklusivität:** Welche Studenten besuchen *nur* den Kurs Java 1(also nicht Java 2)?
2.  **Gesamtübersicht:** Erstellen Sie ein Set, das alle eindeutigen Matrikel Nr. aus beiden Kursen enthält.
3.  **Überschneidung:** Welche Studenten besuchen beide Kurse gleichzeitig?
4.  **Symmetrische Differenz (Zusatz):** Finden Sie alle Studenten, die *entweder* Java 1 oder Java 2 besuchen, aber nicht beide gleichzeitig. (Hinweis: Nutzen Sie eine Kombination aus den gelernten Operationen).

---

## Hinweise zur Implementierung
* Nutzen Sie `Set<Integer> a = new HashSet<>(List.of(...));` zur Initialisierung.
* Achten Sie darauf, beim Durchführen der Operationen Kopien der Sets zu erstellen (z. B. `new HashSet<>(a)`), da Methoden wie `addAll()` oder `removeAll()` das Set, auf dem sie aufgerufen werden, direkt verändern (*in-place*).