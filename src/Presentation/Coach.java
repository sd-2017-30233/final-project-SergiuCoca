package Presentation;

import javax.swing.*;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
public class Coach extends Observer {

    private int idCoach;
    private String name;
    private String nationality;
    private String birthdate;

    public Coach(int idCoach, String name, String nationality, String birthdate) {
        this.idCoach = idCoach;
        this.name = name;
        this.nationality = nationality;
        this.birthdate = birthdate;
    }

    public Coach(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public int getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(int idCoach) {
        this.idCoach = idCoach;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public void update() {
        int result = JOptionPane.showConfirmDialog(null, "A player is available for transfer!\nLogin with a coach account to see him", "Player available", JOptionPane.PLAIN_MESSAGE);
    }
}
