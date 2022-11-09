package projectbackend.service.promotion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.model.promotion.Promotion;
import projectbackend.repository.promotion.IPromotionRepository;
import projectbackend.service.promotion.IPromotionService;

import java.util.Optional;

@Service
public class PromotionService implements IPromotionService {
    @Autowired
    private IPromotionRepository iPromotionRepository;


    @Override
    public void save(Promotion promotion) {
        iPromotionRepository.save(promotion);
    }

    @Override
    public Optional<Promotion> findById(int id) {
        return iPromotionRepository.findById(id);
    }

    @Override
    public void update(Promotion promotion) {
        iPromotionRepository.save(promotion);

    }
}
