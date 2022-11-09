package projectbackend.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.customer.ICustomerStatementDto;

public interface ICustomerService {
    Page<ICustomerStatementDto> getCustomerTop(Pageable pageable);
}
