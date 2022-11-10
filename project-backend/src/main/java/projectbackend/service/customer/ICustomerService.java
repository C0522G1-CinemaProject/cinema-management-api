package projectbackend.service.customer;

import projectbackend.dto.customer.ICustomerDto;
import projectbackend.model.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Optional<ICustomerDto> findCustomerByUsername(String username);

    Optional<Customer> findById(int id);

    Optional<ICustomerDto> findUserByUsername(String username);

}
