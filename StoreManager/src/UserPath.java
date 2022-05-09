import javax.swing.*;
import java.awt.*;

public class UserPath extends JFrame {
    public JButton btnProduct = new JButton("Product");
    public JButton btnCustomer = new JButton("Customer");
    public JButton btnOrder = new JButton("Order");

    public UserPath() {
        this.setTitle("User Path Selection");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnCustomer);
        buttonPanel.add(btnOrder);
        buttonPanel.add(btnProduct);

        this.getContentPane().add(buttonPanel);
    }
}
