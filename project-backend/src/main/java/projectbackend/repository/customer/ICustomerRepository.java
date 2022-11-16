package projectbackend.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.customer.ICustomerStatementDto;
import projectbackend.model.customer.Customer;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {


    /**
     * creator: Phan Phước Đại
     * date:11/11/2022
     * method use statistical top customer positive
     */
    @Query(value = "select idCustomer as id, nameCustomer as name, count(ticket_statement.id) as countTicket," +
            "   sum(money)  as totalMoney, sum(point) as accumulation " +
            "from  ticket_statement " +
            "group by idCustomer " +
            "order by sum(money) desc limit 100",
            nativeQuery = true)
    List<ICustomerStatementDto> getCustomerTop();


    /**
     * creator: Phan Phước Đại
     * date:11/11/2022
     * method use statistical top customer positive
     */

    @Query(value = "select idCustomer as id, nameCustomer as name, count(id) as countTicket," +
            "   sum(money)  as totalMoney, sum(point) as accumulation " +
            "from  ticket_statement " +
            "where dateProjection >=  DATE_SUB(curdate(),INTERVAL :numberMonth MONTH)  " +
            "group by idCustomer " +
            "order by sum(money) desc limit 100",
            nativeQuery = true)
    List<ICustomerStatementDto> getCustomerTop(@Param("numberMonth") int numberMonth);
   /* @Query(value = "select customer.id as id, customer.name as name, count(ticket.id) as tickets," +
            " sum(seat_type.price) as totalMoney, sum(saving_point.point) as accumulation " +
            " from customer join ticket on customer.id = ticket.customer_id " +
            "  join seat_detail on ticket.seat_detail_id = seat_detail.id " +
            " join show_times on show_times.id = seat_detail.show_time_id " +
            "join seat_room on seat_room.id = seat_detail.seat_room_id " +
            " join seat_type on seat_type.id = seat_room.seat_type_id " +
            " join saving_point on saving_point.customer_id= customer.id " +
            " where show_times.date_projection < curdate() and ticket.status_ticket = 1 and show_times.date_projection >=  DATE_SUB(curdate(),INTERVAL :numberMonth MONTH)  " +
            "group by customer.id " +
            "order by sum(seat_type.price) " +
            "limit 100",
            nativeQuery = true)
    List<ICustomerStatementDto> getCustomerTop(@Param("numberMonth") int numberMonth);*/

}
