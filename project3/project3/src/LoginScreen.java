import com.google.gson.Gson;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginScreen {
    public JPanel getMainPanel() {
        return mainPanel;
    }

    private JPanel mainPanel;
    private JTextField usernameTF;
    private JPasswordField passwordTF;
    private JButton updatePasswordButton;
    private Client client;

    private OrderViewController orderViewController;
    private ProductViewController productViewController;
    private SignUpController signUpController;
    private Connection connection;

    public LoginScreen(Client client){
        this.client = client;
        this.signUpController = new SignUpController(client);

        // time to code what the login button does
        updatePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = usernameTF.getText();
                String password = new String(passwordTF.getPassword());
                Account account = new Account(username, password);
                User user = DatabaseManager.getInstance().loadUser(account);

                user.setUserID(user.getUserID());
                user.setUsername(username);
                user.setPassword(password);
                user.setDisplayName(user.getDisplayName());
                user.setIsManager(false);

                DatabaseManager.getInstance().changeUserPassword(user);
            }
        });



    }

}
