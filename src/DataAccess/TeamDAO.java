package DataAccess;


import Presentation.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
public class TeamDAO {

    private PreparedStatement stmt=null;
    private Connection connection = DatabaseConnection.getConnection();

    public String create(Team team) {
        try {
            String query="INSERT INTO Team(idTeam,CoachFK,Name,Town,Rank) VALUES(?,?,?,?,?)";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, team.getIdTeam());
            stmt.setInt(2, team.getCoachFK());
            stmt.setString(3, team.getName());
            stmt.setString(4, team.getTown());
            stmt.setInt(5, team.getRank());
            stmt.executeUpdate();
            //  stmt.close();
            // connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            if (sqlException.getMessage().contains("foreign key"))
                return "Something went wrong";
            else return sqlException.getMessage();
        }
        return "Inserted successfully";
    }

    public String delete(int id) {
        try {
            String query = "DELETE FROM Team WHERE idTeam=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            // stmt.close();
            // connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
        return "Deleted successfully";
    }

    public String update(int id, Team team) {
        try {
            String query="UPDATE Team SET CoachFK=?, Name=?, Rank=? WHERE idTeam=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, team.getCoachFK());
            stmt.setString(2, team.getName());
            stmt.setInt(3, team.getRank());
            stmt.setInt(4, id);
            stmt.executeUpdate();
            //stmt.close();
            // connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return sqlException.getMessage();
        }
        return "Update successfully";
    }

    public ArrayList<Team> listTeams() {
        try {
            ArrayList<Team> list=new ArrayList<Team>();
            String query="SELECT * FROM Team";
            stmt = connection.prepareStatement(query);
            ResultSet result=stmt.executeQuery();
            while (result.next()) {
                Team team = new Team(result.getInt("idTeam"), result.getInt("CoachFK"),result.getString("Name"), result.getString("Town"),result.getInt("Rank"));
                list.add(team);
            }
            // stmt.close();
            // connection.close();
            return list;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    public Team view(int id) {
        Team team = null;
        try {
            String query = "SELECT * FROM Team WHERE idTeam=?";
            stmt = connection.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                team = new Team(result.getInt("idTeam"), result.getInt("CoachFK"),result.getString("Name"), result.getString("Town"),result.getInt("Rank"));
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return team;
    }
}
