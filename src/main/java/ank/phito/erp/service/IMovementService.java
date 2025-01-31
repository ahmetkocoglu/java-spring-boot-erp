package ank.phito.erp.service;

import ank.phito.erp.dto.DtoMovement;
import ank.phito.erp.dto.DtoMovementIU;

import java.util.List;

public interface IMovementService {

    public DtoMovement saveMovement(DtoMovementIU dtoMovement);

    public List<DtoMovement> getAllMovement();

    public DtoMovement getMovementById(String id);

    public void deleteMovement(String id);

    public DtoMovement updateMovement(String id , DtoMovementIU dtoMovementIU);

}
