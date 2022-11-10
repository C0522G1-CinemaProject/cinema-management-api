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
    public Page<ITicketDto> findAllBookingTickets(Pageable pageable, String username) {
        return iTicketRepository.findAllBookingTickets(username, pageable);
    }

    @Override
    public Page<ITicketDto> findAllCanceledTickets(Pageable pageable, String username) {
        return iTicketRepository.findAllCanceledTickets(username, pageable);
    }

    @Override
    public Page<ITicketDto> findAllHistoryPointSearch(String username, String bookingTime, int value, Pageable pageable) {
        return iTicketRepository.findAllHistoryPointSearch(username, bookingTime, value, pageable);
    }

    @Override
    public Page<ITicketDto> findAllHistoryPoint(String username, String bookingTime, Pageable pageable) {
        return iTicketRepository.findAllHistoryPoint(username, bookingTime, pageable);
    }


}
