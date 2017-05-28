package Business;

/**
 * Created by Sergiu Coca on 5/20/2017.
 */
public class Main {
    public static void main(String [] args) {
        Login login = new Login();
        Controller controller = new Controller(login);
        login.getFrame().setVisible(true);
    }
}
