package Business;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Administrator {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JLabel lblmessage = new JLabel("");

    private JButton btnClear = new JButton("Clear");
    private JComboBox comboBox = new JComboBox(new DefaultComboBoxModel(new String[] {"  ","Add", "Delete", "Edit","Transfer" }));
    private JComboBox comboBox_1 = new JComboBox(new DefaultComboBoxModel(new String[] {"  ","Add", "Delete", "Edit" }));
    private JButton btnLogout = new JButton("Logout");


    public JLabel getLblmessage() {
        return lblmessage;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public JComboBox getComboBox_1() {
        return comboBox_1;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JTextField getTextField_1() {
        return textField_1;
    }

    public JTextField getTextField_2() {
        return textField_2;
    }

    public JTextField getTextField_3() {
        return textField_3;
    }

    public JTextField getTextField_4() {
        return textField_4;
    }

    public JTextField getTextField_5() {
        return textField_5;
    }

    public JTextField getTextField_6() {
        return textField_6;
    }

    public JTextField getTextField_7() {
        return textField_7;
    }

    public JTextField getTextField_8() {
        return textField_8;
    }

    public JTextField getTextField_9() {
        return textField_9;
    }

    public JTextField getTextField_10() {
        return textField_10;
    }

    public JTextField getTextField_11() {
        return textField_11;
    }

    public JTextField getTextField_12() {
        return textField_12;
    }

    public Administrator() {
        initialize();
    }


    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 625, 454);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblId = new JLabel("Id:");
        lblId.setFont(UIManager.getFont("Label.font"));
        lblId.setBounds(10, 45, 46, 14);
        panel.add(lblId);

        JLabel lblTeam = new JLabel("Team:");
        lblTeam.setFont(UIManager.getFont("Label.font"));
        lblTeam.setBounds(10, 76, 64, 14);
        panel.add(lblTeam);

        JLabel lblNume = new JLabel("Name:");
        lblNume.setFont(UIManager.getFont("Label.font"));
        lblNume.setBounds(10, 107, 68, 14);
        panel.add(lblNume);

        JLabel lblBirth = new JLabel("Birthdate:");
        lblBirth.setFont(UIManager.getFont("Label.font"));
        lblBirth.setBounds(10, 138, 68, 14);
        panel.add(lblBirth);

        JLabel lblHeight = new JLabel("Height:");
        lblHeight.setFont(UIManager.getFont("Label.font"));
        lblHeight.setBounds(10, 169, 68, 14);
        panel.add(lblHeight);

        textField = new JTextField();
        textField.setFont(UIManager.getFont("TextField.font"));
        textField.setBounds(84, 42, 105, 20);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setFont(UIManager.getFont("TextField.font"));
        textField_1.setBounds(84, 73, 105, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setFont(UIManager.getFont("TextField.font"));
        textField_2.setBounds(84, 104, 105, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setFont(UIManager.getFont("TextField.font"));
        textField_3.setBounds(84, 135, 105, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setFont(UIManager.getFont("TextField.font"));
        textField_4.setBounds(84, 166, 105, 20);
        panel.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblSelectOperation = new JLabel("Select operation for players:");
        lblSelectOperation.setFont(UIManager.getFont("Label.font"));
        lblSelectOperation.setBounds(41, 290, 161, 14);
        panel.add(lblSelectOperation);

        comboBox.setBounds(65, 315, 94, 17);
        panel.add(comboBox);

        JLabel lblPlayers = new JLabel("Players");
        lblPlayers.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPlayers.setBounds(99, 11, 72, 20);
        panel.add(lblPlayers);

        JLabel lblTeams = new JLabel("Teams");
        lblTeams.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTeams.setBounds(441, 11, 103, 20);
        panel.add(lblTeams);

        JLabel lblWeight = new JLabel("Weight:");
        lblWeight.setFont(UIManager.getFont("Label.font"));
        lblWeight.setBounds(10, 200, 68, 14);
        panel.add(lblWeight);

        JLabel lblSpike = new JLabel("Spike:");
        lblSpike.setFont(UIManager.getFont("Label.font"));
        lblSpike.setBounds(10, 231, 64, 14);
        panel.add(lblSpike);

        JLabel lblPosition = new JLabel("Position:");
        lblPosition.setFont(UIManager.getFont("Label.font"));
        lblPosition.setBounds(10, 262, 72, 14);
        panel.add(lblPosition);

        textField_5 = new JTextField();
        textField_5.setFont(UIManager.getFont("TextField.font"));
        textField_5.setBounds(84, 197, 105, 20);
        panel.add(textField_5);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setFont(UIManager.getFont("TextField.font"));
        textField_6.setBounds(84, 228, 105, 20);
        panel.add(textField_6);
        textField_6.setColumns(10);

        textField_7 = new JTextField();
        textField_7.setFont(UIManager.getFont("TextField.font"));
        textField_7.setBounds(84, 259, 105, 20);
        panel.add(textField_7);
        textField_7.setColumns(10);

        JLabel lblSelectOperationFor = new JLabel("Select operation for teams:");
        lblSelectOperationFor.setFont(UIManager.getFont("Label.font"));
        lblSelectOperationFor.setBounds(370, 216, 183, 14);
        panel.add(lblSelectOperationFor);

        comboBox_1.setBounds(380, 239, 105, 20);
        panel.add(comboBox_1);

        btnLogout.setFont(UIManager.getFont("Button.font"));
        btnLogout.setBounds(381, 359, 89, 23);
        panel.add(btnLogout);

        btnClear.setFont(UIManager.getFont("Button.font"));
        btnClear.setBounds(179, 359, 89, 23);
        panel.add(btnClear);

        lblmessage.setFont(UIManager.getFont("Label.font"));
        lblmessage.setBounds(228, 316, 316, 14);
        panel.add(lblmessage);

        JLabel lblId_1 = new JLabel("Id:");
        lblId_1.setFont(UIManager.getFont("Label.font"));
        lblId_1.setBounds(338, 45, 46, 14);
        panel.add(lblId_1);

        JLabel lblCoach = new JLabel("Coach:");
        lblCoach.setFont(UIManager.getFont("Label.font"));
        lblCoach.setBounds(338, 76, 65, 14);
        panel.add(lblCoach);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(UIManager.getFont("Label.font"));
        lblName.setBounds(338, 107, 65, 14);
        panel.add(lblName);

        JLabel lblTown = new JLabel("Town:");
        lblTown.setFont(UIManager.getFont("Label.font"));
        lblTown.setBounds(338, 138, 65, 14);
        panel.add(lblTown);

        JLabel lblRank = new JLabel("Rank:");
        lblRank.setFont(UIManager.getFont("Label.font"));
        lblRank.setBounds(338, 169, 46, 14);
        panel.add(lblRank);

        textField_8 = new JTextField();
        textField_8.setFont(UIManager.getFont("TextField.font"));
        textField_8.setBounds(413, 42, 105, 20);
        panel.add(textField_8);
        textField_8.setColumns(10);

        textField_9 = new JTextField();
        textField_9.setFont(UIManager.getFont("TextField.font"));
        textField_9.setBounds(413, 73, 105, 20);
        panel.add(textField_9);
        textField_9.setColumns(10);

        textField_10 = new JTextField();
        textField_10.setFont(UIManager.getFont("TextField.font"));
        textField_10.setBounds(413, 104, 105, 20);
        panel.add(textField_10);
        textField_10.setColumns(10);

        textField_11 = new JTextField();
        textField_11.setFont(UIManager.getFont("TextField.font"));
        textField_11.setBounds(413, 138, 105, 20);
        panel.add(textField_11);
        textField_11.setColumns(10);

        textField_12 = new JTextField();
        textField_12.setFont(UIManager.getFont("TextField.font"));
        textField_12.setBounds(413, 166, 105, 20);
        panel.add(textField_12);
        textField_12.setColumns(10);
    }
    public void addComboBoxListener(ActionListener cal){
        comboBox.addActionListener(cal);
    }
    public void addComboBox1Listener(ActionListener cal){
        comboBox_1.addActionListener(cal);
    }
    public void addLogoutListener(ActionListener cal){
        btnLogout.addActionListener(cal);
    }
    public void addClearListener(ActionListener cal){
        btnClear.addActionListener(cal);
    }
}