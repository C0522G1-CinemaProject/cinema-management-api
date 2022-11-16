package projectbackend.service.ticket.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectbackend.dto.booking_ticket.ISeatDetail;

import projectbackend.model.ticket.SeatDetail;
import projectbackend.repository.ticket.ISeatDetailRepository;
import projectbackend.service.ticket.ISeatDetailService;

import java.util.List;


@Service
public class SeatDetailService implements ISeatDetailService {

    @Autowired
    private ISeatDetailRepository iSeatDetailRepository;

    @Override
    public List<SeatDetail> findAll() {
        return iSeatDetailRepository.findAll();

    }
}
