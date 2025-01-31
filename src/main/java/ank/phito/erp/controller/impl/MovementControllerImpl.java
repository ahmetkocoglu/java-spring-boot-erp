package ank.phito.erp.controller.impl;

import ank.phito.erp.controller.IMovementController;
import ank.phito.erp.dto.DtoMovement;
import ank.phito.erp.dto.DtoMovementIU;
import ank.phito.erp.service.IMovementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
public class MovementControllerImpl implements IMovementController {

    @Autowired
    private IMovementService movementService;

    @PostMapping(path = "")
    @Override
    public DtoMovement saveMovement(@RequestBody @Valid DtoMovementIU dtoMovementIU) {
        System.out.println("dtoMovementIU");
        return movementService.saveMovement(dtoMovementIU);
    }

    @GetMapping(path = "")
    @Override
    public List<DtoMovement> getAllMovement() {
        return movementService.getAllMovement();
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoMovement getMovementById(@PathVariable(name = "id") String id) {
        return movementService.getMovementById(id);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public void deleteMovement(@PathVariable(name = "id") String id) {
        movementService.deleteMovement(id);
    }

    @PutMapping(path = "/{id}")
    @Override
    public DtoMovement updateMovement(@PathVariable(name = "id") String id, @RequestBody DtoMovementIU dtoMovementIU) {
        return movementService.updateMovement(id, dtoMovementIU);
    }
}
