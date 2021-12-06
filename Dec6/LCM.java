import java.math.BigInteger;
import java.util.ArrayList;

public class LCM {
	public static void main(String[] args) {
		int[] i = { 5, 4, 6, 46, 54, 12, 13, 17 };
		System.out.println("LCM:" + lcmOfArray(new int[] { 5, 4, 6, 46, 54, 12, 13, 17 }));
		System.out.println("LCM:" + lcmOfArray(new int[] { 46, 54, 466, 544 }));
		System.out.println("LCM:" + lcmOfArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		System.out.println("LCM:" + lcmOfArray(new int[] { 13, 6, 17, 18, 19, 20, 37 }));

		System.out.println("lookAndSay:" + lookAndSay(Long.valueOf("3132")));
		System.out.println("lookAndSay:" + lookAndSay(Long.valueOf("1213200012171979")));
		System.out.println("lookAndSay:" + lookAndSay(Long.valueOf("54544666")));
		System.out.println("lookAndSay:" + lookAndSay(Long.valueOf("95")));
		System.out.println("lookAndSay:" + lookAndSay(Long.valueOf("1213141516171819")));
		System.out.println("lookAndSay:" + lookAndSay(Long.valueOf("120520")));
		System.out.println("lookAndSay:" + lookAndSay(Long.valueOf("231")));
	}

	/*
	 * 2) Given an integer value, return a new integer according to the rules below:
	 * 
	 * -Split the number into groups of two digit numbers. If the number has an odd
	 * number of digits, return -1. -For each group of two digit numbers,
	 * concatenate the last digit to a new string the same number of times as the
	 * value of the first digit. -Return the result as an integer.
	 * 
	 * lookAndSay(3132) ➞ 111222
	 * 
	 * // By reading the number digit by digit, you get three "1" and three "2". //
	 * Therefore, you put three ones and three two's together. // Remember to return
	 * an integer value (i.e BigIntger class). Examples: 1)
	 * lookAndSay(1213200012171979) ➞ 23002799999999
	 * 
	 * 2) lookAndSay(54544666) ➞ 44444444446666666666
	 * 
	 * 3) lookAndSay(95) ➞ 555555555
	 * 
	 * 4) lookAndSay(1213141516171819) ➞ 23456789
	 * 
	 * 5) lookAndSay(120520) ➞ 200
	 * 
	 * 6) lookAndSay(231) ➞ -1
	 * 
	 * Notes: Note that the number 0 can be included (see example #5).
	 */
	public static long lcmOfArray(int[] iArray) {
		// 1) Create a function that takes an array of more than three numbers and
		// returns the Least Common Multiple (LCM).
		long checkNum = iArray[0];
		boolean finished = false;
		while (!finished) {
			finished = true;
			for (int i : iArray) {
				if (checkNum % i != 0) {
					checkNum++;
					finished = false;//go to next number
					continue;
				}
			}
		}
		// System.out.println(checkNum);
		return checkNum;
	}

	public static BigInteger lookAndSay(long input) {
		String s = Long.toString(input);//convert to string
		String out = "";
		ArrayList<String> aL = new ArrayList<>();//to store groups
		if (s.length() % 2 != 0) {
			return BigInteger.valueOf(-1);
		}
		for (int i = 0; i < s.length(); i += 2) {
			aL.add(s.substring(i, i + 2));//add groups to arraylist
		}
		for (String sub : aL) {
			for (int copy = 0; copy < Integer.parseInt(sub.substring(0, 1)); copy++) {
				//add all to string based on groups
				out += sub.substring(1);
			}
		}
		return new BigInteger(out);// DO NOT USE LONG.PARSELONG(OUT), it can not handle big enough numbers
	}
}
