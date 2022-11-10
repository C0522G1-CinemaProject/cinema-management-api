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
    private IPromotionService service;

    @GetMapping("/list")
    public ResponseEntity<Page<Promotion>> showList(@RequestParam(value = "name", defaultValue = "") String name,
                                                    @PageableDefault Pageable pageable) {
        Page<Promotion> promotions = service.findAll(pageable, name);
        if (promotions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(promotions, HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<Promotion> saveAdding(@RequestBody PromotionDto promotionDto) {
        Promotion promotion = new Promotion();
        BeanUtils.copyProperties(promotionDto, promotionDto);
        service.save(promotion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Promotion> saveEditing(@RequestBody PromotionDto promotionDto,
                                                 @PathVariable int id) {
        Promotion promotion = service.findById(id).get();
        BeanUtils.copyProperties(promotionDto, promotion);
        service.save(promotion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getInfo(@PathVariable int id) {
        Optional<Promotion> promotion = service.findById(id);
        if (promotion.isPresent()) {
            return new ResponseEntity<>(promotion.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Promotion> delete(@PathVariable int id) {
        Optional<Promotion> promotion = service.findById(id);
        if (promotion.isPresent()) {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
