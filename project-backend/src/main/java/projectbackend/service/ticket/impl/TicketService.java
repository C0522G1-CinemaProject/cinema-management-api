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
    public Page<ITicketDto> findAllHistoryPoint(String username, String startTime, String endTime, Pageable pageable) {
        return iTicketRepository.findAllHistoryPoint(username, startTime, endTime, pageable);
    }

    @Override
    public Page<ITicketDto> findAllOfPointsAdded(String username, String startTime, String endTime, Pageable pageable) {
        return iTicketRepository.findAllOfPointsAdded(username, startTime, endTime, pageable);
    }

    @Override
    public Page<ITicketDto> findAllOfUsePoints(String username, String startTime, String endTime, Pageable pageable) {
        return iTicketRepository.findAllOfUsePoints(username, startTime, endTime, pageable);

    }

    @Override
    public Optional<Ticket> findTicketById(Integer id) {
        return iTicketRepository.findByIdTicket(id);
    }


    @Override
    public void deleteTicket(Integer id) {
        iTicketRepository.deleteTicket(id);
    }


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
    public void saveTicket(Ticket ticket) {
        iTicketRepository.save(ticket);

    }

    @Override
    public Optional<ITicketDto> findByCustomerNameAndPoint(String username) {
        return iTicketRepository.findByCustomerNameAndPoint(username);
    }

}