package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.promotion.PromotionDto;
import projectbackend.model.promotion.Promotion;
import projectbackend.service.promotion.IPromotionService;

@RestController
@RequestMapping("/promotion")
public class PromotionRestController {
    @Autowired
    private IPromotionService iPromotionService;

    @PostMapping("/create")
    public ResponseEntity<Promotion> createPromotion(@RequestBody PromotionDto promotionDto) {
        Promotion promotion = new Promotion();
        BeanUtils.copyProperties(promotionDto, promotion);
        iPromotionService.save(promotion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Promotion> editPromotion(@RequestBody PromotionDto promotionDto,
                                                @PathVariable int id) {
        Promotion promotion = iPromotionService.findById(id).get();
        BeanUtils.copyProperties(promotionDto, promotion);
        iPromotionService.update(promotion);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
