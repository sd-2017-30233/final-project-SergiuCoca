package Presentation;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
public class Player {

    private int idPlayer;
    private int teamFK;
    private String name;
    private String birthdate;
    private int height;
    private int weight;
    private int spike;
    private String position;

    public Player(int idPlayer, int teamFK, String name, String birthdate, int height, int weight, int spike, String position) {
        this.idPlayer = idPlayer;
        this.teamFK = teamFK;
        this.name = name;
        this.birthdate = birthdate;
        this.height = height;
        this.weight = weight;
        this.spike = spike;
        this.position = position;
    }

    public Player(int height, int weight, int spike, String position) {
        this.height = height;
        this.weight = weight;
        this.spike = spike;
        this.position = position;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public int getTeamFK() {
        return teamFK;
    }

    public void setTeamFK(int teamFK) {
        this.teamFK = teamFK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpike() {
        return spike;
    }

    public void setSpike(int spike) {
        this.spike = spike;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
