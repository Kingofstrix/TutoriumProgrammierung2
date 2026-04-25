import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Testdaten generieren (Filme)
        List<Movie> testMovies = List.of(
                new Movie("Inception", "Christopher Nolan", "Sci-Fi", 2010, 836.8),
                new Movie("Interstellar", "Christopher Nolan", "Sci-Fi", 2014, 701.8),
                new Movie("The Dark Knight", "Christopher Nolan", "Action", 2008, 1004.9),
                new Movie("Avatar", "James Cameron", "Sci-Fi", 2009, 2923.7),
                new Movie("Titanic", "James Cameron", "Romance", 1997, 2257.8),
                new Movie("Pulp Fiction", "Quentin Tarantino", "Crime", 1994, 213.9),
                new Movie("Django Unchained", "Quentin Tarantino", "Western", 2012, 425.4),
                new Movie("The Matrix", "Wachowskis", "Sci-Fi", 1999, 463.5)
        );

        // 2. Instanz der Queries-Klasse erstellen
        MovieQueries queries = new MovieQueries(testMovies);

        // 3. Methoden testen und formatierte Ausgabe
        System.out.println("=== JAVA STREAM API TESTLAUF ===\n");

        System.out.println("1. Sci-Fi Filme:");
        System.out.println("-> " + queries.getTitlesByGenre("Sci-Fi") + "\n");

        System.out.println("2. Top 2 Filme nach Einspielergebnis:");
        queries.getTopEarningMovies(2).forEach(m ->
                System.out.println("-> " + m.title() + " (" + m.boxOfficeInMillions() + " Mio)")
        );
        System.out.println();

        System.out.println("3. Gibt es einen Film von Quentin Tarantino?:");
        System.out.println("-> " + queries.hasMovieFromDirector("Quentin Tarantino") + "\n");

        System.out.println("4. Anzahl Filme nach 2010:");
        System.out.println("-> " + queries.countMoviesReleasedAfter(2010) + "\n");

        System.out.println("5. Durchschnittliches Einspielergebnis Sci-Fi (in Mio):");
        queries.getAverageEarningsByGenre("Sci-Fi").ifPresentOrElse(
                avg -> System.out.printf("-> %.2f Mio\n", avg),
                () -> System.out.println("-> Keine Filme gefunden")
        );
        System.out.println();

        System.out.println("6. Filme gruppiert nach Regisseur:");
        queries.groupMoviesByDirector().forEach((director, moviesList) -> {
            System.out.println("-> " + director + ": " + moviesList.size() + " Film(e)");
        });
        System.out.println();

        System.out.println("ZUSATZAUFGABE: Blockbuster chronologisch sortiert:");
        queries.getBlockbusterLabels().forEach(label -> System.out.println("-> " + label));
    }
}