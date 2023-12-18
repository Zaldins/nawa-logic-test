import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class PSBB {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // input the number of families
        System.out.print("Input the number of families: ");
        int n = Integer.parseInt(reader.readLine());

        // input the number of members in each family
        System.out.print("Input the number of members in the family (separated by a space): ");
        int[] familyMembers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        // check if the input number of family members matches the count of families
        if (familyMembers.length != n) {
            System.out.println("Input must be equal with count of family");
            return;
        }

        // sort the family members in ascending order
        Arrays.sort(familyMembers);

        // calculate the minimum number of buses required
        int buses = 0;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            if (familyMembers[left] + familyMembers[right] <= 4) {
                left++;
            }
            right--;
            buses++;
        }

        // output the result
        System.out.println("Minimum bus required is: " + buses);
    }
}
