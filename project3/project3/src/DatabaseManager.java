import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.annotation.processing.Processor;
import javax.xml.crypto.Data;
import java.sql.*;

public class DatabaseManager {

    private static DatabaseManager databaseManager;
    public static DatabaseManager getInstance() {
        if (databaseManager == null) databaseManager = new DatabaseManager();
        return databaseManager;
    }

    private Connection connection;

    private DatabaseManager() {

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:data/store.db");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public Message process(String requestString) {

        Gson gson = new Gson();
        Message message = gson.fromJson(requestString, Message.class);

        switch (message.getId()) {
            case Message.LOAD_PRODUCT: {
                Product product = loadProduct(Integer.parseInt(message.getContent()));
                Message replyMessage = new Message(Message.LOAD_PRODUCT_REPLY, gson.toJson(product));
                return replyMessage;
            }

            case Message.LOAD_PRODUCT_TO_ADD: {
                Product product = loadProduct(Integer.parseInt(message.getContent()));
                Message replyMessage = new Message(Message.LOAD_PRODUCT_REPLY_TO_ADD, gson.toJson(product));
                return replyMessage;
            }

// TODO: process the Message.SAVE_ORDER_LINE

            case Message.SAVE_PRODUCT: {
                Product product = gson.fromJson(message.getContent(), Product.class);
                boolean result = saveProduct(product);
                if (result) return new Message(Message.SUCCESS, "Product saved");
                else return new Message(Message.FAIL, "Cannot save the product");
            }

            case Message.LOAD_CUSTOMER: {
                Customer customer = loadCustomer(Integer.parseInt(message.getContent()));
                Message replyMessage = new Message(Message.LOAD_CUSTOMER_REPLY, gson.toJson(customer));
                return replyMessage;
            }


            case Message.SAVE_CUSTOMER: {
                Customer customer = gson.fromJson(message.getContent(), Customer.class);
                boolean result = saveCustomer(customer);
                if (result) return new Message(Message.SUCCESS, "Customer saved");
                else return new Message(Message.FAIL, "Cannot save the customer");
            }

            case Message.SAVE_USER: {
                User user = gson.fromJson(message.getContent(), User.class);
                boolean result = saveUser(user);
                if (result) return new Message(Message.SUCCESS, "User saved");
                else return new Message(Message.FAIL, "Cannot save the user");
            }

            case Message.LOAD_ORDER: {
                Order order = loadOrder(Integer.parseInt(message.getContent()));
                Message replyMessage = new Message(Message.LOAD_ORDER_REPLY, gson.toJson(order));
                return replyMessage;
            }

            case Message.CANCEL_ORDER: {
                boolean result = cancelOrder(Integer.parseInt(message.getContent()));
                if (result) return new Message(Message.FAIL, "Cannot cancel the order");
                else return new Message(Message.SUCCESS, "Order canceled");
            }

            case Message.SAVE_ORDER: {
                Order order = gson.fromJson(message.getContent(), Order.class);
                boolean result = saveOrder(order);
                if (result) return new Message(Message.SUCCESS, "Order saved");
                else return new Message(Message.FAIL, "Cannot save the order");
            }

            case Message.LOGIN: {
                System.out.println("Received a login message");
                System.out.println(message);
                // TODO: check to see if login is valid
                return new Message(Message.SUCCESS, "Account logged in");
            }

            case Message.LOGIN_REQUEST: {
                UserInfo userInfo = gson.fromJson(message.getContent(), UserInfo.class);
                System.out.println(userInfo);
                User user = loadUser(userInfo.getUsername());

                if (user==null) {
                    return new Message(Message.LOGIN_RESPONSE_NO_USERNAME, "This username doesn't exist in the system");
                } else {
                    if (!user.getPassword().equals(userInfo.getPassword())) {
                        return new Message(Message.LOGIN_RESPONSE_FAIL_PASSWORD, "THe password is incorrect");
                    } else {
                        return new Message(Message.LOGIN_RESPONSE_SUCCESS, gson.toJson(user));
                    }
                }
            }

            default:
                return new Message(Message.FAIL, "Cannot process the message");
        }
    }

