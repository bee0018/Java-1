import com.google.gson.Gson;
import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerViewController {
    private JPanel mainPanel;
    private JTextField customerIDTF;
    private JTextField firstNameTF;
    private JTextField lastNameTF;
    private JTextField phoneNumTF;
    private JLabel customerID;
    private JButton loadButton;
    private JButton saveButton;

    private Client client;

    public CustomerViewController(Client client) {
        this.client = client;

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerID = customerIDTF.getText();
                Message message = new Message(Message.LOAD_CUSTOMER, customerID);
                client.sendMessage(message);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Customer customer = new Customer("", "", "", "");

                customer.setCustomerID(customerIDTF.getText());
                customer.setFirstName(firstNameTF.getText());
                customer.setLastName(lastNameTF.getText());
                customer.setPhoneNumber(phoneNumTF.getText());

                Gson gson = new Gson();
                String productString = gson.toJson(customer);
                Message message = new Message(Message.SAVE_CUSTOMER, productString);
                client.sendMessage(message);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void updateCustomerInfo(Customer customer) {
        firstNameTF.setText(customer.getFirstName());
        lastNameTF.setText(customer.getLastName());
        phoneNumTF.setText(customer.getPhoneNumber());
    }
}
