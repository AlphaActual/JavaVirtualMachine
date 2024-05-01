import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Pritišanac Tin
 * @version 1.0
 * DZ 8A - Korištenje Java 8 Stream API-a i Set kolekcije za prikaz jedinstvenih imena iz prve od dviju datoteka
 * Kod svih zadaća dostupan je na git repozitoriju: <a href="https://github.com/AlphaActual/JavaVirtualMachine">MY REPO</a>
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite ime prve datoteke: ");
        String file1 = scanner.nextLine();
        System.out.println("Unesite ime druge datoteke: ");
        String file2 = scanner.nextLine();
        try {
            // Čitamo sve linije iz prve datoteke i sprema ih u LinkedHashSet. LinkedHashSet održava redoslijed unosa.
            Set<String> names1 = Files.lines(Paths.get("src/" + file1)).collect(Collectors.toCollection(LinkedHashSet::new));
            // Čitamo sve linije iz druge datoteke i sprema ih u HashSet. Redoslijed unosa nije važan.
            Set<String> names2 = Files.lines(Paths.get("src/" + file2)).collect(Collectors.toSet());

            // Uklanjamo sve elemente iz names1 koji se nalaze u names2.
            names1.removeAll(names2);

            for (String name : names1) {
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}