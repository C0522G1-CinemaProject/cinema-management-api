package projectbackend.service.ticket.impl;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.model.ticket.Ticket;
import projectbackend.repository.ticket.ISeatDetailRepository;
=======

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectbackend.dto.ticket.ITicketDto;

import projectbackend.model.ticket.Ticket;
>>>>>>> 1a83e5008e5de991e35f34f1054772e2067509ba
import projectbackend.repository.ticket.ITicketRepository;
import projectbackend.service.ticket.ITicketService;

import java.util.Optional;

@Service
public class TicketService implements ITicketService {
<<<<<<< HEAD
    @Autowired
    private ITicketRepository ticketRepository;

    @Autowired
    private ISeatDetailRepository seatDetailRepository;

    @Transactional
    @Override
    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);

        seatDetailRepository.setStatusSeatIsPending(ticket.getSeatDetail().getId());
=======


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

>>>>>>> 1a83e5008e5de991e35f34f1054772e2067509ba
    }
}
