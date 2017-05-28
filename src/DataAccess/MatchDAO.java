package DataAccess;

import Presentation.Match;
import Presentation.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
public class MatchDAO {

    private PreparedStatement stmt=null;
    private Connection connection = DatabaseConnection.getConnection();

    public ArrayList<Match> listMatches() {
        try {
            ArrayList<Match> list=new ArrayList<Match>();
            String query="SELECT * FROM Matches";
            stmt = connection.prepareStatement(query);
            ResultSet result=stmt.executeQuery();
            while (result.next()) {
                Match match = new Match(result.getInt("idMatch"), result.getInt("Team1"),result.getInt("Team2"), result.getString("Data"), result.getString("Score"));
                list.add(match);
            }
            // stmt.close();
            // connection.close();
            return list;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }
}
