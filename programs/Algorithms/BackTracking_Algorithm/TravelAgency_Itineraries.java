public class TravelAgency_Itineraries {

    public static void PrintAllPermutations(String str[], String perm[], int index) {

        // Print the all permutations
        if (str.length == 0) {
            for (int i = 0; i < perm.length; i++) {

                if (i <= perm.length - 2) {
                    System.out.print(perm[i] + " " + "-> ");
                } else {
                    System.out.println(perm[i]);
                }
            }
            return;
        }

        for (int i = 0; i < str.length; i++) {

            String currString = str[i]; // our current string
            String newString[] = new String[str.length - 1];
            int idx = 0;

            for (int j = 0; j < str.length; j++) {
                if (str[j] != currString) { // If current string is not equal to str of index 'j'
                    newString[idx] = str[j]; // If true, add str of index 'j' value to new string array of index'idx
                    idx++;
                }
            }
            perm[index] = currString; // add current string into perm string array of index
            PrintAllPermutations(newString, perm, index + 1); // pass the values and call function
        }
    }

    public static void main(String[] args) {
        String str[] = new String[] { "New York", " Los Angeles", " Chicago" };
        String perm[] = new String[str.length];
        PrintAllPermutations(str, perm, 0);// pass value and call function
    }
}
