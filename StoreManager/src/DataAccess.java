public interface DataAccess {
    void connect();

    void saveProduct(ProductModel product);

    ProductModel loadProduct(int productID);

    // void loadOrder(int orderId);
    // void saveOrder(OrderModel order);
    // void loadUser(int userId);
    // void saveUser(UserModel user)
}
