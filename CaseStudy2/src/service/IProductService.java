package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();
    Product findProductById(long idProduct);
    void updateProductById(long idProduct, Product product);
    void deleteProductById(long idProduct);
    void addProduct(Product user);

    List<Product> searchProductByName(String keyName);
}