    private User loadUser(String username) {
        try {
            String query = "SELECT * FROM Users WHERE username = '" + username+ "'";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setDisplayName(resultSet.getString(4));
                user.setIsManager(resultSet.getBoolean(5));
                resultSet.close();
                statement.close();

                return user;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }

    public Product loadProduct(int id) {
        try {
            String query = "SELECT * FROM Products WHERE ProductID = " + id;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getDouble(3));
                product.setQuantity(resultSet.getDouble(4));
                resultSet.close();
                statement.close();

                return product;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveProduct(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Products WHERE ProductID = ?");
            statement.setInt(1, product.getProductID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this product exists, update its fields
                statement = connection.prepareStatement("UPDATE Products SET Name = ?, Price = ?, Quantity = ? WHERE ProductID = ?");
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getPrice());
                statement.setDouble(3, product.getQuantity());
                statement.setInt(4, product.getProductID());
            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Products VALUES (?, ?, ?, ?)");
                statement.setString(2, product.getName());
                statement.setDouble(3, product.getPrice());
                statement.setDouble(4, product.getQuantity());
                statement.setInt(1, product.getProductID());
            }
            statement.execute();
            resultSet.close();
            statement.close();
            return true;        // save successfully

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; // cannot save!
        }
    }

    //CUSTOMERS
    public Customer loadCustomer(int id) {
        try {
            String query = "SELECT * FROM Customers WHERE CustomerID = " + id;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(resultSet.getInt(1));
                customer.setUsername(resultSet.getString(2));
                customer.setPassword(resultSet.getString(3));
                customer.setFullName(resultSet.getString(4));
                customer.setEmail(resultSet.getString(5));
                customer.setPaymentMethod(resultSet.getString(6));
                customer.setAddress(resultSet.getString(7));
                customer.setPhoneNumber(resultSet.getString(8));
                resultSet.close();
                statement.close();

                return customer;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveCustomer(Customer customer) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customers WHERE CustomerID = ?");
            statement.setInt(1, customer.getCustomerID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this customer exists, update its fields
                statement = connection.prepareStatement("UPDATE Customers SET Username = ?, Password = ?, FullName = ?, Email = ?, PaymentMethod = ?, Address = ?, PhoneNumber = ? WHERE CustomerID = ?");
                statement.setString(1, customer.getUsername());
                statement.setString(2, customer.getPassword());
                statement.setString(3, customer.getFullName());
                statement.setString(4, customer.getEmail());
                statement.setString(5, customer.getPaymentMethod());
                statement.setString(6, customer.getAddress());
                statement.setString(7, customer.getPhoneNumber());
                statement.setInt(8, customer.getCustomerID());
            }
            else { // this customer does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Customers VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                statement.setString(2, customer.getUsername());
                statement.setString(3, customer.getPassword());
                statement.setString(4, customer.getFullName());
                statement.setString(5, customer.getEmail());
                statement.setString(6, customer.getPaymentMethod());
                statement.setString(7, customer.getAddress());
                statement.setString(8, customer.getPhoneNumber());
                statement.setInt(1, customer.getCustomerID());
            }
            statement.execute();
            resultSet.close();
            statement.close();
            return true;        // save successfully

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; // cannot save!
        }
    }

