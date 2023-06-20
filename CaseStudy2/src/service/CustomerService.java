package service;

import config.Config;
import model.Customer;
import utils.FileUtils;


import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService{
    private final String pathCustomer = "D:\\moduel2\\CaseStudy2\\src\\data\\customer.txt";

    public List<Customer> getAllCustomer(){
        return FileUtils.readFile(pathCustomer, Config.TYPE_CUSTOMER);
    }
    public Customer findCustomerById(long idCustomer) {
        List<Customer> customers = FileUtils.readFile(pathCustomer, Config.TYPE_CUSTOMER);
        for (Customer c : customers) {
            if (c.getId() == idCustomer) {
                return c;
            }
        }
        return null;
    }
    public void updateCustomerById(long idCustomer, Customer customer) {
        List<Customer> customers = FileUtils.readFile(pathCustomer, Config.TYPE_CUSTOMER);
        for (Customer c : customers) {
            if (c.getId() == idCustomer) {
                c.setName(customer.getName());
                c.setAge(customer.getAge());
                c.setPhone(customer.getPhone());
                c.setAddress(customer.getAddress());

            }
        }
        FileUtils.writeFile(pathCustomer, customers);
    }
    public void deleteCustomerById(long idCustomer) {
        List<Customer> customers = FileUtils.readFile(pathCustomer, Config.TYPE_CUSTOMER);
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == idCustomer) {
                customers.remove(i);
                break;
            }
        }
        FileUtils.writeFile(pathCustomer, customers);
    }
    public void addCustomer(Customer customer){
        List<Customer> customers = FileUtils.readFile(pathCustomer, Config.TYPE_CUSTOMER);
        customers.add(customer);
        FileUtils.writeFile(pathCustomer, customers);
    }

    @Override
    public List<Customer> searchCustomerByName(String keyName) {
        List<Customer> customers = getAllCustomer();
        List<Customer> results = new ArrayList<>();

        for (Customer u : customers) {
            if (u.getName().toLowerCase().contains(keyName.toLowerCase())) {
                results.add(u);
            }
        }
        return results;
    }
}
