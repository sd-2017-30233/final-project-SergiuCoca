package Business;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class RegularUser {

    private JFrame frame;
    private JTextField textField_1;
    private JTextField textField_2;

    private JLabel lblMessage = new JLabel("Message:");
    private JComboBox comboBox_1 = new JComboBox(
            new DefaultComboBoxModel(new String[] {" ","Name", "Town", "Rank" }));
    private JComboBox comboBox = new JComboBox(
            new DefaultComboBoxModel(new String[] {" ","Name", "Position", "Height" }));

    private JButton btnSearch = new JButton("Search");
    private JButton btnLogout = new JButton("Logout");

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getTextField_1() {
        return textField_1;
    }

    public JTextField getTextField_2() {
        return textField_2;
    }

    public JLabel getLblMessage() {
        return lblMessage;
    }

    public JComboBox getComboBox_1() {
        return comboBox_1;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public RegularUser() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 451, 375);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        textField_1 = new JTextField();
        textField_1.setFont(UIManager.getFont("TextField.font"));
        textField_1.setBounds(10, 88, 190, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setFont(UIManager.getFont("TextField.font"));
        textField_2.setBounds(83, 230, 301, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);

        String[] columnNames={"","","","","",""};
        Object[][] data=new Object[10][6];

        JLabel lblSearchPlayerBy = new JLabel("Search player by:");
        lblSearchPlayerBy.setFont(UIManager.getFont("Label.font"));
        lblSearchPlayerBy.setBounds(10, 28, 120, 14);
        panel.add(lblSearchPlayerBy);

        JLabel lblSearchTeamBy = new JLabel("Search team by:");
        lblSearchTeamBy.setFont(UIManager.getFont("Label.font"));
        lblSearchTeamBy.setBounds(10, 153, 120, 14);
        panel.add(lblSearchTeamBy);

        lblMessage.setFont(UIManager.getFont("Label.font"));
        lblMessage.setBounds(10, 233, 74, 14);
        panel.add(lblMessage);

        comboBox.setFont(UIManager.getFont("ComboBox.font"));
        comboBox.setBounds(109, 27, 80, 17);
        panel.add(comboBox);

        btnSearch.setFont(UIManager.getFont("Button.font"));
        btnSearch.setBounds(228, 87, 86, 23);
        panel.add(btnSearch);

        btnLogout.setFont(UIManager.getFont("Button.font"));
        btnLogout.setBounds(185, 284, 89, 23);
        panel.add(btnLogout);

        comboBox_1.setFont(UIManager.getFont("ComboBox.font"));
        comboBox_1.setBounds(115, 150, 74, 20);
        panel.add(comboBox_1);
    }

    public void addSearchListener(ActionListener cal){
        btnSearch.addActionListener(cal);
    }
    public void addOutListener(ActionListener cal){
        btnLogout.addActionListener(cal);
    }
}