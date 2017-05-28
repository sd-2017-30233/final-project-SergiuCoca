package Business;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class Coach {

    private JFrame frame;
    private JLabel lblMessage = new JLabel("");
    private JButton btnViewMatches = new JButton("View matches");
    private JButton btnAvaiablePlayers = new JButton("Avaiable players");
    private JButton btnLogout = new JButton("Logout");
    private JScrollPane scrollPane = new JScrollPane();

    public Coach() {
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JLabel getLblMessage() {
        return lblMessage;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 629, 343);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        btnViewMatches.setFont(UIManager.getFont("Button.font"));
        btnViewMatches.setBounds(10, 33, 131, 23);
        panel.add(btnViewMatches);

        btnAvaiablePlayers.setFont(UIManager.getFont("Button.font"));
        btnAvaiablePlayers.setBounds(10, 79, 131, 23);
        panel.add(btnAvaiablePlayers);


        scrollPane.setBounds(180, 25, 423, 176);
        panel.add(scrollPane);

        lblMessage.setBounds(10, 227, 319, 14);
        panel.add(lblMessage);

        btnLogout.setFont(UIManager.getFont("Button.font"));
        btnLogout.setBounds(277, 258, 89, 23);
        panel.add(btnLogout);
    }
    public void addMatchesListener(ActionListener cal){
        btnViewMatches.addActionListener(cal);
    }
    public void addLOutListener(ActionListener cal){
        btnLogout.addActionListener(cal);
    }
    public void addPlayersListener(ActionListener cal){
        btnAvaiablePlayers.addActionListener(cal);
    }
}