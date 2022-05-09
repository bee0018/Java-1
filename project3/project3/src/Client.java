import com.google.gson.Gson;

import javax.crypto.SecretKey;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Base64;

public class Client {
    private JTextArea messageTextArea;
    private JPanel mainPanel;
    private JButton manageInfoButton;
    private JButton manageOrderButton;
    private JButton createOrderButton;
    private JButton searchProductButton;


    private SecretKey secretKey;

    private byte[] initializationVector;


    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    private Gson gson;

    private Worker worker;

    private ProductViewController productViewController;
    private LoginScreen loginScreen;
    private CustomerViewController customerViewController;
    private OrderViewController orderViewController;
    private SignUpController signUpController;
    private SearchProductController searchProductController;
    private OrderHistoryController orderHistoryController;


    /* New code for the final project*/

    private LoginViewController loginViewController;
    private CreateNewOrderViewController createNewOrderViewController;
    private JFrame mainFrame;
    private User user;

    public Client() {
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 12002);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // send the secret key
            secretKey = KeyService.createAESKey();

            String keyString = KeyService.convertSecretKeyToString(secretKey);

            dataOutputStream.writeUTF(keyString);

            // send the initialization vector

            initializationVector = KeyService.createInitializationVector();

            String vectorString = Base64.getEncoder().encodeToString(initializationVector);

            dataOutputStream.writeUTF(vectorString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }





        gson = new Gson();

        worker = new Worker();
        Thread workerThread = new Thread(worker);
        workerThread.start();

        this.createNewOrderViewController = new CreateNewOrderViewController(this);
        this.customerViewController = new CustomerViewController(this);
        this.orderViewController = new OrderViewController(this);
        this.searchProductController = new SearchProductController(this);
        this.orderHistoryController = new OrderHistoryController(this);

        createOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Create Order");
                frame.setContentPane(createNewOrderViewController.getMainPanel());
                frame.setMinimumSize(new Dimension(800, 400));
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        manageInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Manage Customer Information");
                frame.setContentPane(customerViewController.getMainPanel());
                frame.setMinimumSize(new Dimension(800, 400));
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        searchProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Search Products");
                frame.setContentPane(searchProductController.getMainPanel());
                frame.setMinimumSize(new Dimension(800, 400));
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        manageOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Order History");
                frame.setContentPane(orderHistoryController.getMainPanel());
                frame.setMinimumSize(new Dimension(800, 400));
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        this.loginViewController = new LoginViewController(this);
        this.signUpController = new SignUpController(this);
        this.loginScreen = new LoginScreen(this);
        this.mainFrame = new JFrame("Main Window");
    }

    public void sendMessage(Message message) {

        String str = gson.toJson(message);
        try {

            // Encrypting the message
            // using the symmetric key
            byte[] cipherText
                    = KeyService.do_AESEncryption(
                    str,
                    secretKey,
                    initializationVector);

            String cipherTextString = Base64.getEncoder().encodeToString(cipherText);

            dataOutputStream.writeUTF(cipherTextString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public LoginViewController getLoginViewController() {
        return loginViewController;
    }

    public SignUpController getSignUpController() {
        return signUpController;
    }

    public OrderViewController getOrderViewController() {return orderViewController;}

    public LoginScreen getLoginScreen() {return loginScreen;}

    public void setLoginViewController(LoginViewController loginViewController) {
        this.loginViewController = loginViewController;
    }

    public User getUser() {
        return user;
    }


    private class Worker implements Runnable {

        @Override
        public void run() {
            while (true) {
                String replyString = null;
                try {
                    replyString = dataInputStream.readUTF();

                    byte[] decode = Base64.getDecoder().decode(replyString);

                    replyString
                            = KeyService.do_AESDecryption(
                            decode,
                            secretKey,
                            initializationVector);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Message message = gson.fromJson(replyString, Message.class);

                processMessage(message);

            }
        }
    }

    private void processMessage(Message message) {
        messageTextArea.append(gson.toJson(message) + "\n");
        switch (message.getId()) {
            case Message.LOAD_PRODUCT_REPLY: {
                Product product = gson.fromJson(message.getContent(), Product.class);
                productViewController.updateProductInfo(product);
                break;
            }

            case Message.LOAD_PRODUCT_REPLY_TO_ADD: {
                Product product = gson.fromJson(message.getContent(), Product.class);
                createNewOrderViewController.updateOrder(product);
                break;
            }

            case Message.LOAD_CUSTOMER_REPLY: {
                Customer customer = gson.fromJson(message.getContent(), Customer.class);
                customerViewController.updateCustomerInfo(customer);
                break;
            }
            case Message.LOAD_ORDER_REPLY: {
                Order order = gson.fromJson(message.getContent(), Order.class);
                orderViewController.updateOrderInfo(order);
                break;
            }


            case Message.LOGIN_RESPONSE_SUCCESS: {
                User user = gson.fromJson(message.getContent(), User.class);
                this.user = user;

                if (user.getIsManager()) {
                    this.productViewController = new ProductViewController(this);
                    this.mainFrame.setTitle("Manage Product");
                    this.mainFrame.setContentPane(productViewController.getMainPanel());
                    productViewController.getMainPanel().updateUI();

                } else {
                    this.mainFrame.setTitle("Customer View");
                    this.mainFrame.setContentPane(this.mainPanel);
                    this.mainPanel.updateUI();
                }
            }

            default:
        }

    }

    public static void main(String[] args) {

        Client client = new Client();
        client.getMainFrame().setTitle("Login");
        client.getMainFrame().setContentPane(client.getLoginViewController().getMainPanel());
        client.getMainFrame().setMinimumSize(new Dimension(800, 400));
        client.getMainFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.getMainFrame().pack();
        client.getMainFrame().setVisible(true);
    }
}
