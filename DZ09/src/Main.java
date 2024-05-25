import java.io.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Unos: java Main <input file> <output file> [-p | -print]");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
        boolean printToConsole = args.length > 2 && (args[2].equals("-p") || args[2].equals("-print"));

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();

                if (printToConsole) {
                    System.out.println(line);
                }
            }

            System.out.println("Datoteka je uspjesno kopirana!");

        } catch (IOException e) {
            System.out.println("Došlo je do pogereske prilikom kopiranja datoteka " + e.getMessage());
        }
    }
}