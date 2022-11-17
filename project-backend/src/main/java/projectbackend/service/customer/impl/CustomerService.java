package projectbackend.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.model.customer.Customer;
import projectbackend.repository.customer.ICustomerRepository;
import projectbackend.service.customer.ICustomerService;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public Customer findFakeMail(String email) {
        return customerRepository.findFakeMail(email);
    }

    @Override
    public int saveCreateGmail(Customer customer) {
       return customerRepository.saveCreateGmail(customer.getName(), customer.getEmail());
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Integer> findAllCusId() {
        return customerRepository.findAllCustomerIdById();
    }
}
