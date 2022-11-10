package projectbackend.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.dto.customer.ICustomerDto;
import projectbackend.model.customer.Customer;
import projectbackend.repository.customer.ICustomerRepository;
import projectbackend.service.customer.ICustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<ICustomerDto> findCustomerByUsername(String username) {
        return customerRepository.findCustomerByUsername(username);
    }


    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<ICustomerDto> findUserByUsername(String username) {
        return customerRepository.findUserByUsername(username);
    }

}
