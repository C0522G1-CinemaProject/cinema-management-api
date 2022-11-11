package projectbackend.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.customer.ICustomerStatementDto;

import java.util.List;

public interface ICustomerService {
    Page<ICustomerStatementDto> getCustomerTop(Pageable pageable);

    List<ICustomerStatementDto> getCustomerTop();

    List<ICustomerStatementDto> getCustomerTop(int numberMonth);
}
