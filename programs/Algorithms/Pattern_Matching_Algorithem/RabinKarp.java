
public class RabinKarp {
    public static void main(String[] args) {
        char string[] = { 'a', 'b', 'c', 'd', 'a', 'a', 'b', 'c', 'c', 'b' }; // n length of string
        char pattern[] = { 'c', 'd', 'a' }; // m length of pattern

        double stringvalue = 0;
        double patternValue = 0;
        int temp = 0;
        int l = 0;

        // calculat pattern value and string first (m-1) charaters value
        for (int i = 0; i < pattern.length; i++) {
            patternValue += pattern[i] * Math.pow(10, pattern.length - (i + 1));
            stringvalue += string[i] * Math.pow(10, pattern.length - (i + 1));
        }

        // check the value is equal or not
        for (int j = pattern.length; j < string.length;) {

            if (stringvalue == patternValue) { // if true, the value is eqaul
                temp = 1; // Assign 1
                break; // break the loop
            } else {
                stringvalue = (stringvalue - (string[l] * (10 * 10))) * 10 + string[j]; // if false, subtract first
                                                                                        // value and add last + one
                                                                                        // value
                j++;
                l++;
            }
        }
        // check the pattern is match
        if (temp == 1) { // If true, print the index and value
            System.out.println("Pattern found in index = ");
            for (int k = l; k < pattern.length + l; k++) {
                System.out.print(k + " ");
                System.out.println(string[k] + " ");
            }
        } else { // If false, print not found
            System.out.println("Pattern is not found!");
        }
    }

}
