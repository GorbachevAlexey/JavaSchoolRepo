import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();
        String str;
        if (max(a1, b1) == max(a2, b2) && (min(a1, b1) + min(a2, b2)) == max(a2, b2))
            str = "YES";
        else str = "NO";

        System.out.println(str);
    }
}
