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
        // extract messages(liked Nicky Kayyarath's centrialization of the win messages)
        String p1Win = "Player 1 wins";
        String p2Win = "Player 2 wins";
        String tie = "TIE";
        String p2InvlaidString = "Player 2 invalid, Player 1 Wins";
        String p1InvlaidString = "Player 1 invalid, Player 2 Wins";

        switch (p1) {
        // player 1 choices
        case "rock":
            switch (p2) {
            // player 2 choices
            case "rock":
                return tie;
            case "paper":
                return p2Win;
            case "scissors":
                return p1Win;
            default:
                return p2InvlaidString;
            }
        case "paper":
            switch (p2) {
            // player 2 choices
            case "rock":
                return p1Win;
            case "paper":
                return tie;
            case "scissors":
                return p2Win;
            default:
                return p2InvlaidString;
            }
        case "scissors":
            switch (p2) {
            // player 2 choices
            case "rock":
                return p2Win;
            case "paper":
                return p1Win;
            case "scissors":
                return tie;
            default:
                return p2InvlaidString;
            }
        default:
            return p1InvlaidString;
        }
    }

    public static String rps_array(String p1, String p2) {
        // messages(liked Nicky Kayyarath's centrialization of the win messages)
        String p1Win = "Player 1 wins";
        String p2Win = "Player 2 wins";
        String tie = "TIE";
        String p2InvlaidString = "Player 2 invalid, Player 1 Wins";
        String p1InvlaidString = "Player 1 invalid, Player 2 Wins";
        ArrayList<String> rpsArray = new ArrayList<String>();
        // add all to arrayList
        rpsArray.add("rock");
        rpsArray.add("paper");
        rpsArray.add("scissors");
        String out = tie;
        // find location of both players answers
        int p1M = rpsArray.indexOf(p1);
        int p2M = rpsArray.indexOf(p2);
        // if invalid return early
        if (p1M == -1)
            out = p1InvlaidString;
        else if (p2M == -1)
            out = p2InvlaidString;
        // edge case
        else if (p1M == 3 && p2M == 1) {
            out = p2Win;
        } else if (p1M == 1 && p2M == 3) {
            out = p1Win;
        }
        // normal indexs
        else if (p1M < p2M) {
            out = p2Win;
        } else if (p1M > p2M) {
            out = p1Win;
        }
        // return value, can be tested easier too
        return out;
    }
}
