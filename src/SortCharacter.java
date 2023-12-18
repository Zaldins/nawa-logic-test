import java.util.Scanner;
import java.util.Arrays;

public class SortCharacter {
    public static void main(String[] args) {
        // read input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of words: ");
        String input = scanner.nextLine();
        scanner.close();

        // Process the input
        processString(input);
    }

    // function to check if a character is a vowel
    private static boolean isVowel(char ch) {
        String vowels = "aeiou";
        return vowels.contains(Character.toString(ch));
    }

    // function to sort characters based on the order they appear
    private static StringBuilder sortCharacters(String input) {
        char[] chars = input.toCharArray();

        // Bubble sort to maintain the order of appearance
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - i - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    // Swap characters if they are in the wrong order
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }

        return new StringBuilder(new String(chars));
    }

    // function to process the input string and print sorted vowels and reversed consonants
    private static void processString(String input) {
        input = input.toLowerCase().replaceAll("\\s", "");

        // Separate vowels and consonants
        StringBuilder vowelChars = new StringBuilder();
        StringBuilder consonantChars = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (isVowel(ch)) {
                vowelChars.append(ch);
            } else {
                consonantChars.insert(0, ch); // Insert at the beginning to reverse the order
            }
        }

        // print sorted vowels
        System.out.println("Vowel Characters :");
        System.out.println(sortCharacters(vowelChars.toString()));

        // print reversed consonants
        System.out.println("Consonant Characters (reversed):");
        System.out.println(consonantChars.reverse());
    }


}
