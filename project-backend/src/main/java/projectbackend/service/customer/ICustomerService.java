package projectbackend.service.customer;

import projectbackend.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    Customer findByUsername(String username);

    Customer findFakeMail(String email);

    int saveCreateGmail(Customer customer);

    Customer findById(Integer id);

    List<Integer> findAllCusId();
}
