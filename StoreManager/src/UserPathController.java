import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPathController {
    UserPath myView;
    DataAccess myDAO;

    public UserPathController(UserPath view, DataAccess dao) {
        myView = view;
        myDAO = dao;
        myView.btnCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StoreManager.getInstance().getUserView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                StoreManager.getInstance().getUserView().setVisible(true); // Show the ProductView!
            }
        });
        myView.btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StoreManager.getInstance().getOrderView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                StoreManager.getInstance().getOrderView().setVisible(true); // Show the OrderView!
            }
        });
        myView.btnProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StoreManager.getInstance().getProductView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                StoreManager.getInstance().getProductView().setVisible(true); // Show the ProductView!
            }
        });
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == myView.btnProduct) {      // button Product is clicked
//            StoreManager.getInstance().getProductView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            StoreManager.getInstance().getProductView().setVisible(true); // Show the ProductView!
//        }
//
//         if (e.getSource() == myView.btnOrder) {      // button Order is clicked
//             StoreManager.getInstance().getOrderView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             StoreManager.getInstance().getOrderView().setVisible(true); // Show the OrderView!
//        }
//
//        if (e.getSource() == myView.btnCustomer) {    // button Customer is clicked
//            StoreManager.getInstance().getUserView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            StoreManager.getInstance().getUserView().setVisible(true); // Show the OrderView!
//        }
//
//    }
}
