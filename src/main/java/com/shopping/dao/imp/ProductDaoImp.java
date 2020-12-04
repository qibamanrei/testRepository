package com.shopping.dao.imp;

import com.shopping.bean.Product;
import com.shopping.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDaoImp implements ProductDao {
    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Product> selecListByState(int state) {
        String sql = "select pro_id proId, pro_name proName, pro_num proNum, market_price marketPrice," +
                " shop_price shopPrice, pro_color proColor, pro_total_count proTotalCount," +
                " pro_max_img proMaxImg, pro_min_img proMinImg, pro_state proState " +
                " from product" +
                " where pro_state=?;";

        try {
            return template.query(sql, new RowMapper<Product>() {
                @Override
                public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                    Product product = new Product();
                    product.setProId(resultSet.getInt("proId"));
                    product.setProName(resultSet.getString("proName"));
                    product.setProNum(resultSet.getString("proNum"));
                    product.setMarketPrice(resultSet.getDouble("marketPrice"));
                    product.setShopPrice(resultSet.getDouble("shopPrice"));
                    product.setProColor(resultSet.getString("proColor"));
                    product.setProTotalCount(resultSet.getInt("proTotalCount"));
                    product.setProMaxImg(resultSet.getString("proMaxImg"));
                    product.setProMinImg(resultSet.getString("proMinImg"));
                    product.setProState(resultSet.getInt("proState"));
                    return product;
                }
            }, state);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Product getProductInfoById(int proId) {
        String sql = "select pro_id proId, pro_name proName, pro_num proNum, market_price marketPrice," +
                " shop_price shopPrice, pro_color proColor, pro_total_count proTotalCount," +
                " pro_max_img proMaxImg, pro_min_img proMinImg, pro_state proState " +
                " from product" +
                " where pro_id=?;";
        try {
            return template.queryForObject(sql, new RowMapper<Product>() {
                @Override
                public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                    Product product = new Product();
                    product.setProId(resultSet.getInt("proId"));
                    product.setProName(resultSet.getString("proName"));
                    product.setProNum(resultSet.getString("proNum"));
                    product.setMarketPrice(resultSet.getDouble("marketPrice"));
                    product.setShopPrice(resultSet.getDouble("shopPrice"));
                    product.setProColor(resultSet.getString("proColor"));
                    product.setProTotalCount(resultSet.getInt("proTotalCount"));
                    product.setProMaxImg(resultSet.getString("proMaxImg"));
                    product.setProMinImg(resultSet.getString("proMinImg"));
                    product.setProState(resultSet.getInt("proState"));
                    return product;
                }
            }, proId);
        } catch (Exception e) {
            return null;
        }
    }
}
