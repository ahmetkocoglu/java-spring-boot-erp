package ank.phito.erp.controller;

import ank.phito.erp.dto.DtoMovement;
import ank.phito.erp.dto.DtoMovementIU;

import java.util.List;

public interface IMovementController {
    public DtoMovement saveMovement(DtoMovementIU dtoMovementIU);

    public List<DtoMovement> getAllMovement();

    public DtoMovement getMovementById(String id);

    public void deleteMovement(String id);

    public DtoMovement updateMovement(String id , DtoMovementIU dtoMovementIU);
}
