package projectbackend.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return icustomerRepository.findAll();
    }


    @Override
    public void save(Customer customer) {
        icustomerRepository.save(customer);
    }


    @Override
    public Optional<ICustomerDto> findCustomerByUsername(String username) {
        return icustomerRepository.findCustomerByUsername(username);
    }


    @Override

    public Optional<Customer> findById(int id) {
        return icustomerRepository.findById(id);
    }


    @Override
    public void saveCustomer(String username, String password, String name, String dayOfBirth, int gender,
                                                     String idCard, String email, String address, String phoneNumber, int customerType) {
         icustomerRepository.saveCustomer(username, password,name,dayOfBirth,gender,idCard,email,address,phoneNumber,customerType );
    }


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
