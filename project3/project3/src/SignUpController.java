import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController {
    private JPanel mainPanel;
    private JTextField userIDTF;
    private JTextField userNameTF;
    private JTextField passWordTF;
    private JTextField displayNameTF;
    private JButton registerUserButton;

    private Client client;
    public SignUpController(Client client) {
        this.client = client;

        registerUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (saveUser()) {
                    client.getMainFrame().setTitle("Register New User");
                    client.getMainFrame().setContentPane(client.getLoginViewController().getMainPanel());
                    client.getMainFrame().setMinimumSize(new Dimension(800, 400));
                    client.getMainFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    client.getMainFrame().pack();
                    client.getMainFrame().setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid format for UserID");

                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private boolean saveUser() {
        User user = new User();

        try {
            user.setUserID(Integer.parseInt(userIDTF.getText()));
            user.setUsername(userNameTF.getText());
            user.setPassword(passWordTF.getText());
            user.setDisplayName(displayNameTF.getText());
            user.setIsManager(false);


            Gson gson = new Gson();

            String userString = gson.toJson(user);

            Message message = new Message(Message.SAVE_USER, userString);
            client.sendMessage(message);
            return true;
        }
        catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
