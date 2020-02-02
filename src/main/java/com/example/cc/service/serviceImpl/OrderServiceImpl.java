package com.example.cc.service.serviceImpl;

import com.example.cc.dto.CategoryAndSales;
import com.example.cc.dto.PidProPsales;
import com.example.cc.dto.TimeAndPrice;
import com.example.cc.dto.TimeAndSales;
import com.example.cc.entity.Order;
import com.example.cc.entity.Product;
import com.example.cc.service.OrderService;
import com.example.cc.util.ListSort;
import com.example.cc.util.ResJsonTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    private ListSort<PidProPsales> pidProPsalesListSort = new ListSort<>();

    private ListSort<CategoryAndSales> salesList = new ListSort<>();

    @Override
    public ResJsonTemplate getProductDetailsById(String id) {
        final String DB_URL = "jdbc:hive2://10.60.41.125:10000/cc";
        final String USER = "hive";
        final String PASS = "hive";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT product_id, product,price,inventory,category,product_sales  FROM product WHERE product_id=\"" + id + "\"";
            ResultSet rs = stmt.executeQuery(sql);
            Product product = new Product();
            while (rs.next()) {
                product = new Product(rs.getString("product_id"),
                        rs.getString("product"),
                        rs.getDouble("price"),
                        rs.getInt("inventory"),
                        rs.getString("category"),
                        rs.getInt("product_sales"));
            }
            rs.close();
            stmt.close();
            conn.close();
            return new ResJsonTemplate<>("200", product);
        } catch (SQLException se) {
            se.printStackTrace();
            return new ResJsonTemplate<>("500", "SQL error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResJsonTemplate<>("500", "Server internal error");
        }
    }

    @Override
    public ResJsonTemplate getCategoryDetailsByNameAndType(String category, int type) {
        final String DB_URL = "jdbc:hive2://10.60.41.125:10000/cc";
        final String USER = "hive";
        final String PASS = "hive";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT category_id FROM category WHERE category=\"" + category + "\"";
            ResultSet rs = stmt.executeQuery(sql);
            String category_id = "";
            while (rs.next()) {
                category_id = rs.getString("category_id");
            }
            List<TimeAndSales> s_sales = new ArrayList<>();
            List<TimeAndSales> m_sales = new ArrayList<>();
            List<TimeAndSales> d_sales = new ArrayList<>();
            if (type == 0){
                sql = "SELECT season, s_sales FROM c_season WHERE category_id=\"" + category_id + "\"";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    s_sales.add(new TimeAndSales(rs.getInt("season"), rs.getInt("s_sales")));
                }
            }
            if (type == 2) {
                sql = "SELECT month, m_sales FROM c_month WHERE category_id=\"" + category_id + "\"";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    m_sales.add(new TimeAndSales(rs.getInt("month"), rs.getInt("m_sales")));
                }
            }
            if (type == 1){
                sql = "SELECT day, d_sales FROM c_daily WHERE category_id=\"" + category_id + "\"";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    d_sales.add(new TimeAndSales(rs.getInt("day"), rs.getInt("d_sales")));
                }
            }
            rs.close();
            stmt.close();
            conn.close();
            switch (type){
                case 1:return new ResJsonTemplate<>("200", d_sales);
                case 2:return new ResJsonTemplate<>("200", m_sales);
                case 0:return new ResJsonTemplate<>("200", s_sales);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return new ResJsonTemplate<>("500", "SQL error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResJsonTemplate<>("500", "Server internal error");
        }
        return new ResJsonTemplate<>("500", "Server internal error");
    }

    @Override
    public ResJsonTemplate getOrdersByProductId(String product_id) {
        final String DB_URL = "jdbc:hive2://10.60.41.125:10000/cc";
        final String USER = "hive";
        final String PASS = "hive";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT order_id, order_time, order_price, buyer, address, phone, product_id FROM orders WHERE product_id=\"" + product_id + "\"";
            ResultSet rs = stmt.executeQuery(sql);
            List<Order> orders = new ArrayList<>();
            while (rs.next()) {
                orders.add(new Order(rs.getString("order_id"),
                        rs.getString("order_time"),
                        rs.getDouble("order_price"),
                        rs.getString("buyer"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("product_id")));
            }
            rs.close();
            stmt.close();
            conn.close();
            return new ResJsonTemplate<>("200", orders);
        } catch (SQLException se) {
            se.printStackTrace();
            return new ResJsonTemplate<>("500", "SQL error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResJsonTemplate<>("500", "Server internal error");
        }
    }

    @Override
    public ResJsonTemplate getSalesByProductIdAndType(String product_id, int type) {
        final String DB_URL = "jdbc:hive2://10.60.41.125:10000/cc";
        final String USER = "hive";
        final String PASS = "hive";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "";
            ResultSet rs;
            List<TimeAndSales> s_sales = new ArrayList<>();
            List<TimeAndSales> m_sales = new ArrayList<>();
            List<TimeAndSales> d_sales = new ArrayList<>();
            if (type == 1) {
                sql = "SELECT day, d_sales FROM p_daily WHERE product_id=\"" + product_id + "\"";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    d_sales.add(new TimeAndSales(rs.getInt("day"), rs.getInt("d_sales")));
                }
            }
            else if (type == 2){
                sql = "SELECT month, m_sales FROM p_month WHERE product_id=\"" + product_id + "\"";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    m_sales.add(new TimeAndSales(rs.getInt("month"), rs.getInt("m_sales")));
                }
            }
            else {
                sql = "SELECT season, s_sales FROM p_season WHERE product_id=\"" + product_id + "\"";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    s_sales.add(new TimeAndSales(rs.getInt("season"), rs.getInt("s_sales")));
                }
            }
            rs.close();
            stmt.close();
            conn.close();
            switch (type){
                case 0:return new ResJsonTemplate<>("200", s_sales);
                case 1:return new ResJsonTemplate<>("200", d_sales);
                case 2:return new ResJsonTemplate<>("200", m_sales);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return new ResJsonTemplate<>("500", "SQL error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResJsonTemplate<>("500", "Server internal error");
        }
        return new ResJsonTemplate<>("500", "Server internal error");
    }

    @Override
    public ResJsonTemplate getPriceAndDaysByProductID(String product_id) {
        final String DB_URL = "jdbc:hive2://10.60.41.125:10000/cc";
        final String USER = "hive";
        final String PASS = "hive";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT d_price, day FROM p_daily WHERE product_id=\"" + product_id + "\"";
            ResultSet rs = stmt.executeQuery(sql);
            List<TimeAndPrice> prices = new ArrayList<>();
            while (rs.next()) {
                prices.add(new TimeAndPrice(rs.getInt("day"), rs.getDouble("d_price")));
            }
            rs.close();
            stmt.close();
            conn.close();
            return new ResJsonTemplate<>("200", prices);
        } catch (SQLException se) {
            se.printStackTrace();
            return new ResJsonTemplate<>("500", "SQL error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResJsonTemplate<>("500", "Server internal error");
        }
    }


    @Override
    public ResJsonTemplate getCPOTotal() {
        final String DB_URL = "jdbc:hive2://10.60.41.125:10000/cc";
        final String USER = "hive";
        final String PASS = "hive";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT COUNT(*) as total FROM category";
            ResultSet rs = stmt.executeQuery(sql);
            int c_total = 0, p_total = 0, o_total = 0;
            while (rs.next()) {
                c_total = rs.getInt("total");
            }
            sql = "SELECT COUNT(*) as total FROM product";
            while (rs.next()) {
                p_total = rs.getInt("total");
            }
            sql = "SELECT COUNT(*) as total FROM orders";
            while (rs.next()) {
                o_total = rs.getInt("total");
            }
            rs.close();
            stmt.close();
            conn.close();
            HashMap<String, Integer> totals = new HashMap<>();
            totals.put("c_total", c_total);
            totals.put("p_total", p_total);
            totals.put("o_total", o_total);
            return new ResJsonTemplate<>("200", totals);
        } catch (SQLException se) {
            se.printStackTrace();
            return new ResJsonTemplate<>("500", "SQL error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResJsonTemplate<>("500", "Server internal error");
        }
    }

    @Override
    public ResJsonTemplate getCategoryAndSalesOfSeason() {
        final String DB_URL = "jdbc:hive2://10.60.41.125:10000/cc";
        final String USER = "hive";
        final String PASS = "hive";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT category_id, s_sales FROM c_season WHERE season=1";
            ResultSet rs = stmt.executeQuery(sql);
            List<CategoryAndSales> sales1 = new ArrayList<>();
            List<CategoryAndSales> sales2 = new ArrayList<>();
            List<CategoryAndSales> sales3 = new ArrayList<>();
            List<CategoryAndSales> sales4 = new ArrayList<>();
            while (rs.next()) {
                sales1.add(new CategoryAndSales(rs.getString("category_id"),
                        rs.getInt("s_sales")));
            }
            sql = "SELECT category_id, s_sales FROM c_season WHERE season=2";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                sales2.add(new CategoryAndSales(rs.getString("category_id"),
                        rs.getInt("s_sales")));
            }
            sql = "SELECT category_id, s_sales FROM c_season WHERE season=3";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                sales3.add(new CategoryAndSales(rs.getString("category_id"),
                        rs.getInt("s_sales")));
            }
            sql = "SELECT category_id, s_sales FROM c_season WHERE season=4";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                sales4.add(new CategoryAndSales(rs.getString("category_id"),
                        rs.getInt("s_sales")));
            }
            sql = "SELECT category FROM category";
            rs = stmt.executeQuery(sql);
            List<CategoryAndSales> ss_total = new ArrayList<>();
            int i = 0;
            while (rs.next()) {
                ++i;
            }
            ss_total.add(new CategoryAndSales("c_total", i));
            sql = "SELECT product_id FROM product";
            rs = stmt.executeQuery(sql);
            i = 0;
            while (rs.next()) {
                ++i;
            }
            ss_total.add(new CategoryAndSales("p_total", i));
            sql = "SELECT order_id FROM orders";
            rs = stmt.executeQuery(sql);
            i = 0;
            while (rs.next()) {
                ++i;
            }
            ss_total.add(new CategoryAndSales("o_total", i));
            sql = "SELECT category, category_sales FROM category ";//ORDER BY category_sales DESC";
            rs = stmt.executeQuery(sql);
            List<CategoryAndSales> categoryAndSales = new ArrayList<>();
            while (rs.next()) {
                categoryAndSales.add(new CategoryAndSales(rs.getString("category"),
                        rs.getInt("category_sales")));
            }
            rs.close();
            stmt.close();
            conn.close();
            salesList.sort(categoryAndSales, "getSales", "ddesc");
            HashMap<String, List> reValue = new HashMap<>();
            reValue.put("spring", sales1);
            reValue.put("summer", sales2);
            reValue.put("autumn", sales3);
            reValue.put("winter", sales4);
            reValue.put("total", ss_total);
            reValue.put("year", categoryAndSales);
            return new ResJsonTemplate<>("200", reValue);
        } catch (SQLException se) {
            se.printStackTrace();
            return new ResJsonTemplate<>("500", "SQL error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResJsonTemplate<>("500", "Server internal error");
        }
    }


    @Override
    public ResJsonTemplate getRankOfYearSalesOfCategory() {
        final String DB_URL = "jdbc:hive2://10.60.41.125:10000/cc";
        final String USER = "hive";
        final String PASS = "hive";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT category, category_sales FROM category ORDER BY category_sales DESC";
            ResultSet rs = stmt.executeQuery(sql);
            List<CategoryAndSales> categoryAndSales = new ArrayList<>();
            while (rs.next()) {
                categoryAndSales.add(new CategoryAndSales(rs.getString("category"),
                        rs.getInt("category_sales")));
            }
            rs.close();
            stmt.close();
            conn.close();
            return new ResJsonTemplate<>("200", categoryAndSales);
        } catch (SQLException se) {
            se.printStackTrace();
            return new ResJsonTemplate<>("500", "SQL error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResJsonTemplate<>("500", "Server internal error");
        }
    }

    @Override
    public ResJsonTemplate getRankOfProductByGenre(String category) {
        final String DB_URL = "jdbc:hive2://10.60.41.125:10000/cc";
        final String USER = "hadoop";
        final String PASS = "hadoop";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT product_id, product, category_sales FROM ranking WHERE category=\"" + category + "\"";//ORDER BY category_sales DESC";
            ResultSet rs = stmt.executeQuery(sql);
            List<PidProPsales> pidProPsales = new ArrayList<>();
            int i = 0;
            while (rs.next()) {
                pidProPsales.add(new PidProPsales(rs.getString("product_id"),
                        rs.getString("product"),
                        rs.getInt("category_sales")));
                ++i;
                if (i > 30)
                    break;
            }
            rs.close();
            stmt.close();
            conn.close();
            pidProPsalesListSort.sort(pidProPsales, "getCategory_sales", "ddesc");
            return new ResJsonTemplate<>("200", pidProPsales);
        } catch (SQLException se) {
            se.printStackTrace();
            return new ResJsonTemplate<>("500", "SQL error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResJsonTemplate<>("500", "Server internal error");
        }
    }


    @Override
    public ResJsonTemplate deleteProductById(String product_id) {
        final String DB_URL = "jdbc:mysql://10.60.42.201:13142/cc";
        final String USER = "root";
        final String PASS = "123456";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "DELETE FROM product WHERE product_id=\"" + product_id + "\"";
            stmt.execute(sql);
            stmt.close();
            conn.close();
            return new ResJsonTemplate<>("200", "success delete");
        } catch (SQLException se) {
            se.printStackTrace();
            return new ResJsonTemplate<>("500", "SQL error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResJsonTemplate<>("500", "Server internal error");
        }
    }

    @Override
    public ResJsonTemplate insertProduct(String product_id, String product, double price, int inventory, String category) {
        final String DB_URL = "jdbc:mysql://10.60.42.201:13142/cc";
        final String USER = "root";
        final String PASS = "123456";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "INSERT INTO product (product_id, product, price, inventory, category, product_sales)" +
                    "VALUES (\"" + product_id + "\", \"" + product + "\", " + Double.toString(price) + ", "
                    + Integer.toString(inventory) + ", \"" + category + "\", 0)";
            stmt.execute(sql);
            stmt.close();
            conn.close();
            return new ResJsonTemplate<>("200", "success insert");
        } catch (SQLException se) {
            se.printStackTrace();
            return new ResJsonTemplate<>("500", "SQL error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResJsonTemplate<>("500", "Server internal error");
        }
    }


    @Override
    public ResJsonTemplate updateProduct(String product_id, String product, double price, int inventory, String category) {
        final String DB_URL = "jdbc:mysql://10.60.42.201:13142/cc";
        final String USER = "root";
        final String PASS = "123456";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "UPDATE product SET product=\"" + product + "\", price=" + Double.toString(price)
                    + ", inventory=" + Integer.toString(inventory) + ", category=\"" + category
                    + "\" WHERE product_id=\"" + product_id + "\"";
            stmt.execute(sql);
            stmt.close();
            conn.close();
            return new ResJsonTemplate<>("200", "success update");
        } catch (SQLException se) {
            se.printStackTrace();
            return new ResJsonTemplate<>("500", "SQL error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResJsonTemplate<>("500", "Server internal error");
        }
    }


    @Override
    public ResJsonTemplate getProductDetailsById2(String id) {
        final String DB_URL = "jdbc:mysql://10.60.42.201:13142/cc";
        final String USER = "root";
        final String PASS = "123456";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT * FROM product WHERE product_id=\"" + id + "\"";
            ResultSet rs = stmt.executeQuery(sql);
            Product product = new Product();
            while (rs.next()) {
                product = new Product(rs.getString("product_id"),
                        rs.getString("product"),
                        rs.getDouble("price"),
                        rs.getInt("inventory"),
                        rs.getString("category"),
                        rs.getInt("product_sales"));
            }
            rs.close();
            stmt.close();
            conn.close();
            return new ResJsonTemplate<>("200", product);
        } catch (SQLException se) {
            se.printStackTrace();
            return new ResJsonTemplate<>("500", "SQL error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResJsonTemplate<>("500", "Server internal error");
        }
    }

    @Override
    public ResJsonTemplate getAllCategory() {
        final String DB_URL = "jdbc:hive2://10.60.41.125:10000/cc";
        final String USER = "hive";
        final String PASS = "hive";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT category FROM category";
            ResultSet rs = stmt.executeQuery(sql);
            List<String> cats = new ArrayList<>();
            while (rs.next()) {
                cats.add(rs.getString("category"));
            }
            rs.close();
            stmt.close();
            conn.close();
            return new ResJsonTemplate<>("200", cats);
        } catch (SQLException se) {
            se.printStackTrace();
            return new ResJsonTemplate<>("500", "SQL error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResJsonTemplate<>("500", "Server internal error");
        }
    }
}
