package projectbackend.service.ticket.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.model.ticket.Ticket;
import projectbackend.repository.ticket.ISeatDetailRepository;
import projectbackend.repository.ticket.ITicketRepository;
import projectbackend.service.ticket.ITicketService;

import java.util.Optional;

@Transactional
@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;

    @Autowired
    private ISeatDetailRepository seatDetailRepository;

    @Override
    public Optional<Ticket> findById(Integer id) {
        return ticketRepository.findById(id);
    }

    @Override
    public void updateTicketById(int id) {
        ticketRepository.updateTicketById(id);
    }

    @Override
    public Optional<ITicketDto> findTicketById(int id) {
        return ticketRepository.findTicketById(id);
    }

    @Override
    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);

        seatDetailRepository.setStatusSeatIsPending(ticket.getSeatDetail().getId());
    }
}
