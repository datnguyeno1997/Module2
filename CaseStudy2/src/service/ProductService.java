package service;

import config.Config;

import model.Product;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private final String pathProduct = "D:\\moduel2\\CaseStudy2\\src\\data\\product.txt";

    public List<Product> getAllProduct(){
        return FileUtils.readFile(pathProduct, Config.TYPE_PRODUCT);
    }
    public Product findProductById(long idProduct) {
        List<Product> products = FileUtils.readFile(pathProduct, Config.TYPE_PRODUCT);
        for (Product c : products) {
            if (c.getId() == idProduct) {
                return c;
            }
        }
        return null;
    }
    public void updateProductById(long idProduct, Product product) {
        List<Product> products = FileUtils.readFile(pathProduct, Config.TYPE_PRODUCT);
        for (Product c : products) {
            if (c.getId() == idProduct) {
                c.setName(product.getName());
                c.setQuantity(product.getQuantity());
                c.setDescribe(product.getDescribe());

            }
        }
        FileUtils.writeFile(pathProduct, products);
    }
    public void deleteProductById(long idProduct) {
        List<Product> products = FileUtils.readFile(pathProduct, Config.TYPE_PRODUCT);
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idProduct) {
                products.remove(i);
                break;
            }
        }
        FileUtils.writeFile(pathProduct, products);
    }
    public void addProduct(Product product){
        List<Product> products = FileUtils.readFile(pathProduct, Config.TYPE_PRODUCT);
        products.add(product);
        FileUtils.writeFile(pathProduct, products);
    }

    @Override
    public List<Product> searchProductByName(String keyName) {
        List<Product> products = getAllProduct();
        List<Product> results = new ArrayList<>();

        for (Product u : products) {
            if (u.getName().toLowerCase().contains(keyName.toLowerCase())) {
                results.add(u);
            }
        }
        return results;
    }
}

