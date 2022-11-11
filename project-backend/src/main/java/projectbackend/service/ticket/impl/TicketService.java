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
    public Page<ITicketDto> findAllByQuery(Integer ticketId,
                                           Integer customerId,
                                           String idCard,
                                           String phoneNumber,
                                           Pageable pageable) {
        return iTicketRepository.findAllByQuery(ticketId,
                customerId,
                idCard,
                phoneNumber,
                pageable);
    }

    @Override
    public Ticket findTicketById(Integer id) {
        return iTicketRepository.findById(id).get();
    }

    @Override
    public void saveTicket(Ticket ticket) {
        iTicketRepository.save(ticket);

    }
}
