package projectbackend.service.ticket.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import projectbackend.dto.booking_ticket.ISeatDetail;
=======

import projectbackend.dto.booking_ticket.ISeatDetail;

>>>>>>> 1a83e5008e5de991e35f34f1054772e2067509ba
import projectbackend.model.ticket.SeatDetail;
import projectbackend.repository.ticket.ISeatDetailRepository;
import projectbackend.service.ticket.ISeatDetailService;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

@Service
public class SeatDetailService implements ISeatDetailService {
    @Autowired
    private ISeatDetailRepository seatDetailRepository;

    @Override
    public Optional<SeatDetail> findById(Integer id) {
        return seatDetailRepository.findById(id);
    }

    @Override
    public List<ISeatDetail> findAllSeatDetail(Integer idShowTime) {
        return seatDetailRepository.findAllSeatDetail(idShowTime);
    }

    @Override
    public void setStatusSeatIsPending(Integer idSeatDetail) {
        seatDetailRepository.setStatusSeatIsPending(idSeatDetail);
=======


@Service
public class SeatDetailService implements ISeatDetailService {

    @Autowired
    private ISeatDetailRepository iSeatDetailRepository;

    @Override
    public List<SeatDetail> findAll() {
        return iSeatDetailRepository.findAll();

>>>>>>> 1a83e5008e5de991e35f34f1054772e2067509ba
    }
}
