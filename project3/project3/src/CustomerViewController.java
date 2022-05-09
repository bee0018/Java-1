import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerViewController {
    private JTextField customerIDTF;
    private JTextField usernameTF;
    private JTextField passwordTF;
    private JTextField phoneNumberTF;
    private JButton loadCustomerButton;
    private JButton saveCustomerButton;
    private JPanel mainPanel;
    private JTextField fullNameTF;
    private JTextField emailTF;
    private JTextField paymentTF;
    private JTextField addressTF;
    private JButton changePasswordButton;

    private Client client;
    private LoginScreen loginScreen;

    public CustomerViewController(Client client) {
        this.client = client;
        this.loginScreen = new LoginScreen(client);

        loadCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerID = customerIDTF.getText();
                Message message = new Message(Message.LOAD_CUSTOMER, customerID);
                client.sendMessage(message);
            }
        });

        saveCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new Customer();

                customer.setCustomerID(Integer.parseInt(customerIDTF.getText()));
                customer.setUsername(usernameTF.getText());
                customer.setPassword(passwordTF.getText());
                customer.setFullName(fullNameTF.getText());
                customer.setEmail(emailTF.getText());
                customer.setPaymentMethod(paymentTF.getText());
                customer.setAddress(addressTF.getText());
                customer.setPhoneNumber(phoneNumberTF.getText());

                Gson gson = new Gson();

                String customerString = gson.toJson(customer);

                Message message = new Message(Message.SAVE_CUSTOMER, customerString);
                client.sendMessage(message);
            }
        });

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Update New Password");
                frame.setContentPane(loginScreen.getMainPanel());
                frame.setMinimumSize(new Dimension(800, 400));
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void updateCustomerInfo(Customer customer) {
        customerIDTF.setText(String.valueOf(customer.getCustomerID()));
        usernameTF.setText(customer.getUsername());
        passwordTF.setText(customer.getPassword());
        fullNameTF.setText(customer.getFullName());
        emailTF.setText(customer.getEmail());
        paymentTF.setText(customer.getPaymentMethod());
        addressTF.setText(customer.getAddress());
        phoneNumberTF.setText(customer.getPhoneNumber());
    }
}
