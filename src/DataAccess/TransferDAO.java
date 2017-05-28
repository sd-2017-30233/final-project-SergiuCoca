package DataAccess;

import Presentation.Criteria;
import Presentation.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
public class TransferDAO implements Criteria{

    private PreparedStatement stmt=null;
    private Connection connection = DatabaseConnection.getConnection();

    public ArrayList<Player> meetCriteria() {
        try {
            ArrayList<Player> list=new ArrayList<Player>();
            String query="SELECT * FROM Player WHERE TeamFK=13";
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
}
