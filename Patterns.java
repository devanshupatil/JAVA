
public class Patterns {
    public static void main(String[] args) {

        System.out.println("SOLID RECTANGLE :-\n");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.println("***************************");

        System.out.println("HOLLOW PATTERN :-\n");

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 5; j++) {
                if (i == 1 || j == 1 || i == 4 || j == 5) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }

        System.out.print("\n");
        System.out.println("***************************");

        System.out.println(" HALF PYARAMID :-\n");

        for (int i = 0; i < 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");
        System.out.println("***************************");

        System.out.println("INVERTED HALF PYRAMID (rotated by 180 dig) :-\n");

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (4 - i >= j) {
                    System.out.print("  ");
                } else {
                    System.out.print(" *");
                }
            }
            System.out.print("\n");
        }

        System.out.print("\n");
        System.out.println("***************************");

        System.out.println("HALF PYARAMID WITH NUMBERS :-\n");

        for (int i = 0; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");
        System.out.println("***************************");

        System.out.println("INVERTED HALF PYRAMID WITH NUMBERS :-\n");

        for (int i = 5; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");
        System.out.println("***************************");

        System.out.println("FLOYD'S TRINGLE :-\n");

        int number = 1;
        for (int i = 0; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.println("***************************");

        System.out.println("0 - 1 TRINGLE :-\n");

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.println("***************************");

        System.out.println("BUTTERFLY PATTERN :-\n");

        // Upper half
        for (int i = 1; i <= 4; i++) {
            // 1st part
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            // Spaces
            for (int k = 0; k < 2 * (4 - i); k++) {
                System.out.print("  ");
            }

            // 2nd part
            for (int j = 1; j <= i; j++) {
                System.out.print(" *");
            }
            System.out.print("\n");
        }

        // Lower half
        for (int i = 4; i >= 1; i--) {

            // 1st part
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            // Spaces
            for (int k = 0; k < 2 * (4 - i); k++) {
                System.out.print("  ");
            }

            // 2nd part
            for (int j = 1; j <= i; j++) {
                System.out.print(" *");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.println("***************************");

        System.err.println("SOLID RHOMBUS :-\n");

        for (int i = 1; i <= 5; i++) {

            // Spaces
            for (int j = 1; j <= (5 - i); j++) {
                System.out.print("  ");

            }

            // Part Star
            for (int j = 0; j < 9 - (5 - 1); j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        System.out.print("\n");
        System.out.println("***************************");

        System.out.println("NUMBER PYARAMID :-\n");

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= (5 - i); j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.err.println();
        }

        System.out.print("\n");
        System.out.println("***************************");

        System.out.println("PALINDROMIC PATTERN :-\n");

        for (int i = 1; i <= 5; i++) {

            // Spaces
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }

            // 1st half numbers
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }

            // 2nd half numbers
            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.print("\n");
        System.out.println("***************************");

        System.out.println("DIAMOND PATTERN :- \n");

        // Upper half part
        for (int i = 1; i <= 4; i++) {

            // Spaces
            for (int j = 1; j <= 4 - i; j++) {
                System.out.print("  ");
            }

            // Stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // Lower half part
        for (int i = 4; i >= 1; i--) {

            // Spaces
            for (int j = 1; j <= 4 - i; j++) {
                System.out.print("  ");
            }

            // Stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        System.out.print("\n");
        System.out.println("***************************");

    }
}
