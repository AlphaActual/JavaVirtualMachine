import java.util.Scanner;

public class BalancedVowelsAndConsonants {
    public static void main(String[] args) {
        int inputIndex = 0;
        int outputIndex = 0;
        final int ARR_SIZE = 1000;
        String[] inputs = new String[ARR_SIZE];

        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite stringove: ");
        // unos stringova
        while (true) {
            String input = sc.nextLine();
            if (input.equals("kraj")) {
                break;
            }
            inputs[inputIndex++] = input;
        }

        // provjera broja samoglasnika i suglasnika
        char[] samoglasnici = {'a', 'e', 'i', 'o', 'u'};
        String[] outputs = new String[ARR_SIZE];
        for (int i = 0; i < inputIndex; i++) {
            String word = inputs[i];
            int samoglasnikCount = 0;
            int suglasnikCount = 0;
            for (int j = 0; j < word.length(); j++) {
                char currentChar = word.charAt(j);
                if(isVowel(currentChar, samoglasnici)) {
                    samoglasnikCount++;
                } else {
                    suglasnikCount++;
                }
            }
            if (samoglasnikCount == suglasnikCount) {
                outputs[outputIndex++] = word;
            }
        }

        // ispis
        System.out.println("Stringovi koji imaju jednak broj samoglasnika i suglasnika: ");
        for (int i = 0; i < outputIndex; i++) {
            System.out.println(outputs[i]);
        }
    }
    public static boolean isVowel(char c, char[] samoglasnici) {
        for (int i = 0; i < samoglasnici.length; i++) {
            if (c == samoglasnici[i]) {
                return true;
            }
        }
        return false;
    }
}