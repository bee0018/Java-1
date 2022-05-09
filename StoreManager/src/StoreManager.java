public class StoreManager {

    private static StoreManager instance = null;

    private SQLiteDataAdapter dao;

    private ProductView productView = null;

    private OrderView orderView = null;

    private UserView userView = null;

    private UserPath userPath = null;

    private UserPathController userPathController;

    public ProductView getProductView() {
        return productView;
    }

    public OrderView getOrderView() {
        return orderView;
    }

    public UserView getUserView() {
        return userView;
    }

    public UserPath getUserPath() {return userPath;}

    private ProductController productController = null;

    private StoreManager() {}
    public static StoreManager getInstance() {
        if (instance == null)
            instance = new StoreManager("SQLite");
        return instance;
    }

    public SQLiteDataAdapter getDataAccess() {
        return dao;
    }

    private StoreManager(String db) {
        // do some initialization here!!!
        if (db.equals("SQLite"))
            dao = new SQLiteDataAdapter();

        if (dao!=null)
            dao.connect();
        productView = new ProductView();
        orderView = new OrderView();
        userView = new UserView();
        userPath = new UserPath();
        userPathController = new UserPathController(userPath, dao);
        productController = new ProductController(productView, dao);
    }






}
