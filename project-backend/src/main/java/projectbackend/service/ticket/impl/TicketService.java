package projectbackend.service.ticket.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.dto.ticket.ITicketManagerDto;
import projectbackend.model.ticket.Ticket;
import projectbackend.repository.ticket.ISeatDetailRepository;
import projectbackend.repository.ticket.ITicketRepository;
import projectbackend.service.ticket.ITicketService;

import java.util.List;
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
    public void updateTicketByUserName(String userNameUpdate) {
        ticketRepository.updateTicketByUserName(userNameUpdate);
    }

    @Override
    public Optional<Ticket> findTicketCustomerByUserName(String userName) {
        return ticketRepository.findTicketCustomerByUserName(userName);
    }

    @Override
    public List<ITicketDto> findTicketByUsername(String findTicketByUserName) {
        return ticketRepository.findTicketByUsername(findTicketByUserName);
    }

    @Override
    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);

        seatDetailRepository.setStatusSeatIsPending(ticket.getSeatDetail().getId());
    }

    @Override
    public Page<ITicketManagerDto> findAllByQuery(Pageable pageable, Integer ticketId, Integer customerId,
                                                  String idCard, String phoneNumber) {
        return ticketRepository.findAllByQuery(pageable, ticketId, customerId, idCard, phoneNumber);
    }

    @Override
    public Optional<ITicketManagerDto> findTicketManagerById(Integer id) {
        return ticketRepository.findTicketManagerById(id);
    }

    @Override
    public void editTicketManager(Integer id) {
        ticketRepository.editTicketManager(id);
    }

}
