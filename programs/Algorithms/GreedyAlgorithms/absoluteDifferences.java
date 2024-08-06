import java.util.Arrays;

public class absoluteDifferences {

    public static void main(String[] arge) {
        int A[] = { 1, 2, 3 };
        int B[] = { 2, 1, 3 };

        Arrays.sort(A);
        Arrays.sort(B);
        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            ans += A[i] - B[i];
        }
        System.out.println("Minmum absolute difference of pairs = " + ans);
    }

}
