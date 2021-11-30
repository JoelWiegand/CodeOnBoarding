import java.util.ArrayList;

public class RockPaperCode {
    public static void main(String[] args) {
        System.err.println("\n***Using Nested Switch***");
        System.err.println(rps("rock", "paper"));
        System.err.println(rps("paper", "rock"));
        System.err.println(rps("paper", "scissors"));
        System.err.println(rps("scissors", "scissors"));
        System.err.println(rps("scissors", "paper"));
        System.err.println(rps("s", "paper"));
        System.err.println(rps("paper", "p"));

        System.err.println("\n***Using ArrayList***");
        System.err.println(rps_array("rock", "paper"));
        System.err.println(rps_array("paper", "rock"));
        System.err.println(rps_array("paper", "scissors"));
        System.err.println(rps_array("scissors", "scissors"));
        System.err.println(rps_array("scissors", "paper"));
        System.err.println(rps_array("s", "paper"));
        System.err.println(rps_array("paper", "p"));
    }

    public static String rps(String p1, String p2) {
        // switch for each player 1 actions
        switch (p1) {
        // player 1 choices
        case "rock":
            switch (p2) {
            // player 2 choices
            case "rock":
                return "TIE";
            case "paper":
                return "Player 2 wins";
            case "scissors":
                return "Player 1 wins";
            default:
                return "Invalid Entry By Player 2";
            }
        case "paper":
            switch (p2) {
            // player 2 choices
            case "rock":
                return "Player 1 wins";
            case "paper":
                return "TIE";
            case "scissors":
                return "Player 2 wins";
            default:
                return "Invalid Entry By Player 2";
            }
        case "scissors":
            switch (p2) {
            // player 2 choices
            case "rock":
                return "Player 2 wins";
            case "paper":
                return "Player 1 wins";
            case "scissors":
                return "TIE";
            default:
                return "Invalid Entry By Player 2";
            }
        default:
            return "Invalid Entry By Player 1";
        }
    }

    public static String rps_array(String p1, String p2) {
        // try to use set
        ArrayList<String> rpsArray = new ArrayList<String>();
        //add all to arrayList
        rpsArray.add("rock");
        rpsArray.add("paper");
        rpsArray.add("scissors");
        String out = "TIE";
        //find location of both players answers
        int p1M = rpsArray.indexOf(p1);
        int p2M = rpsArray.indexOf(p2);
        //if invalid return early
        if (p1M == -1)
            return "Player 1 invalid, Player 2 Wins";
        else if (p2M == -1)
            return "Player 2 invalid, Player 1 Wins";
        //edge case
        else if (p1M == 3 && p2M == 1) {
            out = "Player 2 wins";
        } else if (p1M == 1 && p2M == 3) {
            out = "Player 1 wins";
        }
        //normal indexs
        else if (p1M < p2M) {
            out = "Player 2 wins";
        } else if (p1M > p2M) {
            out = "Player 1 wins";
        }
        //return value
        return out;
    }
}
