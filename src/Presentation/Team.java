package Presentation;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
public class Team {

    private int idTeam;
    private int coachFK;
    private String name;
    private String town;
    private int rank;

    public Team(int idTeam, int coachFK, String name, String town, int rank) {
        this.idTeam = idTeam;
        this.coachFK = coachFK;
        this.name = name;
        this.town = town;
        this.rank = rank;
    }

    public Team(int coachFK, String name, int rank) {
        this.coachFK = coachFK;
        this.name = name;
        this.rank = rank;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public int getCoachFK() {
        return coachFK;
    }

    public void setCoachFK(int coachFK) {
        this.coachFK = coachFK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
