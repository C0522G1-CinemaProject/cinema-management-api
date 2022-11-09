package projectbackend.service.customer;

import projectbackend.model.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Optional<Customer> findCustomerById(int id);

}
