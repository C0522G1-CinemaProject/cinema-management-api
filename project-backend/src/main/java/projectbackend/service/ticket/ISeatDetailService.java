package projectbackend.service.ticket;

<<<<<<< HEAD
import projectbackend.dto.booking_ticket.ISeatDetail;
import projectbackend.model.ticket.SeatDetail;

import java.util.List;
import java.util.Optional;

public interface ISeatDetailService {
    Optional<SeatDetail> findById(Integer id);

    List<ISeatDetail> findAllSeatDetail(Integer idShowTime);

    void setStatusSeatIsPending(Integer idSeatDetail);
=======

import projectbackend.model.ticket.SeatDetail;

import java.util.List;

public interface ISeatDetailService {
    List<SeatDetail> findAll();

>>>>>>> 1a83e5008e5de991e35f34f1054772e2067509ba
}
