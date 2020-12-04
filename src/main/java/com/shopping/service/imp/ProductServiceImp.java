package com.shopping.service.imp;

import com.shopping.bean.Product;
import com.shopping.dao.ProductDao;
import com.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> selectProductListByState(int state) {
        return productDao.selecListByState(state);
    }

    @Override
    public Product getProductById(int proId) {
        Product product = productDao.getProductInfoById(proId);
        return product;
    }
}
