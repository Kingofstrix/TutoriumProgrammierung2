package RPG_Gilde;

import java.util.List;

public class Example {

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
        // Unsere Testdaten
        List<Hero> guild = List.of(
            new Hero("Thorin", "Warrior", 45, 1500.50, true),
            new Hero("Gandalf", "Mage", 99, 50.00, true),
            new Hero("Gollum", "Rogue", 15, 0.0, false),
            new Hero("Legolas", "Archer", 40, 2000.00, true),
            new Hero("Gimli", "Warrior", 42, 1200.75, true),
            new Hero("Saruman", "Mage", 85, 9500.00, false),
            new Hero("Robin", "Archer", 25, 300.20, true)
        );

        System.out.println("--- RPG Gilden-Verwaltung (Einsteiger) ---\n");

        // AUFGABE 1: Wer ist noch im Rennen? 
        // TODO: Filtere nach Helden, die noch leben (isAlive) und gib sie aus.
        System.out.println("1. Lebende Helden:");
        

        
        // AUFGABE 2: Zähle die Krieger 
        // TODO: Wie viele Helden haben die Rolle "Warrior"?
        long warriorCount = 0; // Hier Stream einbauen
        System.out.println("\n2. Anzahl der Krieger: " + warriorCount);


        // AUFGABE 3: Die Namensliste 
        // TODO: Erstelle eine Liste, die NUR die Namen der Helden enthält.
        List<String> names = null; // Hier Stream einbauen
        System.out.println("\n3. Nur die Namen: " + names);


        // AUFGABE 4: Reich oder Arm? 
        // TODO: Gibt es mindestens einen Helden, der mehr als 5000 Gold hat?
        boolean hasRichHero = false; // Hier Stream einbauen
        System.out.println("\n4. Gibt es reiche Helden (> 5000 Gold)? " + hasRichHero);


        // ZUSATZAUFGABE 5: Die Top 3 
        // TODO: Finde die 3 Helden mit dem höchsten Level.
        System.out.println("\n5. Die Top 3 Helden nach Level:");
        
    }
}