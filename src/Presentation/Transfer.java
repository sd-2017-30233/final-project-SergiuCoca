package Presentation;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
public class Transfer {

    private int idTransfer;
    private int playerTransfer;
    private int oldTeam;
    private int newTeam;

    public Transfer(int idTransfer, int playerTransfer, int oldTeam, int newTeam) {
        this.idTransfer = idTransfer;
        this.playerTransfer = playerTransfer;
        this.oldTeam = oldTeam;
        this.newTeam = newTeam;
    }

    public int getIdTransfer() {
        return idTransfer;
    }

    public void setIdTransfer(int idTransfer) {
        this.idTransfer = idTransfer;
    }

    public int getPlayerTransfer() {
        return playerTransfer;
    }

    public void setPlayerTransfer(int playerTransfer) {
        this.playerTransfer = playerTransfer;
    }

    public int getOldTeam() {
        return oldTeam;
    }

    public void setOldTeam(int oldTeam) {
        this.oldTeam = oldTeam;
    }

    public int getNewTeam() {
        return newTeam;
    }

    public void setNewTeam(int newTeam) {
        this.newTeam = newTeam;
    }
}
