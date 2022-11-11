package projectbackend.controller;


import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.promotion.PromotionDto;
import projectbackend.model.promotion.Promotion;
import projectbackend.service.promotion.IPromotionService;

import java.util.Optional;

@RestController
@RequestMapping("/api/promotion")
@CrossOrigin("*")
public class PromotionRestController {
    @Autowired
    private IPromotionService iPromotionService;

    @PostMapping("/save")
    public ResponseEntity<Promotion> saveAdding(@RequestBody PromotionDto promotionDto) {
        Promotion promotion = new Promotion();
        BeanUtils.copyProperties(promotionDto, promotion);
        iPromotionService.save(promotion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Promotion> saveEditing(@RequestBody PromotionDto promotionDto,
                                                 @PathVariable int id) {
        Promotion promotion = service.findById(id).get();
        BeanUtils.copyProperties(promotionDto, promotion);
        iPromotionService.save(promotion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Promotion> getInfo(@PathVariable int id) {
        Optional<Promotion> promotion = iPromotionService.findById(id);
        if (promotion.isPresent()) {
            return new ResponseEntity<>(promotion.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Promotion> delete(@PathVariable int id) {
        Optional<Promotion> promotion = iPromotionService.findById(id);
        if (promotion.isPresent()) {
            iPromotionService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    

    @GetMapping("/list")
    public ResponseEntity<Page<Promotion>> showPromotion(@RequestParam(value = "name", defaultValue = "") String name,
                                                         @PageableDefault(value = 4)Pageable pageable) {
        Page<Promotion> promotions = iPromotionService.findAll(pageable, name);
        if (promotions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(promotions, HttpStatus.OK);
        }
    }

   

}
