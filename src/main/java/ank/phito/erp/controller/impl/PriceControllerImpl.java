package ank.phito.erp.controller.impl;

import ank.phito.erp.controller.IPriceController;
import ank.phito.erp.dto.DtoPrice;
import ank.phito.erp.dto.DtoPriceIU;
import ank.phito.erp.entity.PriceEntity;
import ank.phito.erp.repository.PriceRepository;
import ank.phito.erp.service.IPriceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices")
public class PriceControllerImpl implements IPriceController {

    @Autowired
    private IPriceService priceService;

    @Autowired
    PriceRepository priceRepository;

    @PostMapping(path = "")
    public String savePriceNew(@RequestBody @Valid PriceEntity price) {
        System.out.println("price");
        PriceEntity dbPrice = priceRepository.save(price);
        return "success";
    }

    @Override
    public DtoPrice savePrice(DtoPriceIU dtoPriceIU) {
        return null;
    }

    @GetMapping(path = "")
    @Override
    public List<DtoPrice> getAllPrice() {
        return priceService.getAllPrice();
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoPrice getPriceById(@PathVariable(name = "id") String id) {
        return priceService.getPriceById(id);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public void deletePrice(@PathVariable(name = "id") String id) {
        priceService.deletePrice(id);
    }

    @PutMapping(path = "/{id}")
    @Override
    public DtoPrice updatePrice(@PathVariable(name = "id") String id, @RequestBody DtoPriceIU dtoPriceIU) {
        return priceService.updatePrice(id, dtoPriceIU);
    }
}
