import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchProductController {
    private JPanel mainPanel;
    private JButton searchButton;
    private JTextField queryTF;
    private JTable searchResultsTable;
    private JScrollPane scrollPane;

    private Client client;
    private DefaultTableModel tableModel;

    public SearchProductController(Client client) {
        this.client = client;
        tableModel = new DefaultTableModel();
        searchResultsTable.setModel(tableModel);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = queryTF.getText();
                searchAndDisplayResults(query);
            }
        });

    }

    private void searchAndDisplayResults(String query) {
        OrderLine orderLine = DatabaseManager.getInstance().searchProducts(query);
        String[] columns = new String[] {"Product ID", "Name", "Price", "Quantity"};
        tableModel.setColumnIdentifiers(columns);

        int row = orderLine.getList().size();
        int col = 4;

        String[][] data = new String[row][col];
        for (int i = 0; i < row; i++) {
            data[i][0] = String.valueOf(orderLine.getList().get(i).getProductID());
            data[i][1] = orderLine.getList().get(i).getName();
            data[i][2] = String.valueOf(orderLine.getList().get(i).getPrice());
            data[i][3] = String.valueOf(orderLine.getList().get(i).getQuantity());
            tableModel.addRow(data[i]);
        }

        searchResultsTable = new JTable(data, columns);
        scrollPane.updateUI();

    }

    public JPanel getMainPanel() {return mainPanel;}
}
