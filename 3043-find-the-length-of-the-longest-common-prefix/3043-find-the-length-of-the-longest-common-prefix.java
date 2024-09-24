import java.util.Arrays;

public class LongestCommonPrefix {
    public static int longestCommonPrefix(String[] arr1, String[] arr2) {
        arr1 = Arrays.stream(arr1).map(Object::toString).toArray(String[]::new);
        arr2 = Arrays.stream(arr2).map(Object::toString).toArray(String[]::new);
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        int max = 0;
        int y = 0;
        for (int i = 0; i < arr1.length; i++) {
            String e1 = arr1[i];
            String e2 = arr2[y];
            if (e1 == null || e2 == null) break;

            char se = e1.charAt(0);
            if (e2.charAt(0) < se) {
                y++;
                i--;
                continue;
            } else if (e2.charAt(0) > se) continue;
            else {
                int ci = 0;
                while (ci < e1.length() && ci < e2.length() && e1.charAt(ci) == e2.charAt(ci)) {
                    ci++;
                }
                max = Math.max(max, ci);
                if (e1.compareTo(e2) > 0) {
                    y++;
                    i--;
                } else if (e1.equals(e2)) y++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] arr1 = {"apple", "apricot", "banana"};
        String[] arr2 = {"applesauce", "banana", "grape"};
        System.out.println(longestCommonPrefix(arr1, arr2));
    }
}