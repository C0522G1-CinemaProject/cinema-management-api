package projectbackend.service.customer;

import projectbackend.dto.customer.ICustomerStatementDto;

import java.util.List;

public interface ICustomerService {

    /**
     * creator: Phan Phước Đại
     * date:11/11/2022
     * method use statistical top customer positive
     */
    List<ICustomerStatementDto> getCustomerTop(int numberMonth);
}
