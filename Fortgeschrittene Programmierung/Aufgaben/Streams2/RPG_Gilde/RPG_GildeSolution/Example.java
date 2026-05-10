package RPG_GildeSolution;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

    // (Klasse Hero wie in der Übung übernommen)
    public static class Hero {
        private String name;
        private String role;
        private int level;
        private double gold;
        private boolean isAlive;

        public Hero(String name, String role, int level, double gold, boolean isAlive) {
            this.name = name;
            this.role = role;
            this.level = level;
            this.gold = gold;
            this.isAlive = isAlive;
        }

        public String getName() { return name; }
        public String getRole() { return role; }
        public int getLevel() { return level; }
        public double getGold() { return gold; }
        public boolean isAlive() { return isAlive; }

        @Override
        public String toString() {
            return name + " (" + role + ", Lvl " + level + ")";
        }
    }

    public static void main(String[] args) {
        List<Hero> guild = List.of(
            new Hero("Thorin", "Warrior", 45, 1500.50, true),
            new Hero("Gandalf", "Mage", 99, 50.00, true),
            new Hero("Gollum", "Rogue", 15, 0.0, false),
            new Hero("Legolas", "Archer", 40, 2000.00, true),
            new Hero("Gimli", "Warrior", 42, 1200.75, true),
            new Hero("Saruman", "Mage", 85, 9500.00, false),
            new Hero("Robin", "Archer", 25, 300.20, true)
        );

        System.out.println("--- LÖSUNG: RPG Gilden-Verwaltung (Einsteiger) ---\n");

        // AUFGABE 1: Filter & forEach
        System.out.println("1. Lebende Helden:");
        guild.stream()
             .filter(Hero::isAlive)        // Alternativ: hero -> hero.isAlive()
             .forEach(System.out::println);


        // AUFGABE 2: Filter & count
        long warriorCount = guild.stream()
             .filter(hero -> hero.getRole().equals("Warrior"))
             .count();
        System.out.println("\n2. Anzahl der Krieger: " + warriorCount);


        // AUFGABE 3: Map & collect
        List<String> names = guild.stream()
             .map(Hero::getName)           // Alternativ: hero -> hero.getName()
             .collect(Collectors.toList());
        System.out.println("\n3. Nur die Namen: " + names);


        // AUFGABE 4: anyMatch
        boolean hasRichHero = guild.stream()
             .anyMatch(hero -> hero.getGold() > 5000);
        System.out.println("\n4. Gibt es reiche Helden (> 5000 Gold)? " + hasRichHero);


        // ZUSATZAUFGABE 5: sorted & limit
        System.out.println("\n5. Die Top 3 Helden nach Level:");
        guild.stream()
             // Umgekehrt sortieren (höchstes Level zuerst)
             .sorted(Comparator.comparingInt(Hero::getLevel).reversed()) 
             .limit(3)
             .forEach(System.out::println);
    }
}
