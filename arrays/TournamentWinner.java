package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TournamentWinner {

    private static final int HOME_TEAM_WON = 1;
    private static final int HOME_TEAM = 0;
    private static final int AWAY_TEAM = 1;
    private static final int INITIAL_POINTS_VALUE = 0;
    private static final int WINNING_POINTS = 3;

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> competition1 = new ArrayList<String>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<String>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 1));
        String expected = "Python";
        var actual = new TournamentWinner().tournamentWinner(competitions, results);
    }

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        String bestTeam = "";
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put(bestTeam, 0);

        for (int idx = 0; idx < competitions.size(); idx++) {

            String winningTeam = results.get(idx) == HOME_TEAM_WON ?
                    competitions.get(idx).get(HOME_TEAM) :
                    competitions.get(idx).get(AWAY_TEAM);

            updateScores(winningTeam, scores);

            if (scores.get(winningTeam) > scores.get(bestTeam)) {
                bestTeam = winningTeam;
            }
        }

        return bestTeam;
    }

    public void updateScores(String team, HashMap<String, Integer> scores) {
        if (!scores.containsKey(team)) {
            scores.put(team, INITIAL_POINTS_VALUE);
        }
        scores.put(team, scores.get(team) + WINNING_POINTS);
    }
}
