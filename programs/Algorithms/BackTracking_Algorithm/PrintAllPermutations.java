
public class PrintAllPermutations {

    public static void printPermutations(String str, String perm) {
        if (str.length() == 0) { // if the str lenght is equal to 0
            System.out.println(perm); // if true, print permutation string
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char currChar = str.charAt(i); // our current character
            String newStr = str.substring(0, i) + str.substring(i + 1); // remove the current character from string
            // because the current character is not Able to repeat
            printPermutations(newStr, perm + currChar); // call the function
            // add current character into perm string
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        printPermutations(str, ""); // pass value and call function
    }
}