import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginViewController {
    private JPanel mainPanel;
    private JTextField usernameTF;
    private JButton loginButton;
    private JButton signUpButton;
    private JPasswordField passwordTF;

    private Client client;
    private SignUpController signUpController;

    public LoginViewController(Client client) {
        this.client = client;
        this.signUpController = new SignUpController(client);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTF.getText();
                String password = new String(passwordTF.getPassword());

                UserInfo userInfo = new UserInfo(username, password);
                Gson gson = new Gson();
                Message loginMessage = new Message(Message.LOGIN_REQUEST, gson.toJson(userInfo));
                client.sendMessage(loginMessage);
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.getMainFrame().setTitle("Register New User");
                client.getMainFrame().setContentPane(client.getSignUpController().getMainPanel());
                client.getMainFrame().setMinimumSize(new Dimension(800, 400));
                client.getMainFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                client.getMainFrame().pack();
                client.getMainFrame().setVisible(true);
            }
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
