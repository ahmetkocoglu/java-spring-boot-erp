package ank.phito.erp.service.impl;

import ank.phito.erp.dto.DtoMovement;
import ank.phito.erp.dto.DtoMovementIU;
import ank.phito.erp.entity.MovementEntity;
import ank.phito.erp.repository.MovementRepository;
import ank.phito.erp.service.IMovementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovementServiceImpl implements IMovementService {
    @Autowired
    MovementRepository movementRepository;

    @Override
    public DtoMovement saveMovement(DtoMovementIU dtoMovementIU) {
        DtoMovement response = new DtoMovement();
        MovementEntity log = new MovementEntity();
        BeanUtils.copyProperties(dtoMovementIU, log);

        MovementEntity dbMovement = movementRepository.save(log);
        BeanUtils.copyProperties(dbMovement, response);

        return response;
    }

    @Override
    public List<DtoMovement> getAllMovement() {
        List<DtoMovement> dtoList = new ArrayList<>();

        List<MovementEntity> logList = movementRepository.findAll();
        for (MovementEntity log : logList) {
            DtoMovement dto = new DtoMovement();
            BeanUtils.copyProperties(log, dto);

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public DtoMovement getMovementById(String id) {
        DtoMovement dtoMovement = new DtoMovement();
        Optional<MovementEntity> optional =  movementRepository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        MovementEntity dbMovement = optional.get();
        BeanUtils.copyProperties(dbMovement, dtoMovement);

        return dtoMovement;
    }

    @Override
    public void deleteMovement(String id) {
        Optional<MovementEntity> optional = movementRepository.findById(id);
        optional.ifPresent(logEntity -> movementRepository.delete(logEntity));
    }

    @Override
    public DtoMovement updateMovement(String id, DtoMovementIU dtoMovementIU) {
        DtoMovement dto = new DtoMovement();

        Optional<MovementEntity> optional = movementRepository.findById(id);
        if (optional.isPresent()) {
            MovementEntity dbMovement = optional.get();

            dbMovement.setTitle(dtoMovementIU.getTitle());
            dbMovement.setDescription(dtoMovementIU.getDescription());

            MovementEntity updatedMovement = movementRepository.save(dbMovement);

            BeanUtils.copyProperties(updatedMovement, dto);
            return dto;
        }
        return null;
    }
}
