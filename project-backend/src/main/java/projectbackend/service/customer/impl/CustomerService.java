package projectbackend.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectbackend.dto.customer.ICustomerStatementDto;
import projectbackend.repository.customer.ICustomerRepository;
import projectbackend.service.customer.ICustomerService;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<ICustomerStatementDto> getCustomerTop(Pageable pageable) {
        return customerRepository.getCustomerTop(pageable);
    }

    @Override
    public List<ICustomerStatementDto> getCustomerTop() {
        return customerRepository.getCustomerTop();
    }

    @Override
    public List<ICustomerStatementDto> getCustomerTop(int numberMonth) {
        if (numberMonth == 0) {
            return customerRepository.getCustomerTop();
        }

        return customerRepository.getCustomerTop(numberMonth);
    }

}
