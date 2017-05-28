package Presentation;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
public class Match {

    private int idMatch;
    private int team1;
    private int team2;
    private String data;
    private String score;

    public Match(int idMatch, int team1, int team2, String data, String score) {
        this.idMatch = idMatch;
        this.team1 = team1;
        this.team2 = team2;
        this.data = data;
        this.score = score;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public int getTeam1() {
        return team1;
    }

    public void setTeam1(int team1) {
        this.team1 = team1;
    }

    public int getTeam2() {
        return team2;
    }

    public void setTeam2(int team2) {
        this.team2 = team2;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
