public class BetterWayToAcend {
    //code to create a string of ascending numbers instead of spliting, allows for a easier solution to inlude 99100
    //idea based off of https://www.geeksforgeeks.org/consecutive-sequenced-numbers-in-a-string/
    public static void main(String[] args) {
        System.err.println( ascending("99100101"));
    }
    public static boolean ascending(String str) {
        long strLength=str.length();

        for(int i =0; i<strLength/2;i++){
            //half of length because then it can be two numbers that take up half of str each
            Long tempNum;//var to hold current number
            tempNum=Long.parseLong(str.substring(0, i+1));//get first number
            String correctString=String.valueOf(tempNum);//the created string to match to input string
            while(correctString.length()<strLength){
                //create a correctString of size at least str.length()
                tempNum++;//get next number
                correctString+=String.valueOf(tempNum);//value of is safer than implict converstion    
            }
            System.err.println(correctString);
            if(correctString.equals(str)){
                //if the strings match it is what is should be
                return true;
            }
        }
        return false;
    }
}
