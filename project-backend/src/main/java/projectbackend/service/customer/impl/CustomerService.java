package projectbackend.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;

import projectbackend.dto.customer.ICustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectbackend.model.customer.Customer;
import projectbackend.repository.customer.ICustomerRepository;
import projectbackend.service.customer.ICustomerService;


import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }


    @Override
    public Optional<ICustomerDto> findCustomerByUsername(String username) {
        return iCustomerRepository.findCustomerByUsername(username);
    }


    @Override
    public Optional<ICustomerDto> findUserByUsername(String username) {
        return iCustomerRepository.findUserByUsername(username);
    }


    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findByIdCustomer(Integer id) {
        return iCustomerRepository.findByIdCustomer(id);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> searchCustomer(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable) {
        return iCustomerRepository.searchCustomer(nameSearch, addressSearch, phoneSearch, pageable);
    }

}
