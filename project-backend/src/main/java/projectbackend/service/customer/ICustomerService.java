package projectbackend.service.customer;

import projectbackend.dto.customer.ICustomerDto;
import projectbackend.model.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Optional<ICustomerDto> findCustomerById(Integer id);

}
