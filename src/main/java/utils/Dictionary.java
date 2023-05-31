package utils;

import java.util.Map;
import java.util.stream.Collectors;

import exceptions.factory.UnknownNameException;

public class Dictionary {

    public enum Language {
        PL, ENG
    }

    public static Language activeLanguage = Language.ENG;

    private static final Map<String, String> dictionaryFromPL = Map.ofEntries(
            Map.entry("zakończ", "exit"),
            Map.entry("pokaż", "showfigures"),
            Map.entry("sortuj", "sort"),
            Map.entry("opisz", "circumscribed"),
            Map.entry("zdubluj", "doubled"),
            Map.entry("usuń", "remove"),
            Map.entry("dodaj", "add"),
            Map.entry("zapisz", "save"),
            Map.entry("precyzja", "precision"),
            Map.entry("jezyk", "language"),
            Map.entry("bok", "side"),
            Map.entry("krótkibok", "shortside"),
            Map.entry("długibok", "longside"),
            Map.entry("przekątna", "diagonal"),
            Map.entry("krótkaprzekątna", "shortdiagonal"),
            Map.entry("długaprzekątna", "longdiagonal"),
            Map.entry("powierzchnia", "area"),
            Map.entry("promień", "radius"),
            Map.entry("średnica", "diameter"),
            Map.entry("obwód", "circuit"),
            Map.entry("wysokość", "height"),
            Map.entry("podstawa", "base"),
            Map.entry("dlugapodstawa", "shortbase"),
            Map.entry("krótkapodstawa", "longbase"),
            Map.entry("przyprostokatka", "cathetus"),
            Map.entry("przeciwprostokątna", "hypotenuse"),
            Map.entry("długaprzyprostokatka", "shortcathetus"),
            Map.entry("krótkaprzyprostokatka", "longcathetus"),
            Map.entry("półośmała", "semiminoraxis"),
            Map.entry("półoświelka", "semimajoraxis"),
            Map.entry("koło", "circle"),
            Map.entry("elipsa", "ellipse"),
            Map.entry("trapezrównoramienny", "isoscelestrapezoid"),
            Map.entry("trójkątrównoramienny", "isoscelestriangle"),
            Map.entry("prostokąt", "rectangle"),
            Map.entry("trójkątrównoboczny", "regulartriangle"),
            Map.entry("romb", "rhombus"),
            Map.entry("trójkątprostokątny", "righttriangle"),
            Map.entry("kwadrat", "square"),
            Map.entry("trójkat", "triangle"),
            Map.entry("sześciokątforemny", "regularhexagon"));

    private static final Map<String, String> dictionaryFromENG = dictionaryFromPL.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

    public static String toENG(String word) {
        try {
            return switch (activeLanguage) {
                case PL -> dictionaryFromPL.get(word);
                default -> word;
            };
        } catch (Exception e) {
            throw new UnknownNameException(word);
        }
    }

    public static String fromENG(String word) {
        try {
            return switch (activeLanguage) {
                case PL -> dictionaryFromENG.get(word);
                default -> word;
            };
        } catch (Exception e) {
            throw new UnknownNameException(word);
        }
    }
}
