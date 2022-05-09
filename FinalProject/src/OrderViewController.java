import com.google.gson.Gson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderViewController {
    private JPanel mainPanel;
    private JTextField orderIDTF;
    private JTextField orderDateTF;
    private JTextField customerIDTF;
    private JTextField totalCostTF;
    private JTextField totalTaxTF;
    private JButton loadButton;
    private JButton saveButton;

    private Client client;

    public OrderViewController(Client client) {
        this.client = client;

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderID = orderIDTF.getText();
                Message message = new Message(Message.LOAD_ORDER, orderID);
                client.sendMessage(message);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Order order = new Order();
                order.setOrderID(Integer.parseInt(orderIDTF.getText()));
                order.setDate(orderDateTF.getText());
                order.setCustomerID(customerIDTF.getText());
                order.setTotalCost(Double.parseDouble(totalCostTF.getText()));
                order.setTotalTax(Double.parseDouble(totalTaxTF.getText()));

                Gson gson = new Gson();
                String productString = gson.toJson(order);
                Message message = new Message(Message.SAVE_ORDER, productString);
                client.sendMessage(message);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void updateOrderInfo(Order order) {
        orderIDTF.setText(String.valueOf(order.getOrderID()));
        orderDateTF.setText(String.valueOf(order.getDate()));
        customerIDTF.setText(String.valueOf(order.getCustomerID()));
        totalCostTF.setText(String.valueOf(order.getTotalCost()));
        totalTaxTF.setText(String.valueOf(order.getTotalTax()));
    }
}
