package projectbackend.service.ticket.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.repository.ticket.ITicketRepository;
import projectbackend.service.ticket.ITicketService;

@Service
public class TicketService implements ITicketService {

    @Autowired
    ITicketRepository iTicketRepository;

    @Override
    public Page<ITicketDto> findAllBookingTickets(Pageable pageable , Integer id) {
        return iTicketRepository.findAllBookingTickets(id,pageable);
    }

    @Override
    public Page<ITicketDto> findAllCanceledTickets(Pageable pageable , Integer id) {
        return iTicketRepository.findAllCanceledTickets(id,pageable);
    }

    @Override
    public Page<ITicketDto> findAllHistoryPoint(Integer id, String bookingTime, int price, Pageable pageable) {
        return findAllHistoryPoint(id,bookingTime,price,pageable);
    }


}
