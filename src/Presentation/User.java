package Presentation;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
public class User {

    private int idUser;
    private String username;
    private String password;
    private int rank;

    public User(int idUser, String username, String password, int rank) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.rank = rank;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
