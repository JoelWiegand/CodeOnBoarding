import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Examples ascending("232425") --> true // Consecutive numbers 23, 24, 25
 * 
 * ascending("2324256") --> false // No matter how this string is divided, the
 * numbers are not consecutive.
 * 
 * ascending("444445") --> true // Consecutive numbers 444 and 445. Notes A
 * number can consist of any number of digits, so long as the numbers are
 * adjacent to each other, and the string has at least two of them.
 * 
 * Examples squarePatch(3) --> [ [3, 3, 3], [3, 3, 3], [3, 3, 3] ]
 * 
 * squarePatch(5) --> [ [5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5,
 * 5, 5, 5, 5], [5, 5, 5, 5, 5] ]
 * 
 * squarePatch(1) --> [ [1] ]
 * 
 * squarePatch(0) --> [] Notes n >= 0. If n = 0, return an empty array.
 **/

public class Week1challenge {
    public static void main(String[] args) {
        ascending("23242567");
        squarePatch(4);
    }

    public static boolean ascending(String str) {
        // a function that returns true if a string consists of ascending or ascending
        // AND consecutive numbers.
        boolean con = false;
        char[] charArray = str.toCharArray();
        int pastSub =Integer.parseInt(str.substring(0, 1));
        String subString = "";
        for (int i = 1; i < charArray.length ; i++) {
            if(charArray.length%i!=0)continue;
            pastSub=Integer.parseInt(str.substring(0, i));
            for (int y = i; y <= charArray.length-i; y+=i) {
                subString = str.substring(y, y + i);
                System.err.println("sub:"+subString + " past:"+pastSub);
                if (pastSub == Integer.parseInt(subString) - 1) {
                    con=true;
                }
                else {
                    con=false;
                    y=charArray.length;
                }
                pastSub=Integer.parseInt(subString);
            }
            if(con)break;
        }
        System.err.println(con);
        return con;
    }

    public static int[][] squarePatch(int num) {
        // a function that takes an integer and outputs an n x n square solely
        // consisting of the integer n.
        int[][] intArray = new int[num][num];
        for (int[] row : intArray) {
            Arrays.fill(row, num);
        }
        System.out.println(Arrays.deepToString(intArray).replace("], ", "]\n"));
        return intArray;
    }
}
