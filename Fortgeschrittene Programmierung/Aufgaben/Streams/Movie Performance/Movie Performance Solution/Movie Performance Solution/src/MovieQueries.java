import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieQueries {

    private final List<Movie> movies;

    public MovieQueries(List<Movie> movies) {
        this.movies = movies;
    }

    // 1. Filtern: getTitlesByGenre
    public List<String> getTitlesByGenre(String genre) {
        return movies.stream()
                .filter(m -> m.genre().equalsIgnoreCase(genre))
                .map(Movie::title)
                .toList(); // oder .collect(Collectors.toList()) vor Java 16
    }

    // 2. Sortieren: getTopEarningMovies
    public List<Movie> getTopEarningMovies(int limit) {
        return movies.stream()
                .sorted(Comparator.comparingDouble(Movie::boxOfficeInMillions).reversed())
                .limit(limit)
                .toList();
    }

    // 3. Matching: hasMovieFromDirector
    public boolean hasMovieFromDirector(String director) {
        return movies.stream()
                .anyMatch(m -> m.director().equalsIgnoreCase(director));
    }

    // 4. Zählen: countMoviesReleasedAfter
    public long countMoviesReleasedAfter(int year) {
        return movies.stream()
                .filter(m -> m.releaseYear() > year)
                .count();
    }

    // 5. Aggregieren: getAverageEarningsByGenre
    public OptionalDouble getAverageEarningsByGenre(String genre) {
        return movies.stream()
                .filter(m -> m.genre().equalsIgnoreCase(genre))
                .mapToDouble(Movie::boxOfficeInMillions)
                .average();
    }

    // 6. Gruppieren: groupMoviesByDirector
    public Map<String, List<Movie>> groupMoviesByDirector() {
        return movies.stream()
                .collect(Collectors.groupingBy(Movie::director));
    }


    // ==========================================
    // ZUSATZAUFGABE: Lambdas als Fields
    // ==========================================

    // isBlockbuster
    public static final Predicate<Movie> isBlockbuster = m -> m.boxOfficeInMillions() > 500.0;

    // movieToLabel
    public static final Function<Movie, String> movieToLabel = m -> m.title() + " (" + m.releaseYear() + ")";

    // byYear
    public static final Comparator<Movie> byYear = Comparator.comparingInt(Movie::releaseYear);

    // Query: getBlockbusterLabels
    public List<String> getBlockbusterLabels() {
        return movies.stream()
                .filter(isBlockbuster)
                .sorted(byYear)
                .map(movieToLabel)
                .toList();
    }
}