import javax.swing.*;
import java.awt.*;

public class UserView extends JFrame {
    // Text Fields
    public JTextField txtUserID = new JTextField(30);
    public JTextField txtUsername = new JTextField(30);
    public JTextField txtPassword = new JTextField(30);
    public JTextField txtDisplayName = new JTextField(30);
    public JTextField txtIsManager = new JTextField(30);

    // Buttons
    public JButton btnLoad = new JButton("Load");
    public JButton btnSave = new JButton("Save");

    public UserView() {

        this.setTitle("User View");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel line1 = new JPanel();
        line1.add(new JLabel("User ID"));
        line1.add(txtUserID);
        this.getContentPane().add(line1);

        JPanel line2 = new JPanel();
        line2.add(new JLabel("Username"));
        line2.add(txtUsername);
        this.getContentPane().add(line2);

        JPanel line3 = new JPanel();
        line3.add(new JLabel("Password"));
        line3.add(txtPassword);
        this.getContentPane().add(line3);

        JPanel line4 = new JPanel();
        line4.add(new JLabel("Display Name"));
        line4.add(txtDisplayName);
        this.getContentPane().add(line4);

        JPanel line5 = new JPanel();
        line5.add(new JLabel("Manager"));
        line5.add(txtIsManager);
        this.getContentPane().add(line5);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSave);

        this.getContentPane().add(buttonPanel);
    }
}
