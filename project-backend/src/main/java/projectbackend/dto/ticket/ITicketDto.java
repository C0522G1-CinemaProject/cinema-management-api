package projectbackend.dto.ticket;

import java.sql.Date;

public interface ITicketDto {
    String getNameCustomer();

    String getEmail();

    String getIdCard();

    String getPhoneNumber();

    String getNameRoom();

    Date getDateProjection();

    String getStartTime();

    String getNameSeat();

    Integer getPrice();


public interface ITicketManagerDto {
    String getTicketId();
    String getCustomerId();
    String getCustomerName();
    String getIdCard();
    String getPhoneNumber();
    String getMovieName();
    String getDateProjection();
    String getStartTime();
    String getRoomName();
    String getSeatName();
    String getStatusTicket();
}
