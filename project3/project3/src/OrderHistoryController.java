import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderHistoryController {
    private JButton searchButton;
    private JTextField orderQueryTF;
    private JTable orderHistoryTable;
    private JScrollPane scrollPanel;
    private JPanel mainPanel;

    private Client client;
    private DefaultTableModel tableModel;

    public OrderHistoryController(Client client) {
        this.client = client;
        tableModel = new DefaultTableModel();
        orderHistoryTable.setModel(tableModel);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = orderQueryTF.getText();
                searchOrderHistory(query);
            }
        });

    }
    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void searchOrderHistory(String query) {
        Order orders = DatabaseManager.getInstance().searchOrders(query);
        String[] columns = new String[] {"Order ID", "Order Date", "Customer ID", "Total Cost", "Total Tax"};
        tableModel.setColumnIdentifiers(columns);

        int row = orders.getList().size();
        int col = 5;

        String[][] data = new String[row][col];
        for (int i = 0; i < row; i++) {
            data[i][0] = String.valueOf(orders.getList().get(i).getOrderID());
            data[i][1] = orders.getList().get(i).getDate();
            data[i][2] = String.valueOf(orders.getList().get(i).getCustomerID());
            data[i][3] = String.valueOf(orders.getList().get(i).getTotalCost());
            data[i][4] = String.valueOf(orders.getList().get(i).getTotalTax());
            tableModel.addRow(data[i]);
        }

        orderHistoryTable = new JTable(data, columns);
        scrollPanel.updateUI();

    }
}
