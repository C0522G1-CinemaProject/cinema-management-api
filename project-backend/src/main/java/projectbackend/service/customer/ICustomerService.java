package projectbackend.service.customer;

import projectbackend.dto.customer.ICustomerStatementDto;

import java.util.List;

public interface ICustomerService {


    List<ICustomerStatementDto> getCustomerTop();

    List<ICustomerStatementDto> getCustomerTop(int numberMonth);
}
