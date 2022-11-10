package projectbackend.service.promotion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectbackend.model.promotion.Promotion;
import projectbackend.repository.promotion.IPromotionRepository;
import projectbackend.service.promotion.IPromotionService;

import java.util.Optional;

@Service
public class PromotionService implements IPromotionService {

    @Autowired
    private IPromotionRepository repository;

    @Override
    public Page<Promotion> findAll(Pageable pageable, String name) {
        return repository.findAllPromotion(pageable, name);
    }

    @Override
    public Optional<Promotion> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) {
        repository.deletePromotion(id);
    }

    @Override
    public void save(Promotion promotion) {
        repository.savePromotion(promotion);
    }
}
