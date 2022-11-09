package projectbackend.repository.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projectbackend.dto.customer.ICustomerStatementDto;
import projectbackend.model.customer.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {


    @Query(value = "select customer.id as id, customer.name as name, count(ticket.id) as tickets," +
            " sum(seat_type.price) as totalMoney, sum(saving_point.point) as accumulation " +
            " from customer join ticket on customer.id = ticket.customer_id " +
            "  join seat_detail on ticket.seat_detail_id = seat_detail.id " +
            " join show_times on show_times.id = seat_detail.show_time_id " +
            "join seat_room on seat_room.id = seat_detail.seat_room_id " +
            " join seat_type on seat_type.id = seat_room.seat_type_id " +
            " join saving_point on saving_point.customer_id= customer.id " +
            " where show_times.dateProjection< curdate() and ticket.status_ticket = 1 " +
            "group by customer.id " +
            "order by sum(seat_type.price) ",
            countQuery =  "select count(customer.id)  " +
                    " from customer join ticket on customer.id = ticket.customer_id " +
                    "  join seat_detail on ticket.seat_detail_id = seat_detail.id " +
                    " join show_times on show_times.id = seat_detail.show_time_id " +
                    "join seat_room on seat_room.id = seat_detail.seat_room_id " +
                    " join seat_type on seat_type.id = seat_room.seat_type_id " +
                    " join saving_point on saving_point.customer_id= customer.id " +
                    " where show_times.dateProjection< curdate() and ticket.status_ticket = 1 " +
                    "group by customer.id " +
                    "order by sum(seat_type.price) ",
            nativeQuery = true)
    Page<ICustomerStatementDto> getCustomerTop(Pageable pageable);
}
