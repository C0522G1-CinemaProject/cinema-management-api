package projectbackend.service.promotion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectbackend.dto.promotion.IPromotionDto;
import projectbackend.model.promotion.Promotion;
import projectbackend.repository.promotion.IPromotionRepository;
import projectbackend.service.promotion.IPromotionService;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService implements IPromotionService {
    @Autowired
    private IPromotionRepository iPromotionRepository;


    @Override
    public void savePromotion(Promotion promotion) {
        iPromotionRepository.save(promotion);
    }

    @Override
    public Optional<Promotion> findById(Integer id) {
        return iPromotionRepository.findById(id);
    }

    @Override
    public void updatePromotion(Promotion promotion) {
        iPromotionRepository.save(promotion);

    }

    @Override
    public IPromotionDto findPromotionById(Integer id) {
        return iPromotionRepository.findPromotionById(id);
    }
}