    // ORDERS
    public Order loadOrder(int id) {
        try {
            String query = "SELECT * FROM Orders WHERE OrderID = " + id;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Order order = new Order();
                order.setOrderID(resultSet.getInt(1));
                order.setDate(resultSet.getString(2));
                order.setCustomerID(resultSet.getInt(3));
                order.setTotalCost(resultSet.getDouble(4));
                order.setTotalTax(resultSet.getDouble(5));
                resultSet.close();
                statement.close();

                return order;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveOrder(Order order) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders WHERE OrderID = ?");
            statement.setInt(1, order.getOrderID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this order exists, update its fields
                statement = connection.prepareStatement("UPDATE Orders SET OrderDate = ?, CustomerID = ?, TotalCost = ?, TotalTax = ?  WHERE OrderID = ?");
                statement.setString(1, order.getDate());
                statement.setInt(2, order.getCustomerID());
                statement.setDouble(3, order.getTotalCost());
                statement.setDouble(4, order.getTotalTax());
                statement.setInt(5, order.getOrderID());
            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Orders VALUES (?, ?, ?, ?, ?)");
                statement.setString(2, order.getDate());
                statement.setInt(3, order.getCustomerID());
                statement.setDouble(4, order.getTotalCost());
                statement.setDouble(5, order.getTotalTax());
                statement.setInt(1, order.getOrderID());
            }
            statement.execute();
            resultSet.close();
            statement.close();
            return true;        // save successfully

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; // cannot save!
        }
    }

    public boolean saveUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE UserID = ?");
            statement.setInt(1, user.getUserID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this order exists, update its fields
                statement = connection.prepareStatement("UPDATE Users SET UserName = ?, Password = ?, DisplayName = ?, IsManager = 0  WHERE UserID = ?");
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getPassword());
                statement.setString(3, user.getDisplayName());
                statement.setBoolean(4, user.getIsManager());
                statement.setInt(5, user.getUserID());
            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Users VALUES (?, ?, ?, ?, ?)");
                statement.setString(2, user.getUsername());
                statement.setString(3, user.getPassword());
                statement.setString(4, user.getDisplayName());
                statement.setBoolean(5, user.getIsManager());
                statement.setInt(1, user.getUserID());
            }
            statement.execute();
            resultSet.close();
            statement.close();
            return true;        // save successfully

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; // cannot save!
        }
    }

    public Message changeUserPassword(User user) {
        try {
            Message message = null;

            Statement stmt = connection.createStatement();
                stmt.executeUpdate("UPDATE Users SET "
                        + "UserID = " + user.userID + ","
                        + '\'' + "UserName" + '\'' + "= " + '\'' + user.username + '\'' + ","
                        + '\'' + "Password" + '\'' + "= " + '\'' + user.password + '\'' + ","
                        + '\'' + "DisplayName" + '\'' + "= " + '\'' + user.displayName+ '\'' + ","
                        + "IsManager = " + user.isManager +
                        " WHERE UserID = " + user.userID
                );
           return new Message(Message.SUCCESS, "Password changed");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Message(Message.FAIL, "Cannot change the password");
    }

    public User loadUser(Account account) {
        User user = null;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE UserName = '" + account.getUsername() + "'");
            if (rs.next()) {
                user = new User();
                user.userID = rs.getInt(1);
                user.username = rs.getString(2);
                user.password = rs.getString(3);
                user.displayName = rs.getString(4);
                user.isManager = rs.getBoolean(5);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public boolean cancelOrder(int orderID) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("DELETE FROM Orders WHERE OrderID = " + orderID + "");
            rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public OrderLine searchProducts(String query) {
        Product product = null;
        OrderLine productLine = new OrderLine();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Products WHERE name LIKE \'%" + query + "%\'");
            while (rs.next()) {
                product = new Product();
                product.setProductID(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setQuantity(rs.getDouble(4));
                productLine.list.add(product);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return productLine;
    }

    public Order searchOrders(String query) {
        Order order = null;
        Order orderLine = new Order();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Orders WHERE CustomerID LIKE \'%" + query + "%\'");
            while (rs.next()) {
                order = new Order();
                order.setOrderID(rs.getInt(1));
                order.setDate(rs.getString(2));
                order.setCustomerID(rs.getInt(3));
                order.setTotalCost(rs.getDouble(4));
                order.setTotalTax(rs.getDouble(5));
                orderLine.list.add(order);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return orderLine;
    }
}
