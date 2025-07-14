//Adrian Shayesteh Dar adsh9563

import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList;

public class InputReader {
    private static ArrayList<InputStream> inputStreams = new ArrayList<>();
    private Scanner scanner;

    public InputReader(InputStream stream) {
        if (inputStreams.contains(stream)) {
            throw new IllegalStateException("Felmeddelande");
        } else {
            inputStreams.add(stream);
            this.scanner = new Scanner(stream);
        }
    }

    public InputReader() {
        this(System.in);
    }

    public int intReader(String prompt) {
        System.out.print(prompt + "?> ");
        while (!scanner.hasNextInt()) {
            System.out.println("Fel: Ange ett giltigt heltal!");
            scanner.next();
            System.out.print(prompt + "?> ");
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public double doubleReader(String prompt) {
        System.out.print(prompt + "?> ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Fel: Ange ett giltigt decimaltal!");
            scanner.next();
            System.out.print(prompt + "?> ");
        }
        double number = scanner.nextDouble();
        scanner.nextLine();
        return number;
    }

    public String stringReader(String prompt) {
        System.out.print(prompt + "?> ");
        return scanner.nextLine();
    }
}