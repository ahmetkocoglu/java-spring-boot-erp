package ank.phito.erp.service.impl;

import ank.phito.erp.dto.DtoCalender;
import ank.phito.erp.dto.DtoCalenderIU;
import ank.phito.erp.entity.CalenderEntity;
import ank.phito.erp.repository.CalenderRepository;
import ank.phito.erp.service.ICalenderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CalenderServiceImpl implements ICalenderService {
    @Autowired
    CalenderRepository calenderRepository;

    @Override
    public DtoCalender saveCalender(DtoCalenderIU dtoCalenderIU) {
        DtoCalender response = new DtoCalender();
        CalenderEntity log = new CalenderEntity();
        BeanUtils.copyProperties(dtoCalenderIU, log);

        CalenderEntity dbCalender = calenderRepository.save(log);
        BeanUtils.copyProperties(dbCalender, response);

        return response;
    }

    @Override
    public List<DtoCalender> getAllCalender() {
        List<DtoCalender> dtoList = new ArrayList<>();

        List<CalenderEntity> logList = calenderRepository.findAll();
        for (CalenderEntity log : logList) {
            DtoCalender dto = new DtoCalender();
            BeanUtils.copyProperties(log, dto);

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public DtoCalender getCalenderById(String id) {
        DtoCalender dtoCalender = new DtoCalender();
        Optional<CalenderEntity> optional =  calenderRepository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        CalenderEntity dbCalender = optional.get();
        BeanUtils.copyProperties(dbCalender, dtoCalender);

        return dtoCalender;
    }

    @Override
    public void deleteCalender(String id) {
        Optional<CalenderEntity> optional = calenderRepository.findById(id);
        optional.ifPresent(logEntity -> calenderRepository.delete(logEntity));
    }

    @Override
    public DtoCalender updateCalender(String id, DtoCalenderIU dtoCalenderIU) {
        DtoCalender dto = new DtoCalender();

        Optional<CalenderEntity> optional = calenderRepository.findById(id);
        if (optional.isPresent()) {
            CalenderEntity dbCalender = optional.get();

            dbCalender.setTitle(dtoCalenderIU.getTitle());
            dbCalender.setDescription(dtoCalenderIU.getDescription());

            CalenderEntity updatedCalender = calenderRepository.save(dbCalender);

            BeanUtils.copyProperties(updatedCalender, dto);
            return dto;
        }
        return null;
    }
}
