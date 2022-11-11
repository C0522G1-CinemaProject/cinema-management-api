package projectbackend.service.ticket;


import projectbackend.model.ticket.SeatDetail;

import java.util.List;

public interface ISeatDetailService {
    List<SeatDetail> findAll();

}
