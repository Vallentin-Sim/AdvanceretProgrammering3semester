package lektion8streams.undervisningsmateriale.movieexercise;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoviesApp {
    public static List<Movie> readMovies(String filename) throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (Scanner in = new Scanner(new File(filename))) {
            while (in.hasNextLine()) {
                String nameLine = in.nextLine();
                String yearLine = in.nextLine();
                String directorsLine = in.nextLine();
                String producersLine = in.nextLine();
                String actorsLine = in.nextLine();
                movies.add(new Movie(getString(nameLine),
                        Integer.parseInt(getString(yearLine)),
                        getList(directorsLine), getList(producersLine),
                        getList(actorsLine)));
            }
        }
        return movies;
    }

    private static String getString(String line) {
        int colon = line.indexOf(":");
        return line.substring(colon + 1).trim();
    }

    private static List<String> getList(String line) {
        return Stream.of(getString(line).split(", "))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        List<Movie> movieList = readMovies("movies.txt");
        movieList.stream().forEach(e -> System.out.println(e.getTitle()));
        System.out.println("Number of movies: " + movieList.size());

        // Opgave 1: Antal film der starter med "H"
        // startsWith() tjekker filmens titel — filter() beholder kun dem der matcher
        long moviesWithH = movieList.stream()
                .filter(m -> m.getTitle().startsWith("H"))
                .count();
        System.out.println("Opgave 1 - Antal film der starter med H: " + moviesWithH);

        // Opgave 2: Titlerne på film der starter med "X"
        // map() transformer hvert Movie-objekt til kun dens titel (String)
        // collect(toList()) samler resultaterne i en ny liste
        List<String> moviesWithX = movieList.stream()
                .filter(m -> m.getTitle().startsWith("X"))
                .map(m -> m.getTitle())
                .collect(Collectors.toList());
        System.out.println("Opgave 2 - Film der starter med X: " + moviesWithX);

        // Opgave 3: Antal film hvor instruktøren også er skuespiller
        // anyMatch() tjekker om mindst ét element i instruktør-listen findes i skuespiller-listen
        // contains() søger i den indre liste (actors)
        long directorIsActor = movieList.stream()
                .filter(m -> m.getDirectors().stream()
                        .anyMatch(director -> m.getActors().contains(director)))
                .count();
        System.out.println("Opgave 3 - Film hvor direktør også er skuespiller: " + directorIsActor);

        // Opgave 4: Antal skuespillere i den film med flest skuespillere
        // mapToInt() konverterer hvert Movie til dens antal skuespillere (int)
        // max() finder den højeste værdi
        int mostActors = movieList.stream()
                .mapToInt(m -> m.getActors().size())
                .max()
                .getAsInt();
        System.out.println("Opgave 4 - Flest skuespillere i én film: " + mostActors);

        // Opgave 5: Titlen på den film med flest skuespillere
        // max() med en Comparator der sammenligner på actors.size()
        // Comparator.comparingInt() er en kortform for at lave en int-baseret Comparator
        String titleMostActors = movieList.stream()
                .max(Comparator.comparingInt(m -> m.getActors().size()))
                .get()
                .getTitle();
        System.out.println("Opgave 5 - Titel med flest skuespillere: " + titleMostActors);

        // Opgave 6: Antal film fordelt på forbogstav i titlen
        // groupingBy() grupperer film efter nøglen — her første bogstav i titlen
        // Collectors.counting() tæller antallet i hver gruppe
        // Resultatet er et Map<Character, Long>
        Map<Character, Long> filmsByLetter = movieList.stream()
                .collect(Collectors.groupingBy(
                        m -> m.getTitle().charAt(0),
                        Collectors.counting()));
        System.out.println("Opgave 6 - Fordeling på forbogstav:");
        filmsByLetter.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println("  " + e.getKey() + ": " + e.getValue()));

        // Opgave 7: Antal film hvis titel starter med "The "
        System.out.println("Opgave 7 - Antal film der starter med 'The ': " +
                movieList.stream()
                        .filter(m -> m.getTitle().startsWith("The "))
                        .count());
    }
}
