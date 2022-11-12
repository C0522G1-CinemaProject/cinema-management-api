package projectbackend.service.ticket.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.model.ticket.Ticket;
import projectbackend.repository.ticket.ITicketRepository;
import projectbackend.service.ticket.ITicketService;

import java.util.Optional;

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

    @Override
    public Page<ITicketDto> findAllBigPoint(String username, String bookingTime, Pageable pageable) {
        return iTicketRepository.findAllBigPointSearch(username, bookingTime, pageable);
    }

    @Override
    public Page<ITicketDto> findAllSmallPoint(String username, String bookingTime, Pageable pageable) {
        return iTicketRepository.findAllSmallPointSearch(username, bookingTime, pageable);
    }

    @Override
    public Optional<Ticket> findByIdTicKet(Integer id) {
        return iTicketRepository.findByIdTicket(id);
    }

    @Override
    public void deleteTicket(Integer id) {
        iTicketRepository.deleteTicket(id);
    }
}
