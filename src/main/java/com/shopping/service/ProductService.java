package com.shopping.service;

import com.shopping.bean.Product;

import java.util.List;

public interface ProductService {
    public List<Product> selectProductListByState(int state);

    public Product getProductById(int proId);
}
