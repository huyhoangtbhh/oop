import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        int n = str.length();
        if(n == 0) return 0;
        int[] arr = new int[n];
        int mx = 1;
        arr[0] = 1;
        for(int i = 1 ; i < n ; i++){
            if(str.charAt(i) == str.charAt(i-1)){
                arr[i] = arr[i-1] + 1;
                mx = Math.max(arr[i], mx);
            }
            else{
                arr[i] = 1;
            }
        }
        return mx;
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        StringBuilder result = new StringBuilder("");
        for(int i = 0  ; i < str.length() ; i++ ){
            int j = i + 1;
            int times = 0;
            boolean isNum = false;
            char c = str.charAt(i);

            if(c >= '0' && c <= '9') {
                times = c - '0';
                isNum = true;
            }

            if(!isNum) {
                result.append(c);
                continue;
            }

            if(j == str.length()) {
                break;
            }
            c = str.charAt(j);
            for(int k = 0 ; k < times ; k++){
                result.append(c);
            }

        }
        return result.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        int leng1 = a.length();
        int leng2 = b.length();
        int result = 0;
        int[][] dp_array = new int[leng1][leng2];
        for(int i = 0; i < leng1; i++){
            for(int j = 0; j < leng2; j++){
                if(a.charAt(i) == b.charAt(j)){
                    if(i == 0 || j == 0){
                        dp_array[i][j] = 1;
                    }
                    else{
                        dp_array[i][j] = dp_array[i-1][j-1] + 1;
                        result = Math.max(result,dp_array[i][j]);
                    }
                }
                else{
                    dp_array[i][j] = 0;
                }
            }
        }
        return result >= len; // YOUR CODE HERE
    }

    public static void main(String[] args) {
        System.out.println(blowup("a231"));
        System.out.println(maxRun("hhhooppoo"));
        System.out.println(stringIntersect("aaobced","bcedaao",5));
    }
}
