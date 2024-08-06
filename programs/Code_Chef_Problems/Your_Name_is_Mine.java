
import java.util.Scanner;

public class Your_Name_is_Mine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter t value: ");
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {

            String maleName = sc.next();
            String femaleName = sc.next();

            char[] male = new char[maleName.length()];
            char[] female = new char[femaleName.length()];

            male = maleName.toCharArray();
            female = femaleName.toCharArray();
            int count = 0;
            int k = 0;

            for (int j = 0; j < femaleName.length(); j++) {

                if (male[k] == female[j]) {

                    count++;
                    k++;

                    if (count == male.length) {

                        break;
                    }
                }

                if (k > maleName.length()) {

                    break;
                }
            }
            if (count == male.length) {

                System.out.println("YES");

            } else {

                System.out.println("NO");
            }

        }
        sc.close();

    }

}
