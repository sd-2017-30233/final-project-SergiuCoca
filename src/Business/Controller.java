package Business;

import DataAccess.*;
import Presentation.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
public class Controller {
    Administrator administrator=new Administrator();
    Coach coach=new Coach();
    RegularUser regularUser=new RegularUser();
    Login login;

    PlayerDAO playerDAO=new PlayerDAO();
    TeamDAO teamDAO=new TeamDAO();
    Criteria transferDAO=new TransferDAO();
    MatchDAO matchDAO=new MatchDAO();

    public Controller(Login login){
        this.administrator.addClearListener(new Clear());
        this.administrator.addComboBoxListener(new PlayerOp());
        this.administrator.addComboBox1Listener(new TeamOp());
        this.administrator.addLogoutListener(new Logout());

        this.regularUser.addOutListener(new Out());
        this.regularUser.addSearchListener(new Search());

        this.coach.addMatchesListener(new Matches());
        this.coach.addLOutListener(new LOut());
        this.coach.addPlayersListener(new Players());

        this.login=login;
        this.login.addExitListener(new Exit());
        this.login.addLoginListener(new Log());
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Administrator~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public class Clear implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            administrator.getTextField().setText(" ");
            administrator.getTextField_1().setText(" ");
            administrator.getTextField_2().setText(" ");
            administrator.getTextField_3().setText(" ");
            administrator.getTextField_4().setText(" ");
            administrator.getTextField_5().setText(" ");
            administrator.getTextField_6().setText(" ");
            administrator.getTextField_7().setText(" ");
            administrator.getTextField_8().setText(" ");
            administrator.getTextField_9().setText(" ");
            administrator.getTextField_10().setText(" ");
            administrator.getTextField_11().setText(" ");
            administrator.getTextField_12().setText(" ");
            administrator.getLblmessage().setText("");
        }
    }
    public class PlayerOp implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (administrator.getComboBox().getSelectedItem().toString()) {
                case "Add": playerDAO.create(new Player(Integer.parseInt(administrator.getTextField().getText()),Integer.parseInt(administrator.getTextField_1().getText()),
                            administrator.getTextField_2().getText(),administrator.getTextField_3().getText(),Integer.parseInt(administrator.getTextField_4().getText()),
                            Integer.parseInt(administrator.getTextField_5().getText()),Integer.parseInt(administrator.getTextField_6().getText()),administrator.getTextField_7().getText()));
                            administrator.getLblmessage().setText("A player has been added!");
                    break;
                case "Delete": playerDAO.delete(Integer.parseInt(administrator.getTextField().getText()));
                               administrator.getLblmessage().setText("A player has been deleted!");
                    break;
                case "Edit": playerDAO.update(Integer.parseInt(administrator.getTextField().getText()),
                             new Player(Integer.parseInt(administrator.getTextField_4().getText()),
                                     Integer.parseInt(administrator.getTextField_5().getText()),Integer.parseInt(administrator.getTextField_6().getText()),administrator.getTextField_7().getText()));
                             administrator.getLblmessage().setText("A player has been edited!");
                    break;
                case "Transfer":
                    Subject subject = new Subject();
                    new Presentation.Coach(subject);
                    playerDAO.transfer(Integer.parseInt(administrator.getTextField().getText()));
                    subject.setState(Integer.parseInt(administrator.getTextField().getText()));
                    break;
            }
        }
    }
    public class TeamOp implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (administrator.getComboBox_1().getSelectedItem().toString()) {
                case "Add": teamDAO.create(new Team(Integer.parseInt(administrator.getTextField_8().getText()),
                        Integer.parseInt(administrator.getTextField_9().getText()),administrator.getTextField_10().getText(),
                        administrator.getTextField_11().getText(),Integer.parseInt(administrator.getTextField_12().getText())));
                        administrator.getLblmessage().setText("A team has been added!");
                    break;
                case "Delete": teamDAO.delete(Integer.parseInt(administrator.getTextField_8().getText()));
                               administrator.getLblmessage().setText("A team has been deleted!");
                    break;
                case "Edit":  teamDAO.update(Integer.parseInt(administrator.getTextField_8().getText()),
                        new Team(Integer.parseInt(administrator.getTextField_9().getText()),administrator.getTextField_10().getText(),
                        Integer.parseInt(administrator.getTextField_12().getText())));
                              administrator.getLblmessage().setText("A team has been edited!");
                    break;
            }
        }
    }
    public class Logout implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            administrator.getFrame().setVisible(false);
            login.getFrame().setVisible(true);
            login.getTextField().setText("");
            login.getTextField_1().setText("");
        }
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Administrator~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~RegularUser~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public class Out implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            regularUser.getFrame().setVisible(false);
            login.getFrame().setVisible(true);
            login.getTextField().setText("");
            login.getTextField_1().setText("");
        }
    }
    public class Search implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] columnNames = {"Id", "Team", "Name", "Birthdate", "Height", "Weight", "Spike", "Position"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            JTable table = new JTable(tableModel);
            List<Player> playerList = playerDAO.listPlayers();
            int k=-1;

            switch (regularUser.getComboBox().getSelectedItem().toString()) {
                case "Name":
                    for (int i = 0; i < playerList.size(); i++){
                        if(regularUser.getTextField_1().getText().equals(playerList.get(i).getName())) k=i;
                        Object[] data = {playerList.get(i).getIdPlayer(),playerList.get(i).getTeamFK(),playerList.get(i).getName(),
                                playerList.get(i).getBirthdate(),playerList.get(i).getWeight(),playerList.get(i).getHeight(),
                                playerList.get(i).getSpike(),playerList.get(i).getPosition()};
                       if(k==i) tableModel.addRow(data);
                    }
                       if(k==-1) regularUser.getTextField_2().setText("Player with name "+regularUser.getTextField_1().getText()+" not found!");
                       else {
                           JOptionPane.showMessageDialog(null, new JScrollPane(table));
                           regularUser.getTextField_2().setText("");
                       }
                    break;
                case "Position":
                    for (int i = 0; i < playerList.size(); i++){
                        if(regularUser.getTextField_1().getText().equals(playerList.get(i).getPosition())) k=i;
                        Object[] data = {playerList.get(i).getIdPlayer(),playerList.get(i).getTeamFK(),playerList.get(i).getName(),
                                playerList.get(i).getBirthdate(),playerList.get(i).getWeight(),playerList.get(i).getHeight(),
                                playerList.get(i).getSpike(),playerList.get(i).getPosition()};
                        if(k==i) tableModel.addRow(data);
                    }
                    if(k==-1) regularUser.getTextField_2().setText("Player with "+regularUser.getTextField_1().getText()+" position not found!");
                    else {
                        JOptionPane.showMessageDialog(null, new JScrollPane(table));
                        regularUser.getTextField_2().setText("");
                    }
                    break;
                case "Height":
                    for (int i = 0; i < playerList.size(); i++){
                        if(Integer.parseInt(regularUser.getTextField_1().getText())==(playerList.get(i).getHeight())) k=i;
                        Object[] data = {playerList.get(i).getIdPlayer(),playerList.get(i).getTeamFK(),playerList.get(i).getName(),
                                playerList.get(i).getBirthdate(),playerList.get(i).getWeight(),playerList.get(i).getHeight(),
                                playerList.get(i).getSpike(),playerList.get(i).getPosition()};
                        if(k==i) tableModel.addRow(data);
                    }
                    if(k==-1) regularUser.getTextField_2().setText("Player with height "+regularUser.getTextField_1().getText()+" not found!");
                    else {
                        JOptionPane.showMessageDialog(null, new JScrollPane(table));
                        regularUser.getTextField_2().setText("");
                    }
                    break;
            }

            String[] columnNames1 = {"Id", "Coach", "Name", "Town", "Rank"};
            DefaultTableModel tableModel1 = new DefaultTableModel(columnNames1, 0);
            JTable table1 = new JTable(tableModel1);
            List<Team> teamList = teamDAO.listTeams();
            int k1=-1;

            switch (regularUser.getComboBox_1().getSelectedItem().toString()) {
                case "Name":
                    for (int i = 0; i < teamList.size(); i++){
                        if(regularUser.getTextField_1().getText().equals(teamList.get(i).getName())) k1=i;
                        Object[] data = {teamList.get(i).getIdTeam(),teamList.get(i).getCoachFK(),teamList.get(i).getName(),
                                teamList.get(i).getTown(),teamList.get(i).getRank()};
                        if(k1==i) tableModel1.addRow(data);
                    }
                    if(k1==-1) regularUser.getTextField_2().setText("Team with name "+regularUser.getTextField_1().getText()+" not found!");
                    else {
                        JOptionPane.showMessageDialog(null, new JScrollPane(table1));
                        regularUser.getTextField_2().setText("");
                    }
                    break;
                case "Town":
                    for (int i = 0; i < teamList.size(); i++){
                        if(regularUser.getTextField_1().getText().equals(teamList.get(i).getTown())) k1=i;
                        Object[] data = {teamList.get(i).getIdTeam(),teamList.get(i).getCoachFK(),teamList.get(i).getName(),
                                teamList.get(i).getTown(),teamList.get(i).getRank()};
                        if(k1==i) tableModel1.addRow(data);
                    }
                    if(k1==-1) regularUser.getTextField_2().setText("Team with town "+regularUser.getTextField_1().getText()+" not found!");
                    else {
                        JOptionPane.showMessageDialog(null, new JScrollPane(table1));
                        regularUser.getTextField_2().setText("");
                    }
                    break;
                case "Rank":
                    for (int i = 0; i < teamList.size(); i++){
                        if(Integer.parseInt(regularUser.getTextField_1().getText())==teamList.get(i).getRank()) k1=i;
                        Object[] data = {teamList.get(i).getIdTeam(),teamList.get(i).getCoachFK(),teamList.get(i).getName(),
                                teamList.get(i).getTown(),teamList.get(i).getRank()};
                        if(k1==i) tableModel1.addRow(data);
                    }
                    if(k1==-1) regularUser.getTextField_2().setText("Team with rank "+regularUser.getTextField_1().getText()+" not found!");
                    else {
                        JOptionPane.showMessageDialog(null, new JScrollPane(table1));
                        regularUser.getTextField_2().setText("");
                    }
                    break;
            }
        }
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~RegularUser~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Coach~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public class LOut implements ActionListener {
     @Override
        public void actionPerformed(ActionEvent e) {
             coach.getFrame().setVisible(false);
             login.getFrame().setVisible(true);
             login.getTextField().setText("");
             login.getTextField_1().setText("");
        }
    }
    public class Players implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] columnNames = {"Id", "Team", "Name", "Birthdate", "Height", "Weight", "Spike", "Position"};
            Object[][] date = new Object[transferDAO.meetCriteria().size()][8];
            int i = 0;
            Iterator<Player> it = transferDAO.meetCriteria().iterator();
            while (it.hasNext()) {
                Player player = it.next();
                date[i][0] = player.getIdPlayer();
                date[i][1] = player.getTeamFK();
                date[i][2] = player.getName();
                date[i][3] = player.getBirthdate();
                date[i][4] = player.getHeight();
                date[i][5] = player.getWeight();
                date[i][6] = player.getSpike();
                date[i][7] = player.getPosition();
                i++;
            }
           JTable table = new JTable(date, columnNames);
            coach.getScrollPane().setViewportView(table);
        }
    }
    public class Matches implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] columnNames = {"Id", "Team1", "Team2", "Data", "Score"};
            Object[][] date = new Object[matchDAO.listMatches().size()][5];
            int i = 0;
            Iterator<Match> it = matchDAO.listMatches().iterator();
            while (it.hasNext()) {
                Match match = it.next();
                date[i][0] = match.getIdMatch();
                date[i][1] = match.getTeam1();
                date[i][2] = match.getTeam2();
                date[i][3] = match.getData();
                date[i][4] = match.getScore();
                i++;
            }
            JTable table = new JTable(date, columnNames);
            coach.getScrollPane().setViewportView(table);

        }
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Coach~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Login~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public class Log implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            if(DatabaseConnection.login(login)==0){
                regularUser.getFrame().setVisible(true);
                login.getFrame().setVisible(false);
            }
            else if(DatabaseConnection.login(login)==1){
                coach.getFrame().setVisible(true);
                login.getFrame().setVisible(false);
            }
            else if(DatabaseConnection.login(login)==2){
                administrator.getFrame().setVisible(true);
                login.getFrame().setVisible(false);
            }
         }
    }
    public class Exit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Login~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}