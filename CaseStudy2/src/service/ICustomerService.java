package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomer();
    Customer findCustomerById(long idCustomer);
    void updateCustomerById(long idCustomer, Customer customer);
    void deleteCustomerById(long idCustomer);
    void addCustomer(Customer user);

    List<Customer> searchCustomerByName(String keyName);
}
