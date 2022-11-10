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
    private ITicketRepository iTicketRepository;

    @Override
    public Page<Ticket> findAllTicket(Pageable pageable) {
        return iTicketRepository.findAllTicket(pageable);
    }

    @Override
    public Optional<Ticket> findById(Integer id) {
        return iTicketRepository.findById(id);
    }

    @Override
    public void updateTicketById(int id) {
        iTicketRepository.updateTicketById(id);
    }

    @Override
    public Optional<ITicketDto> findTicketById(int id) {
        return iTicketRepository.findTicketById(id);
    }


}
