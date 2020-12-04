package com.shopping.dao;

import com.shopping.bean.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> selecListByState(int state);

    public Product getProductInfoById(int proId);
}
