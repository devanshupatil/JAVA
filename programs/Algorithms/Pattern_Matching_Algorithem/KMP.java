
public class KMP {
    public static void main(String[] args) {
        char table[] = { 'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b', 'd', 'a', 'b', 'a', 'b' };
        char pattern[] = { 'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b', 'c', 'a' };

        int arr[] = new int[pattern.length];
        int i = 0;
        int j = i + 1;

        while (j < pattern.length) {

            if (pattern[i] == pattern[j]) { // If the value is match array of next index value
                arr[j] = i + 1; // assign index + 1
                i++;
                j++;
            } else {
                if (i != 0 && i >= 0) { // If not match
                    i = arr[i]; // assign array of index value to i
                } else { // If i is equal to 0
                    arr[j] = 0; // assign 0 to array of j index
                    j++;
                }

            }

        }
        i = j = 0;

        while (i < table.length) {
            if (pattern[j] != table[i]) {
                j = arr[j - 1] - 1;
                if (j < 0) {
                    i++;
                    j = 0;
                }
            } else {

                j++;
                i++;
            }

        }

        System.out.println("Pattern is match.");

    }
}