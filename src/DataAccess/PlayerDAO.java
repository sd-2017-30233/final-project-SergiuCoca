package DataAccess;

import Presentation.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
public class PlayerDAO {

    private PreparedStatement stmt=null;
    private Connection connection = DatabaseConnection.getConnection();

    public String create(Player player) {
        try {
            String query="INSERT INTO Player(idPlayer,TeamFK,Name,Birthdate,Height,Weight,Spike,Position) VALUES(?,?,?,?,?,?,?,?)";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, player.getIdPlayer());
            stmt.setInt(2, player.getTeamFK());
            stmt.setString(3, player.getName());
            stmt.setString(4, player.getBirthdate());
            stmt.setInt(5, player.getHeight());
            stmt.setInt(6, player.getWeight());
            stmt.setInt(7, player.getSpike());
            stmt.setString(8, player.getPosition());
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
            String query = "DELETE FROM Player WHERE idPlayer=?";
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

    public String update(int id, Player player) {
        try {
            String query="UPDATE Player SET  Height=?, Weight=?, Spike=?, Position=? WHERE idPlayer=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, player.getHeight());
            stmt.setInt(2, player.getWeight());
            stmt.setInt(3, player.getSpike());
            stmt.setString(4, player.getPosition());
            stmt.setInt(5, id);
            stmt.executeUpdate();
            //stmt.close();
           // connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return sqlException.getMessage();
        }
        return "Update successfully";
    }

    public ArrayList<Player> listPlayers() {
        try {
            ArrayList<Player> list=new ArrayList<Player>();
            String query="SELECT * FROM Player";
            stmt = connection.prepareStatement(query);
            ResultSet result=stmt.executeQuery();
            while (result.next()) {
                Player player = new Player(result.getInt("idPlayer"), result.getInt("TeamFK"),result.getString("Name"), result.getString("Birthdate"), result.getInt("Height"),result.getInt("Weight"),result.getInt("Spike"),result.getString("Position"));
                list.add(player);
            }
            // stmt.close();
            // connection.close();
            return list;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    public Player view(int id) {
        Player player = null;
        try {
            String query = "SELECT * FROM Player WHERE idPlayer=?";
            stmt = connection.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                player = new Player(result.getInt("idPlayer"), result.getInt("TeamFK"),result.getString("Name"), result.getString("Birthdate"), result.getInt("Height"),result.getInt("Weight"),result.getInt("Spike"),result.getString("Position"));
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return player;
    }

    public String transfer(int id) {
        try {
            String query = "UPDATE Player SET TeamFK='13' WHERE idPlayer=?;";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            // stmt.close();
            // connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
        return "Avaiable for transfer";
    }
}
