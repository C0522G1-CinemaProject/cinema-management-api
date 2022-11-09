package projectbackend.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectbackend.dto.customer.ICustomerStatementDto;
import projectbackend.repository.customer.ICustomerRepository;
import projectbackend.service.customer.ICustomerService;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Page<ICustomerStatementDto> getCustomerTop(Pageable pageable) {
        return customerRepository.getCustomerTop(pageable);
    }
}
