package projectbackend.service.ticket.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.dto.ticket.ITicketManagerDto;
import projectbackend.model.ticket.Ticket;
import projectbackend.repository.ticket.ITicketRepository;
import projectbackend.service.ticket.ITicketService;

import java.util.Optional;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository iTicketRepository;

    //THanh Nt
    @Override
    public Optional<Ticket> findById(Integer id) {
        return iTicketRepository.findById(id);
    }

    @Override
    public void updateTicketById(int id) {
        iTicketRepository.updateTicketById(id);
    }

    @Override
    public Optional<ITicketDto> findInfoTicketById(int id) {
        return iTicketRepository.findInfoTicketById(id);
    }


    //Hung B
    public Page<ITicketManagerDto> findAllByQuery(Pageable pageable, Integer ticketId,
                                                  Integer customerId,
                                                  String idCard,
                                                  String phoneNumber
    ) {
        return iTicketRepository.findAllByQuery(pageable, ticketId,
                customerId,
                idCard,
                phoneNumber
        );
    }

    @Override
    public Optional<ITicketManagerDto> findTicketManagerById(Integer id) {
        return iTicketRepository.findTicketManagerById(id);
    }

    @Override
    public void editTicketManager(Integer id) {
        iTicketRepository.editTicketManager(id);
    }

}
